package com.example.daiscrivi_mobileapp_semester4.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.daiscrivi_mobileapp_semester4.Login.LoginActivity;
import com.example.daiscrivi_mobileapp_semester4.R;
import com.example.daiscrivi_mobileapp_semester4.retrofit.ApiClient;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    Button btn_register;
    TextInputEditText et_username,et_email, et_password, et_confirmPassword;
    ProgressBar loading;
//    private static String URL_REGISTER = "http:// 192.168.100.30/api/register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);

        btn_register = findViewById(R.id.btnRegister);
        et_email = findViewById((R.id.etEmail));
        et_username = findViewById(R.id.etUsername);
        et_password = findViewById(R.id.etPassword);
        et_confirmPassword= findViewById(R.id.etConfirmPassword);
        loading = findViewById(R.id.pb_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_register.setVisibility(View.GONE);
                loading.setVisibility(View.VISIBLE);
                String username = et_username.getText().toString().trim();
                String email = et_email.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                String cPassword = et_confirmPassword.getText().toString().trim();
                if ( !username.equals("") && !email.equals("") && !password.equals("") && !cPassword.equals("")) {
                    if (password.equals(cPassword)) {
                        Register(createRequest());
                    } else {
                        loading.setVisibility(View.GONE);
                        btn_register.setVisibility(View.VISIBLE);
                        et_confirmPassword.setError("Konfirmasi gagal");
                    }
                } else {
                    loading.setVisibility(View.GONE);
                    btn_register.setVisibility(View.VISIBLE);
                    et_username.setError("Masukkan Username");
                    et_email.setError("Masukkan Email !");
                    et_password.setError("Masukkan Password !");
                    et_confirmPassword.setError("Masukkan Confirm Password !");
                }

            }

        });
    }

    public RegisterRequest createRequest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername(et_username.getText().toString());
        registerRequest.setEmail(et_email.getText().toString());
        registerRequest.setPassword(et_password.getText().toString());
        registerRequest.setPassword_confirmation(et_confirmPassword.getText().toString());

        return registerRequest;
    }
    public void Register(RegisterRequest registerRequest) {
        Call<RegisterResponse> registerResponseCall = ApiClient.getUserService().userRegister(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response){
                if(response.isSuccessful()){
                    loading.setVisibility(View.GONE);
                    btn_register.setVisibility(View.VISIBLE);
                    Toast.makeText(RegisterActivity.this, "Berhasil Register", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }else {
                    loading.setVisibility(View.GONE);
                    btn_register.setVisibility(View.VISIBLE);
                    Toast.makeText(RegisterActivity.this, "Register Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                loading.setVisibility(View.GONE);
                btn_register.setVisibility(View.VISIBLE);
                Toast.makeText(RegisterActivity.this, "Failed "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}