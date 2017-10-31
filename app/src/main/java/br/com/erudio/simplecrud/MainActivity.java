package br.com.erudio.simplecrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.erudio.simplecrud.model.PessoaFisica;
import br.com.erudio.simplecrud.remote.ApiUtils;
import br.com.erudio.simplecrud.remote.PessoaFisicaAPIService;
import br.com.erudio.simplecrud.remote.PessoaFisicaAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private PessoaFisicaAdapter _PessoaFisicaAdapter;
    private RecyclerView _RecyclerView;
    private PessoaFisicaAPIService _PessoaFisicaAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main );
        _PessoaFisicaAPIService = ApiUtils.getAPIService();
        _RecyclerView = (RecyclerView) findViewById(R.id.rv_pessoa_fisicas);
        _PessoaFisicaAdapter = new PessoaFisicaAdapter(this, new ArrayList<PessoaFisica>(0), new PessoaFisicaAdapter.PessoaFisicaListener() {

            @Override
            public void onPostClick(long id) {
                Toast.makeText(MainActivity.this, "Post id is" + id, Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        _RecyclerView.setLayoutManager(layoutManager);
        _RecyclerView.setAdapter(_PessoaFisicaAdapter);
        _RecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        _RecyclerView.addItemDecoration(itemDecoration);

        findPessoas();
    }

    public void findPessoas() {
        _PessoaFisicaAPIService.getPessoas().enqueue(new Callback<PessoaFisica>() {
            @Override
            public void onResponse(Call<PessoaFisica> call, Response<PessoaFisica> response) {

                if(response.isSuccessful()) {
                    ArrayList<PessoaFisica> pessoas = new ArrayList<PessoaFisica>();
                    pessoas.add(response.body());
                    _PessoaFisicaAdapter.updatePessoaFisica(pessoas);
                    Log.d("MainActivity", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<PessoaFisica> call, Throwable t) {
                showErrorMessage();
                Log.d("MainActivity", "error loading from API");

            }
        });
    }

    public void showErrorMessage() {
        Toast.makeText(this, "Error loading posts", Toast.LENGTH_SHORT).show();
    }

    /*
    SEE: https://code.tutsplus.com/tutorials/getting-started-with-retrofit-2--cms-27792 and https://github.com/tutsplus/get-started-with-retrofit-2-http-client
    */
}
