package com.android.locbookapp.ui.metro;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.android.locbookapp.R;
import com.android.locbookapp.ui.ghatkopar.GhatkoparStationList;
import com.android.locbookapp.ui.versova.VersovaStationList;

public class Metro extends Fragment {

    ImageButton ghatkopar, versova;

    public Metro() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_metro, container, false);

        // Buttons
        ghatkopar = (ImageButton) v.findViewById(R.id.ghatkopar_list_btn);
        versova = (ImageButton) v.findViewById(R.id.versova_list_btn);

        ghatkopar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GhatkoparStationList.class));
            }
        });

        versova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), VersovaStationList.class));
            }
        });

        return v;
    }
}