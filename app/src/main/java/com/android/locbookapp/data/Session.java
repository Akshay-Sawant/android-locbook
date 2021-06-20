package com.android.locbookapp.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Rachana on 3/17/2017.
 */

public class Session {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;

    public Session(Context context) {
        this.context = context;
        pref = context.getSharedPreferences("locBook_database", Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public void setLoggedin(boolean loggedIn) {
        editor.putBoolean("loggedInMode", loggedIn);
        editor.commit();
    }

    public boolean loggedIn() {
        return pref.getBoolean("loggedInMode", false);
    }

}
