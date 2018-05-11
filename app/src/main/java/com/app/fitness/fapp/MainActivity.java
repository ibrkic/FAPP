package com.app.fitness.fapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.fitness.fapp.views.WorkoutLogFragment;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {

    private static final int NUM_PAGES = 5;

    @BindView(R.id.toolbar_date)
    TextView mToolbarDate;
    @BindView(R.id.pager)
    ViewPager mPager;
    @BindView(R.id.toolbar_swipe_left)
    ImageView toolbarSwipeLeft;
    @BindView(R.id.toolbar_swipe_right)
    ImageView toolbarSwipeRight;
    private PagerAdapter mPagerAdapter;
    private Calendar mCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        setListeners();
    }

    private void setListeners() {
        mPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(position == 0) {
                    mToolbarDate.setText("TODAY");
                } else if(position == -1) {
                    mToolbarDate.setText("YESTERDAY");
                } else if (position == 1) {
                    mToolbarDate.setText("TOMORROW");
                } else {
                    mCalendar = Calendar.getInstance();
                    mCalendar.add(Calendar.DATE, position);
                    mToolbarDate.setText(new SimpleDateFormat("EEEE, MMMM dd").format(mCalendar.getTime()));
                }
            }
        });

        toolbarSwipeLeft.setOnClickListener(v ->  mPager.setCurrentItem(mPager.getCurrentItem() - 1));
        toolbarSwipeRight.setOnClickListener(v ->  mPager.setCurrentItem(mPager.getCurrentItem() + 1));
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new WorkoutLogFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
