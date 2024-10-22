package App.FlashCardStudy.Screens;

import android.os.Bundle;
import App.FlashCardStudy.Base.FlashCardStudyActivity;
import App.FlashCardStudy.R;

public class FrmLogin extends FlashCardStudyActivity
{
    //Variaveis da classe

    //Controles da classe


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
    }

    @Override
    public void loadData() throws Exception
    {
        super.loadData();
    }

    @Override
    public void getParameters() throws Exception
    {
        super.getParameters();
    }

    @Override
    public void onReceiveData(Class classes, int iId, boolean bResult, Object... oObjetcts)
    {
        super.onReceiveData(classes, iId, bResult, oObjetcts);
    }
}
