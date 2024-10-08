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

public class HotelAdapter extends ArrayAdapter<Hotel> {
    Context context;
    ArrayList<Hotel> hotelArrayList = new ArrayList<>();

    public HotelAdapter(@NonNull Context context, @NonNull ArrayList<Hotel> objects) {
        super(context, R.layout.an_item, objects);
        this.context = context;
        this.hotelArrayList = objects;
    }

    @Override
    public int getCount() {
        return hotelArrayList.size();
    }

    @Nullable
    @Override
    public Hotel getItem(int position) {
        return hotelArrayList.get(position);
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
        ImageView hotelImageView = viewContainer.findViewById(R.id.anItemImageView);
        TextView hotelNameTextView = viewContainer.findViewById(R.id.anItemNameTextView);
        Hotel hotel = getItem(position);
        hotelImageView.setImageResource(hotel.getHotelImage());
        hotelNameTextView.setText(hotel.getHotelName());

        return viewContainer;
    }
}
