package App.FlashCardStudy.Screens;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import App.FlashCardStudy.Base.FlashCardStudyActivity;
import App.FlashCardStudy.Base.FlashCardStudyClick;
import App.FlashCardStudy.R;

public class Card extends FlashCardStudyActivity implements View.OnClickListener
{
    //Variaveis da classe
    private FlashCardStudyClick flashCardStudyClick = null;

    //Controles da classe
    private ImageButton cmdPreviousImage = null;
    private ImageButton cmdNextImage = null;
    private Button cmdSendResponse = null;
    private ImageView imgFlashCard = null;
    private EditText txtAnswerFlashCard = null;
    private TextView lblFeedbackAnswer = null;


    @Override
    protected void onCreate(Bundle bundleSavedInstanceState)
    {
        //Carrega o formulario
        setContentView(R.layout.frm_card);

        //O super vem depois, pois como estamos implementando de uma classe base, se não ficar na sequencia, não carrega os controles.
        super.onCreate(bundleSavedInstanceState);
    }

    @Override
    public void startControls()
    {
        //Inicia os controles da tela
        cmdPreviousImage = findViewById(R.id.cmdPreviousImage);
        cmdNextImage = findViewById(R.id.cmdNextImage);
        cmdSendResponse = findViewById(R.id.cmdSendResponse);
        imgFlashCard = findViewById(R.id.imgFlashCard);
        txtAnswerFlashCard = findViewById(R.id.txtAnswerFlashCard);
        lblFeedbackAnswer = findViewById(R.id.lblFeedbackAnswer);

        //Setamos o clique padrão
        flashCardStudyClick = new FlashCardStudyClick(this);

        //Definimos o listener no botao de enviar
        cmdSendResponse.setOnClickListener(flashCardStudyClick);

    }

    @Override
    public void getParameters()
    {
    }

    @Override
    public void loadData()
    {

    }

    @Override
    public void onReceiveData(Class classes, int iId, boolean bResult, Object... oObjetcts)
    {

    }

    @Override
    public void onClick(View view)
    {

    }

}
