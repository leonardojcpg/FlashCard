package App.FlashCardStudy.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

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
    private Button cmdRegister = null;
    private TextView lblRegisterAlready = null;

    @Override
    protected void onCreate(Bundle bundleSavedInstanceState)
    {
        //Seta o layout xml do formulario
        setContentView(R.layout.frm_register);

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
        cmdRegister = findViewById(R.id.cmdRegister);
        lblRegisterAlready = findViewById(R.id.lblRegisterAlready);

        // Inicializa a instância do FirebaseRegisterUser
        firebaseRegisterUser = new FirebaseRegisterUser(this);

        //Setamos a classe de click, para evitarmos cliques duplos na aplicacao
        flashCardStudyClick = new FlashCardStudyClick(this);

        //Setamos o listener nos botoes
        cmdRegister.setOnClickListener(flashCardStudyClick);
        lblRegisterAlready.setOnClickListener(flashCardStudyClick);

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
            //Se o clique for no botao de registrar
            if (view == cmdRegister)
            {
                //Faz o registro de usuario
                firebaseRegister();
            }
            else if (view == lblRegisterAlready)
            {
                goToLoginScreen();
            }
        }
        catch (Exception e)
        {
            //Exibe mensagem de erro em forma de toast
            Toast.makeText(this, R.string.msg_toast_login_failed, Toast.LENGTH_SHORT);
        }

    }

    public void goToLoginScreen()
    {
        Intent intent = null;

        intent = new Intent(this, FrmLogin.class);
        startActivity(intent);
    }

    /**
     * Faz o login de usuario
     */
    public void firebaseRegister()
    {
        String sEmail = txtEmail.getText().toString().trim();
        String sPassword = txtPassword.getText().toString().trim();

        try
        {
            //Se o registro de usuario for valido
            if (registerValidation())
            {
                //Faz o registro
                firebaseRegisterUser.register(sEmail, sPassword);

                //Se obtiver sucesso no registro de usuario, encaminha para a tela de login
                goToLoginScreen();

                //Exibe a mensagem de sucesso
                Toast.makeText(this, R.string.msg_toast_register_success, Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e)
        {
            //Se tiver erro, exibe a mensagem
            Toast.makeText(this, R.string.msg_toast_register_failed + e.getMessage(), Toast.LENGTH_LONG).show();
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
            Toast.makeText(this, R.string.msg_toast_register_failed, Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public boolean registerValidation() throws Exception
    {
        String sEmail = "";
        String sPassword = "";

        //pega o usuario e a senha entrada pelo usuario
        sEmail = txtEmail.getText().toString().trim();
        sPassword = txtPassword.getText().toString().trim();

        //verifica se o usuario(e-mail) foi preenchido
        if ( sEmail.length() <= 0 )
        {
            // Foca o textField invalido e cria a mensagem para mostrar no alerta
            Support.requestFocus(txtEmail, this);
            new StandardAlert(this, null).standardDialogQuestion(getString(R.string.msg_error_email_blank), getString(R.string.atention));
            return false;
        }

        //verifica se o e-mail esta correto
        if (!sEmail.matches(Const.REGEX_EMAIL))
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
            return false;
        }

        //retorna se os campos estao validos
        return true;
    }
}
