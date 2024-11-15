package App.FlashCardStudy.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import App.FlashCardStudy.Base.FlashCardStudyActivity;
import App.FlashCardStudy.Base.FlashCardStudyClick;
import App.FlashCardStudy.R;
import App.FlashCardStudy.Utils.StandardAlert;
import App.FlashCardStudy.Utils.Support;


public class FrmHome extends FlashCardStudyActivity implements View.OnClickListener
{
    //Variaveis da classe
    private FlashCardStudyClick flashCardClick = null;
    private FirebaseUser currentUser = null;

    //Controles da classe
    private Button cmdFlashcardGame = null;
    private Button cmdLogin = null;
    private Button cmdRegister = null;


    @Override
    protected void onCreate(Bundle bundleSavedInstanceState)
    {
        //Esconde barra do android
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Carrega o formulario
        setContentView(R.layout.frm_home);

        //O super vem depois, pois como estamos implementando de uma classe base da pekus, se não ficar na sequencia não carrega os controles
        super.onCreate(bundleSavedInstanceState);
    }


    @Override
    public void startControls() throws Exception
    {
        //Inicia os controles da tela
        cmdFlashcardGame = findViewById(R.id.cmdFlashcardGame);
        cmdLogin = findViewById(R.id.cmdLogin);
        cmdRegister = findViewById(R.id.cmdRegister);

        //Setamos a fonte da tela
        Support.setfont(this, cmdFlashcardGame, R.font.montmedio, false, false);
        Support.setfont(this, cmdLogin, R.font.montmedio, false, false);
        Support.setfont(this, cmdRegister, R.font.montmedio, false, false);


        //Instancia o clique padrao do app
        flashCardClick = new FlashCardStudyClick(this);

        //Define os listeners dos botoes
        cmdFlashcardGame.setOnClickListener(flashCardClick);
        cmdLogin.setOnClickListener(flashCardClick);
        cmdRegister.setOnClickListener(flashCardClick);
    }

    @Override
    public void loadData()
    {

    }

    @Override
    public void onClick(View view)
    {
        //Recupera o usuario logado
        currentUser = FirebaseAuth.getInstance().getCurrentUser();

        try
        {
            //Se o clique for no botao de iniciar um jogo
            if (view == cmdFlashcardGame)
            {
                //Valida se o usuario está logado
                if(currentUser != null)
                {
                    //Chama a tela de novo jogo
                    goToFlashCardGameScreen();
                }
                else
                {
                    //Chama a tela de login
                    goToLoginScreen();
                }

            }
            //Se o clique for no botao de login
            else if (view == cmdLogin)
            {
                //Chama a tela de login
                goToLoginScreen();
            }
            //Se o clique for no botao de registro
            else if (view == cmdRegister)
            {
                //Chama a tela de registro
                goToRegisterScreen();
            }
        }
        catch (Exception err)
        {
            new StandardAlert(this, null).standardDialog(Support.getMsgErr(this, err), getString(R.string.atention));
        }
    }

    @Override
    public void onReceiveData(Class classe, int iId, boolean bResultado, Object... oObjetos)
    {
        super.onReceiveData(classe, iId, bResultado, oObjetos);

        try
        {
        }
        catch (Exception err)
        {
            new StandardAlert(this, null).standardDialog(Support.getMsgErr(this, err), getString(R.string.atention));
        }
    }

    @Override
    protected void onActivityResult(int iRequest, int iResultado, Intent intentData)
    {
        super.onActivityResult(iRequest, iResultado, intentData);

        try
        {

        }
        catch (Exception err)
        {
            new StandardAlert(this, null).standardDialog(Support.getMsgErr(this, err), getString(R.string.atention));
        }
    }

    /**
     * Metodo que chhama a tela de login
     */
    public void goToLoginScreen()
    {
        Intent intent = null;

        //Chama a tela de login
        intent = new Intent(this, FrmLogin.class);
        startActivity(intent);
    }

    /**
     * Metodo que chhama a tela de registro
     */
    public void goToRegisterScreen()
    {
        Intent intent = null;

        //Chama a tela de registro
        intent = new Intent(this, FrmRegister.class);
        startActivity(intent);
    }

    /**
     * Método que chama a tela do jogo flashcard

     */
    public void goToFlashCardGameScreen()
    {
        Intent intent = null;

        //Chama a tela principal do jogo
        intent = new Intent(this, FrmMain.class);
        startActivity(intent);
    }

}
