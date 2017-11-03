package br.com.erudio.simplecrud.remote;

import java.util.Date;
import java.util.List;

import br.com.erudio.simplecrud.model.Conta;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ContaAPIService {

    @GET("/api/conta/")
    Call<List<Conta>> getPessoas();

    @GET("/api/conta/{id}")
    Call<Conta> getPessoa(@Path("id") long id);

    @POST("/api/conta/")
    Call<Conta> savePerson(@Body Conta conta);

    @PUT("/api/conta/{id}")
    @FormUrlEncoded
    Call<Conta> updatePost(
            @Path("id") long id,
            @Field("cpfcnpj") String cpfcnpj,
            @Field("nomeNomeFantasia") String nomeNomeFantasia,
            @Field("dataDeNascimento") Date dataDeNascimento);

    @DELETE("/api/conta/{id}")
    Call<Conta> deletePost(@Path("id") long id);

}