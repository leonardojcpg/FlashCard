package App.FlashCardStudy.Utils;

/**
 * Classe de auxilio para exceção no servidor
 */
public class ServerException extends Exception
{
    //Variáveis da classe
    public int iErrorCod = 0;

    /**
     * Construtor da classe
     */
    public ServerException(String sMessage)
    {
        super(sMessage);
    }
}
