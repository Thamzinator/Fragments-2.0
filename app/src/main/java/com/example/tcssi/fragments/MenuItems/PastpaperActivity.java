package com.example.tcssi.fragments.MenuItems;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.tcssi.fragments.FragmentContacts;
import com.example.tcssi.fragments.FragmentEducational;
import com.example.tcssi.fragments.FragmentInterests;
import com.example.tcssi.fragments.FragmentMerits;
import com.example.tcssi.fragments.FragmentPersonal;
import com.example.tcssi.fragments.ProfileEditActivity;
import com.example.tcssi.fragments.R;
import com.example.tcssi.fragments.ViewPagerAdapter;

public class PastpaperActivity extends AppCompatActivity {

    View view;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewpager;
    private FloatingActionButton editProfileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastpaper);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarid);
        viewpager = (ViewPager) findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.drawable.edu_bg);

        // Adding the fragments
        adapter.AddFragment(new FragmentPersonal(), "Personal");
        adapter.AddFragment(new FragmentContacts(), "Contacts");
        adapter.AddFragment(new FragmentEducational(), "Education");
        adapter.AddFragment(new FragmentInterests(), "Interests");
        adapter.AddFragment(new FragmentMerits(), "Merits");

        // Adapter setup

        viewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewpager);

        editProfileBtn = findViewById(R.id.edit_profile_btn);
        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent profileEdit = new Intent(PastpaperActivity.this, ProfileEditActivity.class);
                startActivity(profileEdit);
                finish();
            }
        });

    }
}
