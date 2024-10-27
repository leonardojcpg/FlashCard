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
import App.FlashCardStudy.Firebase.FirebaseRegisterUser;
import App.FlashCardStudy.R;
import App.FlashCardStudy.Utils.StandardAlert;
import App.FlashCardStudy.Utils.Support;

public class FrmRegister extends FlashCardStudyActivity implements View.OnClickListener, View.OnKeyListener
{
    //Variaveis da classe
    private FirebaseRegisterUser firebaseRegisterUser = null;
    private FlashCardStudyClick flashCardStudyClick = null;

    //Controles da classe
    private Toolbar toolbar = null;
    private EditText txtEmail = null;
    private EditText txtPassword = null;
    private EditText txtName = null;
    private Button cmdRegister = null;
    private TextView lblRegisterAlready = null;

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
        txtName = findViewById(R.id.txtName);
        cmdRegister = findViewById(R.id.cmdRegister);
        lblRegisterAlready = findViewById(R.id.lblRegisterAlready);

        //Setamos a classe de click, para evitarmos cliques duplos na aplicacao
        flashCardStudyClick = new FlashCardStudyClick(this);

        //Setamos o listener nos botoes
        cmdRegister.setOnClickListener(this);
        lblRegisterAlready.setOnClickListener(this);

        //Ajusta a fonte do campo de senha
        Support.setfont(this, txtPassword, R.font.montmedio, false, false);
        Support.setfont(this, txtEmail, R.font.montmedio, false, false);
        Support.setfont(this, cmdRegister, R.font.montmedio, false, false);
        Support.setfont(this, lblRegisterAlready, R.font.montmedio, false, false);

        txtPassword.setTransformationMethod(new PasswordTransformationMethod());

        // Define o listener do key para dar acao ao clicar no "enter" do teclado
        txtPassword.setOnKeyListener(this);
    }

    @Override
    public void loadData() throws Exception
    {
        //Seta o titulo da toolbar como login ao iniciar a pagina
        //toolbar.setTitle(R.string.toolbar_login);
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
            if (view == cmdRegister)
            {
                firebaseRegister();
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
    public void firebaseRegister()
    {
        String sEmail = "";
        String sPassword = "";

        try
        {
            //tenta fazer o login de usuario
            firebaseRegisterUser.register(sEmail, sPassword);
            Toast.makeText(this, R.string.msg_toast_register_success, Toast.LENGTH_SHORT);
        }
        catch (Exception e)
        {
            //Exibe mensagem de erro em forma de toast
            Toast.makeText(this, R.string.msg_toast_register_failed, Toast.LENGTH_SHORT);
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
                        if(registerValidation())
                        {
                            // Se estiverem corretos realiza o login por email
                            firebaseRegister();
                        }

                        return true;
                    }
                }
            }
        } catch (Exception err)
        {
            //Exibe mensagem de erro na forma de toast
            Toast.makeText(this, R.string.msg_toast_register_failed, Toast.LENGTH_SHORT);
        }
        return false;
    }

    public boolean registerValidation() throws Exception
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

        if(sPassword.length() <= 4)
        {
            Support.requestFocus(txtPassword, this);
            new StandardAlert(this, null).standardDialog(getString(R.string.msg_error_password), getString(R.string.atention));
        }

        //retorna se os campos estao validos
        return true;
    }
}
