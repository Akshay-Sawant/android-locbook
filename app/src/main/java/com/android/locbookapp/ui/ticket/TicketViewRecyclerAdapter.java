package com.android.locbookapp.ui.ticket;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.locbookapp.R;

import java.util.ArrayList;

/**
 * Created by Rachana on 3/31/2017.
 */

public class TicketViewRecyclerAdapter extends RecyclerView.Adapter<TicketViewRecyclerAdapter.RecyclerViewHolder> {

    ArrayList<TicketAttributes> arrayList;

    TicketViewRecyclerAdapter(ArrayList<TicketAttributes> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ticket_view_list, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        TicketAttributes ticketAttributes = arrayList.get(position);
        holder.ticketFare.setText(ticketAttributes.getTicketFare());
        holder.currentDate.setText(ticketAttributes.getCurrentDate());
        holder.mobileNumber.setText(ticketAttributes.getMobileNumber());
        holder.source.setText(ticketAttributes.getSource());
        holder.destination.setText(ticketAttributes.getDestination());
        holder.adultNumber.setText(ticketAttributes.getAdultNumber());
        holder.childNumber.setText(ticketAttributes.getChildNumber());
        holder.distance.setText(ticketAttributes.getDistance());
        holder.ticketClass.setText(ticketAttributes.getTicketClass());
        holder.bookDateTime.setText(ticketAttributes.getBookDateTime());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView ticketFare, currentDate, mobileNumber, source, destination, adultNumber, childNumber, distance, ticketClass, bookDateTime;

        public RecyclerViewHolder(View view) {
            super(view);
            ticketFare = (TextView) view.findViewById(R.id.ticket_class_display);
            currentDate = (TextView) view.findViewById(R.id.booking_day_date_display);
            mobileNumber = (TextView) view.findViewById(R.id.mobile_number_display);
            source = (TextView) view.findViewById(R.id.source_display);
            destination = (TextView) view.findViewById(R.id.destination_display);
            adultNumber = (TextView) view.findViewById(R.id.adult_number_display);
            childNumber = (TextView) view.findViewById(R.id.child_number_display);
            distance = (TextView) view.findViewById(R.id.distance_display);
            ticketClass = (TextView) view.findViewById(R.id.ticket_class_display);
            bookDateTime = (TextView) view.findViewById(R.id.booking_date_time_display);
        }
    }
}