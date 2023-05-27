package com.example.daiscrivi_mobileapp_semester4;

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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.daiscrivi_mobileapp_semester4.retrofit.ApiClient;
import com.example.daiscrivi_mobileapp_semester4.retrofit.LoginRequest;
import com.example.daiscrivi_mobileapp_semester4.retrofit.LoginResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button btn_login;
    EditText et_email, et_password;
    ProgressBar _loading;
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

//        btn_login.setOnClickListener(new View.OnClickListener() {
//     @Override
//    public void onClick(View v) {
//                                             String email = et_email.getText().toString().trim();
//                                             String password = et_password.getText().toString().trim();
//                                             if (!email.equals("") && !password.equals("") || email.equals("fagil")) {
//                                                 Login(email, password);
//                                             } else {
//                                                 et_email.setError("Email tidak boleh kosong");
//                                                 et_password.setError("Password tidak boleh kosong");
//                                             }
//                                         }
//
//    private void Login(final String email, final String password) {
//                                             StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
//                                                     new Response.Listener<String>() {
//                                                         @Override
//                                                         public void onResponse(String response) {
//                                                             try {
//                                                                 JSONObject jsonObject = new JSONObject(response);
//                                                                 boolean status = jsonObject.getBoolean("status");
//                                                                 String message = jsonObject.getString("message");
//                                                                 JSONObject userData = jsonObject.getJSONObject("data").getJSONObject("user");
//                                                                 String userId = userData.getString("id");
//                                                                 String username = userData.getString("username");
//                                                                 String role = userData.getString("role");
//                                                                 String email = userData.getString("email");
//                                                                 String createdAt = userData.getString("created_at");
//                                                                 String updatedAt = userData.getString("updated_at");
//
//                                                                 if (status == true && message.equals("A user logged successfully")) {
//                                                                     SharedPreferences sharedPreferences = LoginActivity.this.getSharedPreferences("yuknulis", MODE_PRIVATE);
//                                                                     SharedPreferences.Editor editor = sharedPreferences.edit();
//                                                                     editor.putString(getString(R.string.username), username);
//                                                                     editor.putString(getString(R.string.email), email);
//                                                                     editor.putString(getString(R.string.role), role);
//                                                                     editor.commit();
//
//                                                                     Toast.makeText(LoginActivity.this, "Login Sukses!", Toast.LENGTH_SHORT).show();
//                                                                     Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                                                                     startActivity(intent);
//
//                                                                 } else {
//                                                                     Toast.makeText(LoginActivity.this, "Login Gagal!" + message, Toast.LENGTH_SHORT).show();
//
//                                                                 }
//
//                                                             } catch (JSONException e) {
//                                                                 e.printStackTrace();
//                                                                 Toast.makeText(LoginActivity.this, "Login Error!" + e, Toast.LENGTH_SHORT).show();
//
//                                                             }
//                                                         }
//                                                     },
//                                                     new Response.ErrorListener() {
//                                                         @Override
//                                                         public void onErrorResponse(VolleyError error) {
//                                                             Toast.makeText(LoginActivity.this, "error" + error.toString(), Toast.LENGTH_SHORT).show();
//
//                                                         }
//                                                     }
//
//                                             ) {
//                                                 @Override
//                                                 protected Map<String, String> getParams() throws AuthFailureError {
//                                                     Map<String, String> params = new HashMap<>();
//                                                     params.put("email", email);
//                                                     params.put("password", password);
//                                                     return params;
//                                                 }
//                                             };
//                                             RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
//                                             requestQueue.add(stringRequest);
//
//                                         }
//                                     }
//
//        );

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
                    _loading.setVisibility(View.GONE);
                    btn_login.setVisibility(View.VISIBLE);

//                    SharedPreferences sharedPreferences = LoginActivity.this.getSharedPreferences("yuknulis", MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString(getString(R.string.username), username);
//                    editor.putString(getString(R.string.email), email);
//                    editor.putString(getString(R.string.role), role);
//                    editor.commit();
                    Toast.makeText(LoginActivity.this, "Login berhasil", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            LoginResponse loginResponse = response.body();
                            startActivity(new Intent(LoginActivity.this,
                                    MainActivity.class).putExtra("data", loginResponse.getMessage()));
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