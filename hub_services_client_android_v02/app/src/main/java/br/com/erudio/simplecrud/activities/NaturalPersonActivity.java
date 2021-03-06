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
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import br.com.erudio.simplecrud.R;
import br.com.erudio.simplecrud.config.ApiUtils;
import br.com.erudio.simplecrud.databinding.ActivityLegalPersonBinding;
import br.com.erudio.simplecrud.model.NaturalPerson;
import br.com.erudio.simplecrud.remote.NaturalPersonAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NaturalPersonActivity extends Activity implements View.OnClickListener {

    private static final String TAG = NaturalPersonActivity.class.getSimpleName();
    private TextView textViewResponse;

    private EditText editTextName;
    private EditText editTextCpf;
    private EditText editTextBirthday;

    private Button buttonSubmit;

    private NaturalPersonAPIService api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_natural_person);

        /*
        ActivityLegalPersonBinding x = null;
        x.etCompanyName.getText();
        */
        editTextName = (EditText) findViewById(R.id.et_name);
        editTextCpf = (EditText) findViewById(R.id.et_cpf);
        editTextBirthday = (EditText) findViewById(R.id.et_birthday);

        Button buttonSubmit = (Button) findViewById(R.id.btn_save);

        textViewResponse = (TextView) findViewById(R.id.tv_response);

        api = ApiUtils.getNaturalPersonAPIService();

        buttonSubmit.setOnClickListener(this);
    }

    private void insertPerson(){

        String name = editTextName.getText().toString().trim();
        String cpf = editTextCpf.getText().toString().trim();
        Date birthday = new Date();//editTextBirthday.getText().toString().trim();

        NaturalPerson naturalPerson = new NaturalPerson();
        naturalPerson.setNameTradeName(name);
        naturalPerson.setCpfcnpj(cpf);
        naturalPerson.setBirthday("1975-12-05");

        api.savePerson(naturalPerson).enqueue(new Callback<NaturalPerson>() {

            @Override
            public void onResponse(Call<NaturalPerson> call, Response<NaturalPerson> response) {
                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "naturalPerson submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<NaturalPerson> call, Throwable t) {
                showErrorMessage();
                Log.e(TAG, "Unable to submit naturalPerson to API.");
            }
        });
    }

    private void getAllNaturalPersons() {
        Call<List<NaturalPerson>> call = api.getPersons();

        call.enqueue(new Callback<List<NaturalPerson>>() {
            @Override
            public void onResponse(Call<List<NaturalPerson>> call, Response<List<NaturalPerson>> response) {
                List<NaturalPerson> persons = response.body();
            }

            @Override
            public void onFailure(Call<List<NaturalPerson>> call, Throwable t) {
                Log.e(TAG, "Error occured while fetching naturalPerson.");
            }
        });
    }


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
                Intent homepage = new Intent(NaturalPersonActivity.this, MainActivity.class);
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