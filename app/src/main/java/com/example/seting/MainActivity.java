package com.example.seting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String num;
    Button bt;
    TextView tx_num;
    final int colorMag = Color.rgb(225,198,110);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        num = sharedPref.getString("fav_num", "0");

        bt = (Button) findViewById(R.id.bt);
        int color = Integer.parseInt(sharedPref.getString("fav_color", String.valueOf(colorMag)));
        bt.setBackgroundColor(color);
        bt.setText(String.valueOf(color));
        tx_num = (TextView) findViewById(R.id.tx_num);
        tx_num.setText(num);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)//co the ko dung, thi dung phan mac dinh??
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.action_setting){
            Intent intent = new Intent(this, SettingsActivity.class);
            //intent.putExtra("num", num);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}