package com.android.locbookapp.ui.trains;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.locbookapp.R;
import com.android.locbookapp.ui.central.Central;
import com.android.locbookapp.ui.harbour.Harbour;
import com.android.locbookapp.ui.local.LocalStationsList;
import com.android.locbookapp.ui.western.Western;

public class Train extends Fragment {

    Button c, w, h, t;
    LinearLayout stationList;

    public Train() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_train, container, false);
        c = (Button) v.findViewById(R.id.central);
        h = (Button) v.findViewById(R.id.harbour);
        w = (Button) v.findViewById(R.id.western);
        t = (Button) v.findViewById(R.id.thana);
        stationList = (LinearLayout) v.findViewById(R.id.station_list_btn);
        stationList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LocalStationsList.class));
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Central central = new Central();
                ft.add(R.id.local_container, central);
                ft.commit();
            }
        });
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Harbour harbour = new Harbour();
                ft.replace(R.id.local_container, harbour);
                ft.commit();
            }
        });
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Western western = new Western();
                ft.replace(R.id.local_container, western);
                ft.commit();
            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Trans trans = new Trans();
                ft.replace(R.id.local_container, trans);
                ft.commit();
            }
        });

        return v;
    }
}