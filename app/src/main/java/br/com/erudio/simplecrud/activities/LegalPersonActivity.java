package br.com.erudio.simplecrud.activities;

import android.app.Activity;
import android.app.ProgressDialog;
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

    ProgressDialog pd;

    private Button buttonSubmit;

    private LegalPersonAPIService api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legal_person);

        editTextCompanyName = (EditText) findViewById(R.id.et_company_name);
        editTextCnpj = (EditText) findViewById(R.id.et_cnpj);
        editTradeName = (EditText) findViewById(R.id.et_trading_name);

        Button buttonSave = (Button) findViewById(R.id.btn_save);
        Button buttonUpdate = (Button) findViewById(R.id.btn_update);
        textViewResponse = (TextView) findViewById(R.id.tv_response);

        pd = new ProgressDialog(this);

        String companyName = editTextCompanyName.getText().toString().trim();
        String tradeName = editTradeName.getText().toString().trim();
        String cnpj = editTextCnpj.getText().toString().trim();

        final LegalPerson legalPerson = new LegalPerson();
        legalPerson.setNameTradeName(tradeName);
        legalPerson.setCompanyName(companyName);
        legalPerson.setCpfcnpj(cnpj);

        api = ApiUtils.getLegalPersonAPIService();

        Intent data = getIntent();
        final String iddata = data.getStringExtra("id");
        if(iddata == null) {

            buttonSave.setVisibility(View.VISIBLE);
            buttonUpdate.setVisibility(View.GONE);

            buttonSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pd.setMessage("send data ... ");
                    pd.setCancelable(false);
                    pd.show();

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
            });
        } else {
            buttonSave.setVisibility(View.GONE);
            buttonUpdate.setVisibility(View.VISIBLE);

            legalPerson.setId(Long.valueOf(iddata));

            editTextCompanyName.setText(data.getStringExtra("et_company_name"));
            editTradeName.setText(data.getStringExtra("et_trading_name"));
            editTextCnpj.setText(data.getStringExtra("et_cnpj"));

            buttonUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pd.setMessage("update ....");
                    pd.setCancelable(false);
                    pd.show();

                    api.updatePerson(legalPerson.getId(), legalPerson).enqueue(new Callback<LegalPerson>() {

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
            });

        }
    }

    @Override
    public void onClick(View view) {
        //TODO
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