package com.android.locbookapp.ui.western;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.android.locbookapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Western extends Fragment {
    public Western() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_western, container, false);
    }
}