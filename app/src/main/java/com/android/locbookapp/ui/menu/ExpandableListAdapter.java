package com.android.locbookapp.ui.menu;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.locbookapp.R;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {

            LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }

        TextView txtListChild = (TextView) convertView.findViewById(R.id.list_item);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        ImageView lblHeaderIcon = (ImageView) convertView.findViewById(R.id.list_header_icon);
        TextView lblListHeader = (TextView) convertView.findViewById(R.id.list_header);
        lblListHeader.setTypeface(null, Typeface.NORMAL);
        lblListHeader.setText(headerTitle);

        switch (listDataHeader.indexOf(headerTitle)) {
            case 0:
                lblHeaderIcon.setImageResource(R.drawable.e_list_rail);
                break;
            case 1:
                lblHeaderIcon.setImageResource(R.drawable.e_list_hospitals);
                break;
            case 2:
                lblHeaderIcon.setImageResource(R.drawable.e_list_medical);
                break;
            case 3:
                lblHeaderIcon.setImageResource(R.drawable.e_list_ambulance);
                break;
            case 4:
                lblHeaderIcon.setImageResource(R.drawable.e_list_blood);
                break;
            case 5:
                lblHeaderIcon.setImageResource(R.drawable.e_list_helpline);
                break;
            case 6:
                lblHeaderIcon.setImageResource(R.drawable.e_list_airline);
                break;
            case 7:
                lblHeaderIcon.setImageResource(R.drawable.e_list_fire);
                break;
            case 8:
                lblHeaderIcon.setImageResource(R.drawable.e_list_electricity);
                break;
            case 9:
                lblHeaderIcon.setImageResource(R.drawable.e_list_crane);
                break;
            case 10:
                lblHeaderIcon.setImageResource(R.drawable.e_list_roadway);
                break;
            case 11:
                lblHeaderIcon.setImageResource(R.drawable.e_list_tourist);
                break;
            case 12:
                lblHeaderIcon.setImageResource(R.drawable.e_list_imp);
                break;
        }
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}