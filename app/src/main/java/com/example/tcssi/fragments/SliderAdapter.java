package com.example.tcssi.fragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context= context;
    }

    // Arrays
    public int[] slide_images = {

            R.drawable.bell,
            R.drawable.stationery,
            R.drawable.report,
            R.drawable.stationery,
            R.drawable.truck
    };

    public String[] slide_headings = {

            "Instant Notifications",
            "Stationary",
            "Academic Record",
            "Tertiary & Funding applications",
            "Groceries, Books and Stationary"

    };

    public String[] slide_desc = {

            "Receive immediate notifications as they are posted on your portal. Save them as reminders and never miss a single submission or forget to study for your tests and exams",
            "Receive immediate notifications as they are posted on your portal. Save them as reminders and never miss a single submission or forget to study for your tests and exams",
            "Receive immediate notifications as they are posted on your portal. Save them as reminders and never miss a single submission or forget to study for your tests and exams",
            "Receive immediate notifications as they are posted on your portal. Save them as reminders and never miss a single submission or forget to study for your tests and exams",
            "Receive immediate notifications as they are posted on your portal. Save them as reminders and never miss a single submission or forget to study for your tests and exams"

    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText((slide_desc[position]));

        container.addView(view);

        return view;
    }

    public void  destroyItem(ViewGroup container, int position, Object object){

        container.removeView((RelativeLayout)object);
    }
}
