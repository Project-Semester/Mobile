package com.example.daiscrivi_mobileapp_semester4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class login extends AppCompatActivity {
    EditText et_email, et_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_login);
        et_email = findViewById(R.id.etEmail);
        et_password = findViewById(R.id.etPassword);
        btn_login = findViewById(R.id.btnLogin);

        btn_login.setOnClickListener(v -> {
            String email = et_email.getText().toString();
            String password = et_password.getText().toString();
            if (email.equals("fagilnuril18@gmail.com") && password.equals("123")) {
                Intent intent = new Intent(login.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(login.this, "Email atau Password salah", Toast.LENGTH_SHORT).show();
            }
        });

    }
}