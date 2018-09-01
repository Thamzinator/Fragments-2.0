package com.example.tcssi.fragments;


import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Profile extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarid);
        viewpager = (ViewPager) findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Adding the fragments
        adapter.AddFragment(new FragmentPersonal(), "Personal");
        adapter.AddFragment(new FragmentContacts(), "Contacts");
        adapter.AddFragment(new FragmentEducational(), "Education");
        adapter.AddFragment(new FragmentInterests(), "Interests");
        adapter.AddFragment(new FragmentMerits(), "Merits");

        // Adapter setup

        viewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewpager);

    }
}
