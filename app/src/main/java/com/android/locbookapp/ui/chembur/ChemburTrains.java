package com.android.locbookapp.ui.chembur;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.locbookapp.R;
import com.android.locbookapp.data.LocBookDatabase;
import com.android.locbookapp.ui.mono.MonoRecyclerAdapter;
import com.android.locbookapp.ui.mono.MonoTimeTable;

import java.util.ArrayList;

public class ChemburTrains extends AppCompatActivity {

    RecyclerView monoList;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<MonoTimeTable> arrayList = new ArrayList<>();
    LocBookDatabase locBookDatabase;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chembur_trains);
        String stationName = getIntent().getStringExtra("SEL_STN");
        toolbar = (Toolbar) findViewById(R.id.tool_bar);

        setSupportActionBar(toolbar);
        setTitle(stationName);

        // Recycler View
        monoList = (RecyclerView) findViewById(R.id.chembur_timetable_list);
        layoutManager = new LinearLayoutManager(this);
        monoList.setLayoutManager(layoutManager);
        monoList.setHasFixedSize(true);

        // database variables
        locBookDatabase = new LocBookDatabase(this);
        sqLiteDatabase = locBookDatabase.getReadableDatabase();
        cursor = locBookDatabase.getMonoTimeTable(sqLiteDatabase);

        while (cursor.moveToNext()) {
            MonoTimeTable monoTimeTable = new MonoTimeTable(cursor.getString(cursor.getColumnIndex(LocBookDatabase.C_TIME)),
                    cursor.getString(cursor.getColumnIndex(LocBookDatabase.W_C)), cursor.getString(cursor.getColumnIndex(LocBookDatabase.MODE)),
                    cursor.getString(cursor.getColumnIndex(LocBookDatabase.DES_CHEMBUR)));
            arrayList.add(monoTimeTable);
        }

        locBookDatabase.close();
        adapter = new MonoRecyclerAdapter(arrayList);
        monoList.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
