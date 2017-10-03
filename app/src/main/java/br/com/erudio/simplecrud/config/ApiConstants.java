package br.com.erudio.simplecrud.config;

public class ApiConstants {

    private static final String ROOT_PATH = "http://192.168.101.1:8080/api/";

    private static final String NATURAL_PERSON_PATH = ROOT_PATH + "pessoaFisica/";
    private static final String LEGAL_PERSON_PATH = ROOT_PATH + "pessoaJuridica/";
    private static final String HELPER_PATH = ROOT_PATH + "helper/";
    private static final String ACCOUNT_PATH = ROOT_PATH + "conta/";
    private static final String TRANSACTION_PATH = ROOT_PATH + "transacao/";

    public static final String URL_CREATE_HERO = ROOT_PATH + "createhero";
    public static final String URL_READ_HEROES = ROOT_PATH + "getheroes";
    public static final String URL_UPDATE_HERO = ROOT_PATH + "updatehero";
    public static final String URL_DELETE_HERO = ROOT_PATH + "deletehero&id=";

}
