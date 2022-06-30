/*  IDENTITAS DIRI :
 *  NIM : 10119028
 *  NAMA : Rizal Sihombing
 *  KELAS : IF-1
 */

package com.example.a10119028_rizalsihombing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.example.a10119028_rizalsihombing.databinding.ActivityMapsBinding;
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

public class MapsFragment extends Fragment {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;


    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng sydney = new LatLng(-34, 151);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));

            LatLng lokasiSaatIni = new LatLng(-6.925434, 107.582349);
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
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(callback);
    }
}