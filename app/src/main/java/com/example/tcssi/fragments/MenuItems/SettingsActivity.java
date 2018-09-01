package com.example.tcssi.fragments.MenuItems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tcssi.fragments.R;
import com.example.tcssi.fragments.SetupActivity;
import com.example.tcssi.fragments.WalkthroughActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button toSetup = (Button) findViewById(R.id.accountSettings);
        Button toWalkThrough = (Button) findViewById(R.id.toWalkThrough);

        toWalkThrough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SettingsActivity.this, WalkthroughActivity.class);
                startActivity(intent);
            }
        });

        toSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SettingsActivity.this, SetupActivity.class);
                startActivity(intent);
            }
        });
    }
}
