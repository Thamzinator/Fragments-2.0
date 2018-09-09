package com.example.tcssi.fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

public class SingleApplication extends AppCompatActivity {

    FlipperLayout flipper;
    private Button toApplic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_application);

        toApplic = findViewById(R.id.buttonUpload);

        toApplic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toApplic = new Intent(SingleApplication.this, SubmitApplication.class);
                startActivity(toApplic);
            }
        });

        flipper = findViewById(R.id.flipper);
        setLayout();
    }



    private void setLayout(){

        String url[] = new String[]{

            "http://hatfieldstudios.co.za/wp-content/uploads/2017/10/PKB0123-1.jpg",
            "http://hatfieldstudios.co.za/wp-content/uploads/2017/10/PKB2451-1.jpg",
            "http://hatfieldstudios.co.za/wp-content/uploads/2017/10/Room.jpg"
        };

        for(int i=0; i<3; i++){
            FlipperView view = new FlipperView(getBaseContext());
            view.setImageUrl(url[i])
                    .setDescription("Hatfield Studios")
                    .setImageScaleType(ImageView.ScaleType.FIT_XY);
            flipper.addFlipperView(view);
            view.setOnFlipperClickListener(new FlipperView.OnFlipperClickListener() {
                @Override
                public void onFlipperClick(FlipperView flipperView) {

                    Toast.makeText(SingleApplication.this, "Test toast", Toast.LENGTH_LONG).show();

                }
            });

        }

    }
}
