package com.android.locbookapp.ui.mono;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.android.locbookapp.R;
import com.android.locbookapp.ui.chembur.ChemburStationList;
import com.android.locbookapp.ui.wadala.WadalaStationList;

public class Mono extends Fragment {

    ImageButton chembur, wadala;

    public Mono() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mono, container, false);

        // Buttons
        chembur = (ImageButton) v.findViewById(R.id.chembur_list_btn);
        wadala = (ImageButton) v.findViewById(R.id.wadala_list_btn);

        chembur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ChemburStationList.class));
            }
        });

        wadala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), WadalaStationList.class));
            }
        });

        return v;
    }
}