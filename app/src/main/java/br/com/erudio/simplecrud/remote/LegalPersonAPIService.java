package br.com.erudio.simplecrud.remote;

import java.util.List;

import br.com.erudio.simplecrud.model.LegalPerson;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LegalPersonAPIService {

    @GET("/api/pessoaJuridica/")
    Call<List<LegalPerson>> getPersons();

    @GET("/api/pessoaJuridica/{id}")
    Call<LegalPerson> getPerson(@Path("id") long id);

    @POST("/api/pessoaJuridica/")
    Call<LegalPerson> savePerson(@Body LegalPerson legalPerson);

    @PUT("/api/pessoaJuridica/{id}")
    @FormUrlEncoded
    Call<LegalPerson> updatePerson(@Path("id") long id, @Body LegalPerson legalPerson);

    @DELETE("/api/pessoaJuridica/{id}")
    Call<LegalPerson> deletePerson(@Path("id") long id);

}