package br.com.erudio.simplecrud.remote;

import java.util.List;

import br.com.erudio.simplecrud.model.Transacao;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TransacaoAPIService {

    @GET("/api/transacao/")
    Call<List<Transacao>> getTransacoes();

    @GET("/api/transacao/{id}")
    Call<Transacao> getTransacao(@Path("id") long id);

    @POST("/api/transacao/")
    Call<Transacao> createTransacao(@Body Transacao transacao);

    @PUT("/api/transacao/estornoTransacao/{id}")
    @FormUrlEncoded
    Call<Transacao> updateTransacao(@Path("id") long id);

}