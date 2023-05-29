package com.example.daiscrivi_mobileapp_semester4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;


public class WriteFragment extends Fragment {
    TextView tv_username;
    CircleImageView profile;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_USERNAME = "username";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_write, container, false);
        tv_username = view.findViewById(R.id.tvUseraname);
        profile = view.findViewById(R.id.profile_image);
        sharedPreferences = getActivity().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String username = sharedPreferences.getString(KEY_USERNAME, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);
        if (username != null) {
            tv_username.setText(username);
        }


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ProfileActivity.class));
            }
        });
//        Intent intent = getActivity().getIntent();
//        if (intent.getExtras() != null) {
//            String username = intent.getStringExtra("username");
//            tv_username.setText(username);
//        }
        return view;

    }

}