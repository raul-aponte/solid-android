package com.fungisoft.solidprinciples.advice;

import android.content.Context;
import android.content.SharedPreferences;

public final class PreferencesUtil {
    public static String getUser(Context context) {
        return getSharedPreferences(context).getString("USER_KEY", "");
    }

    public static String getToken(Context context) {
        return getSharedPreferences(context).getString("TOKEN_KEY", "");
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences("PREFERENCE_KEY", Context.MODE_PRIVATE);
    }


}
