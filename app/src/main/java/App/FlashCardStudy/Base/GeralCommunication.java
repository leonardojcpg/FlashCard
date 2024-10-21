package App.FlashCardStudy.Base;

/**
 * Usado por tasks, fragmentos e qualquer outro componente do android que deseje
 * se comunicar diretamente com uma activity atráves do método onReceiveData().
 */

public interface GeralCommunication
{
    /**
     * Chame este método para se comunicar diretamente com a activity através do método
     * onReceiveData().
     * @param classes A classe que está chamando (use o this.getClass())
     * @param iId Se houver multiplos métodos chamando a comunicação com o
     *            fragmento, use um ID para identificar o botão/método que
     *            está chamando.
     * @param bResult O resultado da operação/task (se houver)
     * @param oObjects Objetos extras podem ser enviados caso desejado.
     */
    void geralCommunicate(Class classes, int iId, boolean bResult, Object... oObjects);
}
