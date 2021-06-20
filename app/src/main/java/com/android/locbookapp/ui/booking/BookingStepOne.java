package com.android.locbookapp.ui.booking;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.locbookapp.R;
import com.android.locbookapp.data.LocBookDatabase;

import java.util.ArrayList;

public class BookingStepOne extends Fragment implements View.OnClickListener {

    public String strSource, strDestination, strFare, strDistance;
    public TextView fareView;
    LocBookDatabase locBookDatabase;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    Button proceedToStepTwo, fareCalculate;
    private AutoCompleteTextView source, destination;

    public BookingStepOne() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_booking_step_one, container, false);

        source = (AutoCompleteTextView) v.findViewById(R.id.book_source);
        destination = (AutoCompleteTextView) v.findViewById(R.id.book_destination);
        proceedToStepTwo = (Button) v.findViewById(R.id.proceed_to_step_two);
        fareCalculate = (Button) v.findViewById(R.id.ste_one_fare);
        fareView = (TextView) v.findViewById(R.id.fare_view);

        fareCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strSource = source.getText().toString();
                strDestination = destination.getText().toString();
                // fare

                if (strSource.equalsIgnoreCase("kurla") || strDestination.equalsIgnoreCase("sion")) {
                    fareView.setText("5 rs");
                }

                if (strSource.equalsIgnoreCase("kurla") || strDestination.equalsIgnoreCase("byculla")) {
                    fareView.setText("10 rs");
                }

                if (strSource.equalsIgnoreCase("kurla") || strDestination.equalsIgnoreCase("cst")) {
                    fareView.setText("10 rs");
                }

            }
        });

        proceedToStepTwo.setOnClickListener(this);

        locBookDatabase = new LocBookDatabase(getContext());
        sqLiteDatabase = locBookDatabase.getReadableDatabase();
        cursor = locBookDatabase.getStationList(sqLiteDatabase);

        final ArrayList stationArray = new ArrayList();
        final ArrayAdapter listAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, stationArray);

        source.setThreshold(1);
        source.setAdapter(listAdapter);

        destination.setThreshold(1);
        destination.setAdapter(listAdapter);

        while (cursor.moveToNext()) {
            stationArray.add(cursor.getString(cursor.getColumnIndex(LocBookDatabase.STATION_NAME)));
            Log.e("ListView", "Autotextview Station List");
        }

        // fare and destination will get from DB or through code and save to strFare and strDistance

        return v;
    }

    @Override
    public void onClick(View v) {
        if (v == proceedToStepTwo) {
            strSource = source.getText().toString();
            strDestination = destination.getText().toString();

            if (TextUtils.isEmpty(strSource) && TextUtils.isEmpty(strDestination)) {
                Toast.makeText(getContext(), "Select Source and Destination", Toast.LENGTH_SHORT).show();
            }
            if (strSource.equalsIgnoreCase(strDestination)) {
                destination.setText("");
                Toast.makeText(getContext(), "Source and Destination Cannot be the Same", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(strSource)) {
                Toast.makeText(getContext(), "Select Source", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(strDestination)) {
                Toast.makeText(getContext(), "Select Destination", Toast.LENGTH_SHORT).show();
            }
        }
    }
}