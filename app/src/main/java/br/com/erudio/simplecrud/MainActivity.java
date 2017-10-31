package br.com.erudio.simplecrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import br.com.erudio.simplecrud.model.PessoaFisica;
import br.com.erudio.simplecrud.remote.ApiUtils;
import br.com.erudio.simplecrud.remote.PessoaFisicaAPIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView textViewResponse;

    private PessoaFisicaAPIService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nameEt = (EditText) findViewById(R.id.et_name);
        final EditText cpfEt = (EditText) findViewById(R.id.et_cpf);
        final EditText birthdayEt = (EditText) findViewById(R.id.et_birthday);
        Button submitBtn = (Button) findViewById(R.id.btn_submit);
        textViewResponse = (TextView) findViewById(R.id.tv_response);

        service = ApiUtils.getAPIService();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEt.getText().toString().trim();
                String cpf = cpfEt.getText().toString().trim();
                if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(cpf)) {
                    sendPost(name, cpf);
                }
            }
        });
    }

    public void showErrorMessage() {
        Toast.makeText(this, R.string.mssg_error_saving_person, Toast.LENGTH_SHORT).show();
    }

    public void sendPost(String name, String cpf) {

        service.savePost(name, cpf, new Date()).enqueue(new Callback<PessoaFisica>() {
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

    public void updatePost(long id, String name, String cpf) {
        service.updatePost(id, name, cpf, new Date()).enqueue(new Callback<PessoaFisica>() {
            @Override
            public void onResponse(Call<PessoaFisica> call, Response<PessoaFisica> response) {

                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "pessoaFisica updated." + response.body().toString());
                }
            }
            @Override
            public void onFailure(Call<PessoaFisica> call, Throwable t) {

                showErrorMessage();
                Log.e(TAG, "Unable to update pessoaFisica.");
            }
        });
    }

    public void showResponse(String response) {
        if(textViewResponse.getVisibility() == View.GONE) {
            textViewResponse.setVisibility(View.VISIBLE);
        }
        textViewResponse.setText(response);
    }
}
