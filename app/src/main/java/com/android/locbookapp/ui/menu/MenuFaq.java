package com.android.locbookapp.ui.menu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.locbookapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuFaq extends AppCompatActivity {

    faqExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faq);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);

        setSupportActionBar(toolbar);
        setTitle("FAQ");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        expListView = (ExpandableListView) findViewById(R.id.expandable_list);

        // preparing list data
        prepareListData();

        listAdapter = new faqExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return false;
            }

        });

        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if (groupPosition != previousGroup)
                    expListView.collapseGroup(previousGroup);
                previousGroup = groupPosition;
            }
        });

    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        listDataHeader.add("•  How do i use LocBook ?");
        listDataHeader.add("•  How to enter money in wallet ?");
        listDataHeader.add("•  What are the process of booking local tickets ?");
        listDataHeader.add("•  How should i access map ?");
        listDataHeader.add("•  Do i need google account ?");
        listDataHeader.add("•  How to create an account in LocBook ?");
        listDataHeader.add("•  How i will view my tickets to Ticket Checker ?");
        listDataHeader.add("•  What is the validity of my tickets ?");
        listDataHeader.add("•  Could i view my tickets offline ?");
        listDataHeader.add("•  Does it automatically get updated ?");
        listDataHeader.add("•  How to check the version of LocBook ?");

        List<String> intro = new ArrayList<String>();
        intro.add("The working of LocBook is displayed in menu.You can view it for your reference.");

        List<String> wallet = new ArrayList<String>();
        wallet.add("When you enter the wallet of LocBook , you will see certain process you have to follow it.It will automatically catch the amount you enter by using SHA security.");

        List<String> booking = new ArrayList<String>();
        booking.add("You have to first select your source -> Destination.Further you have to select your ticket-type and journey , proceed it.It will display your tickets.");

        List<String> map = new ArrayList<String>();


        List<String> account = new ArrayList<String>();

        List<String> LBaccount = new ArrayList<String>();

        List<String> ticket_checker = new ArrayList<String>();

        List<String> ticket_validity = new ArrayList<String>();

        List<String> offline_tickets = new ArrayList<String>();

        List<String> update = new ArrayList<String>();

        List<String> version = new ArrayList<String>();


        // Header, Child data
        listDataChild.put(listDataHeader.get(0), intro);
        listDataChild.put(listDataHeader.get(1), wallet);
        listDataChild.put(listDataHeader.get(2), booking);
        listDataChild.put(listDataHeader.get(3), map);
        listDataChild.put(listDataHeader.get(4), account);
        listDataChild.put(listDataHeader.get(5), LBaccount);
        listDataChild.put(listDataHeader.get(6), ticket_checker);
        listDataChild.put(listDataHeader.get(7), ticket_validity);
        listDataChild.put(listDataHeader.get(8), offline_tickets);
        listDataChild.put(listDataHeader.get(9), update);
        listDataChild.put(listDataHeader.get(10), version);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
