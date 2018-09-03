package com.example.tcssi.fragments;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.example.tcssi.fragments.R;

import java.util.HashMap;
import java.util.Map;

public class ProfileEditActivity extends AppCompatActivity {


    private ProgressBar mProgress;
    private EditText mName;
    private EditText mSurname;
    private EditText mAddress;
    private EditText mBirthday;
    private Button mSaveBtn;
    private FirebaseAuth firebaseAuth;

    private String user_id;
    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        mName = findViewById(R.id.input_name);
        mProgress = findViewById(R.id.profile_progress);
        mSurname = findViewById(R.id.input_surname);
        mAddress = findViewById(R.id.input_address);
        mBirthday = findViewById(R.id.input_birthday);
        mSaveBtn = findViewById(R.id.save_changes);
        firebaseAuth = FirebaseAuth.getInstance();

        user_id = firebaseAuth.getCurrentUser().getUid();

        mFirestore = FirebaseFirestore.getInstance();

        mFirestore.collection("profiles").document(user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {

                    if(task.getResult().exists()){

                        String name = task.getResult().getString("name");
                        String surname = task.getResult().getString("surname");
                        String address = task.getResult().getString("address");
                        String birthday = task.getResult().getString("birthday");

                        mName.setText(name);
                        mSurname.setText(surname);
                        mAddress.setText(address);
                        mBirthday.setText(birthday);

                    }

                } else {

                    Toast.makeText(ProfileEditActivity.this, "Firestore retrieval error", Toast.LENGTH_LONG).show();

                }

            }
        });

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = mName.getText().toString().trim();
                String surname = mSurname.getText().toString().trim();
                String address = mAddress.getText().toString().trim();
                String birthday = mBirthday.getText().toString().trim();


                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(surname)) {


                    Map<String, String> userMap = new HashMap<>();
                    userMap.put("name", name);
                    userMap.put("surname", surname);
                    userMap.put("address", address);
                    userMap.put("birthday", birthday);
                    mProgress.setVisibility(View.VISIBLE);
                    mProgress.setEnabled(true);

                    mFirestore.collection("profiles").document(user_id).set(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {

                                Toast.makeText(ProfileEditActivity.this, "Details Updated", Toast.LENGTH_LONG).show();
                                goToProfile();
                            } else {

                                Toast.makeText(ProfileEditActivity.this, "Error saving", Toast.LENGTH_LONG).show();


                            }

                        }
                    });
                }

            }
        });


    }

    private void goToProfile() {

        Intent toProfile = new Intent(ProfileEditActivity.this, SingleApplication.class);
        startActivity(toProfile);
        finish();

    }
}

