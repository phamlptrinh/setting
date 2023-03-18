package com.example.seting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Intent intent = getIntent();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment(), null).commit();
//chua chuyen intent vo fragment
    }
}