package App.FlashCardStudy.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import java.util.Locale;

import App.FlashCardStudy.Base.FlashCardStudyActivity;
import App.FlashCardStudy.Constants.Const;
import App.FlashCardStudy.R;

public class Support
{
    /**
     * Carrega a imagem e a toolbar de voltar
     */
    public static void loadToolbarBack(@NonNull Toolbar toolbar, FlashCardStudyActivity flashCardStudyActivity) throws Exception
    {
        Drawable drawableColor = null;

        //TODO: Definições para ícones
        //Todos os ícones são feitos atraves do site abaixo a partir do original:
        //https://romannurik.github.io/AndroidAssetStudio/icons-generic.html#source.type=image&source.space.trim=1&source.space.pad=0&size=48&padding=4&color=rgba(255%2C%20255%2C%20255%2C%200)&name=menu_voltar
        // Para os da barra da toolbar colocar padding de 8dp e assent size de 48dp
        // Para o voltar ou o home, colocar padding de 4dp e assent size de 24dp
        // Para os de float action button colocar padding de 0dp e assent size de 48dp

        // Sempre jogar estes tipos de ícone no mipmap
        // Se for imagem de tamanho definido, tipo logotipo, entre outros vai para o drawable

        // Definiçao para ícones da aplicação e de notificação
        // http://assetstudio.androidpro.com.br/

        //Obtem o drawable da seta de voltar
        drawableColor = ContextCompat.getDrawable(flashCardStudyActivity, R.mipmap.menu_voltar);

        //Muda a cor padrão para a nova
        drawableColor.setColorFilter(ContextCompat.getColor(flashCardStudyActivity, R.color.cor_app), PorterDuff.Mode.SRC_ATOP);

        //Seta o navigation item
        toolbar.setNavigationIcon(drawableColor);
        toolbar.setNavigationContentDescription(Const.TOOLBAR_VOLTAR);

        //Coloca a toolbar como actionbar e adiciona as opções de menu
        flashCardStudyActivity.setSupportActionBar(toolbar);
    }

    /**
     * Coloca uma view com foco na tela
     */
    public static void setFocus(View view, AppCompatActivity activity) throws Exception
    {
        //Verifica se conseguiu solicitar o foco
        if (view.requestFocus())
        {
            //Mostra o teclado
            ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(view, 0);
        }
    }

    public static int appLanguage()
    {
        //cria as variaveis
        int iLanguage = 0;
        String sLanguageCode = "";

        //pega o codigo da linguagem
        sLanguageCode = Locale.getDefault().getLanguage();

        //pega o idioma do aplicativo e o transforma em um numero de controle
        if (sLanguageCode.compareToIgnoreCase(Const.IDIOMA_LINGUAGEM_EN) == 0)
        {
            iLanguage = Const.IDIOMA_INGLES;
        }
        else if(sLanguageCode.compareToIgnoreCase(Const.IDIOMA_LINGUAGEM_ES) == 0)
        {
            iLanguage = Const.IDIOMA_ESPANHOL;
        }
        else
        {
            // Idioma padrão
            iLanguage = Const.IDIOMA_PORTUGUES;
        }

        //retorna o numero de representacao da linguagem
        return iLanguage;
    }

}
