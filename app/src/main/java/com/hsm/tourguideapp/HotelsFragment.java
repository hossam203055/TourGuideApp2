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

public class HotelsFragment extends Fragment {
    public String tag;
    private ArrayList<Hotel> hotelsArrayList;
    private ListView hotelListView;
    private HotelAdapter hotelAdapter;

    public HotelsFragment() {
//        String s = getString(R.string.hotelsFragment); //I tried to execute this statement but it makes IllegalStateException exception. I have to type String value by java
        tag = "Hotels";
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hotels_fragment,container,false);
        tag = getResources().getString(R.string.hotelsFragment);
        hotelsArrayList = new ArrayList<>();
        hotelsArrayList.add(new Hotel(R.drawable.grand_hotel,getResources().getString(R.string.grandHotelName),getResources().getString(R.string.grandHotelAddress),"30.0528294,31.2401934",1044f,3,"+2020225747801"));
        hotelsArrayList.add(new Hotel(R.drawable.hilton_cairo_world_trade_center_residences,getResources().getString(R.string.hiltonCairoWorldTradeCenterResidencesName),getResources().getString(R.string.hiltonCairoWorldTradeCenterResidencesAddress),"30.0639084,31.1582268",2199.00f,4,"+2020225802000"));
        hotelsArrayList.add(new Hotel(R.drawable.ramses_hilton,getResources().getString(R.string.ramsesHiltonName),getResources().getString(R.string.ramsesHiltonAddress),"30.0503057,31.2300286",2102,5,"+2020225777444"));
        hotelsArrayList.add(new Hotel(R.drawable.lotus_hotel,getResources().getString(R.string.lotusHotelCairoName),getResources().getString(R.string.lotusHotelCairoAddress),"30.0467384,31.235649",261,2,"+2020225750966"));
        hotelsArrayList.add(new Hotel(R.drawable.semiramis_intercontinental_hotel,getResources().getString(R.string.semiramisInterContinentalHotelName),getResources().getString(R.string.semiramisInterContinentalHotelAddress), "30.04306,31.2298013",2402,5,"+2020227988000"));
        hotelsArrayList.add(new Hotel(R.drawable.sun_hotel_cairo,getResources().getString(R.string.sunHotelCairoName),getResources().getString(R.string.sunHotelCairoAddress),"30.0757106,31.2361513",352,3,"+2020225797977"));
        hotelsArrayList.add(new Hotel(R.drawable.hotel_grand_royal,getResources().getString(R.string.grandRoyalHotelName),getResources().getString(R.string.grandRoyalHotelAddress),"30.0473662,31.2369926",582,2,"+2020223934684"));
        hotelsArrayList.add(new Hotel(R.drawable.cairo_inn,getResources().getString(R.string.cairoInnHotelName),getResources().getString(R.string.cairoInnHotelAddress),"30.047636,31.2372682",702,1,"+2 0100 077 3210"));

        hotelAdapter = new HotelAdapter(getContext(),hotelsArrayList);
        hotelListView = view.findViewById(R.id.hotelListView);
        hotelListView.setAdapter(hotelAdapter);
        hotelListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(),HotelItemActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("hotelName",hotelsArrayList.get(position).getHotelName());
                bundle.putInt("hotelImage",hotelsArrayList.get(position).getHotelImage());
                bundle.putString("hotelAddress",hotelsArrayList.get(position).getHotelAddress());
                bundle.putString("hotelGeo",hotelsArrayList.get(position).getHotelGeo());
                bundle.putFloat("hotelCostPerDay",hotelsArrayList.get(position).getHotelCostPerDay());
                bundle.putInt("hotelNumStars",hotelsArrayList.get(position).getHotelNumStars());
                bundle.putString("hotelPhone",hotelsArrayList.get(position).getHotelPhone());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        return view;
    }
}
