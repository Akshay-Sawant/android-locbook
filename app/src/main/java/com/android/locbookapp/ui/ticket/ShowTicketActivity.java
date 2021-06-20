package com.android.locbookapp.ui.ticket;


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

public class ShowTicketActivity extends AppCompatActivity {

    RecyclerView ticketList;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<TicketAttributes> arrayList = new ArrayList<>();
    LocBookDatabase locBookDatabase;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor, cursor1;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ticket);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);

        setSupportActionBar(toolbar);
        setTitle("Ticket");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Recycler View
        ticketList = (RecyclerView) findViewById(R.id.ticket_list_view);
        layoutManager = new LinearLayoutManager(this);
        ticketList.setLayoutManager(layoutManager);
        ticketList.setHasFixedSize(true);

        // database variables
        locBookDatabase = new LocBookDatabase(this);
        sqLiteDatabase = locBookDatabase.getReadableDatabase();
        cursor = locBookDatabase.getBookedTicket(sqLiteDatabase);
        //cursor1 = locBookDatabase.getUserInfo(sqLiteDatabase);

        while (cursor.moveToNext()) {
            TicketAttributes ticketAttributes = new TicketAttributes(cursor.getString(cursor.getColumnIndex(LocBookDatabase.FARE)),
                    cursor.getString(cursor.getColumnIndex(LocBookDatabase.CURRENT_DATE)), cursor.getString(cursor.getColumnIndex(LocBookDatabase.CURRENT_DATE)),
                    cursor.getString(cursor.getColumnIndex(LocBookDatabase.B_SOURCE)), cursor.getString(cursor.getColumnIndex(LocBookDatabase.B_DESTINATION)),
                    cursor.getString(cursor.getColumnIndex(LocBookDatabase.ADULT)), cursor.getString(cursor.getColumnIndex(LocBookDatabase.CHILD)),
                    cursor.getString(cursor.getColumnIndex(LocBookDatabase.DISTANCE)), cursor.getString(cursor.getColumnIndex(LocBookDatabase.CLASS)),
                    cursor.getString(cursor.getColumnIndex(LocBookDatabase.BOOKING_DATE_TIME)));
            arrayList.add(ticketAttributes);
        }

        locBookDatabase.close();
        adapter = new TicketViewRecyclerAdapter(arrayList);
        ticketList.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
