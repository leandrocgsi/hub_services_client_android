package br.com.erudio.simplecrud.remote;

import java.util.List;

import br.com.erudio.simplecrud.model.Pessoa;
import br.com.erudio.simplecrud.model.StatusConta;
import br.com.erudio.simplecrud.model.TipoConta;
import br.com.erudio.simplecrud.model.TipoTransacao;
import br.com.erudio.simplecrud.model.Transacao;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface HelperAPIService {

    @GET("/api/helper/tiposConta")
    Call<List<TipoConta>> listAllTipoContas();

    @GET("/api/helper/tiposTransacao")
    Call<List<TipoTransacao>> listAllTiposTransacao();

    @GET("/api/helper/statusConta")
    Call<List<StatusConta>> listAllStatusContas();

    @GET("/api/helper/pessoas")
    Call<List<Pessoa>> listAllPessoas();
}