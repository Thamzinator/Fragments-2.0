package com.example.tcssi.fragments.Calendar;

import android.icu.text.DateFormat;
import android.icu.text.DateFormatSymbols;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tcssi.fragments.R;

import java.util.Calendar;

public class CalendarFragment extends Fragment {

    private static final String TAG = "CalendarFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        return view;
    }


}
