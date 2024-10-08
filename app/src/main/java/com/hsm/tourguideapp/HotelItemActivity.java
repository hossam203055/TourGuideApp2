package com.hsm.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HotelItemActivity extends AppCompatActivity {
    ImageView hotelItemImage;
    TextView hotelItemName;
    TextView hotelItemAddress;
    TextView hotelItemCostPerDay;
    TextView hotelItemNumStars;
    TextView hotelItemPhone;
    Button hotelItemCallPhone;
    Button hotelItemViewMap;
    String hotelItemGeo;
    String zoomMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_activity_item);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        hotelItemImage = findViewById(R.id.hospitalItemImageView);
        hotelItemName = findViewById(R.id.hospitalItemNameTextView);
        hotelItemAddress = findViewById(R.id.hospitalItemAddressTextView);
        hotelItemCostPerDay = findViewById(R.id.hospitalItemCostPerDayTextView);
        hotelItemNumStars = findViewById(R.id.hotelItemNumStarsTextView);
        hotelItemPhone = findViewById(R.id.hospitalItemPhoneTextView);
        hotelItemCallPhone = findViewById(R.id.hospitalItemCallPhoneButton);
        hotelItemViewMap = findViewById(R.id.hospitalItemViewMapButton);

        Bundle b = getIntent().getExtras();
        hotelItemImage.setImageResource(b.getInt("hotelImage"));
        hotelItemName.setText(b.getString("hotelName"));
        hotelItemAddress.setText(b.getString("hotelAddress"));
        hotelItemCostPerDay.setText(b.getFloat("hotelCostPerDay")+" L.E");
        hotelItemNumStars.setText(""+b.getInt("hotelNumStars"));
        hotelItemPhone.setText(b.getString("hotelPhone"));
        hotelItemGeo = b.getString("hotelGeo");
        zoomMap = "?z=19";

        hotelItemCallPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callPhoneIntent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:"+hotelItemPhone.getText().toString()));
                startActivity(callPhoneIntent);
            }
        });

        hotelItemViewMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewMapIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:"+hotelItemGeo+zoomMap));
                startActivity(viewMapIntent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==android.R.id.home)
            this.finish();
        return super.onOptionsItemSelected(item);

    }
}
