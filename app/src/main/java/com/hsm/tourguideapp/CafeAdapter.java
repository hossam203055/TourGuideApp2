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

public class CafeAdapter extends ArrayAdapter<Cafe> {
    Context context;
    ArrayList<Cafe> cafeArrayList = new ArrayList<>();

    public CafeAdapter(@NonNull Context context, @NonNull ArrayList<Cafe> objects) {
        super(context, R.layout.an_item, objects);
        this.context = context;
        this.cafeArrayList = objects;
    }

    @Override
    public int getCount() {
        return cafeArrayList.size();
    }

    @Nullable
    @Override
    public Cafe getItem(int position) {
        return cafeArrayList.get(position);
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
        ImageView cafeImageView = viewContainer.findViewById(R.id.anItemImageView);
        TextView cafeNameTextView = viewContainer.findViewById(R.id.anItemNameTextView);
        Cafe cafe = getItem(position);
        cafeImageView.setImageResource(cafe.getCafeImage());
        cafeNameTextView.setText(cafe.getCafeName());

        return viewContainer;
    }
}
