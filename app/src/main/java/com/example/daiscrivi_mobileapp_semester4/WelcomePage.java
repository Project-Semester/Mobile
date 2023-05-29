package com.example.daiscrivi_mobileapp_semester4;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.daiscrivi_mobileapp_semester4.Login.LoginActivity;
import com.example.daiscrivi_mobileapp_semester4.Register.RegisterActivity;

public class WelcomePage extends AppCompatActivity {
    Button btn_login, btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_welcome_page);
        btn_login = findViewById(R.id.btnLogin);
        btn_login.setOnClickListener(v -> {
            Intent intent = new Intent(WelcomePage.this, LoginActivity.class);
            startActivity(intent);
        });
        btn_register = findViewById(R.id.btnRegister);
        btn_register.setOnClickListener(v -> {
            Intent intent = new Intent(WelcomePage.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
    @Override
    public void onBackPressed(){
        moveTaskToBack(true);
    }
}