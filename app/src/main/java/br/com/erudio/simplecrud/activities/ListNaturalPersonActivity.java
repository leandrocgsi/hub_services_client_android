package br.com.erudio.simplecrud.activities;

import android.app.Activity;
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

    private static final String TAG = NaturalPersonActivity.class.getSimpleName();

    ListView listView;
    private NaturalPersonAPIService api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api = ApiUtils.getNaturalPersonAPIService();
        listView = (ListView) findViewById(R.id.listViewPersons);

        getAllNaturalPersons();
    }

    private void getAllNaturalPersons() {
        Call<List<NaturalPerson>> call = api.getPersons();

        call.enqueue(new Callback<List<NaturalPerson>>() {
            @Override
            public void onResponse(Call<List<NaturalPerson>> call, Response<List<NaturalPerson>> response) {
                List<NaturalPerson> persons = response.body();

                //Creating an String array for the ListView
                String[] heroes = new String[persons.size()];

                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < persons.size(); i++) {
                    heroes[i] = persons.get(i).getNameTradeName();
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
}