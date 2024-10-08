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

public class CafesFragment extends Fragment {
    public String tag;
    private ArrayList<Cafe> cafesArrayList;
    private ListView cafeListView;
    private CafeAdapter cafeAdapter;

    public CafesFragment() {
//        String s = getString(R.string.cafesFragment); //I tried to execute this statement but it makes IllegalStateException exception. I have to type String value by java
        tag = "Cafes";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cafes_fragment,container,false);
        tag = getResources().getString(R.string.cafesFragment);
        cafesArrayList = new ArrayList<>();

        cafesArrayList.add(new Cafe(R.drawable.beanos,getResources().getString(R.string.beanosName),getResources().getString(R.string.beanosAddress),"30.0432815,31.238824","+2020227922328"));
        cafesArrayList.add(new Cafe(R.drawable.cilantro,getResources().getString(R.string.cilantroName),getResources().getString(R.string.cilantroAddress),"30.0436522, 31.2376016","+20224619105"));
        cafesArrayList.add(new Cafe(R.drawable.zahtret_al_bostan,getResources().getString(R.string.zahretAlBostanName),getResources().getString(R.string.zahretAlBostanAddress),"30.0469805,31.2388904",getResources().getString(R.string.notFoundAlert)));
        cafesArrayList.add(new Cafe(R.drawable.cafe_corniche,getResources().getString(R.string.cafeCornicheName),getResources().getString(R.string.cafeCornicheAddress),"30.042669,31.2316975","+20227988000"));
        cafesArrayList.add(new Cafe(R.drawable.el_horreya_cafe_and_bar,getResources().getString(R.string.elHorreyaCafeAndBarName),getResources().getString(R.string.elHorreyaCafeAndBarAddress),"30.0452479,31.239627","+20223920397"));
        cafesArrayList.add(new Cafe(R.drawable.elnadwa_elthakafia,getResources().getString(R.string.elnadwaElthkafiaName),getResources().getString(R.string.elnadwaElthkafiaAddress),"30.0456007,31.2392791",getResources().getString(R.string.notFoundAlert)));
        cafesArrayList.add(new Cafe(R.drawable.alamericaine,getResources().getString(R.string.alAmericaineName),getResources().getString(R.string.alAmericaineAddress),"30.0527241,31.2398731","+20225745344"));

        cafeListView = view.findViewById(R.id.cafeListView);
        cafeAdapter = new CafeAdapter(getContext(), cafesArrayList);
        cafeListView.setAdapter(cafeAdapter);

        cafeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();

                bundle.putString("cafeName", cafesArrayList.get(position).getCafeName());
                bundle.putInt("cafeImage", cafesArrayList.get(position).getCafeImage());
                bundle.putString("cafeAddress", cafesArrayList.get(position).getCafeAddress());
                bundle.putString("cafeGeo", cafesArrayList.get(position).getCafeGeo());
                bundle.putString("cafePhone", cafesArrayList.get(position).getCafePhone());

                Intent intent = new Intent(getContext(),CafeItemActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return view;
    }
}
