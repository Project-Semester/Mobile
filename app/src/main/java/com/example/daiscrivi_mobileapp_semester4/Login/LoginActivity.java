package com.example.daiscrivi_mobileapp_semester4.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.daiscrivi_mobileapp_semester4.MainActivity;
import com.example.daiscrivi_mobileapp_semester4.R;
import com.example.daiscrivi_mobileapp_semester4.retrofit.ApiClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button btn_login;
    EditText et_email, et_password;
    ProgressBar _loading;
    private SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_USERNAME = "username";

//    private static final String URL_LOGIN = "http:// 192.168.100.30/api/login";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        et_password = findViewById(R.id.etPassword);
        et_email = findViewById(R.id.etEmail);
        btn_login = findViewById(R.id.btnLogin);
        _loading = findViewById(R.id.loading);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_login.setVisibility(View.GONE);
                _loading.setVisibility(View.VISIBLE);
                String email = et_email.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                if (!email.equals("") && !password.equals("")) {
                    Login();
                } else {
                    btn_login.setVisibility(View.VISIBLE);
                    _loading.setVisibility(View.GONE);
                    et_email.setError("Email tidak boleh kosong");
                    et_password.setError("Password tidak boleh kosong");
                }
            }
        });


    }

    public void Login() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(et_email.getText().toString());
        loginRequest.setPassword(et_password.getText().toString());
        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Login berhasil", Toast.LENGTH_SHORT).show();
                    _loading.setVisibility(View.GONE);
                    btn_login.setVisibility(View.VISIBLE);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            LoginResponse loginResponse = response.body();
                            String username = loginResponse.getData().getUser().getUsername();
                            String email = loginResponse.getData().getUser().getEmail();
                            String role = loginResponse.getData().getUser().getRole();
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString(KEY_USERNAME, username);
                            editor.putString(KEY_EMAIL, email);
                            editor.apply();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class)
                            );
                        }
                    }, 000);

                } else {
                    _loading.setVisibility(View.GONE);
                    btn_login.setVisibility(View.VISIBLE);
                    Toast.makeText(LoginActivity.this, "Login gagal periksa kembali Email dan Password kamu", Toast.LENGTH_SHORT).show();
                    try {
                        System.out.println(response.errorBody().string());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                _loading.setVisibility(View.GONE);
                btn_login.setVisibility(View.VISIBLE);
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                System.out.println(t.getLocalizedMessage());
            }
        });
    }
}