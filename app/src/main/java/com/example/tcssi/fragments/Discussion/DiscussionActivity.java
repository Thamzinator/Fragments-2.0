package com.example.tcssi.fragments.Discussion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.tcssi.fragments.LoginActivity;
import com.example.tcssi.fragments.R;
import com.example.tcssi.fragments.SetupActivity;
import com.example.tcssi.fragments.Utils.BottomNavigationViewHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;

public class DiscussionActivity extends AppCompatActivity {


    private static final String TAG = "DiscussionActivity";
    private static final int ACTIVITY_NUM = 2;
    private Context mContext = DiscussionActivity.this;
    private FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;
    private String current_user_id;
    private FloatingActionButton addPostBtn;

    private RecyclerView blog_list_view;
    private List<BlogPost> blog_list;
    private List<User> user_list;
    private BlogRecyclerAdapter blogRecyclerAdapter;

    private DocumentSnapshot lastVisible;
    private Boolean isFirstPageFirstLoad = true;


    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart: started");

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null) {

            Log.d(TAG, "onStart: going to main");

            sendToMain();

        } else {

            current_user_id = mAuth.getCurrentUser().getUid();

            firebaseFirestore.collection("Users").document(current_user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {

                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                    Log.d(TAG, "onComplete: started");

                    if (task.isSuccessful()) {

                        if (!task.getResult().exists()) {

                            Intent setupIntent = new Intent(DiscussionActivity.this, SetupActivity.class);
                            startActivity(setupIntent);
                            finish();

                            Log.d(TAG, "onComplete: going to start");

                        }

                    } else {

                        String errorMessage = task.getException().getMessage();
                        Toast.makeText(DiscussionActivity.this, "Error : " + errorMessage, Toast.LENGTH_LONG).show();

                    }

                }
            });

        }
    }

    private void sendToMain() {
        Intent loginIntent = new Intent(DiscussionActivity.this, LoginActivity.class);
        Log.d(TAG, "sendToMain: sending to main");
        startActivity(loginIntent);
        finish();
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Log.d(TAG, "onCreate: started");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion);
        Log.d(TAG, "onCreate: Started");

        setupBottomNavigationView();

        blog_list = new ArrayList<>();
        user_list = new ArrayList<>();
        blog_list_view = findViewById(R.id.blog_list_view);
        blogRecyclerAdapter = new BlogRecyclerAdapter(blog_list, user_list);
        blog_list_view.setLayoutManager(new LinearLayoutManager(DiscussionActivity.this));
        blog_list_view.setAdapter(blogRecyclerAdapter);

        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        blog_list_view.addOnScrollListener(new RecyclerView.OnScrollListener() {


            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                Log.d(TAG, "onScrolled: started");
                super.onScrolled(recyclerView, dx, dy);

                Boolean reachedBottom = !recyclerView.canScrollVertically(1);

                if(reachedBottom){

                    Toast.makeText(DiscussionActivity.this, "Reached bottom", Toast.LENGTH_LONG ).show();

                    loadMorePost();

                }
            }
        });

        Query firstQuery = firebaseFirestore.collection("Posts").orderBy("timestamp", Query.Direction.DESCENDING).limit(15);
        firstQuery.addSnapshotListener(DiscussionActivity.this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {

                Log.d(TAG, "onEvent: snapshot");

                if(isFirstPageFirstLoad) {
                    lastVisible = documentSnapshots.getDocuments().get(documentSnapshots.size() - 1);
                    blog_list.clear();
                    user_list.clear();
                }

                for (DocumentChange doc: documentSnapshots.getDocumentChanges()){
                    Log.d(TAG, "onEvent: for documentChange");

                    if(doc.getType() == DocumentChange.Type.ADDED){

                        Log.d(TAG, "onEvent: if doc.getType");

                        String blogPostId = doc.getDocument().getId();
                        final BlogPost blogPost = doc.getDocument().toObject(BlogPost.class).withId(blogPostId);

                        String blogUserId = doc.getDocument().getString("user_id");

                        firebaseFirestore.collection("Users").document(blogUserId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                                Log.d(TAG, "onComplete: lets see");

                                if(task.isSuccessful()){

                                    Log.d(TAG, "onComplete: task is successful");

                                    User user = task.getResult().toObject(User.class);

                                    if(isFirstPageFirstLoad) {

                                        Log.d(TAG, "onComplete: isFirstPageFirstLoad");

                                        user_list.add(user);
                                        blog_list.add(blogPost);

                                    }else{

                                        user_list.add(0, user);
                                        blog_list.add(0, blogPost);
                                    }

                                    blogRecyclerAdapter.notifyDataSetChanged();


                                }
                            }
                        });

                    }
                }

                isFirstPageFirstLoad = false;

            }

        });


        addPostBtn = findViewById(R.id.add_post_btn);

        addPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent postIntent = new Intent(DiscussionActivity.this, NewPostActivity.class);
                startActivity(postIntent);
            }
        });


    }

    public void loadMorePost() {

        Log.d(TAG, "loadMorePost: started");

        if (mAuth.getCurrentUser() != null) {

            Log.d(TAG, "loadMorePost: current user is null");

            Query nextQuery = firebaseFirestore.collection("Posts")
                    .orderBy("timestamp", Query.Direction.DESCENDING)
                    .startAfter(lastVisible)
                    .limit(15);

            nextQuery.addSnapshotListener(DiscussionActivity.this, new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                    Log.d(TAG, "onEvent: we're loading more");

                    if (!documentSnapshots.isEmpty()) {

                        Log.d(TAG, "onEvent: document shapshot is not empty");

                        lastVisible = documentSnapshots.getDocuments().get(documentSnapshots.size() - 1);
                        for (DocumentChange doc : documentSnapshots.getDocumentChanges()) {

                            if (doc.getType() == DocumentChange.Type.ADDED) {

                                Log.d(TAG, "onEvent: not sure what this does");

                                String blogPostId = doc.getDocument().getId();
                                final BlogPost blogPost = doc.getDocument().toObject(BlogPost.class).withId(blogPostId);

                                String blogUserId = doc.getDocument().getString("user_id");
                                firebaseFirestore.collection("Users").document(blogUserId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                                        Log.d(TAG, "onComplete: task is  so so successful if were here");

                                        if(task.isSuccessful()){

                                            User user = task.getResult().toObject(User.class);

                                            user_list.add(user);
                                            blog_list.add(blogPost);

                                            blogRecyclerAdapter.notifyDataSetChanged();


                                        }
                                    }
                                });

                            }
                        }

                    }

                }

            });

        }

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
}

