package App.FlashCardStudy.Screens;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.FutureTarget;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import App.FlashCardStudy.Base.FlashCardStudyActivity;
import App.FlashCardStudy.Base.FlashCardStudyClick;
import App.FlashCardStudy.Constants.Const;
import App.FlashCardStudy.R;
import App.FlashCardStudy.Utils.StandardAlert;
import App.FlashCardStudy.Utils.Support;

public class FrmCard extends FlashCardStudyActivity implements View.OnClickListener
{
    // Variáveis da classe
    private FirebaseFirestore db = null;
    private StorageReference storageReference = null;
    private ImageView imgFlashCard = null;
    private List<String> arrUrlImages = null;
    private Uri imageUri;
    private Bitmap processedBitmap;
    private FlashCardStudyClick flashCardClick = null;

    // Controles da classe
    private Toolbar toolbar = null;
    private EditText txtAnswerFlashCard = null;
    private Button cmdSendResponse = null;
    private TextView lblFeedbackAnswer = null;

    private static final int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle bundleSavedInstanceState)
    {
        // Recupera o layout utilizado
        setContentView(R.layout.frm_card);

        // O super vem depois, pois como estamos implementando de uma classe base,
        // se não ficar na sequência não carrega os controles
        super.onCreate(bundleSavedInstanceState);
    }

    @Override
    public void startControls() throws Exception
    {
        // Inicia os controles da tela
        imgFlashCard = findViewById(R.id.imgFlashCard);
        toolbar = findViewById(R.id.toolbar);
        txtAnswerFlashCard = findViewById(R.id.txtAnswerFlashCard);
        cmdSendResponse = findViewById(R.id.cmdSendResponse);
        lblFeedbackAnswer = findViewById(R.id.lblFeedbackAnswer);

        // Carrega o botão voltar da tela
        Support.loadToolbarBack(toolbar, this);

        // Inicializa Firebase Storage
        storageReference = FirebaseStorage.getInstance().getReference(Const.HASH_MAP_FLASHCARDS_FIREBASE);

        // Instancia o click da classe
        flashCardClick = new FlashCardStudyClick(this);

        // Configura o clique na imagem para selecionar uma nova
        imgFlashCard.setOnClickListener(flashCardClick);
    }

    @Override
    public void loadData()
    {
        // Carrega a toolbar
        toolbar.setTitle(R.string.back_toolbar);

        // Carrega o banco de dados do firebase
        db = FirebaseFirestore.getInstance();
        arrUrlImages = new ArrayList<>();

        // Carrega as imagens do firebase
        loadFlashCardImages();
    }

    @Override
    public void onClick(View view)
    {
        //Se o clique for da imagem
        if (view == imgFlashCard)
        {
            //Faz o upload da imagem
            openFileChooser();
        }
    }

    /**
     * Abre o seletor de arquivos para escolher uma imagem
     */
    private void openFileChooser()
    {
        Intent intent = null;

        intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    /**
     * Método que trata o retorno da activity
     * ----------------------------------------
     * @param requestCode The integer request code originally supplied to
     *                    startActivityForResult(), allowing you to identify who this
     *                    result came from.
     * @param resultCode The integer result code returned by the child activity
     *                   through its setResult().
     * @param data An Intent, which can return result data to the caller
     *               (various data can be attached to Intent "extras").
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        //Se voltou do upload da imagem
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null)
        {
            //Recupera a imagem
            imageUri = data.getData();
            //Processa a imagem
            processImage(imageUri);
        }
    }

    /**
     * Processa a imagem para padronizar tamanho e qualidade
     */
    private void processImage(Uri imageUri)
    {
        new Thread(() ->
        {
            try
            {
                FutureTarget<Bitmap> futureBitmap = Glide.with(this)
                        .asBitmap()
                        .load(imageUri)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        // Dimensões fixas das imagens
                        .submit(350, 350);

                processedBitmap = futureBitmap.get();

                // Atualiza o ImageView na UI thread
                runOnUiThread(() -> imgFlashCard.setImageBitmap(processedBitmap));

                // Realiza o upload da imagem
                uploadImageToFirebase();
            }
            catch (Exception err)
            {
                //Mostra a mensagem de erro
                new StandardAlert(this, null).standardDialog(Support.getMsgErr(this, err), getString(R.string.atention));
            }
        }).start();
    }

    /**
     * Faz o upload da imagem processada para o Firebase
     */
    private void uploadImageToFirebase()
    {
        ByteArrayOutputStream baos = null;
        byte[] imageData = null;

        //Se o bitmap processado for nulo
        if (processedBitmap == null)
        {
            return;
        }

        // Converter bitmap processado em byte array
        baos = new ByteArrayOutputStream();
        processedBitmap.compress(Bitmap.CompressFormat.JPEG, 80, baos);
        imageData = baos.toByteArray();

        // Gerar um identificador único para o FlashCard
        String flashCardId = db.collection(Const.HASH_MAP_FLASHCARDS_FIREBASE).document().getId();

        // Criar referência no Firebase Storage
        StorageReference fileReference = storageReference.child(flashCardId + R.string.jpg);

        // Upload da imagem
        fileReference.putBytes(imageData).addOnSuccessListener(taskSnapshot -> fileReference.getDownloadUrl().addOnSuccessListener(uri ->
        {
            // URL da imagem armazenada no Firebase
            String imageUrl = uri.toString();

            // Salvar no Firestore
            db.collection(Const.HASH_MAP_FLASHCARDS_FIREBASE)
                .document(flashCardId)
                .set(new FlashCardData(imageUrl))
                .addOnCompleteListener(task ->
                {
                    if (task.isSuccessful())
                    {
                        //Mostra a mensagem de sucesso
                        new StandardAlert(this, null).standardDialog(getString(R.string.msg_flashcard_saved_success), getString(R.string.atention));
                        loadFlashCardImages();
                    }
                    else
                    {
                        //Mostra mensagem de erro
                        new StandardAlert(this, null).standardDialog(getString(R.string.msg_flashcard_saved_error), getString(R.string.atention));
                    }
                });
        })).addOnFailureListener(e -> new StandardAlert(this, null).standardDialog(getString(R.string.msg_flashcard_error_upload), getString(R.string.atention)));
    }

    /**
     * Método que carrega as imagens
     */
    private void loadFlashCardImages()
    {
        CollectionReference flashcardsRef = null;

        //Pega a referencia dos cards
        flashcardsRef = db.collection(Const.HASH_MAP_FLASHCARDS_FIREBASE);
        //Pega a imagem e adiciona o complete listener
        flashcardsRef.get().addOnCompleteListener(task ->
        {
            //Se a task tiver sucesso
            if (task.isSuccessful())
            {
                //Limpa a lista de imagens
                arrUrlImages.clear();

                for (QueryDocumentSnapshot document : task.getResult())
                {
                    String sImageUrl = document.getString(Const.HASH_MAP_URL_IMAGEM_FIREBASE);
                    arrUrlImages.add(sImageUrl);
                }
                // Chama o método que mostra as imagens aleatoriamente
                showRandomImage();
            }
            else
            {
                //Erro ao carregar imagem
                new StandardAlert(this, null).standardDialog(getString(R.string.msg_flashcard_load_error), getString(R.string.atention));
            }
        });
    }

    /**
     * Método que mostra as imagens de maneira aleatória
     */
    private void showRandomImage()
    {
        //Se o array de imagens nao estiver vazio
        if (!arrUrlImages.isEmpty())
        {
            Random random = new Random();
            int iRandomIndex = random.nextInt(arrUrlImages.size());
            String sRandomImageUrl = arrUrlImages.get(iRandomIndex);

            // Usa Glide para carregar a imagem na ImageView
            Glide.with(this).load(sRandomImageUrl).into(imgFlashCard);
        }
    }


    /**
     * Classe para armazenar os dados do FlashCard
     */
    private static class FlashCardData
    {
        private String imageUrl = "";

        public FlashCardData(String imageUrl)
        {
            this.imageUrl = imageUrl;
        }

        public String getImageUrl()
        {
            return imageUrl;
        }
    }
}
