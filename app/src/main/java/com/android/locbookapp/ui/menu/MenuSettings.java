package com.android.locbookapp.ui.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.locbookapp.R;
import com.android.locbookapp.ui.appinfopage.AppInfoPage;
import com.android.locbookapp.ui.profile.Profile;

import java.io.File;

public class MenuSettings extends AppCompatActivity {

    private static MenuSettings instance;
    final Context context = this;
    private Toolbar toolbar;
    private ImageView profile;
    private LinearLayout profileId, manageSpace, clearCache, aboutHelp, appInfo;

    public static MenuSettings getInstance() {
        return instance;
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        instance = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);

        setSupportActionBar(toolbar);
        setTitle("Settings");

        profile = (ImageView) findViewById(R.id.profile_pic);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuSettings.this, Profile.class));
            }
        });

        // Setting menu
        profileId = (LinearLayout) findViewById(R.id.profile_id);
        profileId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuSettings.this, Profile.class));
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        manageSpace = (LinearLayout) findViewById(R.id.manage_space);
        manageSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                i.addCategory(Intent.CATEGORY_DEFAULT);
                i.setData(Uri.parse("package:" + getPackageName()));
                startActivity(i);
            }
        });

        clearCache = (LinearLayout) findViewById(R.id.clear_cache);
        clearCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Light_Dialog_Alert);

                alertDialogBuilder.setMessage("Do you really want to clear Cache Data?");

                alertDialogBuilder.setCancelable(false).setPositiveButton(" Yes ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MenuSettings.getInstance().clearApplicationData();
                        Toast.makeText(getApplicationContext(), "Cache Memory Cleared", Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton(" No ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        aboutHelp = (LinearLayout) findViewById(R.id.about_id);
        aboutHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        appInfo = (LinearLayout) findViewById(R.id.app_info);
        appInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuSettings.this, AppInfoPage.class));
            }
        });

    }

    public void clearApplicationData() {
        File cache = getCacheDir();
        File appDir = new File(cache.getParent());
        if (appDir.exists()) {
            String[] children = appDir.list();
            for (String s : children) {
                if (!s.equals("lib")) {
                    deleteDir(new File(appDir, s));
                    Log.i("TAG", "File /data/data/APP_PACKAGE/" + s + " DELETED ");
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}