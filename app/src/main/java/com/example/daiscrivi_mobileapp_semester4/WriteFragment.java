package com.example.daiscrivi_mobileapp_semester4;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class WriteFragment extends Fragment {
TextView tv_username;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_write, container, false);
        tv_username = view.findViewById(R.id.tvUseraname);
        Intent intent = getActivity().getIntent();
        if (intent.getExtras() != null) {
            String username = intent.getStringExtra("username");
            tv_username.setText(username);
        }
        return view;

    }

}