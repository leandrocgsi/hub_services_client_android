package br.com.erudio.simplecrud;

public class Api {

    private static final String ROOT_PATH = "http://192.168.101.1:8080/HeroApi/v1/Api.php?apicall=";

    public static final String URL_CREATE_HERO = ROOT_PATH + "createhero";
    public static final String URL_READ_HEROES = ROOT_PATH + "getheroes";
    public static final String URL_UPDATE_HERO = ROOT_PATH + "updatehero";
    public static final String URL_DELETE_HERO = ROOT_PATH + "deletehero&id=";

}
