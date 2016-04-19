package org.mansa.cluster;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;

/**
 * Created by mansa on 4/18/16.
 */
public class MapFragment extends SupportMapFragment implements GoogleMap.OnIndoorStateChangeListener,
        GoogleMap.OnMapLongClickListener,
        SeekBar.OnSeekBarChangeListener{

    private final int[] MAP_TYPES = {GoogleMap.MAP_TYPE_SATELLITE,
            GoogleMap.MAP_TYPE_NORMAL,
            GoogleMap.MAP_TYPE_HYBRID,
            GoogleMap.MAP_TYPE_TERRAIN,
            GoogleMap.MAP_TYPE_NONE};

    SeekBar mIndoorSelector;
    TextView mIndoorMinLevel, mIndoorMaxLevel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup parent = (ViewGroup) super.onCreateView( inflater, container, savedInstanceState );
        View overlay = inflater.inflate( R.layout.view_map_overlay, parent, false );

        mIndoorSelector = (SeekBar) overlay.findViewById( R.id.indoor_level_selector );
        mIndoorMinLevel = (TextView) overlay.findViewById( R.id.indoor_min_level );
        mIndoorMaxLevel = (TextView) overlay.findViewById( R.id.indoor_max_level );

        parent.addView( overlay );
        initCamera(  );
        initMapIndoorSelector();
        
        return parent;
    }

    @Override
    public void onStart() {
        super.onStart( );
    }

    @Override
    public void onStop() {
        super.onStop( );
    }

    private void initMapIndoorSelector() {
        mIndoorSelector.setOnSeekBarChangeListener( this );

        getMap().getUiSettings().setIndoorLevelPickerEnabled( false );
        getMap().setOnIndoorStateChangeListener( this );
    }

    private void initCamera() {
        CameraPosition position = CameraPosition.builder()
                .target( new LatLng( 40.7506, -73.9936 ) )
                .zoom( 18f )
                .bearing( 0.0f )
                .tilt( 0.0f )
                .build();

        getMap().animateCamera(
                CameraUpdateFactory.newCameraPosition( position ), null );
        getMap().setMapType( GoogleMap.MAP_TYPE_HYBRID );
    }


    private String getAddressFromLatLng( LatLng latLng ) {
        Geocoder geocoder = new Geocoder( getActivity() );

        String address = "";
        try {
            address = geocoder
                    .getFromLocation( latLng.latitude, latLng.longitude, 1 )
                    .get( 0 ).getAddressLine( 0 );
        } catch (IOException e ) {
        }

        return address;
    }


    @Override
    public void onIndoorBuildingFocused() {

    }

    @Override
    public void onIndoorLevelActivated(IndoorBuilding indoorBuilding) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onMapLongClick(LatLng latLng) {

    }
}
