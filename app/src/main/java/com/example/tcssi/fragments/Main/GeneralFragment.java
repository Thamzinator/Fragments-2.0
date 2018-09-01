package com.example.tcssi.fragments.Main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.tcssi.fragments.R;

import java.util.ArrayList;

public class GeneralFragment extends Fragment {
    private static final String TAG = "GeneralFragment";

    public GeneralFragment(){
        //Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_general, container, false);
        ListView mListView = (ListView) view.findViewById(R.id.listView);

        // Create the Notification object

        Notification test = new Notification("01", "Revision Camp", "14-16 March Exam preparation camp");
        Notification assignment = new Notification("02", "Golden Key", "Academic excellence merit cerimony");
        Notification quiz = new Notification("02", "Tennis Match", "NWU vs UP final log match");
        Notification homework = new Notification("02", "Reachout And Give (RAG)", "Katlehong childrens home winter fund-rai... ");
        Notification venue = new Notification("03", "Golden Key", "Final date for registration is 21 March");
        Notification test1 = new Notification("03", "SRC Election", "2019 Committee selection will...");
        Notification assignment1 = new Notification("04", "Soccer Tournament", "AmaTuks and NWU battle it out on...");
        Notification quiz1 = new Notification("05", "Academic Development Center", "Psychologist are availible to help with...");
        Notification homework1 = new Notification("08", "Campus clinic", "Free eye testing and prescriptions...");
        Notification venue1 = new Notification("13", "Cafeteria Specials", "The following items are on special today:");
        Notification test2 = new Notification("16", "ABASA society", "Inviting all accounting students to the...");
        Notification assignment2 = new Notification("16", "AUDT 271 assignment", "Audit Review Cycles and...");
        Notification quiz2 = new Notification("21", "FMAN quiz", "Quiz on Study unit 7 and 8.1");
        Notification homework2 = new Notification("24", "MDAC 271 homework", "Activity 4: Cost Framework pg 98 ");
        Notification venue2 = new Notification("31", "TAXC 271 Venue change", "Test venue changed to 12 G03");
        Notification test3 = new Notification("01", "ACCC 271 Test", "Deffered and Income Tax");
        Notification assignment3 = new Notification("02", "AUDT 271 assignment", "Audit Review Cycles and...");
        Notification quiz3 = new Notification("02", "FMAN quiz", "Quiz on Study unit 7 and 8.1");
        Notification homework3 = new Notification("02", "MDAC 271 homework", "Activity 4: Cost Framework pg 98 ");
        Notification venue3 = new Notification("03", "TAXC 271 Venue change", "Test venue changed to 12 G03");
        Notification test4 = new Notification("03", "ACCC 271 Test", "Deffered and Income Tax");
        Notification assignment4 = new Notification("04", "AUDT 271 assignment", "Audit Review Cycles and...");
        Notification quiz4 = new Notification("05", "FMAN quiz", "Quiz on Study unit 7 and 8.1");
        Notification homework4 = new Notification("08", "MDAC 271 homework", "Activity 4: Cost Framework pg 98 ");
        Notification venue4 = new Notification("13", "TAXC 271 Venue change", "Test venue changed to 12 G03");
        Notification test5 = new Notification("16", "ACCC 271 Test", "Deffered and Income Tax");
        Notification assignment5 = new Notification("16", "AUDT 271 assignment", "Audit Review Cycles and...");
        Notification quiz5 = new Notification("21", "FMAN quiz", "Quiz on Study unit 7 and 8.1");
        Notification homework5 = new Notification("24", "MDAC 271 homework", "Activity 4: Cost Framework pg 98 ");
        Notification venue5 = new Notification("31", "TAXC 271 Venue change", "Test venue changed to 12 G03");

        //Add notification objects to ArrayList

        ArrayList<Notification> notificationList = new ArrayList<>();

        notificationList.add(test);
        notificationList.add(assignment);
        notificationList.add(quiz);
        notificationList.add(homework);
        notificationList.add(venue);
        notificationList.add(test1);
        notificationList.add(assignment1);
        notificationList.add(quiz1);
        notificationList.add(homework1);
        notificationList.add(venue1);
        notificationList.add(test2);
        notificationList.add(assignment2);
        notificationList.add(quiz2);
        notificationList.add(homework2);
        notificationList.add(venue2);
        notificationList.add(test3);
        notificationList.add(assignment3);
        notificationList.add(quiz3);
        notificationList.add(homework3);
        notificationList.add(venue3);
        notificationList.add(test4);
        notificationList.add(assignment4);
        notificationList.add(quiz4);
        notificationList.add(homework4);
        notificationList.add(venue4);
        notificationList.add(test5);
        notificationList.add(assignment5);
        notificationList.add(quiz5);
        notificationList.add(homework5);
        notificationList.add(venue5);

        NotificationListAdapter adapter = new NotificationListAdapter(getActivity(), R.layout.adapter_view_layout, notificationList);
        mListView.setAdapter(adapter);


        return view;
    }
}
