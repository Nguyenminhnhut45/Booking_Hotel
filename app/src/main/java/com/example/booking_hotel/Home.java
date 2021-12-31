package com.example.booking_hotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.booking_hotel.fragment.Account;
import com.example.booking_hotel.fragment.button_2;
import com.example.booking_hotel.fragment.home;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        home home = new home();

        loadFragment(home);
        bottomNavigationView = findViewById(R.id.nav_menu);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()){
                    case R.id.menu_home:
                        loadFragment(home);
                        return true;

                    case R.id.menu_2:
                        fragment = new button_2();
                        loadFragment(fragment);
                        return true;

//                    case R.id.menu_3:
//                        fragment = new button_2();
//                        loadFragment(fragment);
//                        return true;
//
                    case R.id.menu_4:
                        fragment = new Account();
                        loadFragment(fragment);
                        return true;
                }
                return false;
            }
        });


    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.continer,fragment);
        fragmentTransaction.commit();
    }
}