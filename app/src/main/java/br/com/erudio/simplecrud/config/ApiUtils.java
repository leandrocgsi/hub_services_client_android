package br.com.erudio.simplecrud.config;

import br.com.erudio.simplecrud.remote.PessoaFisicaAPIService;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://10.0.2.2:8080/";

    public static PessoaFisicaAPIService getAPIService() {

        return RetrofitBuilder.getClient(BASE_URL).create(PessoaFisicaAPIService.class);
    }
}
