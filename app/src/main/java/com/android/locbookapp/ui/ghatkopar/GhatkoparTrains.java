package com.android.locbookapp.ui.ghatkopar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.locbookapp.R;
import com.android.locbookapp.data.LocBookDatabase;
import com.android.locbookapp.ui.metro.MetroRecyclerAdapter;
import com.android.locbookapp.ui.metro.MetroTimeTable;

import java.util.ArrayList;

public class GhatkoparTrains extends AppCompatActivity {

    RecyclerView metroList;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<MetroTimeTable> arrayList = new ArrayList<>();
    LocBookDatabase locBookDatabase;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghatkopar_trains);
        String stationName = getIntent().getStringExtra("SEL_STN");

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        setTitle(stationName);

        // Recycler View
        metroList = (RecyclerView) findViewById(R.id.ghatkopar_timetable_list);
        layoutManager = new LinearLayoutManager(this);
        metroList.setLayoutManager(layoutManager);
        metroList.setHasFixedSize(true);

        // database variables
        locBookDatabase = new LocBookDatabase(this);
        sqLiteDatabase = locBookDatabase.getReadableDatabase();
        cursor = locBookDatabase.getMetroTimeTable(sqLiteDatabase);

        while (cursor.moveToNext()) {
            MetroTimeTable metroTimeTable = new MetroTimeTable(cursor.getString(cursor.getColumnIndex(LocBookDatabase.G_TIME)),
                    cursor.getString(cursor.getColumnIndex(LocBookDatabase.G_V)));
            arrayList.add(metroTimeTable);
        }

        locBookDatabase.close();
        adapter = new MetroRecyclerAdapter(arrayList);
        metroList.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
