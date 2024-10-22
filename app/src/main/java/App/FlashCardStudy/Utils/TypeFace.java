package App.FlashCardStudy.Utils;

import android.content.Context;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import java.lang.reflect.Field;

public class TypeFace
{
    /**
     * Método que realiza a troca das fontes dos controles da tela
     */
    public static void changeControlsFont(Context context, String sDefaultFont, int iNewFont) throws Exception
    {
        Typeface customTypeface = null;
        Field fieldFontDefault = null;

        //Obtem a fonte
        customTypeface = ResourcesCompat.getFont(context, iNewFont);

        //Obtem a fonte defualt e realiza a troca para a customizada
        fieldFontDefault = Typeface.class.getDeclaredField(sDefaultFont);
        fieldFontDefault.setAccessible(true);
        fieldFontDefault.set(null, customTypeface);
    }
}

