package com.hsm.tourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HSM on 17/3/2018.
 */

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {
    Context context;
    ArrayList<Restaurant> restaurantArrayList = new ArrayList<>();

    public RestaurantAdapter(@NonNull Context context, @NonNull ArrayList<Restaurant> objects) {
        super(context, R.layout.an_item, objects);
        this.context = context;
        this.restaurantArrayList = objects;
    }

    @Override
    public int getCount() {
        return restaurantArrayList.size();
    }

    @Nullable
    @Override
    public Restaurant getItem(int position) {
        return restaurantArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View viewContainer = convertView;
        if (viewContainer == null)
            viewContainer = LayoutInflater.from(getContext()).inflate(R.layout.an_item,parent,false);
        ImageView restaurantImageView = viewContainer.findViewById(R.id.anItemImageView);
        TextView restaurantNameTextView = viewContainer.findViewById(R.id.anItemNameTextView);
        Restaurant restaurant = getItem(position);
        restaurantImageView.setImageResource(restaurant.getRestaurantImage());
        restaurantNameTextView.setText(restaurant.getRestaurantName());

        return viewContainer;
    }
}
