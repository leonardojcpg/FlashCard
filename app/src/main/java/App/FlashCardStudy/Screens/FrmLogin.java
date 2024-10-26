package App.FlashCardStudy.Screens;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import App.FlashCardStudy.Base.FlashCardStudyActivity;
import App.FlashCardStudy.Base.FlashCardStudyClick;
import App.FlashCardStudy.Constants.Const;
import App.FlashCardStudy.Firebase.FirebaseLoginUser;
import App.FlashCardStudy.R;
import App.FlashCardStudy.Utils.StandardAlert;
import App.FlashCardStudy.Utils.Support;

public class FrmLogin extends FlashCardStudyActivity implements View.OnClickListener, View.OnKeyListener
{
    //Variaveis da classe
    private FirebaseLoginUser loginUser = null;
    private GoogleSignInOptions googleSignIn = null;
    private GoogleSignInClient googleSignInClient = null;
    private FlashCardStudyClick flashCardStudyClick = null;

    //Controles da classe
    private Toolbar toolbar = null;
    private EditText txtEmail = null;
    private EditText txtPassword = null;
    private Button cmdLogin = null;
    private Button cmdLoginGoogle = null;
    private TextView lblForgotPassword = null;
    private TextView lblNoRegister = null;

    @Override
    protected void onCreate(Bundle bundleSavedInstanceState)
    {
        //Seta o layout xml do formulario
        setContentView(R.layout.frm_login);

        //O super vem depois, pois como estamos implementando de uma classe base,
        //se não ficar na sequencia não carrega os controles
        super.onCreate(bundleSavedInstanceState);
    }

    @Override
    public void startControls() throws Exception
    {
        super.startControls();
        //Carrega os controles da tela
        toolbar = findViewById(R.id.toolbar);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPasswod);
        cmdLogin = findViewById(R.id.cmdLogin);
        cmdLoginGoogle = findViewById(R.id.cmdLoginGoogle);
        lblForgotPassword = findViewById(R.id.lblForgotPassword);
        lblNoRegister = findViewById(R.id.lblNoRegister);

        //Setamos a classe de click, para evitarmos cliques duplos na aplicacao
        flashCardStudyClick = new FlashCardStudyClick(this);

        //Setamos o listener nos botoes
        cmdLogin.setOnClickListener(this);
        cmdLoginGoogle.setOnClickListener(this);

        // cria a configuracao de login com o google
        googleSignIn = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(this, googleSignIn);

        //Ajusta a fonte do campo de senha
        Support.setfont(this, txtPassword, R.font.montmedio, false, false);
        Support.setfont(this, txtEmail, R.font.montmedio, false, false);
        Support.setfont(this, cmdLogin, R.font.montmedio, false, false);
        Support.setfont(this, cmdLoginGoogle, R.font.montmedio, false, false);
        Support.setfont(this, lblForgotPassword, R.font.montmedio, false, false);
        Support.setfont(this, lblNoRegister, R.font.montmedio, false, false);

        txtPassword.setTransformationMethod(new PasswordTransformationMethod());

        // Define o listener do key para dar acao ao clicar no "enter" do teclado
        txtPassword.setOnKeyListener(this);
    }

    @Override
    public void loadData() throws Exception
    {
        //Seta o titulo da toolbar como login ao iniciar a pagina
        toolbar.setTitle(R.string.toolbar_login);
    }

    @Override
    public void getParameters() throws Exception
    {
        super.getParameters();
    }

    @Override
    public void onClick(View view)
    {
        try
        {
            if (view == cmdLogin)
            {
                firebaseLogin();
            }
        }
        catch (Exception e)
        {
            //Exibe mensagem de erro em forma de toast
            Toast.makeText(this, R.string.msg_toast_login_failed, Toast.LENGTH_SHORT);
        }

    }

    /**
     * Faz o login de usuario
     */
    public void firebaseLogin()
    {
        String sEmail = "";
        String sPassword = "";
        try
        {
            //tenta fazer o login de usuario
            loginUser.loginUser(sEmail, sPassword);
            Toast.makeText(this, R.string.msg_toast_login_success, Toast.LENGTH_SHORT);
        }
        catch (Exception e)
        {
            //Exibe mensagem de erro em forma de toast
            Toast.makeText(this, R.string.msg_toast_login_failed, Toast.LENGTH_SHORT);
        }
    }

    @Override
    public void onReceiveData(Class classes, int iId, boolean bResult, Object... oObjetcts)
    {
        super.onReceiveData(classes, iId, bResult, oObjetcts);
    }


    @Override
    public boolean onKey(View view, int iKeyCode, KeyEvent event)
    {
        try{
            // Se a view for o edit text da senha
            if (view == txtPassword)
            {
                //Se pressionou algum botão
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    // Se o codigo do botao do teclado for o enter
                    if (iKeyCode == KeyEvent.KEYCODE_ENTER)
                    {
                        // Verifica se os campos estao corretos
                        if(loginValidation())
                        {
                            // Se estiverem corretos realiza o login por email
                            firebaseLogin();
                        }

                        return true;
                    }
                }
            }
        } catch (Exception err)
        {
            //Exibe mensagem de erro na forma de toast
            Toast.makeText(this, R.string.msg_toast_login_failed, Toast.LENGTH_SHORT);
        }
        return false;
    }

    public boolean loginValidation() throws Exception
    {
        String sUser = "";
        String sPassword = "";

        //pega o usuario e a senha entrada pelo usuario
        sUser = txtEmail.getText().toString().trim();
        sPassword = txtPassword.getText().toString().trim();

        //verifica se o usuario(e-mail) foi preenchido
        if ( sUser.length() <= 0 )
        {
            // Foca o textField invalido e cria a mensagem para mostrar no alerta
            Support.requestFocus(txtEmail, this);
            new StandardAlert(this, null).standardDialogQuestion(getString(R.string.msg_error_email_blank), getString(R.string.atention));
            return false;
        }

        //verifica se o e-mail esta correto
        if (!sUser.matches(Const.REGEX_EMAIL))
        {
            // Foca o textField invalido e cria a mensagem para mostrar no alerta
            Support.requestFocus(txtEmail, this);
            new StandardAlert(this, null).standardDialogQuestion(getString(R.string.msg_erro_email_invalid), getString(R.string.atention));
            return false;
        }

        //verifica se a senha foi preenchida
        if ( sPassword.length() <= 0 )
        {
            // Foca o textField invalido e cria a mensagem para mostrar no alerta
            Support.requestFocus(txtPassword, this);
            new StandardAlert(this, null).standardDialogQuestion(getString(R.string.msg_error_password_blank), getString(R.string.atention));
            return false;
        }

        //retorna se os campos estao validos
        return true;
    }
}
