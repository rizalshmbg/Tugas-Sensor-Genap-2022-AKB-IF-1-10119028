/*  IDENTITAS DIRI :
 *  NIM : 10119028
 *  NAMA : Rizal Sihombing
 *  KELAS : IF-1
 */

package com.example.a10119028_rizalsihombing;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.LocaleList;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.a10119028_rizalsihombing.databinding.ActivityMapsBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends FragmentActivity{

    private ActivityMapsBinding binding;
    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        client = LocationServices.getFusedLocationProviderClient(this);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        getCurrentLocation();
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
         ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null ) {
                    mapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(@NonNull GoogleMap googleMap) {
                            LatLng lokasiSaatIni = new LatLng(location.getLatitude(), location.getLongitude());
                            LatLng lokasi1 = new LatLng(-6.9207268, 107.5814325);
                            LatLng lokasi2 = new LatLng(-6.9289013,107.5851245);
                            LatLng lokasi3 = new LatLng(-6.9217517,107.5858157);
                            LatLng lokasi4 = new LatLng(-6.9219929,107.585581);
                            LatLng lokasi5 = new LatLng(-6.9236863,107.5804113);

                            googleMap.addMarker(new MarkerOptions().position(lokasiSaatIni).title("Lokasi Saat Ini"));
                            googleMap.addMarker(new MarkerOptions().position(lokasi1).title("Lomie Keramat"));
                            googleMap.addMarker(new MarkerOptions().position(lokasi2).title("Warteg Putra Bahari"));
                            googleMap.addMarker(new MarkerOptions().position(lokasi3).title("Warning Sambel Ijo Dadakan "));
                            googleMap.addMarker(new MarkerOptions().position(lokasi4).title("Raja Ayam"));
                            googleMap.addMarker(new MarkerOptions().position(lokasi5).title("Warung Nasi Ma Ati"));

                            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasiSaatIni, 15));
                        }
                    });
                }
            }
        });
    }
}