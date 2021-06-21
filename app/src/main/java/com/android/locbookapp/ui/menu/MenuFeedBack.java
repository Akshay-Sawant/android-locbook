package com.android.locbookapp.ui.menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.locbookapp.R;

public class MenuFeedBack extends AppCompatActivity {

    EditText reciep, sub, msg;
    String rec, subject, textMessage;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);

        setSupportActionBar(toolbar);
        setTitle("FeedBack");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        reciep = (EditText) findViewById(R.id.reciep_email_id);
        sub = (EditText) findViewById(R.id.receip_subject);
        msg = (EditText) findViewById(R.id.receip_description);

    }

    private void sendEmail() {

        //Getting content for email
        rec = reciep.getText().toString();
        subject = sub.getText().toString();
        textMessage = msg.getText().toString();

        //Creating SendMail object
        SendMail sm = new SendMail(this, rec, subject, textMessage);

        //Executing sendmail to send email
        sm.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.send_button, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();
        if (item.getItemId() == R.id.mail_send_button) {
            sendEmail();
        }
        return super.onOptionsItemSelected(item);
    }

}