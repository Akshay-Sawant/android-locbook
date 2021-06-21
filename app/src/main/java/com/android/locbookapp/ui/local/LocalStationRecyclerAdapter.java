package com.android.locbookapp.ui.local;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.locbookapp.R;

import java.util.ArrayList;

/**
 * Created by Rachana on 3/29/2017.
 */

public class LocalStationRecyclerAdapter extends RecyclerView.Adapter<LocalStationRecyclerAdapter.RecyclerViewHolder> {

    ArrayList<LocalList> arrayList;
    private Context context;

    LocalStationRecyclerAdapter(Context context, ArrayList<LocalList> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.station_item_list, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        LocalList localList = arrayList.get(position);
        holder.localStationName.setText(localList.getLocalStationName());
        holder.localRoute.setText(localList.getLocalRoute());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        TextView localStationName, localRoute;

        public RecyclerViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            localStationName = (TextView) view.findViewById(R.id.station_name);
            localRoute = (TextView) view.findViewById(R.id.station_line);
        }

        @Override
        public void onClick(View v) {

        }
    }

}