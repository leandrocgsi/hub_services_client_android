package br.com.erudio.simplecrud.config;

import br.com.erudio.simplecrud.remote.NaturalPersonAPIService;
import br.com.erudio.simplecrud.remote.LegalPersonAPIService;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://10.0.2.2:8080/";

    public static NaturalPersonAPIService getNaturalPersonAPIService() {
        return RetrofitBuilder.getClient(BASE_URL).create(NaturalPersonAPIService.class);
    }
    public static LegalPersonAPIService getLegalPersonAPIService() {
        return RetrofitBuilder.getClient(BASE_URL).create(LegalPersonAPIService.class);
    }
}
