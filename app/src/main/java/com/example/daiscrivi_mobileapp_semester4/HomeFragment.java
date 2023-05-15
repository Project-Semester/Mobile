package com.example.daiscrivi_mobileapp_semester4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    public Context context;
    Button Log_out;
    ViewPager2 viewPager2;
    private View rekomendasiHomePhoto;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rekomendasiHomePhoto = view.findViewById(R.id.imageView2);

        rekomendasiHomePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View view) {
                Intent intent = new Intent(context, DetailHomeFragment.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewPager2 = getView().findViewById(R.id.viewPager);

        List<SlideItem> slideItems = new ArrayList<>();
        slideItems.add(new SlideItem(R.drawable.judul_wattpad));
        slideItems.add(new SlideItem(R.drawable.judul_wattpad2));
        slideItems.add(new SlideItem(R.drawable.judul_wattpad3));
        slideItems.add(new SlideItem(R.drawable.judul_wattpad4));        slideItems.add(new SlideItem(R.drawable.judul_wattpad));
        slideItems.add(new SlideItem(R.drawable.judul_wattpad5));
    }
}