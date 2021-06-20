package com.android.locbookapp.ui.cab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.locbookapp.R;

import java.util.ArrayList;

/**
 * Created by Rachana on 3/23/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    ArrayList<TaxiFare> arrayList = new ArrayList<>();

    RecyclerAdapter(ArrayList<TaxiFare> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.taxi_fare_item_list, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        TaxiFare taxiFare = arrayList.get(position);
        holder.kilometer.setText(taxiFare.getKilometer());
        holder.dayFare.setText(taxiFare.getDayFare());
        holder.nightFare.setText(taxiFare.getNightFare());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView kilometer, dayFare, nightFare;

        public RecyclerViewHolder(View view) {
            super(view);
            kilometer = (TextView) view.findViewById(R.id.kilo_meter);
            dayFare = (TextView) view.findViewById(R.id.day_fare);
            nightFare = (TextView) view.findViewById(R.id.night_fare);
        }


    }

}
