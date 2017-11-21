package br.com.erudio.simplecrud.remote;

import java.util.List;

import br.com.erudio.simplecrud.model.AccountStatus;
import br.com.erudio.simplecrud.model.AccountType;
import br.com.erudio.simplecrud.model.Person;
import br.com.erudio.simplecrud.model.TransactionType;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HelperAPIService {

    @GET("/api/helper/tiposConta")
    Call<List<AccountType>> listAllAccountTypes();

    @GET("/api/helper/tiposTransacao")
    Call<List<TransactionType>> listAllTransactionTypes();

    @GET("/api/helper/statusConta")
    Call<List<AccountStatus>> listAllAccountStatus();

    @GET("/api/helper/pessoas")
    Call<List<Person>> listAllPersons();
}