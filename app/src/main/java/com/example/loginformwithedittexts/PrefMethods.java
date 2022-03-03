package com.example.loginformwithedittexts;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrefMethods {
    private static SharedPreferences getPref(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void saveString(Context context, String key, String value) {
        getPref(context).edit().putString(key, value).commit();
    }

    public static String getString(Context context, String key, String defValue) {
        return getPref(context).getString(key, defValue);
    }

    public static void removeString(Context context, String key) {
        getPref(context).edit().remove(key).apply();
    }

    public static List<Modelclass> getAllValues(Context context) {
        Map<String, ?> values = getPref(context).getAll();
        List<Modelclass> prefDataList = new ArrayList<>();
        for (Map.Entry<String, ?> entry : values.entrySet()) {
            Modelclass prefData = new Modelclass();
            prefData.key = entry.getKey();
            prefData.value = entry.getValue().toString();
            prefDataList.add(prefData);
        }
        return prefDataList;
    }
}