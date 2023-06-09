package com.erendev.keys;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPageAdapter extends FragmentStateAdapter {
    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0: return new Home();
            case 1: return new Account();
            case 2: return new Search();
            case 3: return new Settings();
            default: return new Home();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
