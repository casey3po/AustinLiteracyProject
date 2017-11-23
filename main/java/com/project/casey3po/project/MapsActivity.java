package com.project.casey3po.project;


import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends MainActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMinZoomPreference(10);

        //Set latitude and longitude of branches
        LatLng austin = new LatLng(30.272481, -97.745200);
        LatLng milwood = new LatLng(30.421954, -97.715905);
        LatLng spicewood = new LatLng(30.433351, -97.773239);
        LatLng walnut = new LatLng(30.364651, -97.698395);
        LatLng quarry = new LatLng(30.353023, -97.755387);
        LatLng john = new LatLng(30.332282, -97.693932);
        LatLng yarborough = new LatLng(30.323096, -97.740967);
        LatLng windsor = new LatLng(30.311389, -97.690499);
        LatLng uhills = new LatLng(30.308722, -97.666809);
        LatLng village = new LatLng(30.362059, -97.730667);
        LatLng howson = new LatLng(30.298495, -97.767746);
        LatLng lbj = new LatLng(30.286045, -97.729294);
        LatLng txstate = new LatLng(30.274185, -97.738564);
        LatLng carver = new LatLng(30.269550, -97.724316);
        LatLng willie = new LatLng(30.272960, -97.699768);
        LatLng cepeda = new LatLng(30.259246, -97.708866);
        LatLng terraza = new LatLng(30.259987, -97.733586);
        LatLng twinoaks = new LatLng(30.248718, -97.762425);
        LatLng ruiz = new LatLng(30.230069, -97.707150);
        LatLng manchaca = new LatLng(30.216719, -97.797444);
        LatLng pleasant = new LatLng(30.192389, -97.777188);
        LatLng southeast = new LatLng(30.187641, -97.742169);
        LatLng hampton = new LatLng(30.217673, -97.855228);

        //Place the markers
        mMap.addMarker(new MarkerOptions().position(spicewood).title("Spicewood Springs Branch"));
        mMap.addMarker(new MarkerOptions().position(milwood).title("Milwood Branch"));
        mMap.addMarker(new MarkerOptions().position(walnut).title("Little Walnut Creek Branch"));
        mMap.addMarker(new MarkerOptions().position(village).title("North Village Branch"));
        mMap.addMarker(new MarkerOptions().position(quarry).title("Old Quarry Branch"));
        mMap.addMarker(new MarkerOptions().position(john).title("St.John Branch"));
        mMap.addMarker(new MarkerOptions().position(yarborough).title("Yarborough Branch"));
        mMap.addMarker(new MarkerOptions().position(windsor).title("Windsor Park Branch"));
        mMap.addMarker(new MarkerOptions().position(uhills).title("University Hills Branch"));
        mMap.addMarker(new MarkerOptions().position(howson).title("Howson Branch"));
        mMap.addMarker(new MarkerOptions().position(lbj).title("LBJ Branch"));
        mMap.addMarker(new MarkerOptions().position(txstate).title("Texas State and Archives Branch"));
        mMap.addMarker(new MarkerOptions().position(carver).title("Carver Branch"));
        mMap.addMarker(new MarkerOptions().position(willie).title("Willie Mae Kirk Branch"));
        mMap.addMarker(new MarkerOptions().position(cepeda).title("Cepeda Branch"));
        mMap.addMarker(new MarkerOptions().position(terraza).title("Terraza Branch"));
        mMap.addMarker(new MarkerOptions().position(twinoaks).title("Twin Oaks Branch"));
        mMap.addMarker(new MarkerOptions().position(ruiz).title("Ruiz Branch"));
        mMap.addMarker(new MarkerOptions().position(manchaca).title("Manchaca Branch"));
        mMap.addMarker(new MarkerOptions().position(pleasant).title("Pleasant Valley Branch"));
        mMap.addMarker(new MarkerOptions().position(southeast).title("Southeast Branch"));
        mMap.addMarker(new MarkerOptions().position(hampton).title("Hampton Branch"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(austin));
    }
}
