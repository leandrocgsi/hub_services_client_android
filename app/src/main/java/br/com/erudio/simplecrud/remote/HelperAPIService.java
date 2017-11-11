package br.com.erudio.simplecrud.remote;

import java.util.List;

import br.com.erudio.simplecrud.model.Person;
import br.com.erudio.simplecrud.model.StatusConta;
import br.com.erudio.simplecrud.model.TipoConta;
import br.com.erudio.simplecrud.model.TipoTransacao;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HelperAPIService {

    @GET("/api/helper/tiposConta")
    Call<List<TipoConta>> listAllTipoContas();

    @GET("/api/helper/tiposTransacao")
    Call<List<TipoTransacao>> listAllTiposTransacao();

    @GET("/api/helper/statusConta")
    Call<List<StatusConta>> listAllStatusContas();

    @GET("/api/helper/pessoas")
    Call<List<Person>> listAllPersons();
}