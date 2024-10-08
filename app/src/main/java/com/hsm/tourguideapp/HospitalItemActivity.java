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

public class HospitalItemActivity extends AppCompatActivity {
    ImageView hospitalItemImage;
    TextView hospitalItemName;
    TextView hospitalItemAddress;
    TextView hospitalItemPhone;
    Button hospitalItemCallPhone;
    Button hospitalItemViewMap;
    String hospitalItemGeo;
    String zoomMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_activity_item);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        hospitalItemImage = findViewById(R.id.hospitalItemImageView);
        hospitalItemName = findViewById(R.id.hospitalItemNameTextView);
        hospitalItemAddress = findViewById(R.id.hospitalItemAddressTextView);
        hospitalItemPhone = findViewById(R.id.hospitalItemPhoneTextView);
        hospitalItemCallPhone = findViewById(R.id.hospitalItemCallPhoneButton);
        hospitalItemViewMap = findViewById(R.id.hospitalItemViewMapButton);

        Bundle b = getIntent().getExtras();
        hospitalItemImage.setImageResource(b.getInt("hospitalImage"));
        hospitalItemName.setText(b.getString("hospitalName"));
        hospitalItemAddress.setText(b.getString("hospitalAddress"));
        hospitalItemPhone.setText(b.getString("hospitalPhone"));
        hospitalItemGeo = b.getString("hospitalGeo");
        zoomMap = "?z=19";

        hospitalItemCallPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callPhoneIntent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:"+hospitalItemPhone.getText().toString()));
                startActivity(callPhoneIntent);
            }
        });

        hospitalItemViewMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewMapIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:"+hospitalItemGeo+zoomMap));
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
