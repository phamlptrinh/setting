package com.example.seting;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SettingsFragment extends PreferenceFragmentCompat {

    /*SharedPreferences sP;
    String sharedPrefFile = "hisharedpre";*/
    EditTextPreference fav_num;
    ListPreference fav_color;
    Preference fin;

    //Button btFin ;
    final int colorRed = Color.RED;
    final int colorYellow = Color.YELLOW;
    final int colorGreen = Color.GREEN;

    final String [] color = {String.valueOf(Color.RED), String.valueOf(Color.YELLOW), String.valueOf(Color.GREEN)};
    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        fav_num = findPreference("fav_num");
        fav_color = findPreference("fav_color");
        fin = findPreference("fin");

        /*btFin = new Button(getActivity().getApplicationContext());
        btFin = btFin.findViewById(R.id.btFin);
        btFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });*/
        fin.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(@NonNull Preference preference) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
                return true;
            }
        });

        fav_color.setEntries(R.array.color);
        fav_color.setEntryValues(color);

        fav_num.setSummary(fav_num.getText());
        fav_num.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
                String newnum = newValue.toString();
                fav_num.setSummary(newnum);
                return true;
            }
        });

        fav_color.setSummary(fav_color.getEntry());
        final Preference.OnPreferenceChangeListener listener = fav_color.getOnPreferenceChangeListener();
        fav_color.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
                ListPreference lp = (ListPreference) preference;
                int pos = lp.findIndexOfValue(newValue.toString());
                fav_color.setSummary(lp.getEntries()[pos].toString());

                /*fav_color.setSummary(fav_color.getEntry().toString());
                if(listener != null){listener.onPreferenceChange(preference, newValue);
                    fav_color.setSummary(fav_color.getEntry().toString());}*///ko chay
                return true;
            }
        });

    }
}