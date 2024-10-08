package com.hsm.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by HSM on 10/3/2018.
 */

public class HospitalsFragment extends Fragment {
    public String tag;
    private ArrayList<Hospital> hospitalsArrayList;
    private ListView hospitalListView;
    private HospitalAdapter hospitalAdapter;

    public HospitalsFragment() {
//        String s = getString(R.string.hospitalsFragment); //I tried to execute this statement but it makes IllegalStateException exception. I have to type String value by java
        tag = "Hospitals";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hospitals_fragment,container,false);
        tag = getResources().getString(R.string.hospitalsFragment);
        hospitalsArrayList = new ArrayList<>();

        hospitalsArrayList.add(new Hospital(R.drawable.alhelal_hospital,getResources().getString(R.string.alHelalHospitalName),getResources().getString(R.string.alHelalHospitalAddress),"30.0496241,31.2408443","+2 0114 402 9767"));
        hospitalsArrayList.add(new Hospital(R.drawable.elgalaa_hospital,getResources().getString(R.string.elGalaaHospitalName),getResources().getString(R.string.elGalaaHospitalAddress),"30.0534849,31.2362445","+2020225756245"));
        hospitalsArrayList.add(new Hospital(R.drawable.misr_international_hospital,getResources().getString(R.string.misrInternationalHospitalName),getResources().getString(R.string.misrInternationalHospitalAddress),"30.0425636,31.2157846","+2020237608261"));

        hospitalListView = view.findViewById(R.id.hospitalListView);
        hospitalAdapter = new HospitalAdapter(getContext(),hospitalsArrayList);
        hospitalListView.setAdapter(hospitalAdapter);

        hospitalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();

                bundle.putString("hospitalName",hospitalsArrayList.get(position).getHospitalName());
                bundle.putInt("hospitalImage",hospitalsArrayList.get(position).getHospitalImage());
                bundle.putString("hospitalAddress",hospitalsArrayList.get(position).getHospitalAddress());
                bundle.putString("hospitalGeo",hospitalsArrayList.get(position).getHospitalGeo());
                bundle.putString("hospitalPhone",hospitalsArrayList.get(position).getHospitalPhone());

                Intent intent = new Intent(getContext(),HospitalItemActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return view;
    }
}
