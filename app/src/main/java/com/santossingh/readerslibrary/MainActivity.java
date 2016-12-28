package com.santossingh.readerslibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.santossingh.readerslibrary.Database.Item;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity implements BaseFragment.OnListFragmentInteractionListener {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(getApplicationContext());
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();

        // Clear the realm from last time
        Realm.deleteRealm(realmConfiguration);
        // Create a new empty instance of Realm
        realm = Realm.getInstance(realmConfiguration);
    }

    @Override
    public void onListFragmentInteraction(Item item) {
        String ISBN = item.getVolumeInfo().getIndustryIdentifiers().get(0).getIdentifier();
        Toast.makeText(getApplicationContext(), ISBN, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, ViewActivity.class).putExtra("ISBN", ISBN);
        startActivity(intent);
    }

}
