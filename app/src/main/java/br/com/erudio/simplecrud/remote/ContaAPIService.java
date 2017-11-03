package br.com.erudio.simplecrud.remote;

import java.util.List;

import br.com.erudio.simplecrud.model.Conta;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ContaAPIService {

    @GET("/api/conta/")
    Call<List<Conta>> getContas();

    @GET("/api/conta/{id}")
    Call<Conta> getConta(@Path("id") long id);

    @POST("/api/conta/")
    Call<Conta> createConta(@Body Conta conta);

    @PUT("/api/conta/{id}")
    @FormUrlEncoded
    Call<Conta> updateConta(@Path("id") long id, @Body Conta conta);

    @DELETE("/api/conta/{id}")
    Call<Conta> deletePost(@Path("id") long id);

}