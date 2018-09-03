package com.example.tcssi.fragments.MenuItems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.tcssi.fragments.R;
import com.example.tcssi.fragments.SingleApplication;
import com.example.tcssi.fragments.item;

import java.util.ArrayList;
import java.util.List;

public class ApplicationsActivity extends AppCompatActivity {
    private static final String TAG = "ApplicationsActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applications);
        Log.d(TAG, "onCreate: started");

        //Set the status bar backgroundd to transparent

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // setup recyclerview with the adapter

        RecyclerView recyclerView = findViewById(R.id.rv_list);
        List<item> mlist = new ArrayList<>();
        mlist.add(new item(R.drawable.univ, "University", 125));
        mlist.add(new item(R.drawable.colleg, "Colleges", 275));
        mlist.add(new item(R.drawable.accom, "Accommodation", 1222));
        mlist.add(new item(R.drawable.books, "Textbooks", 14550));
        mlist.add(new item(R.drawable.univ, "Student Loans", 103));
        mlist.add(new item(R.drawable.colleg, "Groceries", 625));

        Adapter adapter = new Adapter(this,mlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
