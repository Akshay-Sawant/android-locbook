package com.android.locbookapp.ui.ghatkopar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.locbookapp.R;

public class GhatkoparStationList extends AppCompatActivity {

    private static ListView ghatkoparStationList;
    private static String[] gStationList = new String[]{"• versova", "• d n nagar", "• azad nagar", "• andheri",
            "• western exp highway", "• chakala (jb nagar)", "• airport road", "• marol naka", "• saki naka",
            "• asalpha", "• jagrutinagar", "• ghatkopar"};
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghatkopar_station_list);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" You are at ?");

        // List view
        ghatkoparStationList = (ListView) findViewById(R.id.ghatkopar_station_list_view);

        final ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.station_item_list1, gStationList);
        ghatkoparStationList.setAdapter(listAdapter);

        ghatkoparStationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String stationName = gStationList[position].toUpperCase().substring(2);
                Intent intent = new Intent(GhatkoparStationList.this, GhatkoparTrains.class);
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
