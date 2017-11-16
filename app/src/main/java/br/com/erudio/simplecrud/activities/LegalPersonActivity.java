package br.com.erudio.simplecrud.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class LegalPersonActivity extends AppCompatActivity {

    private static final String TAG = LegalPersonActivity.class.getSimpleName();
    private TextView textViewResponse;

    private EditText editTextCompanyName;
    private EditText editTextCnpj;
    private EditText editTradeName;

    private LegalPerson legalPerson = new LegalPerson();

    private LegalPersonAPIService api;

    ProgressDialog pd;

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

        api = ApiUtils.getLegalPersonAPIService();

        Intent data = getIntent();
        final String iddata = data.getStringExtra("id");
        if(iddata != null) {
            buttonSave.setVisibility(View.GONE);
            buttonUpdate.setVisibility(View.VISIBLE);

            editTextCompanyName.setText(data.getStringExtra("et_company_name"));
            editTradeName.setText(data.getStringExtra("et_trading_name"));
            editTextCnpj.setText(data.getStringExtra("et_cnpj"));
        }

        pd = new ProgressDialog(this);

        /*buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setMessage("Loading Hapus ...");
                pd.setCancelable(false);
                pd.show();

                Call<LegalPerson> del  = api.deletePerson(Long.valueOf(iddata));
                del.enqueue(new Callback<LegalPerson>() {
                    @Override
                    public void onResponse(Call<LegalPerson> call, Response<LegalPerson> response) {
                        //TODO
                    }

                    @Override
                    public void onFailure(Call<LegalPerson> call, Throwable t) {
                        pd.hide();
                        Log.d("Retro", "onFailure");
                    }
                });
            }
        });*/

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setMessage("send data ... ");
                pd.setCancelable(false);
                pd.show();

                String companyName = editTextCompanyName.getText().toString().trim();
                String tradeName = editTradeName.getText().toString().trim();
                String cnpj = editTextCnpj.getText().toString().trim();

                legalPerson.setNameTradeName(tradeName);
                legalPerson.setCompanyName(companyName);
                legalPerson.setCpfcnpj(cnpj);

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
            }
        });
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