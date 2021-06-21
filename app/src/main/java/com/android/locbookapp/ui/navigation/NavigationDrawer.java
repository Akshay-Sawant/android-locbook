package com.android.locbookapp.ui.navigation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.locbookapp.R;
import com.android.locbookapp.ui.booking.BookingActivity;
import com.android.locbookapp.ui.history.HistoryActivity;
import com.android.locbookapp.ui.maps.MapsActivity;
import com.android.locbookapp.ui.menu.MenuEmergency;
import com.android.locbookapp.ui.menu.MenuFaq;
import com.android.locbookapp.ui.menu.MenuFeedBack;
import com.android.locbookapp.ui.menu.MenuSettings;
import com.android.locbookapp.ui.notification.Notification;
import com.android.locbookapp.ui.pinlock.PinLockActivity;
import com.android.locbookapp.ui.profile.Profile;
import com.android.locbookapp.ui.registration.RegistrationActivity;
import com.android.locbookapp.ui.signin.ProjectIntroduction;
import com.android.locbookapp.ui.termsandconditions.TermsAndCondition;
import com.android.locbookapp.ui.ticket.ShowTicketActivity;
import com.android.locbookapp.ui.timetable.TimeTableActivity;
import com.android.locbookapp.ui.web.WebViewActivity;
import com.google.android.material.navigation.NavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

