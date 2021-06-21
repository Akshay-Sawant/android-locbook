package com.android.locbookapp.ui.history;

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

public class TransactionRecyclerAdapter extends RecyclerView.Adapter<TransactionRecyclerAdapter.RecyclerViewHolder> {

    ArrayList<TransactionClassAttributes> arrayList;

    TransactionRecyclerAdapter(ArrayList<TransactionClassAttributes> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_list_view_item, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        TransactionClassAttributes transactionClassAttributes = arrayList.get(position);
        holder.randomTransactionId.setText(transactionClassAttributes.getRandomTransactionID());
        holder.transactionDateTime.setText(transactionClassAttributes.getTransactionDateTime());
        holder.ticketFare.setText(transactionClassAttributes.getTicketFare());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView randomTransactionId, transactionDateTime, ticketFare;

        public RecyclerViewHolder(View view) {
            super(view);
            randomTransactionId = (TextView) view.findViewById(R.id.random_transaction_number);
            transactionDateTime = (TextView) view.findViewById(R.id.booking_date);
            ticketFare = (TextView) view.findViewById(R.id.transaction_amount);
        }
    }
}