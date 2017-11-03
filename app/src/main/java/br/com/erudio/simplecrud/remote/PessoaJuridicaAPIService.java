package br.com.erudio.simplecrud.remote;

import java.util.List;

import br.com.erudio.simplecrud.model.PessoaJuridica;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PessoaJuridicaAPIService {

    @GET("/api/pessoaJuridica/")
    Call<List<PessoaJuridica>> getPessoas();

    @GET("/api/pessoaJuridica/{id}")
    Call<PessoaJuridica> getPessoa(@Path("id") long id);

    @POST("/api/pessoaJuridica/")
    Call<PessoaJuridica> savePerson(@Body PessoaJuridica pessoaJuridica);

    @PUT("/api/pessoaJuridica/{id}")
    @FormUrlEncoded
    Call<PessoaJuridica> updatePost(@Path("id") long id, @Body PessoaJuridica pessoaJuridica);

    @DELETE("/api/pessoaJuridica/{id}")
    Call<PessoaJuridica> deletePost(@Path("id") long id);

}