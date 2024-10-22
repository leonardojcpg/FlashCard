package App.FlashCardStudy.Screens;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.squareup.picasso.Picasso;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import App.FlashCardStudy.Base.FlashCardStudyActivity;
import App.FlashCardStudy.Constants.Const;
import App.FlashCardStudy.R;
import App.FlashCardStudy.Utils.Support;

public class FrmCard extends FlashCardStudyActivity
{
    //Variaveis da classe
    private FirebaseFirestore db = null;
    private ImageView imgFlashCard = null;
    private List<String> lstUrlImages = null;

    //Controles da classe
    private Toolbar toolbar = null;
    private ImageButton cmdPreviousImage = null;
    private ImageButton cmdNextImage = null;
    private EditText txtAnswerFlashCard = null;
    private Button cmdSendResponse = null;
    private TextView lblFeedbackAnswer = null;


    @Override
    protected void onCreate(Bundle bundleSavedInstanceState)
    {
        //Recupera o layout utilizado
        setContentView(R.layout.frm_card);

        //O super vem depois, pois como estamos implementando de uma classe base,
        //se não ficar na sequencia não carrega os controles
        super.onCreate(bundleSavedInstanceState);
    }

    @Override
    public void startControls() throws Exception
    {
        //Inicia os controles da tela
        imgFlashCard = findViewById(R.id.imgFlashCard);
        toolbar = findViewById(R.id.toolbar);
        cmdPreviousImage = findViewById(R.id.cmdPreviousImage);
        cmdNextImage = findViewById(R.id.cmdNextImage);
        txtAnswerFlashCard = findViewById(R.id.txtAnswerFlashCard);
        cmdSendResponse = findViewById(R.id.cmdSendResponse);
        lblFeedbackAnswer = findViewById(R.id.lblFeedbackAnswer);

        //Carrega o botão voltar da tela
        Support.loadToolbarBack(toolbar, this);
    }

    @Override
    public void loadData()
    {
        //Carrega a toolbar
        toolbar.setTitle(R.string.back_toolbar);

        //Carrega o banco de dados do firebase
        db = FirebaseFirestore.getInstance();
        lstUrlImages = new ArrayList<>();

        //Carrega as imagens do firebase
        loadFlashCardImages();
    }

    /**
     * Metodo que carrega as imagens
     */
    private void loadFlashCardImages()
    {
        CollectionReference flashcardsRef = null;

        flashcardsRef = db.collection(Const.HASH_MAP_FLASHCARDS_FIREBASE);
        flashcardsRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful())
            {
                for (QueryDocumentSnapshot document : task.getResult())
                {
                    String sImageUrl = document.getString(Const.HASH_MAP_URL_IMAGEM_FIREBASE);
                    lstUrlImages.add(sImageUrl);
                }
                //Chama o metodo que mostra as imagens aleatoriamente
                showRandomImage();
            }
            else
            {
                // Trate os erros aqui
                Log.d("FirebaseError", "Erro ao buscar imagens", task.getException());
            }
        });
    }

    /**
     * Metodo que mostra as imagens de maneira aleatoria
     */
    private void showRandomImage()
    {
        Random random = null;
        int iRandomIndex = 0;
        String sRandomImageUrl = "";

        if (!lstUrlImages.isEmpty())
        {
            random = new Random();
            iRandomIndex = random.nextInt(lstUrlImages.size());
            sRandomImageUrl = lstUrlImages.get(iRandomIndex);

            // Usa Picasso para carregar a imagem na ImageView
            Picasso.get().load(sRandomImageUrl).into(imgFlashCard);
        }
    }
}
