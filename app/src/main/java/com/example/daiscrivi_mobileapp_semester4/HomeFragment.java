package com.example.daiscrivi_mobileapp_semester4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    public Context context;
    private View rekomendasiHomePhoto;
    private ArrayList<News> newsArrayList;
    private String[] newsHeading;
    private int[] imageResourceID;
    private RecyclerView recyclerview;
    private TabLayout tabLayout;
    private ViewPager viewPager;


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

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);

        // Create and set up the adapter for the ViewPager
        TabAdapterHome adapter = new TabAdapterHome(getChildFragmentManager());
        viewPager.setAdapter(adapter);

        // Link the TabLayout with the ViewPager
        tabLayout.setupWithViewPager(viewPager);

        return view;

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();
        recyclerview = view.findViewById(R.id.horizontalRv);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerview.setHasFixedSize(true);
        AdapterHome adapter = new AdapterHome(getContext(), newsArrayList);
        recyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void dataInitialize() {

        newsArrayList = new ArrayList<>();

        newsHeading = new String[] {
                getString(R.string.head_1),
                getString(R.string.head_2),
                getString(R.string.head_3),
                getString(R.string.head_4),
                getString(R.string.head_5)
        };

        imageResourceID = new int[] {
                R.drawable.judul_wattpad,
                R.drawable.judul_wattpad2,
                R.drawable.judul_wattpad3,
                R.drawable.judul_wattpad4,
                R.drawable.judul_wattpad5
        };

        for (int i = 0; i < newsHeading.length; i++) {

            News news = new News(newsHeading[i], imageResourceID[i]);
            newsArrayList.add(news);

        }
    }


}


