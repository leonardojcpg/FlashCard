package App.FlashCardStudy.Base;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import App.FlashCardStudy.R;
import App.FlashCardStudy.Utils.Support;


public class FlashCardStudyActivity extends AppCompatActivity implements GeralCommunication
{

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);

        try
        {
            //Seta para forçar a tela sempre sem o modo escuro
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

            //Obtem os parametros da intent
            getParameters();

            //Inicia todos os controles da tela
            startControls();

            //carrega os dados nas variaveis e controles
            loadData();

            //Se a versão for maior ou igual ao lolipop, define as animações
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            {
                //chama o método para definir os elementos compartilhados
                definirSharedElements();
            }
        }
        catch (Exception err)
        {
//            LogTrace.escreve(Pekus.localErro(getClass(), err), Apoio.getPathLogs(this), Apoio.getArqErr());
//            new AlertaPadrao(this, null).abreDialogoPadrao(Apoio.getMsgErr(getClass(), err), getString(R.string.atencao));
        }
    }
    public void startControls() throws Exception
    {

    }

    public void loadData() throws Exception
    {
    }

    public void getParameters() throws Exception
    {
    }

    public void onReceiveData(Class classes, int iId, boolean bResult, Object... oObjetcts)
    {
    }

    public void definirSharedElements() throws Exception
    {
    }

    @Override
    public void geralCommunicate(Class classes, int iId, boolean bResult, Object... oObjects)
    {
        try
        {
            //Chama o método para que a activity trate, caso deseje.
            onReceiveData(classes, iId, bResult, oObjects);
        }
        catch (Exception err)
        {
//            LogTrace.escreve(Pekus.localErro(getClass(), err), Apoio.getPathLogs(this), Apoio.getArqErr());
//            new AlertaPadrao(this, null).abreDialogoPadrao(Apoio.getMsgErr(getClass(), err), getString(R.string.atencao));
        }
    }

    /**
     * Passa por todas views da activity trocando a fonte para a padrão do projeto
     * @param view
     * @throws Exception
     */
    private void setFontActivity(ViewGroup view) throws Exception
    {
        View viewAux = null;
        TextView textView = null;

        // Fazemos um laço para passar pelas subviews da view recebida por parametro
        for (int iPosicao = 0; iPosicao < view.getChildCount(); iPosicao++)
        {
            // recuperamos
            viewAux = view.getChildAt(iPosicao);

            // Se a view for um textview
            if (viewAux instanceof TextView)
            {
                // Recuperamos o objeto do textview e aplicamos a fonte padrão
                textView = (TextView)viewAux;
                Support.setfont(this, textView, R.font.montmedio, textView.getTypeface().isBold(), textView.getTypeface().isItalic());
            }
            // Caso seja outro viewGroup
            else if (viewAux instanceof ViewGroup)
            {
                // Invocamos o método mais uma vez para criar recurssividade
                // e passar por todas as views da tela
                setFontActivity((ViewGroup)viewAux);
            }
        }
    }
}
