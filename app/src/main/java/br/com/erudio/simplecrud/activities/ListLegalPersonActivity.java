package br.com.erudio.simplecrud.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.erudio.simplecrud.R;
import br.com.erudio.simplecrud.adapter.AdapterData;
import br.com.erudio.simplecrud.config.ApiUtils;
import br.com.erudio.simplecrud.model.LegalPerson;

import br.com.erudio.simplecrud.model.NaturalPerson;
import br.com.erudio.simplecrud.remote.LegalPersonAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListLegalPersonActivity extends AppCompatActivity {

    private static final String TAG = ListLegalPersonActivity.class.getSimpleName();

    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<LegalPerson> mItems = new ArrayList<>();
    ProgressDialog pd;

    private LegalPersonAPIService api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_legal_person);

        api = ApiUtils.getLegalPersonAPIService();

        pd = new ProgressDialog(this);
        mRecycler = (RecyclerView) findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(mManager);

        pd.setMessage("Loading ...");
        pd.setCancelable(false);
        pd.show();

        Call<List<LegalPerson>> call = api.getPersons();
        call.enqueue(new Callback<List<LegalPerson>>() {
            @Override
            public void onResponse(Call<List<LegalPerson>> call, Response<List<LegalPerson>> response) {
                pd.hide();
                Log.d(TAG, "RESPONSE : " + response.body());
                mItems =  response.body();

                mAdapter = new AdapterData(ListLegalPersonActivity.this,mItems);
                mRecycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<LegalPerson>> call, Throwable t) {
                Log.e(TAG, "Error occured while fetching naturalPerson.");
            }
        });
    }
}
