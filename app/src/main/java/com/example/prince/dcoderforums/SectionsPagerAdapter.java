package com.example.prince.dcoderforums;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.prince.dcoderforums.fragments.ChatTabFragment;
import com.example.prince.dcoderforums.fragments.CodeTabFragment;
import com.example.prince.dcoderforums.fragments.PlaceholderFragment;
import com.example.prince.dcoderforums.fragments.QnATabFragment;
import com.example.prince.dcoderforums.fragments.ThreadTabFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        switch (position) {

            case 0:
                return ChatTabFragment.newInstance();

            case 1:
                return ThreadTabFragment.newInstance();

            case 2:
                return QnATabFragment.newInstance();

            case 3:
                return CodeTabFragment.newInstance();
        }
        return PlaceholderFragment.newInstance();
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }
}