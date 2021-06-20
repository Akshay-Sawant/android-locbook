package com.android.locbookapp.ui.bus;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.locbookapp.R;
import com.android.locbookapp.data.LocBookDatabase;

import java.util.ArrayList;

public class BusStopList extends AppCompatActivity {

    RecyclerView busNumberList;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<BusNumber> arrayList = new ArrayList<>();
    LocBookDatabase locBookDatabase;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_stop_list);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        setTitle("BEST Buses");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Recycler View
        busNumberList = (RecyclerView) findViewById(R.id.bus_stop_list_view);
        layoutManager = new LinearLayoutManager(this);
        busNumberList.setLayoutManager(layoutManager);
        busNumberList.setHasFixedSize(true);

        // database variables
        locBookDatabase = new LocBookDatabase(this);
        sqLiteDatabase = locBookDatabase.getReadableDatabase();
        cursor = locBookDatabase.getBusNumberList(sqLiteDatabase);

        while (cursor.moveToNext()) {
            BusNumber busNumber = new BusNumber(cursor.getString(cursor.getColumnIndex(LocBookDatabase.BUS_NUM)), cursor.getString(cursor.getColumnIndex(LocBookDatabase.BUS_SOURCE)),
                    cursor.getString(cursor.getColumnIndex(LocBookDatabase.BUS_DESTINAION)), cursor.getString(cursor.getColumnIndex(LocBookDatabase.BUS_AREA)),
                    cursor.getString(cursor.getColumnIndex(LocBookDatabase.BUS_STOPS_NUMBER)));
            arrayList.add(busNumber);
        }

        locBookDatabase.close();
        adapter = new BusNumberRecyclerAdapter(arrayList);
        busNumberList.setAdapter(adapter);

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