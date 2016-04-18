package org.mansa.cluster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.moonmonkeylabs.realmsfrestaurantdata.SFRestaurantDataLoader;
import co.moonmonkeylabs.realmsfrestaurantdata.SFRestaurantModule;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Sets default realm with sample data module
        Realm.setDefaultConfiguration(new RealmConfiguration
                .Builder(this)
                .setModules( Realm.getDefaultModule(), new SFRestaurantModule())
                .build());
        // Loads and adds sample data to realm
        new SFRestaurantDataLoader().loadBusinessSmallDataSet(this);
        // Sets layout with map fragment
        setContentView(R.layout.activity_main);
    }
}
