package App.FlashCardStudy.Base;

import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;


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
}
