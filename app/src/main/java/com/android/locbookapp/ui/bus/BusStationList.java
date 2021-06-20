package com.android.locbookapp.ui.bus;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.locbookapp.R;
import com.android.locbookapp.data.LocBookDatabase;

import java.util.ArrayList;

public class BusStationList extends AppCompatActivity {

    RecyclerView busStationList;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<BusStation> arrayList = new ArrayList<>();
    LocBookDatabase locBookDatabase;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_station_list);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        setTitle("BEST Buses");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Recycler View
        busStationList = (RecyclerView) findViewById(R.id.bus_station_list_view);
        layoutManager = new LinearLayoutManager(this);
        busStationList.setLayoutManager(layoutManager);
        busStationList.setHasFixedSize(true);

        // database variables
        locBookDatabase = new LocBookDatabase(this);
        sqLiteDatabase = locBookDatabase.getReadableDatabase();
        cursor = locBookDatabase.getBusStopList(sqLiteDatabase);

        while (cursor.moveToNext()) {
            BusStation busStation = new BusStation(cursor.getString(cursor.getColumnIndex(LocBookDatabase.BUS_STOP_NAME)));
            arrayList.add(busStation);
        }

        locBookDatabase.close();
        adapter = new BusStopRecyclerAdapter(arrayList);
        busStationList.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
