package com.hsm.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by HSM on 10/3/2018.
 */

public class OverviewFragment extends Fragment {
    public String tag;
    Button showMoreInformationButton;

    public OverviewFragment() {
//        String s = getString(R.string.overviewFragment); //I tried to execute this statement but it makes IllegalStateException exception. I have to type String value by java
        tag = "Overview";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.overview_fragment,container,false);
        tag = getResources().getString(R.string.overviewFragment);
        showMoreInformationButton = view.findViewById(R.id.showMoreInformationButton);
        showMoreInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Downtown_Cairo"));
                startActivity(browseIntent);
            }
        });
        return view;
    }
}
