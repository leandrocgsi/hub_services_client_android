package br.com.erudio.simplecrud.remote;

import java.util.List;

import br.com.erudio.simplecrud.model.Transaction;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TransactionAPIService {

    @GET("/api/transacao/")
    Call<List<Transaction>> getTansactions();

    @GET("/api/transacao/{id}")
    Call<Transaction> getTransaction(@Path("id") long id);

    @POST("/api/transacao/")
    Call<Transaction> createTransaction(@Body Transaction transaction);

    @PUT("/api/transacao/estornoTransaction/{id}")
    Call<Transaction> updateTransaction(@Path("id") long id);

}