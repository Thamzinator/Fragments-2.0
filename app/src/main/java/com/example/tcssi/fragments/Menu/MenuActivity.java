package com.example.tcssi.fragments.Menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.tcssi.fragments.MenuItems.ApplicationsActivity;
import com.example.tcssi.fragments.EvaluationsActivity;
import com.example.tcssi.fragments.MenuItems.PastpaperActivity;
import com.example.tcssi.fragments.MenuItems.QuizActivity;
import com.example.tcssi.fragments.Profile;
import com.example.tcssi.fragments.R;
import com.example.tcssi.fragments.MenuItems.RecordActivity;
import com.example.tcssi.fragments.MenuItems.SettingsActivity;
import com.example.tcssi.fragments.MenuItems.SnapActivity;
import com.example.tcssi.fragments.MenuItems.TutorActivity;
import com.example.tcssi.fragments.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MenuActivity";
    private static final int ACTIVITY_NUM = 4;
    private Context mContext = MenuActivity.this;
    private ImageView profileMenu;
    private CardView quizzesCard, tutorCard, pastpaperCard, snapCard, evaluationCard, applicationsCard, academicCard, settingsCard;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Log.d(TAG, "onCreate: Started");

        setupBottomNavigationView();

        //Defining Cards
        quizzesCard = (CardView) findViewById(R.id.card_quiz);
        tutorCard = (CardView) findViewById(R.id.card_tutor);
        pastpaperCard = (CardView) findViewById(R.id.card_pastpapers);
        snapCard = (CardView) findViewById(R.id.card_snap);
        evaluationCard = (CardView) findViewById(R.id.card_eval);
        applicationsCard = (CardView) findViewById(R.id.card_applic);
        academicCard = (CardView) findViewById(R.id.card_record);
        settingsCard = (CardView) findViewById(R.id.card_settings);
        profileMenu = (ImageView) findViewById(R.id.profileMenu);


        //Add click listener to the cards
        quizzesCard.setOnClickListener(this);
        tutorCard.setOnClickListener(this);
        pastpaperCard.setOnClickListener(this);
        snapCard.setOnClickListener(this);
        evaluationCard.setOnClickListener(this);
        applicationsCard.setOnClickListener(this);
        academicCard.setOnClickListener(this);
        settingsCard.setOnClickListener(this);
        profileMenu.setOnClickListener(this);

    }

    /**
     * BottomNavigationView setup
     */

    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    @Override
    public void onClick(View v) {

        Intent i;

        i = new Intent(this, PastpaperActivity.class);
        startActivity(i);

        switch (v.getId()) {
            case R.id.card_quiz:
                i = new Intent(this, QuizActivity.class);
                startActivity(i);
                break;

        }
        switch (v.getId()) {
            case R.id.card_tutor:
                i = new Intent(this, TutorActivity.class);
                startActivity(i);

                break;
        }

        switch (v.getId()) {
            case R.id.card_pastpapers:
                i = new Intent(this, PastpaperActivity.class);
                startActivity(i);
                break;
        }

        switch (v.getId()) {
            case R.id.card_applic:
                i = new Intent(this, ApplicationsActivity.class);
                startActivity(i);
                break;

        }
        switch (v.getId()) {
            case R.id.card_eval:
                i = new Intent(this, EvaluationsActivity.class);
                startActivity(i);
                break;
        }

        switch (v.getId()) {
            case R.id.card_snap:
                i = new Intent(this, SnapActivity.class);
                startActivity(i);
                break;
        }
        switch (v.getId()) {
            case R.id.card_applic:
                i = new Intent(this, ApplicationsActivity.class);
                startActivity(i);
                break;
        }
        switch (v.getId()) {
            case R.id.card_record:
                i = new Intent(this, RecordActivity.class);
                startActivity(i);
                break;
        }
        switch (v.getId()) {
            case R.id.card_settings:
                i = new Intent(this, SettingsActivity.class);
                startActivity(i);
                break;
        }
    }

}

