package com.android.locbookapp.ui.chembur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.locbookapp.R;

public class ChemburStationList extends AppCompatActivity {

    private static ListView chemburStationList;
    private static String[] cStationList = new String[]{"• WADALA", "• Bhakti Park", "• Mysore Colony", "• Bharat Petroleum", "• Fertiliser Township",
            "• VPN Marg Junction", "• Chembur"};
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chembur_station_list);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("You are at ?");
        // List view
        chemburStationList = (ListView) findViewById(R.id.chembur_station_list_view);

        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.station_item_list1, cStationList);
        chemburStationList.setAdapter(listAdapter);

        chemburStationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String stationName = cStationList[position].toUpperCase().substring(2);
                Intent intent = new Intent(ChemburStationList.this, ChemburTrains.class);
                intent.putExtra("SEL_STN", stationName);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
