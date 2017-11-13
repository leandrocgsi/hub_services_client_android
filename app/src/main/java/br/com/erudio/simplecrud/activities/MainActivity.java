package br.com.erudio.simplecrud.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;

import br.com.erudio.simplecrud.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int timeout = 50; // make the activity visible for 4 seconds

        switch (item.getItemId()) {
            case R.id.natural_person_menu:
                Timer t1 = new Timer();
                t1.schedule(new TimerTask() {

                    @Override
                    public void run() {
                        finish();
                        Intent homepage = new Intent(MainActivity.this, NaturalPersonActivity.class);
                        startActivity(homepage);
                    }
                }, timeout);
                return true;
            case R.id.legal_person_menu:
                Timer t2 = new Timer();
                t2.schedule(new TimerTask() {

                    @Override
                    public void run() {
                        finish();
                        Intent homepage = new Intent(MainActivity.this, LegalPersonActivity.class);
                        startActivity(homepage);
                    }
                }, timeout);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

//SEE: https://www.simplifiedcoding.net/retrofit-android-example/           and             http://swarajsaaj.github.io/posts/consuming-rest-api-using-retrofit-android
//https://www.concretepage.com/android/android-options-menu-example-using-getmenuinflater-inflate-oncreateoptionsmenu-and-onoptionsitemselected