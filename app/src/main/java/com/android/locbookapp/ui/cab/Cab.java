package com.android.locbookapp.ui.cab;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.locbookapp.R;
import com.android.locbookapp.data.LocBookDatabase;

import java.util.ArrayList;

public class Cab extends Fragment {
    LocBookDatabase locBookDatabase;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView fareList;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<TaxiFare> arrayList = new ArrayList<>();
    Cursor cursor;
    ImageButton complaintButton;

    public Cab() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cab, container, false);

        // Recycler view
        fareList = (RecyclerView) v.findViewById(R.id.taxi_fare_display_recycler_view);
        complaintButton = (ImageButton) v.findViewById(R.id.taxi_complaint_number_btn);
        complaintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(getContext());
                View promptView = li.inflate(R.layout.taxi_complaint_dialog, null);
                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext(), R.style.RatingDialog);
                alertDialogBuilder.setView(promptView);
                //set dialog message
                alertDialogBuilder.setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        layoutManager = new LinearLayoutManager(getContext());
        fareList.setLayoutManager(layoutManager);
        fareList.setHasFixedSize(true);

        // database variables
        locBookDatabase = new LocBookDatabase(getContext());
        sqLiteDatabase = locBookDatabase.getReadableDatabase();
        cursor = locBookDatabase.getTaxiFare(sqLiteDatabase);

        while (cursor.moveToNext()) {
            TaxiFare taxiFare = new TaxiFare(cursor.getString(cursor.getColumnIndex(LocBookDatabase.KILO_METER)),
                    cursor.getString(cursor.getColumnIndex(LocBookDatabase.DAY_FARE)), cursor.getString(cursor.getColumnIndex(LocBookDatabase.NIGHT_FARE)));
            arrayList.add(taxiFare);
        }

        locBookDatabase.close();
        adapter = new RecyclerAdapter(arrayList);
        fareList.setAdapter(adapter);

        return v;
    }

}
