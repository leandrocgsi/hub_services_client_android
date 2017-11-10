package br.com.erudio.simplecrud.remote;

import java.util.List;

import br.com.erudio.simplecrud.model.NaturalPerson;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface NaturalPersonAPIService {

    @GET("/api/pessoaFisica/")
    Call<List<NaturalPerson>> getPersons();

    @GET("/api/pessoaFisica/{id}")
    Call<NaturalPerson> getPerson(@Path("id") long id);

    @POST("/api/pessoaFisica/")
    Call<NaturalPerson> savePerson(@Body NaturalPerson naturalPerson);

    @PUT("/api/pessoaFisica/{id}")
    @FormUrlEncoded
    Call<NaturalPerson> updatePerson(@Path("id") long id, @Body NaturalPerson naturalPerson);

    @DELETE("/api/pessoaFisica/{id}")
    Call<NaturalPerson> deletePerson(@Path("id") long id);

}