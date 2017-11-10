package br.com.erudio.simplecrud.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import br.com.erudio.simplecrud.R;
import br.com.erudio.simplecrud.config.ApiUtils;
import br.com.erudio.simplecrud.model.PessoaJuridica;
import br.com.erudio.simplecrud.remote.LegalPersonAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JuridicalPersonActivity extends Activity implements View.OnClickListener {

    private static final String TAG = JuridicalPersonActivity.class.getSimpleName();
    private TextView textViewResponse;

    private EditText editTextCompanyName;
    private EditText editTextCnpj;
    private EditText editTradeName;

    private Button buttonSubmit;

    private LegalPersonAPIService api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juridical_person);

        editTextCompanyName = (EditText) findViewById(R.id.et_razao_social);
        editTextCnpj = (EditText) findViewById(R.id.et_cnpj);
        editTradeName = (EditText) findViewById(R.id.et_fantasy_name);

        Button buttonSubmit = (Button) findViewById(R.id.btn_submit);
        textViewResponse = (TextView) findViewById(R.id.tv_response);

        api = ApiUtils.getLegalPersonAPIService();

        buttonSubmit.setOnClickListener(this);
    }

    private void insertPerson(){

        String companyName = editTextCompanyName.getText().toString().trim();
        String tradeName = editTradeName.getText().toString().trim();
        String cnpj = editTextCnpj.getText().toString().trim();

        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setNomeNomeFantasia(tradeName);
        pessoaJuridica.setNomeRazaoSocial(companyName);
        pessoaJuridica.setCpfcnpj(cnpj);

        api.savePerson(pessoaJuridica).enqueue(new Callback<PessoaJuridica>() {

            @Override
            public void onResponse(Call<PessoaJuridica> call, Response<PessoaJuridica> response) {
                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "pessoaJuridica submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<PessoaJuridica> call, Throwable t) {
                showErrorMessage();
                Log.e(TAG, "Unable to submit pessoaJuridica to API.");
            }
        });
    }

    /*private void getAllPessoaJuridicas() {
        Call<List<PessoaJuridica>> getAllPessoaJuridicasCall = api.getPessoas();

        getAllPessoaJuridicasCall.enqueue(new Callback<List<PessoaJuridica>>() {
            @Override
            public void onResponse(Call<List<PessoaJuridica>> call, Response<List<PessoaJuridica>> response) {
                displayPessoaJuridica(response.body().get(0));
            }

            @Override
            public void onFailure(Call<List<PessoaJuridica>> call, Throwable t) {
                Log.e(TAG, "Error occured while fetching pessoaJuridica.");
            }
        });
    }*/


    @Override
    public void onClick(View view) {
        insertPerson();
    }

    public void returnToMain(View view) {
        //setContentView(R.layout.activity_main);

        int timeout = 50;
        Timer t2 = new Timer();
        t2.schedule(new TimerTask() {

            @Override
            public void run() {
                finish();
                Intent homepage = new Intent(JuridicalPersonActivity.this, MainActivity.class);
                startActivity(homepage);
            }
        }, timeout);
    }

    public void showResponse(String response) {
        if(textViewResponse.getVisibility() == View.GONE) {
            textViewResponse.setVisibility(View.VISIBLE);
        }
        textViewResponse.setText(response);
    }

    public void showErrorMessage() {
        Toast.makeText(this, R.string.mssg_error_saving_fisical_person, Toast.LENGTH_SHORT).show();
    }
}
//SEE: https://www.simplifiedcoding.net/retrofit-android-example/           and             http://swarajsaaj.github.io/posts/consuming-rest-api-using-retrofit-android