package com.hsm.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by HSM on 10/3/2018.
 */

public class RestaurantsFragment extends Fragment {
    public String tag;
    private ArrayList<Restaurant> restaurantsArrayList;
    private ListView restaurantListView;
    private RestaurantAdapter restaurantAdapter;

    public RestaurantsFragment() {
//        String s = getString(R.string.restaurantsFragment); //I tried to execute this statement but it makes IllegalStateException exception. I have to type String value by java
        tag = "Restaurants";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.restaurants_fragment, container, false);
        tag = getResources().getString(R.string.restaurantsFragment);
        restaurantsArrayList = new ArrayList<>();
        restaurantsArrayList.add(new Restaurant(R.drawable.koshary_abo_tarek, getResources().getString(R.string.kosharyAbouTarekName), getResources().getString(R.string.kosharyAbouTarekName), "30.0501949,31.2355987", "+20216760"));
        restaurantsArrayList.add(new Restaurant(R.drawable.kfc, getResources().getString(R.string.kFCName), getResources().getString(R.string.kFCAddress), "30.0478647,31.2468174", "+20219019"));
        restaurantsArrayList.add(new Restaurant(R.drawable.tom_and_basal, getResources().getString(R.string.tomAndBasalName), getResources().getString(R.string.tomAndBasalAddress), "30.0462386,31.2370055", "+2020225760800"));
        restaurantsArrayList.add(new Restaurant(R.drawable.kazaz, getResources().getString(R.string.kazazName), getResources().getString(R.string.kazazAddress), "30.0470971,31.2388323", "+20216903"));
        restaurantsArrayList.add(new Restaurant(R.drawable.pizza_hut, getResources().getString(R.string.pizzaHutAddress), getResources().getString(R.string.pizzaHutAddress), "30.0445987,31.23259", "+20219000"));
        restaurantsArrayList.add(new Restaurant(R.drawable.groppi, getResources().getString(R.string.groppiName), getResources().getString(R.string.groppiAddress), "30.0476845,31.2378543", "+2020223911871"));
        restaurantsArrayList.add(new Restaurant(R.drawable.mcdonalds, getResources().getString(R.string.mcDonaldsName), getResources().getString(R.string.mcDonaldsAddress), "30.0436958,31.2370004", "+20219997"));

        restaurantListView = view.findViewById(R.id.restaurantListView);
        restaurantAdapter = new RestaurantAdapter(getContext(), restaurantsArrayList);
        restaurantListView.setAdapter(restaurantAdapter);
        restaurantListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("restaurantName", restaurantsArrayList.get(position).getRestaurantName());
                bundle.putInt("restaurantImage", restaurantsArrayList.get(position).getRestaurantImage());
                bundle.putString("restaurantAddress", restaurantsArrayList.get(position).getRestaurantAddress());
                bundle.putString("restaurantGeo", restaurantsArrayList.get(position).getRestaurantGeo());
                bundle.putString("restaurantPhone", restaurantsArrayList.get(position).getRestaurantPhone());
                Intent intent = new Intent(getContext(), RestaurantItemActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return view;
    }
}
