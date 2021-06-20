package com.android.locbookapp.ui.mono;

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

public class MonoRecyclerAdapter extends RecyclerView.Adapter<MonoRecyclerAdapter.RecyclerViewHolder> {

    ArrayList<MonoTimeTable> arrayList;

    public MonoRecyclerAdapter(ArrayList<MonoTimeTable> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mono_timetable_list_item, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        MonoTimeTable monoTimeTable = arrayList.get(position);
        holder.monoTime.setText(monoTimeTable.getMonoTime());
        holder.monoRoute.setText(monoTimeTable.getMonoRoute());
        holder.monoMode.setText(monoTimeTable.getMonoMode());
        holder.monoDestination.setText(monoTimeTable.getMonoDestination());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView monoTime, monoRoute, monoMode, monoDestination;

        public RecyclerViewHolder(View view) {
            super(view);
            monoTime = (TextView) view.findViewById(R.id.mono_time);
            monoRoute = (TextView) view.findViewById(R.id.mono_route);
            monoMode = (TextView) view.findViewById(R.id.mono_mode);
            monoDestination = (TextView) view.findViewById(R.id.mono_destination);
        }
    }
}