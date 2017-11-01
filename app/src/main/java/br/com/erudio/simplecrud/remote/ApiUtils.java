package br.com.erudio.simplecrud.remote;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://10.0.2.2:8080/api/";

    public static PessoaFisicaAPIService getAPIService() {

        return RetrofitBuilder.getClient(BASE_URL).create(PessoaFisicaAPIService.class);
    }
}
