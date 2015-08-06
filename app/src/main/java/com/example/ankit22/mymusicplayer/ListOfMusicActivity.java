package com.example.ankit22.mymusicplayer;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Created by ankit on 4/8/15.
 */
public class ListOfMusicActivity extends FragmentActivity {
    private ViewPager viewPager;
    private MusicListFragmentStatePagerAdapter musicFragment;
    private int NO_OF_PAGES=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager);
        viewPager = (ViewPager)findViewById(R.id.activity_view_pager);
        musicFragment = new MusicListFragmentStatePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(musicFragment);
    }
    private class MusicListFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
        public MusicListFragmentStatePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position){
            switch(position)
            {
                case 0:
                    return new FirstFragment();
                case 1:
                    return new SecondFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return NO_OF_PAGES;
        }
    }
}

