package br.com.erudio.simplecrud.remote;

import java.util.Date;

import br.com.erudio.simplecrud.model.PessoaFisica;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PessoaFisicaAPIService {

    @GET("/pessoaFisica/")
    Call<PessoaFisica> getPessoas();

    @GET("/pessoaFisica/{id}")
    Call<PessoaFisica> getPessoa(@Path("id") long id);

    @POST("/pessoaFisica/")
    @FormUrlEncoded
    Call<PessoaFisica> savePost(
            @Field("cpfcnpj") String cpfcnpj,
            @Field("nomeNomeFantasia") String nomeNomeFantasia,
            @Field("dataDeNascimento") Date dataDeNascimento);

    @PUT("/pessoaFisica/{id}")
    @FormUrlEncoded
    Call<PessoaFisica> updatePost(
            @Path("id") long id,
            @Field("cpfcnpj") String cpfcnpj,
            @Field("nomeNomeFantasia") String nomeNomeFantasia,
            @Field("dataDeNascimento") Date dataDeNascimento);

    @DELETE("/pessoaFisica/{id}")
    Call<PessoaFisica> deletePost(@Path("id") long id);

}