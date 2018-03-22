package com.example.whip.settings;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        long now = System.currentTimeMillis();
        long last = prefs.getLong ("derniere visite",0);
        long delta = (now-last)/1000;
        Toast.makeText(this,"Derniere visite il y a " + delta + " secondes", Toast.LENGTH_LONG).show();

        //MAJ derniere visite
        SharedPreferences.Editor prefeditor = prefs.edit();
        prefeditor.putLong("derniere visite",now);
        prefeditor.apply();
        prefeditor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.settings){
            getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();

        }
        return super.onOptionsItemSelected(item);
    }
}
