package com.example.daiscrivi_mobileapp_semester4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    TextView tv_username, tv_email;
    Button btn_logout;
     SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();
        tv_username = findViewById(R.id.tvUsername);
        tv_email = findViewById(R.id.tvEmail);
        btn_logout = findViewById(R.id.btnLogout);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String username = sharedPreferences.getString(KEY_USERNAME, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);
        if (username != null && email != null) {
            tv_username.setText(username);
            tv_email.setText(email);
        }
//        Intent intent = getIntent();
//        if (intent.getExtras() != null) {
//            String username = intent.getStringExtra("username");
//            String email = intent.getStringExtra("email");
//            tv_username.setText(username);
//            tv_email.setText(email);
//        }


        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(ProfileActivity.this, "Anda berhasil Logout", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(ProfileActivity.this, WelcomePage.class));
            }
        });
    }
}