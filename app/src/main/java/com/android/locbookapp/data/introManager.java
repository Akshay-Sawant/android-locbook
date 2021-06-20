package com.android.locbookapp.data;

import android.content.Context;
import android.content.SharedPreferences;

public class introManager {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    public introManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("first", 0);
        editor = sharedPreferences.edit();
    }

    public void setIsFirstTimeUser(boolean isFirst) {
        editor.putBoolean("isFirstTimeUser", isFirst);
        editor.commit();
    }

    public boolean isFirstTimeUser() {
        return sharedPreferences.getBoolean("isFirstTimeUser", true);
    }
}
