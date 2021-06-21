package com.android.locbookapp.util;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.locbookapp.R;
import com.android.locbookapp.ui.signup.Signup;


/**
 * A simple {@link Fragment} subclass.
 */
public class navigation_header extends Fragment {

    public TextView username, h_email;

    public navigation_header() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.navigation_header, container, false);

        username = (TextView) v.findViewById(R.id.user_name);
        h_email = (TextView) v.findViewById(R.id.user_email);

        Signup s = new Signup();
        String name = s.newEmail.getText().toString();
        username.setText(name.substring(0, 6));
        h_email.setText(name);

        return v;
    }
}