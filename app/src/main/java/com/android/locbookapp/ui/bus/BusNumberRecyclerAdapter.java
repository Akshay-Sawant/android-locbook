package com.android.locbookapp.ui.bus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.locbookapp.R;

import java.util.ArrayList;

/**
 * Created by Rachana on 3/28/2017.
 */

public class BusNumberRecyclerAdapter extends RecyclerView.Adapter<BusNumberRecyclerAdapter.RecyclerViewHolder> {

    ArrayList<BusNumber> arrayList;

    BusNumberRecyclerAdapter(ArrayList<BusNumber> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bus_number_list, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        BusNumber busNumber = arrayList.get(position);
        holder.busNumber.setText(busNumber.getBusNumber());
        holder.busSource.setText(busNumber.getBusSource());
        holder.busDestination.setText(busNumber.getBusDestination());
        holder.busArea.setText(busNumber.getBusArea());
        holder.busStopNumber.setText(busNumber.getBusStopNumbers());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView busNumber, busSource, busDestination, busArea, busStopNumber;

        public RecyclerViewHolder(View view) {
            super(view);
            busNumber = (TextView) view.findViewById(R.id.bus_number);
            busSource = (TextView) view.findViewById(R.id.bus_source);
            busDestination = (TextView) view.findViewById(R.id.bus_destination);
            busArea = (TextView) view.findViewById(R.id.bus_area);
            busStopNumber = (TextView) view.findViewById(R.id.bus_stop_number);
        }
    }
}