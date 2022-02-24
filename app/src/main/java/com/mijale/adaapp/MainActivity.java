package com.mijale.adaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.mijale.adaapp.Fragments.AlertsFragment;
import com.mijale.adaapp.Fragments.ForumFragment;
import com.mijale.adaapp.Fragments.ProfileFragment;
import com.mijale.adaapp.Fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setOnItemSelectedListener(bottomNavMethod);
        fab = findViewById(R.id.fab);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ForumFragment()).commit();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreatePost.class);
                startActivity(intent);
            }
        });

    }

    private NavigationBarView.OnItemSelectedListener bottomNavMethod =
            new NavigationBarView.OnItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment fragment = null;

                    switch (menuItem.getItemId()) {

                        case R.id.forum:
                            fragment = new ForumFragment();
                            break;
                        case R.id.alert:
                            fragment = new AlertsFragment();
                            break;
                        case R.id.profile:
                            fragment = new ProfileFragment();
                            break;
                        case R.id.settings:
                            fragment = new SettingsFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                    return true;
                }
            };



}