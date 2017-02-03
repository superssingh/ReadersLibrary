package com.santossingh.readerslibrary.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.santossingh.readerslibrary.Database.Item;
import com.santossingh.readerslibrary.Fragments.BaseFragment;
import com.santossingh.readerslibrary.R;

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
        // Create a new empty instance of Realm
        realm = Realm.getInstance(realmConfiguration);
    }

    @Override
    public void onListFragmentInteraction(Item item) {
        Intent intent = new Intent(this, DetailActivity.class)
                .putExtra(String.valueOf(R.string.BOOK_ID), item.getId())
                .putExtra(String.valueOf(R.string.BOOK_TITLE), item.getVolumeInfo().getTitle())
                .putExtra(String.valueOf(R.string.AUTHOR), item.getVolumeInfo().getAuthors().get(0))
                .putExtra(String.valueOf(R.string.PUBLISHED_YEAR), item.getVolumeInfo().getPublishedDate())
                .putExtra(String.valueOf(R.string.IMAGE), item.getVolumeInfo().getImageLinks().getSmallThumbnail())
                .putExtra(String.valueOf(R.string.DESCRIPTION), item.getVolumeInfo().getDescription())
                .putExtra(String.valueOf(R.string.PREVIEW_LINK), item.getVolumeInfo().getPreviewLink())
                .putExtra(String.valueOf(R.string.BUY_LINK), item.getAccessInfo().getWebReaderLink())
                .putExtra(String.valueOf(R.string.DOWNLOAD_LINK), item.getSaleInfo().getIsEbook());
        startActivity(intent);
    }

}
