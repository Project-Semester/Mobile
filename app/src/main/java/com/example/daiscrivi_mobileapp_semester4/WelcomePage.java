package com.example.daiscrivi_mobileapp_semester4;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class WelcomePage extends AppCompatActivity {
    Button btn_login, btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        btn_login = findViewById(R.id.btnLogin);
        btn_login.setOnClickListener(v -> {
            Intent intent = new Intent(WelcomePage.this, login.class);
            startActivity(intent);
        });

        btn_register = findViewById(R.id.btnRegister);
        btn_register.setOnClickListener(v -> Toast.makeText(WelcomePage.this, "Email atau Password salah", Toast.LENGTH_SHORT).show());


    }
}