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

public class BusStopRecyclerAdapter extends RecyclerView.Adapter<BusStopRecyclerAdapter.RecyclerViewHolder> {

    ArrayList<BusStation> arrayList;

    BusStopRecyclerAdapter(ArrayList<BusStation> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bus_station_list, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        BusStation busStation = arrayList.get(position);
        holder.busStopName.setText(busStation.getBusStopName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView busStopName;

        public RecyclerViewHolder(View view) {
            super(view);
            busStopName = (TextView) view.findViewById(R.id.bus_stop_name);
        }
    }
}