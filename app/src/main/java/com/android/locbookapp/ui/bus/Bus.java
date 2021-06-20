package com.android.locbookapp.ui.bus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;

import com.android.locbookapp.R;

public class Bus extends Fragment {

    CardView busNumber, busStop;

    public Bus() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bus, container, false);
        busNumber = (CardView) v.findViewById(R.id.bus_number_view);
        busStop = (CardView) v.findViewById(R.id.bus_stop_view);

        busNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BusStopList.class));
            }
        });

        busStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return v;
    }

}
