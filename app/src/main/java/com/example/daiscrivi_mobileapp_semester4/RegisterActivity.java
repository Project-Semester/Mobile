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

public class RegisterActivity extends AppCompatActivity {
    Button btn_register;
    EditText et_email, et_password, et_confirmPassword;
    ProgressBar loading;
    private static String URL_REGISTER = "http:// 192.168.100.30/api/register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);

        btn_register = findViewById(R.id.btnRegister);
        et_email = findViewById((R.id.etEmail));
        et_password = findViewById(R.id.etPassword);
        loading = findViewById(R.id.pb_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et_email.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                String cPassword = et_confirmPassword.getText().toString().trim();
                if (!email.equals("") && !password.equals("") && !cPassword.equals("")) {
                    if (password.equals(cPassword)) {
                        Register();
                    } else {
                        et_confirmPassword.setError("Konfirmasi gagal");
                    }
                } else {
                    et_email.setError("Masukkan Email !");
                    et_password.setError("Masukkan Password !");
                    et_confirmPassword.setError("Masukkan Confirm Password !");
                }

            }

            private void Register() {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGISTER,
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
                                        SharedPreferences sharedPreferences = RegisterActivity.this.getSharedPreferences("yuknulis", MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putString(getString(R.string.username), username);
                                        editor.putString(getString(R.string.email), email);
                                        editor.putString(getString(R.string.role), role);
                                        editor.commit();

                                        Toast.makeText(RegisterActivity.this, "Login Sukses!", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                        startActivity(intent);

                                    } else {
                                        Toast.makeText(RegisterActivity.this, "Login Gagal!" + message, Toast.LENGTH_SHORT).show();

                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Toast.makeText(RegisterActivity.this, "Login Error!" + e, Toast.LENGTH_SHORT).show();

                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(RegisterActivity.this, "error" + error.toString(), Toast.LENGTH_SHORT).show();

                            }
                        }

                ) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);
                requestQueue.add(stringRequest);

            }
        });

    }
}