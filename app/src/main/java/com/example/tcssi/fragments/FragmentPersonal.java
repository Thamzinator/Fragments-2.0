package com.example.tcssi.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcssi.fragments.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class FragmentPersonal extends Fragment {
    View view;
    private TextView textViewName;
    private TextView textViewSurname;
    private TextView textViewAddress;
    private TextView textViewDob;

    private String user_id;
    private FirebaseFirestore mFirestore;
    private FirebaseAuth firebaseAuth;

    public FragmentPersonal() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cv_personal, container, false);
        textViewName = view.findViewById(R.id.textName);
        textViewSurname = view.findViewById(R.id.textViewSurname);
        textViewAddress = view.findViewById(R.id.textAddress);
        textViewDob = view.findViewById(R.id.textDob);
        firebaseAuth = FirebaseAuth.getInstance();
        user_id = firebaseAuth.getCurrentUser().getUid();
        mFirestore = FirebaseFirestore.getInstance();

        mFirestore.collection("profiles").document(user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if(task.isSuccessful()){

                    if(task.getResult().exists()){

                        String name = task.getResult().getString("name");
                        String surname = task.getResult().getString("surname");
                        String address = task.getResult().getString("address");
                        String dob = task.getResult().getString("birthday");

                        textViewName.setText(name);
                        textViewSurname.setText(surname);
                        textViewAddress.setText(address);
                        textViewDob.setText(dob);

                    }

                } else {

                    String error = task.getException().getMessage();
                    Toast.makeText(getActivity(), "(FIRESTORE Retrieve Error) : " + error, Toast.LENGTH_LONG).show();

                }

            }
        });
        return view;





    }



}
