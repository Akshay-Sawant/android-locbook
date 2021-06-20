package com.android.locbookapp.ui.wadala;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.locbookapp.R;

public class WadalaStationList extends AppCompatActivity {

    private static ListView wadalaStationList;
    private static String[] wStationList = new String[]{"• Chembur", "• VPN Marg Junction", "• Fertiliser Township", "• Bharat Petroleum",
            "• Mysore Colony", "• Bhakti Park", "• Wadala"};
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wadala_station_list);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" You are at ?");

        // List view
        wadalaStationList = (ListView) findViewById(R.id.wadala_station_list_view);

        final ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.station_item_list1, wStationList);
        wadalaStationList.setAdapter(listAdapter);

        wadalaStationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String stationName = wStationList[position].toUpperCase().substring(2);
                Intent intent = new Intent(WadalaStationList.this, WadalaTrains.class);
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
