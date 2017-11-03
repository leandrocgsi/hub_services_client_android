package br.com.erudio.simplecrud.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import br.com.erudio.simplecrud.R;
import br.com.erudio.simplecrud.config.ApiUtils;
import br.com.erudio.simplecrud.model.PessoaFisica;
import br.com.erudio.simplecrud.remote.PessoaFisicaAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JuridicalPersonActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = JuridicalPersonActivity.class.getSimpleName();
    private TextView textViewResponse;

    private EditText editTextName;
    private EditText editTextCpf;
    private EditText editTextBirthday;

    private Button buttonSubmit;

    private PessoaFisicaAPIService api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisical_person);

        editTextName = (EditText) findViewById(R.id.et_name);
        editTextCpf = (EditText) findViewById(R.id.et_cpf);
        editTextBirthday = (EditText) findViewById(R.id.et_birthday);

        Button buttonSubmit = (Button) findViewById(R.id.btn_submit);
        textViewResponse = (TextView) findViewById(R.id.tv_response);

        api = ApiUtils.getAPIService();

        buttonSubmit.setOnClickListener(this);
    }

    private void insertPerson(){

        String name = editTextName.getText().toString().trim();
        String cpf = editTextCpf.getText().toString().trim();
        Date birthday = new Date();//editTextBirthday.getText().toString().trim();

        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setNomeNomeFantasia(name);
        pessoaFisica.setCpfcnpj(cpf);
        pessoaFisica.setDataDeNascimento("1975-12-05");

        api.savePerson(pessoaFisica).enqueue(new Callback<PessoaFisica>() {

            @Override
            public void onResponse(Call<PessoaFisica> call, Response<PessoaFisica> response) {
                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "pessoaFisica submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<PessoaFisica> call, Throwable t) {
                showErrorMessage();
                Log.e(TAG, "Unable to submit pessoaFisica to API.");
            }
        });
    }

    /*private void getAllPessoaFisicas() {
        Call<List<PessoaFisica>> getAllPessoaFisicasCall = api.getPessoas();

        getAllPessoaFisicasCall.enqueue(new Callback<List<PessoaFisica>>() {
            @Override
            public void onResponse(Call<List<PessoaFisica>> call, Response<List<PessoaFisica>> response) {
                displayPessoaFisica(response.body().get(0));
            }

            @Override
            public void onFailure(Call<List<PessoaFisica>> call, Throwable t) {
                Log.e(TAG, "Error occured while fetching pessoaFisica.");
            }
        });
    }*/


    @Override
    public void onClick(View view) {
        insertPerson();
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