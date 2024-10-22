package App.FlashCardStudy.Base;

import android.content.Context;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import App.FlashCardStudy.R;
import App.FlashCardStudy.Utils.TypeFace;

public class FlashCardStudyAttachment extends AppCompatActivity implements GeralCommunication
{
    // Contexto da tela pricipal
    private Context mainContext = null;

    @Override
    public void geralCommunicate(Class classes, int iId, boolean bResult, Object... oObjects)
    {
    }


    /**
     * Criamos o método de criação para aaplicar, pois não há create em tela anexadas
     */
    protected void criaActivityAnexo(Context contextPrincipalParam)
    {
        try
        {
            // Define contexto principal
            mainContext = contextPrincipalParam;

            //Troca a fonte dos controles de tela de forma geral
            TypeFace.changeControlsFont(mainContext, "SERIF", R.font.montmedio);

            //Seta para forçar a tela sempre sem o modo escuro
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

            //Obtem os parametros da intent
            obtemParametros();

            //Inicia todos os controles da tela
            iniciaControles();

            //carrega os dados nas variaveis e controles
            carregaDados();

            //Se a versão for maior ou igual ao lolipop, define as animações
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            {
                //chama o método para definir os elementos compartilhados
                definirSharedElements();
            }
        }
        catch (Exception err)
        {
//            LogTrace.escreve(Pekus.localErro(getClass(), err), Apoio.getPathLogs(contextPrincipal), Apoio.getArqErr());
//            new AlertaPadrao(contextPrincipal, null).abreDialogoPadrao(Apoio.getMsgErr(getClass(), err), contextPrincipal.getString(R.string.atencao));
        }
    }

    /**
     * O método utilizado para iniciar os controles da tela.
     * Este é usado para encontrar as views na tela e para atribuir
     * listeners aos views.<br><br>
     * <p>
     * O método será chamado automáticamente pelo método OnCreate().<br>
     * <b>NÃO CHAME ESTE MÉTODO MANUALMENTE</b>.
     */
    public void iniciaControles() throws Exception
    {
    }

    /**
     * Usado para atribuir dados aos controles da tela.
     * Este método é usado para definir valores para as variaveis
     * e para as views da tela. Chame todos os métodos para
     * preenchimento de dados aqui.<br><br>
     * <p>
     * O método será chamado automáticamente pelo método OnCreate().<br>
     * <b>NÃO CHAME ESTE MÉTODO MANUALMENTE</b>.
     */
    public void carregaDados() throws Exception
    {
    }

    /**
     * Usado para obter os parametros da intent.
     * Este método é usado para obter as variaveis da intent e atribui-las
     * á variaveis das classes.<br><br>
     *
     * O método será chamado automáticamente pelo método OnCreate().<br>
     * <b>NÃO CHAME ESTE MÉTODO MANUALMENTE</b>.
     */
    public void obtemParametros() throws Exception
    {
    }

    /**
     * Usado para definir os elementos compartilhados entre telas.
     * Este método é usado para definir o transition name de uma view para realizar a animação
     * entre duas ou mais telas.<br><br>
     *
     * O método será chamado automáticamente pelo método OnCreate e a verificação da versão
     * (>= Lolipop) é feita automáticamente. Não é necessário tratar erros.<br>
     * Declare a anotação @TargetApi(Build.VERSION_CODES.LOLLIPOP) ao usar o método.<br>
     * <b>NÃO CHAME ESTE MÉTODO MANUALMENTE</b>.
     */
    public void definirSharedElements() throws Exception
    {
    }

    /**
     * Quando um componente chamar a comunicação com a activity, este método será chamado automáticamente.
     * Para identificar a classe que está chamando, basta comparar
     * o objeto classe com a classe que deseja.<br>
     *     Ex. <b>if (classe == TaskImportaDados.class)</b> {}<br><br>
     *
     * Este método será chamado automáticamente quando o método comunicaComActivity()
     * da interface IComunicacaoActivity for chamado por um componente externo.<br>
     * <b>NÃO CHAME ESTE MÉTODO MANUALMENTE</b><br><br>
     *
     * Não é necessário realizar o tratamento de erros.
     * @param classe classe que chamou o método
     * @param iId Se houver multiplos métodos chamando a comunicação com o
     *            fragmento, use um ID para identificar o botão/método que
     *            está chamando.
     * @param bResultado O resultado da operação/task (se houver)
     * @param oObjetos Dados adicionais podem ser passados por parametros caso necessário
     */
    public void onReceiveData(Class classe, int iId, boolean bResultado, Object... oObjetos)
    {
    }

}
