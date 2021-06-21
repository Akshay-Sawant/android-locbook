package com.android.locbookapp.ui.versova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.locbookapp.R;

public class VersovaStationList extends AppCompatActivity {

    private static ListView versovaStationList;
    private static String[] vStationList = new String[]{"• ghatkopar", "• jagrutinagar", "• asalpha", "• saki naka",
            "• marol naka", "• airport road", "• chakala (jb nagar)", "• western exp highway",
            "• andheri", "• azad nagar", "• d n nagar", "• vesova"};
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_versova_station_list);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" You are at ?");

        // List view
        versovaStationList = (ListView) findViewById(R.id.versova_station_list_view);

        final ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.station_item_list1, vStationList);
        versovaStationList.setAdapter(listAdapter);

        versovaStationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String stationName = vStationList[position].toUpperCase().substring(2);
                Intent intent = new Intent(VersovaStationList.this, VersovaTrains.class);
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
