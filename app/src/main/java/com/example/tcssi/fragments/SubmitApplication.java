package com.example.tcssi.fragments;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SubmitApplication extends AppCompatActivity {

    private Button mSelectBtn;

    private final static int FILE_SELECT_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_application);

        mSelectBtn = findViewById(R.id.buttonUpload);

        mSelectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openFileSelector();

            }
        });
    }

    private void openFileSelector() {

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try{

            startActivityForResult(
                    Intent.createChooser(intent, "Select the File to Upload"),
                    FILE_SELECT_CODE);
        }catch (android.content.ActivityNotFoundException ex){
            //Potentially direct user without a dialog
            Toast.makeText(this, "Please install a file manager", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == FILE_SELECT_CODE && resultCode == RESULT_OK){

            Uri fileUri = data.getData();

            Toast.makeText(this, "File selected", Toast.LENGTH_LONG).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
