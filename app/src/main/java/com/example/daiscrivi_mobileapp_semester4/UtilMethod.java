package com.example.daiscrivi_mobileapp_semester4;

import android.content.Context;
import android.content.SharedPreferences;

public class UtilMethod {


    public static String getToken(Context context){
        SharedPreferences preferences = context.getSharedPreferences("token", Context.MODE_PRIVATE);
        return preferences.getString("token" , "no token");
    }

}
