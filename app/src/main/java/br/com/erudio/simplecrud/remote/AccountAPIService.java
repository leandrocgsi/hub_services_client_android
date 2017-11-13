package br.com.erudio.simplecrud.remote;

import java.util.List;

import br.com.erudio.simplecrud.model.Account;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AccountAPIService {

    @GET("/api/conta/")
    Call<List<Account>> getAccounts();

    @GET("/api/conta/{id}")
    Call<Account> getAccount(@Path("id") long id);

    @POST("/api/account/")
    Call<Account> createAccount(@Body Account account);

    @PUT("/api/account/{id}")
    @FormUrlEncoded
    Call<Account> updateAccount(@Path("id") long id, @Body Account account);

    @DELETE("/api/conta/{id}")
    Call<Account> deletePost(@Path("id") long id);

}