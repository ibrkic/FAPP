package com.app.fitness.fapp.views;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.app.fitness.fapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrackExerciseActivity extends FragmentActivity {

    @BindView(R.id.exercise_trak_pager)
    ViewPager exerciseTrackPager;
    @BindView(R.id.tabs)
    TabLayout tabs;

    private TrackExercisePagerAdapter trackExercisePagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_exercise);
        ButterKnife.bind(this);

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(TrackExerciseActivity.this, "LALAL", Toast.LENGTH_SHORT).show();
                    exerciseTrackPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        trackExercisePagerAdapter = new TrackExercisePagerAdapter(getSupportFragmentManager());
        exerciseTrackPager.setAdapter(trackExercisePagerAdapter);
        tabs.setupWithViewPager(exerciseTrackPager);
    }

    private class TrackExercisePagerAdapter extends FragmentPagerAdapter {
        public TrackExercisePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;
            switch(i) {
                case 0:
                    fragment = new TrackFragment();
                    break;
                case 1:
                    fragment = new HistoryFragment();
                    break;
                case 2:
                    fragment = new GraphFragment();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "OBJECT " + (position + 1);
        }
    }
}
