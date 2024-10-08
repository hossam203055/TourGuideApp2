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
import android.widget.Toast;

public class CafeItemActivity extends AppCompatActivity {
    ImageView cafeItemImage;
    TextView cafeItemName;
    TextView cafeItemAddress;
    TextView cafeItemPhone;
    Button cafeItemCallPhone;
    Button cafeItemViewMap;
    String cafeItemGeo;
    String zoomMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_activity_item);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        cafeItemImage = findViewById(R.id.cafeItemImageView);
        cafeItemName = findViewById(R.id.cafeItemNameTextView);
        cafeItemAddress = findViewById(R.id.cafeItemAddressTextView);
        cafeItemPhone = findViewById(R.id.cafeItemPhoneTextView);
        cafeItemCallPhone = findViewById(R.id.cafeItemCallPhoneButton);
        cafeItemViewMap = findViewById(R.id.cafeItemViewMapButton);

        Bundle b = getIntent().getExtras();
        cafeItemImage.setImageResource(b.getInt("cafeImage"));
        cafeItemName.setText(b.getString("cafeName"));
        cafeItemAddress.setText(b.getString("cafeAddress"));
        cafeItemPhone.setText(b.getString("cafePhone"));
        cafeItemGeo = b.getString("cafeGeo");
        zoomMap = "?z=19";

        if (cafeItemPhone.getText().equals(getResources().getString(R.string.notFoundAlert)))
                cafeItemCallPhone.setEnabled(false);
        else {
            cafeItemCallPhone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callPhoneIntent = new Intent(Intent.ACTION_DIAL,
                            Uri.parse("tel:" + cafeItemPhone.getText().toString()));
                    startActivity(callPhoneIntent);

                }
            });
        }



        cafeItemViewMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewMapIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:" + cafeItemGeo + zoomMap));
                startActivity(viewMapIntent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home)
            this.finish();
        return super.onOptionsItemSelected(item);

    }
}
