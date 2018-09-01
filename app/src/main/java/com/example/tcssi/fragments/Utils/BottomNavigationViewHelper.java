package com.example.tcssi.fragments.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.example.tcssi.fragments.Calendar.CalendarActivity;
import com.example.tcssi.fragments.Discussion.DiscussionActivity;
import com.example.tcssi.fragments.Main.MainActivity;
import com.example.tcssi.fragments.Menu.MenuActivity;
import com.example.tcssi.fragments.Message.MessageActivity;
import com.example.tcssi.fragments.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d(TAG, "setupBottomNavigationView: Setting up BottomNavigationView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);




    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.ic_notif:
                        Intent intent1 = new Intent(context, MainActivity.class); //ACTIVITY_nUM = A
                        context.startActivity(intent1);
                        break;

                    case R.id.ic_cal:
                        Intent intent2 = new Intent(context, CalendarActivity.class);
                        context.startActivity(intent2);
                        break;

                    case R.id.ic_disc:
                        Intent intent3 = new Intent(context, DiscussionActivity.class);
                        context.startActivity(intent3);
                        break;

                    case R.id.ic_msg:
                        Intent intent4 = new Intent(context, MessageActivity.class);
                        context.startActivity(intent4);
                        break;

                    case R.id.ic_menu:
                        Intent intent5 = new Intent(context, MenuActivity.class);
                        context.startActivity(intent5);
                        break;
                }


                return false;
            }
        });
    }
}
