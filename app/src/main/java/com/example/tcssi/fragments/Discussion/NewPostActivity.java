package com.example.tcssi.fragments.Discussion;

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

import com.example.tcssi.fragments.R;
import com.example.tcssi.fragments.SetupActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;

public class NewPostActivity extends AppCompatActivity {

    private EditText newPostHeader;
    private EditText newPostDesc;
    private Button newPostBtn;
    private ProgressBar newPostProgress;

    private StorageReference storageReference;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;

    private String current_user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        storageReference = FirebaseStorage.getInstance().getReference();
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        current_user_id = firebaseAuth.getCurrentUser().getUid();

        newPostHeader = findViewById(R.id.new_post_header);
        newPostDesc = findViewById(R.id.new_post_desc);
        newPostBtn = findViewById(R.id.post_btn);
        newPostProgress = findViewById(R.id.new_post_progress);

        newPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String header = newPostHeader.getText().toString();
                String desc = newPostDesc.getText().toString();

                if(!TextUtils.isEmpty(header) && !TextUtils.isEmpty(desc)){

                    newPostProgress.setVisibility(View.VISIBLE);
                    String randomName = FieldValue.serverTimestamp().toString();

                    Map<String, Object> postMap = new HashMap<>();
                    postMap.put("header", header);
                    postMap.put("desc", desc);
                    postMap.put("user_id", current_user_id);
                    postMap.put("timestamp", FieldValue.serverTimestamp());

                    firebaseFirestore.collection("Posts").add(postMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {

                            if(task.isSuccessful()){

                                Toast.makeText(NewPostActivity.this, "Post was added", Toast.LENGTH_LONG).show();
                                Intent mainIntent = new Intent(NewPostActivity.this, DiscussionActivity.class);
                                startActivity(mainIntent);
                                finish();

                            }else{

                                String error = task.getException().getMessage();
                                Toast.makeText(NewPostActivity.this, "(TYPE 1 Error) : " + error, Toast.LENGTH_LONG).show();



                            }
                            newPostProgress.setVisibility(View.INVISIBLE);

                        }
                    });


                }else {
                    newPostProgress.setVisibility(View.INVISIBLE);

                    Toast.makeText(NewPostActivity.this, "(TYPE 2 Error) : ", Toast.LENGTH_LONG).show();


                }

            }
        });




    }
}
