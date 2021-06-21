package com.android.locbookapp.ui.metro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.locbookapp.R;

import java.util.ArrayList;

/**
 * Created by Rachana on 3/24/2017.
 */

public class MetroRecyclerAdapter extends RecyclerView.Adapter<MetroRecyclerAdapter.RecyclerViewHolder> {

    ArrayList<MetroTimeTable> arrayList;

    public MetroRecyclerAdapter(ArrayList<MetroTimeTable> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.metro_timetable_list_item, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        MetroTimeTable metroTimeTable = arrayList.get(position);
        holder.metroTime.setText(metroTimeTable.getMetroTime());
        holder.metroRoute.setText(metroTimeTable.getMetroRoute());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView metroTime, metroRoute;

        public RecyclerViewHolder(View view) {
            super(view);
            metroTime = (TextView) view.findViewById(R.id.metro_time);
            metroRoute = (TextView) view.findViewById(R.id.metro_route);
        }
    }
}