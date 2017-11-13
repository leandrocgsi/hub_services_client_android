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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.erudio.simplecrud.config.ApiUtils;
import br.com.erudio.simplecrud.model.NaturalPerson;
import br.com.erudio.simplecrud.remote.NaturalPersonAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListNaturalPersonActivity extends Activity implements View.OnClickListener {

    private static final String TAG = NaturalPersonActivity.class.getSimpleName();


        ListView listView;
    private NaturalPersonAPIService api;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            api = ApiUtils.getNaturalPersonAPIService();
            listView = (ListView) findViewById(R.id.listViewPersons);

            //calling the method to display the heroes
            getNaturalPersons();
        }

        private void getNaturalPersons() {

            Call<List<NaturalPerson>> call = api.getPersons();

            call.enqueue(new Callback<List<NaturalPerson>>() {
                @Override
                public void onResponse(Call<List<NaturalPerson>> call, Response<List<NaturalPerson>> response) {
                    List<NaturalPerson> heroList = response.body();

                    //Creating an String array for the ListView
                    String[] heroes = new String[heroList.size()];

                    //looping through all the heroes and inserting the names inside the string array
                    for (int i = 0; i < heroList.size(); i++) {
                        heroes[i] = heroList.get(i).getNameTradeName();
                    }

                    //displaying the string array into listview
                    listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, heroes));
                }

                @Override
                public void onFailure(Call<List<NaturalPerson>> call, Throwable t) {
                    Log.e(TAG, "Error occured while fetching naturalPerson.");
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
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

    }