package App.FlashCardStudy.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import App.FlashCardStudy.Base.GeralCommunication;
import App.FlashCardStudy.Constants.Const;
import App.FlashCardStudy.R;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;


/**
 * Classe para criar o dialogo padrao de mensagens
 */
public class StandardAlert implements View.OnClickListener
{
    //Controles da classe
    private TextView lblError = null;
    private TextView lblMessage = null;
    private Button cmdDialogButtonOK = null;
    private Button cmdDialogoPositive = null;
    private Button cmdDialogoNegative = null;
    private AlertDialog dlgStandard = null;
    private AlertDialog dlgStandardQuestion = null;

    //Variáveis da classe
    private Context context = null;
    private GeralCommunication geralCommunication = null;

    /**
     * Construtor da classe
     */
    public StandardAlert(Context contextParam, GeralCommunication geralCommunicationParam)
    {
        //Carrega os dados
        context = contextParam;
        geralCommunication = geralCommunicationParam;
    }

    /**
     * Inicializa o dialogo personalizado com apenas um botao
     */
    public AlertDialog standardDialog(String sMessage, String sTitle)
    {
        AlertDialog.Builder builder = null;
        LayoutInflater inflateScreen = null;
        View viewDialog = null;

        // Inflamos o layout do teclado
        inflateScreen = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        viewDialog = inflateScreen.inflate(R.layout.dlg_standard, null);

        //Instancia o dialog
        builder = new AlertDialog.Builder(context);

        // vincula os campos
        lblError = viewDialog.findViewById(R.id.lblError);
        cmdDialogButtonOK = viewDialog.findViewById(R.id.cmdOk);

        // Define o valor nos campos
        lblError.setText(sMessage);

        //seta a view
        builder.setNegativeButton(null, null);
        builder.setPositiveButton(null, null);

        // Definimos os listeners do 'OK'
        cmdDialogButtonOK.setOnClickListener(this);

        //Cria o dialogo e chama
        builder.setView(viewDialog);
        dlgStandard = builder.create();
        dlgStandard.setTitle(sTitle);
        dlgStandard.setCancelable(false);
        dlgStandard.show();

        return dlgStandard;
    }

    /**
     * Inicializa o dialogo personalizado com apenas um botao
     */
    public AlertDialog standardDialogQuestion(String sMessage, String sTitle)
    {
        AlertDialog.Builder builder = null;
        LayoutInflater inflaterTela = null;
        View viewDialog = null;

        // Inflamos o layout do teclado
        inflaterTela = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        viewDialog = inflaterTela.inflate(R.layout.dlg_standard_question, null);

        //Instancia o dialog
        builder = new AlertDialog.Builder(context);

        // vincula os campos
        lblMessage = viewDialog.findViewById(R.id.lblDialogMessage);
        cmdDialogoNegative = viewDialog.findViewById(R.id.cmgNegative);
        cmdDialogoPositive = viewDialog.findViewById(R.id.cmdPositive);

        // Define o valor nos campos
        lblMessage.setText(sMessage);

        //seta a view
        builder.setNegativeButton(null, null);
        builder.setPositiveButton(null, null);

        // Definimos os listeners do 'OK'
        cmdDialogoNegative.setOnClickListener(this);
        cmdDialogoPositive.setOnClickListener(this);

        builder.setView(viewDialog);
        dlgStandardQuestion = builder.create();
        dlgStandardQuestion.setTitle(sTitle);
        dlgStandardQuestion.setCancelable(false);
        dlgStandardQuestion.show();

        return dlgStandardQuestion;
    }

    @Override
    public void onClick(View view)
    {
        try
        {
            // Se clicou no botao do dialogo
            if( view == cmdDialogButtonOK )
            {
                // Fecha o dialogo
                dlgStandard.dismiss();

                //Se tiver comunicacao de retorno
                if ( geralCommunication != null )
                {
                    //Devolve sucesso no clique
                    geralCommunication.geralCommunicate(getClass(), cmdDialogButtonOK.getId(), true, Const.DIALOGO_RETORNO_OK, dlgStandard);
                }
            }
            // Se clicou no botao do dialogo de pergunta negativo
            else if( view == cmdDialogoNegative)
            {
                // Fecha o dialogo
                dlgStandardQuestion.dismiss();

                // Se tiver comunicacao de retorno
                if( geralCommunication != null )
                {
                    //Devolve sucesso no clique
                    geralCommunication.geralCommunicate(getClass(), cmdDialogoNegative.getId(), true, Const.DIALOGO_RETORNO_NAO, dlgStandardQuestion);
                }
            }
            // Se clicou no botao de dialogo de pergunta positivo
            else if( view == cmdDialogoPositive )
            {
                // Fecha o dialogo
                dlgStandardQuestion.dismiss();

                // Se tiver comunicacao de retorno
                if( geralCommunication != null )
                {
                    //Devolve sucesso no clique
                    geralCommunication.geralCommunicate(getClass(), cmdDialogoPositive.getId(), true, Const.DIALOGO_RETORNO_SIM, dlgStandardQuestion);
                }
            }
        }
        catch (Exception err)
        {
            //LogTrace.escreve(Pekus.localErro(getClass(), err), Apoio.getPathLogs(context), Apoio.getArqErr());
        }
    }
}