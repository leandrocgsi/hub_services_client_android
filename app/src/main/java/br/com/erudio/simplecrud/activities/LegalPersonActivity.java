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

import java.util.Timer;
import java.util.TimerTask;

import br.com.erudio.simplecrud.R;
import br.com.erudio.simplecrud.config.ApiUtils;
import br.com.erudio.simplecrud.model.LegalPerson;
import br.com.erudio.simplecrud.remote.LegalPersonAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LegalPersonActivity extends Activity implements View.OnClickListener {

    private static final String TAG = LegalPersonActivity.class.getSimpleName();
    private TextView textViewResponse;

    private EditText editTextCompanyName;
    private EditText editTextCnpj;
    private EditText editTradeName;

    private Button buttonSubmit;

    private LegalPersonAPIService api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legal_person);

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

        LegalPerson legalPerson = new LegalPerson();
        legalPerson.setNameTradeName(tradeName);
        legalPerson.setCompanyName(companyName);
        legalPerson.setCpfcnpj(cnpj);

        api.savePerson(legalPerson).enqueue(new Callback<LegalPerson>() {

            @Override
            public void onResponse(Call<LegalPerson> call, Response<LegalPerson> response) {
                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "legalPerson submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<LegalPerson> call, Throwable t) {
                showErrorMessage();
                Log.e(TAG, "Unable to submit legalPerson to API.");
            }
        });
    }

    /*private void getAllLegalPersons() {
        Call<List<LegalPerson>> getAllLegalPersonsCall = api.getPessoas();

        getAllLegalPersonsCall.enqueue(new Callback<List<LegalPerson>>() {
            @Override
            public void onResponse(Call<List<LegalPerson>> call, Response<List<LegalPerson>> response) {
                displayLegalPerson(response.body().get(0));
            }

            @Override
            public void onFailure(Call<List<LegalPerson>> call, Throwable t) {
                Log.e(TAG, "Error occured while fetching legalPerson.");
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
                Intent homepage = new Intent(LegalPersonActivity.this, MainActivity.class);
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