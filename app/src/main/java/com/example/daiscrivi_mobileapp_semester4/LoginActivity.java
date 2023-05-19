package com.example.daiscrivi_mobileapp_semester4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    Button btn_login;
    EditText et_email, et_password;
    private static final String URL_LOGIN = "https://www.example.com/login";


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


        btn_login.setOnClickListener(new View.OnClickListener() {


                                         @Override
                                         public void onClick(View v) {
                                             String email = et_email.getText().toString().trim();
                                             String password = et_password.getText().toString().trim();
                                             if (!email.equals("") && !password.equals("")) {
                                                 Login(email, password);
                                             } else {
                                                 et_email.setError("Email tidak boleh kosong");
                                                 et_password.setError("Password tidak boleh kosong");
                                             }


                                         }

            private void Login(final String email, final String password) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    boolean status = jsonObject.getBoolean("status");
                                    String message = jsonObject.getString("message");
                                    JSONObject userData = jsonObject.getJSONObject("data").getJSONObject("user");
                                    String userId = userData.getString("id");
                                    String username = userData.getString("username");
                                    String role = userData.getString("role");
                                    String email = userData.getString("email");
                                    String createdAt = userData.getString("created_at");
                                    String updatedAt = userData.getString("updated_at");

                                    if (status == true && message.equals("A user logged successfully")) {
                                        SharedPreferences sharedPreferences = LoginActivity.this.getSharedPreferences("yuknulis", MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putString(getString(R.string.username), username);
                                        editor.putString(getString(R.string.email), email);
                                        editor.putString(getString(R.string.role), role);
                                        editor.commit();

                                        Toast.makeText(LoginActivity.this, "Login Sukses!", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);

                                    } else {
                                        Toast.makeText(LoginActivity.this, "Login Gagal!" + message, Toast.LENGTH_SHORT).show();

                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Toast.makeText(LoginActivity.this, "Login Error!" + e, Toast.LENGTH_SHORT).show();

                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(LoginActivity.this, "error" + error.toString(), Toast.LENGTH_SHORT).show();

                            }
                        }

                ) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("email", email);
                        params.put("password", password);
                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
                requestQueue.add(stringRequest);

            }
                                     }

        );

    }
}