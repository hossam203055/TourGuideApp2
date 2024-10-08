package com.hsm.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantItemActivity extends AppCompatActivity {
    ImageView restaurantItemImage;
    TextView restaurantItemName;
    TextView restaurantItemAddress;
    TextView restaurantItemPhone;
    Button restaurantItemCallPhone;
    Button restaurantItemViewMap;
    String restaurantItemGeo;
    String zoomMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_activity_item);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        restaurantItemImage = findViewById(R.id.cafeItemImageView);
        restaurantItemName = findViewById(R.id.cafeItemNameTextView);
        restaurantItemAddress = findViewById(R.id.cafeItemAddressTextView);
        restaurantItemPhone = findViewById(R.id.cafeItemPhoneTextView);
        restaurantItemCallPhone = findViewById(R.id.cafeItemCallPhoneButton);
        restaurantItemViewMap = findViewById(R.id.cafeItemViewMapButton);

        Bundle b = getIntent().getExtras();
        restaurantItemImage.setImageResource(b.getInt("restaurantImage"));
        restaurantItemName.setText(b.getString("restaurantName"));
        restaurantItemAddress.setText(b.getString("restaurantAddress"));
        restaurantItemPhone.setText(b.getString("restaurantPhone"));
        restaurantItemGeo = b.getString("restaurantGeo");
        zoomMap = "?z=19";

        restaurantItemCallPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callPhoneIntent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:"+restaurantItemPhone.getText().toString()));
                startActivity(callPhoneIntent);
            }
        });

        restaurantItemViewMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewMapIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:"+restaurantItemGeo+zoomMap));
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
