package com.android.locbookapp.ui.profile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.locbookapp.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile extends AppCompatActivity {

    private static int RESULT_LOAD_IMAGE = 1;
    final Context context = this;
    private Toolbar toolbar;
    private CircleImageView profileImageButton, profileView;
    private ImageButton edit_user_name;
    private TextView display_user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        profileImageButton = (CircleImageView) findViewById(R.id.profile_select_btn);
        profileView = (CircleImageView) findViewById(R.id.profile_view);
        edit_user_name = (ImageButton) findViewById(R.id.edit_name_button);
        display_user_name = (TextView) findViewById(R.id.p_user_name);

        // profile image set button
        profileImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RESULT_LOAD_IMAGE);
            }
        });

        setSupportActionBar(toolbar);
        setTitle("Profile");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        //edit user name
        edit_user_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater li = LayoutInflater.from(context);
                View promptView = li.inflate(R.layout.prompt_editext, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context, R.style.MyDialogTheme);

                // set prompt to alert dialog box
                alertDialogBuilder.setView(promptView);
                final EditText userInput = (EditText) promptView.findViewById(R.id.user_input);

                //set dialog message
                alertDialogBuilder.setCancelable(false).setPositiveButton(" Save ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // get user input and set it to display_user_name
                        // edit text
                        display_user_name.setText(userInput.getText().toString());
                    }
                }).setNegativeButton(" Discard ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    profileView.setImageURI(selectedImage);
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