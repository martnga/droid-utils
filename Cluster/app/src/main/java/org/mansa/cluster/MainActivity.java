package org.mansa.cluster;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterManager;

import java.util.Random;

import co.moonmonkeylabs.realmsfrestaurantdata.SFRestaurantDataLoader;
import co.moonmonkeylabs.realmsfrestaurantdata.SFRestaurantModule;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public abstract class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }
}

