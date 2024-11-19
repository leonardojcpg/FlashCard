package App.FlashCardStudy.Constants;

/**
 * Constantes do projeto
 */
public interface Const
{
    //Constante para o REGEX do email
    String REGEX_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    //Constante para o REGEX do nome
    String REGEX_NAME = "^[ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzçÇÃÁÂãáâàÉéíÍÓóêÊôÔÕõúÚù ]+$";

    //Constante para o REGEX do nome
    String REGEX_SENHA = "^(?=.*[a-z])(?=.*\\d)(?=\\S+$).{8,25}$";

    //Constante para REGEX de telefone
    String REGEX_TELEFONE = "(?:9[0-9]{1}|[1-5]{1})[0-9]{3}-[0-9]{4}";

    //Modificáveis e modificadores para a troca de caracter
    String[] MODIFICAVEIS = {
            "~", "\"", "`", "'", "´", "Á", "Ã", "À", "Â", "Ä", "É", "È", "Ë", "Ê", "Í", "Ì", "Ï", "Î", "Ó", "Õ", "Ò", "Ö", "Ô", "Ú", "Ù", "Ü", "Û", "Ç", "Ñ", "à", "á", "â", "ã", "ä", "é", "è", "ê", "ë", "í", "ì", "î", "ï", "ó", "ò", "õ", "ô", "ö",
            "ú", "ù", "û", "ü", "ç", "ñ"
    };

    String[] MODIFICADORES = {
            " ", " ", " ", " ", " ", "A", "A", "A", "A", "A", "E", "E", "E", "E", "I", "I", "I", "I", "O", "O", "O", "O", "O", "U", "U", "U", "U", "C", "N", "a", "a", "a", "a", "a", "e", "e", "e", "e", "i", "i", "i", "i", "o", "o", "o", "o", "o",
            "u", "u", "u", "u", "c", "n"
    };

    //define o formato padrao de data
    String FORMATO_PADRAO_HORA = "HH:mm";
    String FORMATO_PADRAO_DATA = "yyyy-MM-dd HH:mm:ss.SSS";
    String FORMATO_DATA_HORA_AGENDAMENTO = "dd/MM/yyyy HH:mm";

    // define o formatado padrao de data dia/mes/ano
    String FORMATO_DATA_PT_BR = "dd/MM/yyyy";

    //Define para o tempo de duração do splash
    int TEMPO_DISPLAY_SPLASH = 1500;

    //Define para o tempo de duração do posicionamento do tablayout do cardápio
    int TEMPO_POSICIONAMENTO_TAB_CARDAPIO = 150;

    // Constantes de preferencias
    String PREFS_TOKEN = "prefs_token";

    //Chave de protecao
    // 13FA386162B3CDEF    95016218773023DE
    byte[] B_CHAVE_ARR_KEY = new byte[] {(byte)0x13, (byte)0xfa, (byte)0x38, (byte)0x61, (byte)0x62, (byte)0xb3, (byte)0xcd, (byte)0xef};
    byte[] B_CHAVE_ARR_IV = new byte[] {(byte)0x95, (byte)0x01, (byte)0x62, (byte)0x18, (byte)0x77, (byte)0x30, (byte)0x23, (byte)0xde};


    // Constantes de retorno do dialogo de mensagem
    int DIALOGO_RETORNO_OK = 1;
    int DIALOGO_RETORNO_SIM = 2;
    int DIALOGO_RETORNO_NAO = 3;

    //Constantes para linguagem
    String IDIOMA_LINGUAGEM_PT = "pt";
    String IDIOMA_LINGUAGEM_EN = "en";
    String IDIOMA_LINGUAGEM_ES = "es";
    String IDIOMA_PAIS_BR = "BR";
    String IDIOMA_PAIS_US = "US";
    String IDIOMA_PAIS_ES = "ES";

    //Defines das linguagens
    int IDIOMA_PORTUGUES = 1;
    int IDIOMA_INGLES = 2;
    int IDIOMA_ESPANHOL = 3;

    //String da toolbar
    String TOOLBAR_VOLTAR = "back";


    //Tag de troca dos arquivos de politica e termos
    String TAG_TROCA_POLITICA_TERMOS = "_NOMECLIENTE_";

    //Constantes para imagens do firebase
    String HASH_MAP_URL_IMAGEM_FIREBASE = "imageUrl";
    String HASH_MAP_FLASHCARDS_FIREBASE = "flashcards";
    String HASH_MAP_FLASHCARDS_NAME = "imageName";
    String HASH_MAP_FLASHCARDS_RESPONSES = "responses";
}