public class NavigationDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    final Context context = this;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    CircleImageView timetable, map, showTicket, booking, history, wallet;
    CardView designing, technicalNews, yourStory, digitalIndia, indiaTimes, sports, naukri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        // LocBook menu declaration
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        timetable = (CircleImageView) findViewById(R.id.timetable_menu);
        map = (CircleImageView) findViewById(R.id.map_menu);
        showTicket = (CircleImageView) findViewById(R.id.showticket_menu);
        booking = (CircleImageView) findViewById(R.id.book_menu);
        history = (CircleImageView) findViewById(R.id.history_menu);
        wallet = (CircleImageView) findViewById(R.id.wallet_menu);

        // CardView declaration
        designing = (CardView) findViewById(R.id.cardOne);
        technicalNews = (CardView) findViewById(R.id.cardTwo);
        yourStory = (CardView) findViewById(R.id.cardThree);
        digitalIndia = (CardView) findViewById(R.id.cardFour);
        sports = (CardView) findViewById(R.id.cardFive);
        indiaTimes = (CardView) findViewById(R.id.cardSix);
        naukri = (CardView) findViewById(R.id.cardSeven);


        //launching timetable activity
        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NavigationDrawer.this, TimeTableActivity.class));
            }
        });

        //launching transaction activity
        showTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NavigationDrawer.this, ShowTicketActivity.class));
            }
        });

        //launching booking activity
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NavigationDrawer.this, BookingActivity.class));
            }
        });

        //launching map activity
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NavigationDrawer.this, MapsActivity.class));
            }
        });

        //launching history activity
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NavigationDrawer.this, HistoryActivity.class));
            }
        });
        //launching wallet activity
        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NavigationDrawer.this, PinLockActivity.class));
            }
        });

        //launching blog view
        designing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(NavigationDrawer.this, WebViewActivity.class);
                i.putExtra("url", "http://krishnayadav99.blogspot.in/");
                startActivity(i);
            }
        });

        // launching gizmodo view
        technicalNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(NavigationDrawer.this, WebViewActivity.class);
                i.putExtra("url", "http://www.gizmodo.in/");
                startActivity(i);
            }
        });

        // launching yourstory view
        yourStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(NavigationDrawer.this, WebViewActivity.class);
                i.putExtra("url", "https://yourstory.com/");
                startActivity(i);
            }
        });

        // launching sports view
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(NavigationDrawer.this, WebViewActivity.class);
                i.putExtra("url", "http://www.espn.in/");
                startActivity(i);
            }
        });

        // launching digitalIndia view
        digitalIndia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(NavigationDrawer.this, WebViewActivity.class);
                i.putExtra("url", "http://www.digitalindia.gov.in/");
                startActivity(i);
            }
        });

        // launching indiaTimes view
        indiaTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(NavigationDrawer.this, WebViewActivity.class);
                i.putExtra("url", "http://www.indiatimes.com/");
                startActivity(i);
            }
        });

        // launching naukri view
        naukri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(NavigationDrawer.this, WebViewActivity.class);
                i.putExtra("url", "https://www.naukri.com/");
                startActivity(i);
            }
        });

        setSupportActionBar(toolbar);
        setTitle("Home");

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    public void onProfileClick(View v) {
        startActivity(new Intent(NavigationDrawer.this, Profile.class));
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.notification_button, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int btn = item.getItemId();
        switch (btn) {
            case R.id.notification_button:
                startActivity(new Intent(NavigationDrawer.this, Notification.class));
                break;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.settings:
                drawerLayout.closeDrawer(GravityCompat.START);
                startActivity(new Intent(NavigationDrawer.this, MenuSettings.class));
                break;

            case R.id.faq:
                drawerLayout.closeDrawer(GravityCompat.START);
                startActivity(new Intent(NavigationDrawer.this, MenuFaq.class));
                break;

            case R.id.introduction:
                drawerLayout.closeDrawer(GravityCompat.START);
                startActivity(new Intent(NavigationDrawer.this, ProjectIntroduction.class));
                break;

            case R.id.feedback:
                drawerLayout.closeDrawer(GravityCompat.START);
                startActivity(new Intent(NavigationDrawer.this, MenuFeedBack.class));
                break;

            case R.id.emergency:
                drawerLayout.closeDrawer(GravityCompat.START);
                startActivity(new Intent(NavigationDrawer.this, MenuEmergency.class));
                break;

            case R.id.blog:
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent i = new Intent(NavigationDrawer.this, WebViewActivity.class);
                i.putExtra("url", "https://aradhanac32.wixsite.com/locbook");
                startActivity(i);
                break;

            case R.id.tandc:
                drawerLayout.closeDrawer(GravityCompat.START);
                startActivity(new Intent(NavigationDrawer.this, TermsAndCondition.class));
                break;

            case R.id.rate:

                drawerLayout.closeDrawer(GravityCompat.START);
                LayoutInflater li = LayoutInflater.from(context);
                View promptView = li.inflate(R.layout.rating_bar, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context, R.style.RatingDialog);

                // set prompt to alert dialog box
                alertDialogBuilder.setView(promptView);
                final RatingBar ratingBar = (RatingBar) promptView.findViewById(R.id.rating_bar);

                //set dialog message
                alertDialogBuilder.setCancelable(false).setPositiveButton(" Submit ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // get user input and set it to display_user_name
                        // edit text
                        Toast.makeText(NavigationDrawer.this, "Thank You For Loving Our App", Toast.LENGTH_SHORT).show();
                        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                            @Override
                            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                                int ratingNumber = (int) ratingBar.getRating();
                            }
                        });
                    }
                }).setNegativeButton(" Not Now ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
                break;

            case R.id.share:
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "Hi, i am using 'LocBook'. Download the Locbook application get the facility of booking local tickets and" +
                        " Mumbai train local timings and more.";
                String shareSub = "LocBook Support";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share Using"));
                break;

            case R.id.signout:
                drawerLayout.closeDrawer(GravityCompat.START);

                AlertDialog.Builder alertDialogBuilder1 = new AlertDialog.Builder(context, R.style.Theme_AppCompat_Light_Dialog_Alert);

                // set prompt to alert dialog box
                alertDialogBuilder1.setMessage("Do you really want to Sign out?");
                //set dialog message
                alertDialogBuilder1.setCancelable(false).setPositiveButton(" Yes ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(NavigationDrawer.this, RegistrationActivity.class));
                        finish();
                    }
                }).setNegativeButton(" No ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

                // create alert dialog
                AlertDialog alertDialog1 = alertDialogBuilder1.create();

                // show it
                alertDialog1.show();
                break;

        }
        return true;
    }
}