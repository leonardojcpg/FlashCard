package App.FlashCardStudy.Screens;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import App.FlashCardStudy.Base.FlashCardStudyActivity;
import App.FlashCardStudy.R;

public class FrmHistory extends FlashCardStudyActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle bundleSavedInstanceState)
    {
        //Esconde barra do android
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Carrega o formulario
        setContentView(R.layout.frm_history);

        //O super vem depois, pois como estamos implementando de uma classe base da pekus, se não ficar na sequencia não carrega os controles
        super.onCreate(bundleSavedInstanceState);
    }

    @Override
    public void startControls()
    {}

    @Override
    public void onClick(View view)
    {

    }
}
