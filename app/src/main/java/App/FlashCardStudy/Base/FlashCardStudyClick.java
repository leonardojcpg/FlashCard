package App.FlashCardStudy.Base;

import android.os.SystemClock;
import android.util.Log;
import android.view.View;

/**
 * Classe responsavel pelos cliques das telas do projeto
 */
public class FlashCardStudyClick implements View.OnClickListener
{
    //Variaveis da classe
    private View.OnClickListener listener = null;
    private long lLastTimeClick = 0;

    //Construtor da classe
    public FlashCardStudyClick(View.OnClickListener listenerParam)
    {
        listener = listenerParam;
    }

    /**
     *  O FlashCardStudyClick foi criado pois a ação dos botões estavam sendo acionadas duas vezes seguidas
     *  abrindo posteriormente do clique duplo seguido dois dialogos da senha
     *  substituindo o 'this' no 'setOnClickListener' por 'FlashCardStudyClick' há um intervalo de tempo
     *  para que não ocorra dois eventos após o clique duplo seguido
     * @param view
     */
    @Override
    public void onClick(View view)
    {
        //Se o tempo real menos o tempo do ultimo clique for menor que 1 segundo
        if(SystemClock.elapsedRealtime() - lLastTimeClick < 1000)
        {
            //Retorna
            return;
        }

        //Obtem o tempo real do aplicativo
        lLastTimeClick = SystemClock.elapsedRealtime();

        //Faz o clique
        Log.d("Passei", "Passei");
        listener.onClick(view);
    }
}