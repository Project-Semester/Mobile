package com.example.daiscrivi_mobileapp_semester4;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdapterHome extends FragmentPagerAdapter {

    public TabAdapterHome(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // Return the appropriate fragment for each tab
        switch (position) {
            case 0:
                return new FragmentHomeArtis();
            case 1:
                return new FragmentHomeAlbum();
            case 2:
                return new FragmentHomeAksi();
            case 3:
                return new FragmentHomeFiksi();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Return the total number of tabs
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Return the title of each tab
        switch (position) {
            case 0:
                return "Artis";
            case 1:
                return "Album";
            case 2:
                return "Aksi";
            case 3:
                return "Fiksi";
            default:
                return null;
        }
    }
}
