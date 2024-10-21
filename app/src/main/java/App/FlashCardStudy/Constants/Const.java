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

    // Chaves das preferências para armazenar dados de usuario, email e endereço
    String PREFS_USUARIO = "PREFS_USUARIO";
    String PREFS_CLIENTE = "PREFS_CLIENTE";
    String PREFS_ENDERECO = "PREFS_ENDERECO";
    String PREFS_NOTIFICACOES_RECEBIDAS = "PREFS_NOTIFICACOES_RECEBIDAS";
    String PREFS_PEDIDO_CARRINHO = "PREFS_PEDIDO_CARRINHO";
    String PREFS_ATUALIZAR_PEDIDOS = "PREFS_ATUALIZAR_PEDIDOS";
    String PREFS_ATUALIZAR_CARDAPIO = "PREFS_ATUALIZAR_CARDAPIO";
    String PREFS_CARTAO = "PREFS_CARTAO";
    String PREFS_AVISO_OPINIAO = "PREFS_AVISO_OPINIAO";
    String PREFS_CARDAPIO_PESQUISA = "PREFS_CARDAPIO_PESQUISA";
    String PREFS_CUPOM_FISICO = "PREFS_CUPOM_FISICO";
    String PREFS_LOJA_SELECIONADA_CUPOM = "PREFS_LOJA_SELECIONADA_CUPOM";
    String PREFS_FAVORITO = "PREFS_FAVORITO";
    String PREFS_AUTENTICACAO_DOIS_FATORES_HABILITADA = "PREFS_AUTENTICACAO_DOIS_FATORES_HABILITADA";

    //define do tipo de receiver do broadcast do push
    String EVENTO_PUSH = "pekus.delivery.EVENTO_PUSH";

    //Define para não permitir a volta quando entrar na tela meus endereços
    String RETORNAR_COMPRA = "RETORNAR_COMPRA";

    //Defines dos tipos de integracao de pedidos
    int TIPO_INTEGRACAO_CANCELADO_PEKUS = -1;
    int TIPO_INTEGRACAO_NAO_INTEGRADO = 0;
    int TIPO_INTEGRACAO_ABERTO = 1;
    int TIPO_INTEGRACAO_CANCELADO = 2;
    int TIPO_INTEGRACAO_EXPEDIDO = 3;
    int TIPO_INTEGRACAO_ENVIADO = 4;
    int TIPO_INTEGRACAO_AGUARDANDO_PAGTO = 5;
    int TIPO_INTEGRACAO_AGENDADO = 6;
    int TIPO_INTEGRACAO_PRONTO_PARA_RETIRADA = 7;

    //define de extra para push
    String EXTRA = "extra";

    //define os tipos de plataformas
    int PLATAFORMA_ANDROID = 1;

    //Defines tipos de usuario
    int USUARIO_EMAIL = 1;
    int USUARIO_FACEBOOK = 2;
    int USUARIO_APPLE_ID = 3;
    int USUARIO_GOOGLE = 4;

    //Defines tipos de imagens
    int IMAGEM_PEQUENA = 1;
    int IMAGEM_GRANDE = 2;

    //defines dos tipos de verificacoes de caracteres
    int VALIDACAO_CARACTERES_EXISTE_MAIUSCULA = 1;
    int VALIDACAO_CARACTERES_EXISTE_MINUSCULA = 2;
    int VALIDACAO_CARACTERES_EXISTE_NUMERO = 3;

    //TODO:Depois sempre trocar a key do maps para cada cliente que for enviado
    // API Google Geocoding
    String URL_API_GOOGLE_GEOCODE_JSON = "https://maps.googleapis.com/maps/api/geocode/json?";
    String CHAVE_API_GOOGLE_KEY = "key=";
    String CHAVE_API_GOOGLE_LATLNG = "&latlng=";

    //Defines de retorno do Google
    String RETORNO_API_GOOGLE_ERROR_MESSAGE = "error_message";
    String RETORNO_API_GOOGLE_RESULTS = "results";
    String RETORNO_API_GOOGLE_ADDRESS_COMPONENTS = "address_components";
    String RETORNO_API_GOOGLE_TYPES = "types";
    String RETORNO_API_GOOGLE_ROUTE = "route";
    String RETORNO_API_GOOGLE_STREET_NUMBER = "street_number";
    String RETORNO_API_GOOGLE_POSTAL_CODE = "postal_code";
    String RETORNO_API_GOOGLE_SUBLOCALITY_LEVEL_1 = "sublocality_level_1";
    String RETORNO_API_GOOGLE_ADMINISTRATIVE_AREA_LEVEL_1 = "administrative_area_level_1";
    String RETORNO_API_GOOGLE_ADMINISTRATIVE_AREA_LEVEL_2 = "administrative_area_level_2";
    String RETORNO_API_GOOGLE_COUNTRY = "country";

    //Define para obtenção de nomes completos ou curtos pela api do Google
    String RETORNO_API_GOOGLE_LONG_NAME = "long_name";
    String RETORNO_API_GOOGLE_SHORT_NAME = "short_name";

    //Defines de valores para obtenção de endereço via GPS
    int GPS_INTERVALO_BUSCA  = 10000;
    int GPS_INTERVALO_RAPIDO  = 1000;

    //Requisições de permissão
    int REQUISICAO_PERMISSAO_GRAVACAO_SD_CARD = 1;
    int REQUISICAO_PERMISSAO_LIGAR_CALL_PHONE = 2;
    int REQUISICAO_PERMISSAO_GPS = 3;

    // Constantes do sistema
    String APK = "DeliveryPekus.apk";

    //Define  o voltar do toolbar
    String TOOLBAR_VOLTAR = "back";

    //Define a constante de put extra do CPF
    String TEXTO_PARAMETRO = "TEXTO_PARAMETRO";
    String TIPO_OBSERVACAO = "TIPO_OBSERVACAO";
    String OBRIGATORIO = "OBRIGATORIO";
    String PRODUTO_CARRINHO = "PRODUTO_CARRINHO";
    String POSICAO_PRODUTO_CARRINHO = "POSICAO_PRODUTO_CARRINHO";
    String PRODUTO_SUGESTAO = "PRODUTO_SUGESTAO";

    //Define de mensagem de pagamento
    String MENSAGEM_PAGAMENTO = "MENSAGEM_PAGAMENTO";

    //Constante de put extra para os produtos enviados a pesquisa de cardapio
    String LOJA_SELECIONADA = "LOJA_SELECIONADA";
    String EXIBE_MENSAGEM = "EXIBE_MENSAGEM";
    String ESCONDE_FAVORITO = "ESCONDE_FAVORITO";

    // Extra de mostrar mensagem em entrar endereco
    String TEXTO_AVISO = "TEXTO_ENDERECO";

    //Hashmap para envio de dados
    String HASH_MAP_USUARIO_MOBILE = "UsuarioMobile";
    String HASH_MAP_CLIENTE = "Cliente";
    String HASH_MAP_TOKEN = "Token";
    String HASH_MAP_ENDERECOS = "Enderecos";
    String HASH_MAP_CD_USUARIO = "CdUsuario";
    String HASH_MAP_ENDERECO = "Endereco";
    String HASH_MAP_USUARIOS_MOBILE = "UsuariosMobile";
    String HASH_MAP_CD_LOJA = "CdLoja";
    String HASH_MAP_DS_CEP = "DsCep";
    String HASH_MAP_NR_NUMERO = "NrNumero";
    String HASH_MAP_DS_MENSAGEM = "DsMensagem";
    String HASH_MAP_CD_CLIENTE = "CdCliente";
    String HASH_MAP_NR_VERSAO = "NR_VERSAO";
    String HASH_MAP_FL_TIPO_SISTEMA = "FL_TIPO_SISTEMA";
    String HASH_MAP_DADOS_CARTAO = "DadosCartao";
    String HASH_MAP_CD_CARTAO = "CdCartao";
    String HASH_MAP_DS_CUPOM = "DsCupom";
    String HASH_MAP_NR_VALOR_MINIMO = "NrValorMinimo";
    String HASH_MAP_CD_PEDIDO = "CdPedido";
    String HASH_MAP_PEDIDO_AVALIACAO = "PedidoAvaliacao";
    String HASH_MAP_CD_LOJA_PARAM = "CD_LOJA";
    String HASH_MAP_CD_CUPOM_PARAM = "CD_CUPOM";
    String HASH_MAP_CD_USUARIO_PARAM = "CD_USUARIO";
    String HASH_MAP_CD_PEDIDO_PARAM = "CD_PEDIDO";
    String HASH_MAP_ITENS_PEDIDO = "ItensPedido";
    String HASH_MAP_USUARIO = "Usuario";
    String HASH_MAP_LOJA = "Loja";
    String HASH_MAP_TELEFONE = "TELEFONE";
    String HASH_MAP_EMAIL = "EMAIL";
    String HASH_MAP_CD_TIPO_AUTENTICACAO = "CD_TIPO_AUTENTICACAO";
    String HASH_MAP_DS_TOKEN = "DS_TOKEN";
    String HASH_MAP_TOKEN_INICIAL = "TOKEN_INICIAL";
    String HASH_MAP_USUARIO_CONFIGURACAO = "USUARIO_MOBILE_CONFIGURACAO";
    String HASH_MAP_CD_MATERIAL_PARAM = "CD_MATERIAL";
    String HASH_MAP_INSERE_MATERIAL_PARAM = "INSERE_MATERIAL";
    String HASH_MAP_FL_COMBO_PARAM = "FL_COMBO";
    String HASH_MAP_CD_USUARIO_MOBILE = "CD_USUARIO_MOBILE";
    String HASH_MAP_VALOR_PEDIDO = "ValorPedido";
    String HASH_MAP_TELEFONE_MINUSCULO = "Telefone";
    String HASH_MAP_CD_FIDELIZACAO = "CdFidelizacao";

    //Hashmap das notificacoes push
    String HASH_MAP_IMAGEM_NOTIFICACAO_PUSH = "image";
    String HASH_MAP_TIPO_NOTIFICACAO_PUSH = "type";
    String HASH_MAP_PROMO_NOTIFICACAO_PUSH = "promo";
    String HASH_MAP_BODY_NOTIFICACAO_PUSH = "body";
    String HASH_MAP_TITLE_NOTIFICACAO_PUSH = "title";
    String HASH_MAP_BARRA_PROGRESSO_NOTIFICACAO_PUSH = "progress";

    //Define o tipo de notificação push
    String TIPO_NOTIFICACAO_PUSH_PEDIDO_CANCELADO = "-1";
    String TIPO_NOTIFICACAO_PUSH_PEDIDO_ABERTO = "0";
    String TIPO_NOTIFICACAO_PUSH_PEDIDO_EXPEDIDO = "1";
    String TIPO_NOTIFICACAO_PUSH_PEDIDO_ENVIADO = "2";
    String TIPO_NOTIFICACAO_PUSH_PEDIDO_CONCLUIDO = "3";
    String TIPO_NOTIFICACAO_PUSH_PEDIDO_AGUARDANDO_PGTO = "4";
    String TIPO_NOTIFICACAO_PUSH_PEDIDO_AGENDADO = "5";
    String TIPO_NOTIFICACAO_PUSH_PEDIDO_PRONTO_PARA_RETIRADA = "6";

    //Campos para obtencao no Facebook
    String CAMPOS_FACEBOOK_PUBLIC_PROFILE = "public_profile";
    String CAMPOS_FACEBOOK_EMAIL = "email";
    String CAMPOS_FACEBOOK_NAME = "name";
    String CAMPOS_FACEBOOK_RECEBER = "id, name, email";
    String DADOS_FACEBOOK_FIELDS = "fields";

    //Define dos tamanhos dos campos
    int TAMANHO_CAMPO_TROCO = 5;
    int TAMANHO_CAMPO_CEP = 9;
    int TAMANHO_CAMPO_CEP_SEM_MASCARA = 8;
    int TAMANHO_VERIFICACAO_CPF = 12;
    int TAMANHO_VALIDACAO_CPF = 11;
    int TAMANHO_VALIDACAO_CUPOM = 4;

    //Define da tela de lista seleção
    String DADOS_LISTA_SELECAO = "DADOS_LISTA_SELECAO";
    String TITULO_LISTA_SELECAO = "TITULO_LISTA_SELECAO";
    String VALIDA_LISTA_SELECAO = "VALIDA_LISTA_SELECAO";
    String FILTRA_VALORES_SELECAO = "FILTRA_VALORES_SELECAO";
    String TITULO_FILTRO_VALORES_SELECAO = "TITULO_FILTRO_VALORES_SELECAO";
    String HINT_FILTRO_VALORES_SELECAO = "HINT_FILTRO_VALORES_SELECAO";
    String MENSAGEM_VALIDA_LISTA_SELECAO = "MENSAGEM_VALIDA_LISTA_SELECAO";
    String CLASSE_RETORNO = "CLASSE_RETORNO";
    String ITEM_RETORNO = "ITEM_RETORNO";
    String TEXTO_CONSULTA_PRODUTO = "TEXTO_CONSULTA_PRODUTO";

    //Define de retorno do filtro de estabelecimento
    String ITEM_RETORNO_FILTRO_ESTAB = "ITEM_RETORNO_FILTRO_ESTAB";

    //define dos retornos telas do sistema
    int TIPO_OBSERVACAO_OBSERVACAO_PEDIDO = 1;
    int TIPO_OBSERVACAO_CPF = 2;
    int TIPO_OBSERVACAO_TROCO = 3;

    //Define com a quantidade de casas decimais
    int QUANTIDADE_CASAS_DECIMAIS = 2;

    //Define da imagem de voltar do titulo das telas
    int IMAGEM_VOLTAR_WIDTH = 37;
    int IMAGEM_VOLTAR_HEIGHT = 40;

    //Define de quantidade de colunas para listas
    int QUANTIDADE_COLUNAS_LISTA_UM = 1;

    //Define de flags de combo
    int FLAG_COMBO_SIM = 1;
    int FLAG_COMBO_NAO = 0;

    //Define de sem usuario para envio
    int SEM_USUARIO = -1;

    //define dos retornos telas do sistema
    int RETORNO_TELA_LOGIN = 1;
    int RETORNO_TELA_ENDERECO = 2;
    int RETORNO_TELA_MEUS_ENDERECOS = 3;
    int RETORNO_TELA_CADASTRADO = 4;
    int RETORNO_TELA_PRINCIPAL = 5;
    int RETORNO_TELA_PEDIDO_ITEM = 6;
    int RETORNO_TELA_PEDIDO_CARRINHO = 7;
    int RETORNO_TELA_ENTRAR_CADASTRAR = 8;
    int RETORNO_TELA_PEDIDO_EDICAO = 9;
    int RETORNO_TELA_PESQUISAR_CARDAPIO = 10;
    int RETORNO_TELA_OBSERVACOES_GENERICO = 11;
    int RETORNO_TELA_LISTA_SELECAO = 12;
    int RETORNO_TELA_ESQUECI_SENHA = 13;
    int RETORNO_TELA_PESQUISAR_RESTAURANTE = 14;
    int RETORNO_TELA_MINHAS_FORMAS_PAGTO = 15;
    int RETORNO_TELA_CAD_FORMAS_PAGTO = 16;
    int RETORNO_TELA_LOGIN_CAD_CARTAO = 17;
    int RETORNO_TELA_PEDIDO_SUGESTAO = 18;
    int RETORNO_TELA_PEDIDO_ITEM_SEM_SUGESTAO = 19;
    int RETORNO_TELA_ADICIONAR_OBSERVACOES_COMBO = 20;
    int RETORNO_TELA_PAGTO_DIGITAL = 21;
    int RETORNO_TELA_OBSERVACOES_GENERICO_OBRIGATORIO_CPF = 22;
    int RETORNO_TELA_AVALIACAO = 23;
    int RETORNO_TELA_DETALHES_PEDIDO = 24;
    int RETORNO_TELA_SESSAO_COMBO = 25;
    int RETORNO_TELA_CONCLUIR_COMBO = 26;
    int RETORNO_TELA_LOGIN_GOOGLE = 27;
    int RETORNO_TELA_FIDELIZACAO = 28;
    int RETORNO_TELA_CUPOM = 29;
    int RETORNO_TELA_LISTA_CUPONS = 30;
    int RETORNO_TELA_MINHA_CONTA = 31;
    int RETORNO_TELA_EXIBIR_MAPA = 32;
    int RETORNO_TELA_DADOS_LOJA_CUPOM = 33;
    int RETORNO_TELA_CARRINHO_DESCONTOS = 34;
    int RETORNO_TELA_FIDELIZACOES_LOJA = 35;
    int RETORNO_TELA_TIPO_AUTENTICACAO = 36;
    int RETORNO_TELA_AUTENTICACAO = 37;
    int RETORNO_TELA_LISTA_SELECAO_BAIRRO = 38;
    int RETORNO_TELA_FILTRO_LISTA_SELECAO = 39;
    int RETORNO_TELA_FIDELIZACAO_PONTOS = 40;
    int RETORNO_TELA_FIDELIZACAO_CASHBACK = 41;

    //Constantes das guias do principal
    int PRINCIPAL_TAB_CARDAPIO = 0;
    int PRINCIPAL_TAB_PEDIDOS = 2;
    int PRINCIPAL_TAB_INFORMACOES = 3;
    int PRINCIPAL_TAB_FAVORITOS = 1;

    //Define para o menu de opções
    int MENU_INFORMACOES_ESTABELECIMENTO = 0;
    int MENU_MINHA_CONTA = 1;
    int MENU_NOTIFICACOES = 2;
    int MENU_FALE_CONOSCO = 3;
    int MENU_POLITICA = 4;
    int MENU_TERMO_USO = 5;
    int MENU_COMPRAR_CONOSCO = 6;
    int MENU_SOBRE = 7;
    int MENU_EFETUAR_LOGIN = 8;
    int MENU_COMPARTILHAR = 9;
    int MENU_SAIR = 10;

    //Define para a tela de minha conta
    int MENU_MINHA_CONTA_MEUS_DADOS = 0;
    int MENU_MINHA_CONTA_MEUS_ENDERECOS = 1;
    int MENU_MINHA_CONTA_MINHAS_FORMAS_PAGTO = 2;
    int MENU_MINHA_CONTA_FIDELIZACAO = 3;
    int MENU_MINHA_CONTA_ALTERAR_SENHA = 4;
    int MENU_MINHA_CONTA_CONFIGURACOES = 5;
    int MENU_MINHA_CONTA_SAIR = 6;
    int MENU_MINHA_CONTA_APAGAR_CONTA = 7;

    //Define dos dados de lojas
    String DADOS_JSON_LOJAS = "LOJAS";
    String DADOS_JSON_BANDEIRAS = "BANDEIRAS";


    //Define dos dados do cardapio
    String DADOS_JSON_CARDAPIO = "Cardapio";
    String DADOS_JSON_FAVORITOS = "Favoritos";

    //Define para a tela de cadastro
    String CADASTRO_TIPO = "CADASTRO_INICIO";
    String CADASTRO_EMAIL_FACEBOOK = "CADASTRO_EMAIL_FACEBOOK";
    String CADASTRO_NOME_FACEBOOK = "CADASTRO_NOME_FACEBOOK";

    //Define para a tela de endereço
    String USUARIO_CADASTRAR_ENDERECO = "USUARIO_CADASTRAR_ENDERECO";
    String CLIENTE_CADASTRAR_ENDERECO = "CLIENTE_CADASTRAR_ENDERECO";

    //Define para a tela de item do pedido
    String ITEM_PEDIDO_DETALHES = "ITEM_PEDIDO_DETALHES";
    String ITEM_PEDIDO_LOJA = "ITEM_PEDIDO_LOJA";
    String ITEM_PEDIDO_MATERIAL = "ITEM_PEDIDO_MATERIAL";
    String ITEM_PEDIDO_ENDERECO = "ITEM_PEDIDO_ENDERECO";
    String ITEM_PEDIDO_DADOS_ESTAB = "ITEM_PEDIDO_DADOS_ESTAB";
    String ITEM_PEDIDO_FEZ_LOGIN = "ITEM_PEDIDO_FEZ_LOGIN";
    String OBJETO_CUPOM = "OBJETO_CUPOM";
    String ITEM_LOGIN_PELO_CUPOM = "ITEM_LOGIN_PELO_CUPOM";

    //Parametros de coordenadas
    String ITEM_CUPOM_LATITUDE = "ITEM_CUPOM_LATITUDE";
    String ITEM_CUPOM_LONGITUDE = "ITEM_CUPOM_LONGITUDE";
    String ITEM_CUPOM_ESTADO = "ITEM_CUPOM_ESTADO";

    //Define para a tela de observação do item combo
    String ITEM_MATERIAL_OBSERVACAO_COMBO = "ITEM_MATERIAL_OBSERVACAO_COMBO";
    String ITEM_POSICAO_CARDAPIO_OBSERVACAO_COMBO = "ITEM_POSICAO_CARDAPIO_OBSERVACAO_COMBO";

    //Define para a tela de pagamento PIX
    String ITEM_STATUS_PAGTO = "ITEM_STATUS_PAGTO";

    //Define para a tela de termnos e politica
    String URL_TERMOS_POLITICA = "URL_TERMOS_POLITICA";
    String DEFINE_TERMOS_POLITICA = "DEFINE_TERMOS_POLITICA";

    //Define para a tela de filtro de estabelecimento
    String DADOS_FILTRO_ESTAB = "DADOS_FILTRO_ESTAB";

    //Define para a tela de filtro de estabelecimento
    String PEDIDO_INFO = "PEDIDO_INFO";

    //Parametros de coordenadas do mapa
    String MAPA_COORDENADAS_LAT = "MAPA_COORDENADAS_LAT";
    String MAPA_COORDENADAS_LONG = "MAPA_COORDENADAS_LONG";
    String MAPA_COORDENADAS_CD_PEDIDO = "MAPA_COORDENADAS_CD_PEDIDO";

    //constantes de criptografia e compactacao
    boolean CRIPTOGRAFAR = true;
    boolean COMPACTAR = true;

    //Constante para apresentar os menus referente ao tipo de restaurante
    int LINEAR_TIPO_RESTAURANTE_VISIVEL = 1;

    // Constantes de retorno do dialogo de mensagem
    int DIALOGO_RETORNO_OK = 1;
    int DIALOGO_RETORNO_SIM = 2;
    int DIALOGO_RETORNO_NAO = 3;

    //Defines das linguagens
    int IDIOMA_PORTUGUES = 1;
    int IDIOMA_INGLES = 2;
    int IDIOMA_ESPANHOL = 3;

    //Constantes para linguagem
    String IDIOMA_LINGUAGEM_PT = "pt";
    String IDIOMA_LINGUAGEM_EN = "en";
    String IDIOMA_LINGUAGEM_ES = "es";
    String IDIOMA_PAIS_BR = "BR";
    String IDIOMA_PAIS_US = "US";
    String IDIOMA_PAIS_ES = "ES";

    //Constantes para loja fechada e aberta
    int LOJA_ABERTA = 0;
    int LOJA_FECHADA = 1;

    //Constantes de tipo de caracteres
    String TIPO_CARACTERES_UTF_8 = "UTF-8";
    String TIPO_HTML_BLARG = "blarg://ignored";

    // Tags diversas
    String TAG_DISCAGEM = "tel:";
    String TAG_ENVIO_EMAIL = "mailto";

    //Constantes de precificacao do combo
    int PRECIFICACAO_MAIORPRECO = 1;
    int PRECIFICACAO_MEDIA = 2;
    int PRECIFICACAO_PRECOFIXO = 3;
    int PRECIFICACAO_RODIZIO = 4;

    //Constantes de quantificacao do combo
    int QUANTIFICACAO_FRACIONADO = 1;
    int QUANTIFICACAO_INTEIRO = 2;

    //Constante para tipo de pagamento
    int TIPO_PAGTO_DINHEIRO = 1;
    int TIPO_PAGTO_PRESENCIAL = 2;
    int TIPO_PAGTO_REMOTO = 3;
    int TIPO_PAGTO_DIGITAL = 4;
    int TIPO_PAGTO_DIGITAL_QLUB = 9;

    // Verificação do sistema
    short TIPO_SISTEMA_ANDROID = 0;

    //Define de produtos esgotados
    int PRODUTO_ESGOTADO = 1;

    //Define de observação digitada
    int OBSERVACAO_DIGITADA = 1;

    //Constante para tipo de delivery
    int TIPO_DELIVERY_PAGTO = 1;
    int TIPO_DELIVERY_WHATSAPP = 2;

    //Defines de tipos de cartão
    int TIPO_BANDEIRA_VISA = 0;
    int TIPO_BANDEIRA_MASTER = 1;
    int TIPO_BANDEIRA_AMEX = 2;
    int TIPO_BANDEIRA_ELO = 3;
    int TIPO_BANDEIRA_DISCOVER = 4;
    int TIPO_BANDEIRA_DINERS = 5;
    int TIPO_BANDEIRA_AURA = 6;
    int TIPO_BANDEIRA_JCB = 7;
    int TIPO_BANDEIRA_HIPERCARD = 8;

    //Define dos tipos de documento
    int TIPO_DOCTO_CPF = 0;
    int TIPO_DOCTO_CNPJ = 1;

    //Retirar na loja
    int RETIRAR_NA_LOJA = 1;

    //Define de flags de retirar loja
    int FLAG_RETIRAR_LOJA_MARCADO = 1;
    int FLAG_RETIRAR_LOJA_NAO_MARCADO = 0;

    //Quantidade de vezes para pedir a opinião do cliente
    int QTDE_VEZES_PEDIR_OPINIAO = 5;

    //Desconto habilitado
    int DESCONTO_HABILITADO = 1;
    int DESCONTO_POR_VALOR = 1;

    //TODO: IMPORTANTE NÃO ALTERAR!!!!
    //ESTA MENSAGEM SERVE PARA VALIDAÇÃO DO CUPOM, NÃO DEVE SER RETIRADA OU ALTERADA DAQUI
    //Mensagem de retorno do servidor, quando o cupom já foi utilizado
    String MENSAGEM_CUPOM_DESCONTO_UTILIZADO = "ESTE CUPOM DE DESCONTO JÁ FOI UTILIZADO!";

    //Tempo para chamada da próxima verificação do pagamento digital (15 segundos)
    int TEMPO_VERIFICACAO_PAGTO_DIGITAL = 15000;

    //Tempo para chamada da próxima atualização do mapa (30 segundos)
    int TEMPO_ATUALIZACAO_MAPA = 30000;

    // Constantes dos status dos pagamentos digitais dentro do ePed
    int STATUS_PAGTO_DIGITAL_PENDENTE = 0;
    int STATUS_PAGTO_DIGITAL_PAGO = 1;
    int STATUS_PAGTO_DIGITAL_CANCELADO = 2;
    int STATUS_PAGTO_DIGITAL_EXPIRADO = 3;

    //Constantes de agendamento
    int AGENDAMENTO_HABILITADO = 1;
    int AGENDAMENTO_OBRIGATORIO = 1;

    //Tipo hora nos agendamentos minimo e maximo
    int TIPO_HORA_AGENDAMENTO = 0;

    // Constantes das estrelas da tel de avaliação
    int ESTRELA_1 = 0;
    int ESTRELA_2 = 1;
    int ESTRELA_3 = 2;
    int ESTRELA_4 = 3;
    int ESTRELA_5 = 4;

    //Constante de verificação se tem contato via whatsapp
    int FL_CONTATO_VIA_WHATSAPP_SIM = 1;

    // Flags genéricas
    int FL_VERDADEIRO = 1;
    int FL_FALSO = 0;

    // Extras de intent
    String EXTRA_MATERIAL = "EXTRA_MATERIAL";
    String EXTRA_PRODUTO_CARRINHO = "EXTRA_PRODUTO_CARRINHO";
    String EXTRA_POSICAO_COMBO = "EXTRA_POSICAO_COMBO";
    String EXTRA_ENVIO_CARDAPIO = "EXTRA_ENVIO_CARDAPIO";
    String EXTRA_CD_FIDELIZACAO = "EXTRA_CD_FIDELIZACAO";
    String EXTRA_FIDELIZACAO = "EXTRA_FIDELIZACAO";
    String PONTOS_UTILIZADOS = "PONTOS_UTILIZADOS";
    String PONTOS_CASHBACK_UTILIZADOS = "PONTOS_CASHBACK_UTILIZADOS";
    String VALOR_DESCONTO = "VALOR_DESCONTO";
    String EXTRA_REGULAMENTO = "EXTRA_REGULAMENTO";
    String FIDELIZACAO_CASHBACK_SELECIONADA = "FIDELIZACAO_CASHBACK_SELECIONADA";

    // Flag de voltar tudo combo
    int RESULT_VOLTAR_CARDAPIO = 1;
    int RESULT_ERRO_ENDERECO = 2;
    int RESULT_RETORNA_CUPONS = 3;
    int RESULT_MUDAR_ENDERECO = 4;

    // Flag de se o cupom é pra colocar na barra
    int EXIBE_IMAGEM_BANNER = 1;

    // url do gerador de qr code
    String URL_QRCODE = "https://chart.googleapis.com/chart?chs=210x210&cht=qr&chl=";

    // Constante dos meios de pagamento  0-Safe2Pay 1-Rede, 2-PagSeguro, 3-Cielo
    int TIPO_SAFE2PAY = 0;
    int TIPO_REDE = 1;
    int TIPO_PAGSEGURO = 2;
    int TIPO_CIELO = 3;

    //Constantes de tipo de fidelização
    int TIPO_FIDELIDADE_CRM = -1;
    int TIPO_FIDELIDADE_VALOR = 0;
    int TIPO_FIDELIDADE_QUANTIDADE = 1;
    int TIPO_FIDELIDADE_PONTOS = 2;
    int TIPO_FIDELIDADE_CASHBACK = 3;

    // Constante de tipo de desconto de fidelização
    int TIPO_DESCONTO_FIDELIDADE_PERCENTUAL = 0;
    int TIPO_DESCONTO_FIDELIDADE_VALOR = 1;

    // Tipos de cupom de balcao
    int TIPO_CUPOM_BALCAO_VALOR = 0;
    int TIPO_CUPOM_BALCAO_PERCENTUAL = 1;

    // Constante do mapa
    int EXIBIR_MAPA = 1;

    //Constante para o máximo de resultados de obtenção de endereços
    int MAXIMO_RESULTADO_OBTENCAO_ENDERECO = 5;

    //Pastas e extensões para o app
    String ARQUIVO_POLITICA = "politicaprivacidade.html";
    String ARQUIVO_TERMOS = "termosuso.html";

    //Tag de troca dos arquivos de politica e termos
    String TAG_TROCA_POLITICA_TERMOS = "_NOMECLIENTE_";

    //Constante para habilitar o fale conosco
    int FALE_CONOSCO_HABILITADO = 1;

    //Constante para tipo de app para envio do token
    int TIPO_APP_DELIVERY = 0;

    //Constante para identificação de seções
    String SECAO_PROMOCOES = "Promoções";

    //Constantes para contagem dos componentes no CardapioScrollListener
    int CONTAGEM_HEADER_ITEM = 2;
    int CONTAGEM_HEADER = 1;

    //Constantes para forma de mostrar o bottom da tela principal
    int MOSTRAR_BOTTOM_ESCONDE_VOLTAR = 0;
    int ESCONDE_BOTTOM_MOSTRA_VOLTAR = 1;
    int ESCONDE_BOTTOM_ESCONDE_VOLTAR = 2;
    int MOSTRAR_BOTTOM_MOSTRAR_VOLTAR = 3;
    int ESCONDE_VOLTAR = 4;
    int MOSTRAR_VOLTAR = 5;

    //define dos retornos telas do sistema
    int RETORNO_PEDIDO_EXCLUIR_CUPOM_FIDELIZACAO = -1;

    //Chaves de intent da autenticação
    String TIPO_AUTENTICACAO = "TIPO_AUTENTICACAO";
    String TELEFONE_USUARIO = "TELEFONE_USUARIO";
    String EMAIL_USUARIO = "EMAIL_USUARIO";
    String MENSAGEM_AUTENTICACAO = "MENSAGEM_AUTENTICACAO";
    String TEMPO_EXPIRACAO_TOKEN = "TEMPO_EXPIRACAO_TOKEN";
    int AUTENTICACAO_VIA_EMAIL = 1;
    int AUTENTICACAO_VIA_WHATSAPP = 2;

    //Constantes para identificação do tipo de pagamento digital
    String PIX = "PIX";
    String URL = "URL";

    //Constante do tamanho do token de autenticação
    int TAMANHO_TOKEN_AUTENTICACAO = 6;

    // Não mexeu no favorito
    int NAO_MUDOU_FL_FAVORITO = -1;
}