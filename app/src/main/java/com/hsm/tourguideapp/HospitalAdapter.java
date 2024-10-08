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

public class HospitalAdapter extends ArrayAdapter<Hospital> {
    Context context;
    ArrayList<Hospital> hospitalArrayList = new ArrayList<>();

    public HospitalAdapter(@NonNull Context context, @NonNull ArrayList<Hospital> objects) {
        super(context, R.layout.an_item, objects);
        this.context = context;
        this.hospitalArrayList = objects;
    }

    @Override
    public int getCount() {
        return hospitalArrayList.size();
    }

    @Nullable
    @Override
    public Hospital getItem(int position) {
        return hospitalArrayList.get(position);
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
        ImageView hospitalImageView = viewContainer.findViewById(R.id.anItemImageView);
        TextView hospitalNameTextView = viewContainer.findViewById(R.id.anItemNameTextView);
        Hospital restaurant = getItem(position);
        hospitalImageView.setImageResource(restaurant.getHospitalImage());
        hospitalNameTextView.setText(restaurant.getHospitalName());

        return viewContainer;
    }
}
