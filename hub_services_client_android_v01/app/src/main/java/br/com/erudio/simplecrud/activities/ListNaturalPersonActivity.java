package br.com.erudio.simplecrud.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.erudio.simplecrud.R;
import br.com.erudio.simplecrud.config.ApiUtils;
import br.com.erudio.simplecrud.model.NaturalPerson;
import br.com.erudio.simplecrud.remote.NaturalPersonAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListNaturalPersonActivity extends Activity {

    private static final String TAG = ListNaturalPersonActivity.class.getSimpleName();

    ListView listView = null;
    private NaturalPersonAPIService api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_natural_person);
        api = ApiUtils.getNaturalPersonAPIService();
        listView = (ListView) findViewById(R.id.listViewPersons);

        getAllNaturalPersons();
    }

    public void editPerson() {

    }

    private void getAllNaturalPersons() {
        Call<List<NaturalPerson>> call = api.getPersons();

        call.enqueue(new Callback<List<NaturalPerson>>() {
            @Override
            public void onResponse(Call<List<NaturalPerson>> call, Response<List<NaturalPerson>> response) {
                List<NaturalPerson> persons = response.body();

                String[] personsArray = new String[persons.size()];

                for (int i = 0; i < persons.size(); i++) {
                    personsArray[i] = persons.get(i).getNameTradeName();
                }

                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, personsArray));
            }

            @Override
            public void onFailure(Call<List<NaturalPerson>> call, Throwable t) {
                Log.e(TAG, "Error occured while fetching naturalPerson.");
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}