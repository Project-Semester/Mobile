package com.example.daiscrivi_mobileapp_semester4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;


public class DetailHomeFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_fragment_home);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }
}