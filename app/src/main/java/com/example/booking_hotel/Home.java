package com.example.booking_hotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.booking_hotel.fragment.Account;
import com.example.booking_hotel.fragment.BookingHotel;
import com.example.booking_hotel.fragment.DoiMatKhau;
import com.example.booking_hotel.fragment.ThongTinCaNhan;
import com.example.booking_hotel.fragment.button_2;
import com.example.booking_hotel.fragment.home;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;

    //Drawer menu
    static final float END_SCALE = 0.7f;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menu_icon;
    LinearLayout contentView;

    TextView fullname, username;
    ImageView img_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        //hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menu_icon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);

        fullname = findViewById(R.id.txt_fullnameuser);
        username = findViewById(R.id.txt_usernameuser);
        img_user = findViewById(R.id.img_user);


        fullname.setText("Thuận Trần");
        username.setText("nhut2");

        //
        navigationDrawer();

        home home = new home();

        loadFragment(home);


    }

    private void navigationDrawer() {

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.menu1_home);

        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                home home = new home();

                loadFragment(home);
                Fragment fragment;
                switch (item.getItemId()){
                    case R.id.menu1_home:
                        loadFragment(home);
                        onBackPressed();
                        return true;

                    case R.id.menu1_Search:
                        fragment = new button_2();
                        loadFragment(fragment);
                        onBackPressed();
                        return true;

//                    case R.id.menu_3:
//                        fragment = new button_2();
//                        loadFragment(fragment);
//                        return true;
//
                    case R.id.menu1_Profile:
                        fragment = new ThongTinCaNhan();
                        loadFragment(fragment);
                        onBackPressed();
                        return true;

                    case R.id.menu1_doimk1:
                        fragment = new DoiMatKhau();
                        loadFragment(fragment);
                        onBackPressed();
                        return true;

                    case R.id.menu1_Logout:
                        finish();
                        return true;
                }
                return false;
            }
        });

        animateNavigationDrawer();


        bottomNavigationView = findViewById(R.id.nav_menu);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                home home = new home();
                switch (item.getItemId()){
                    case R.id.menu_home:
                        loadFragment(home);
                        return true;

                    case R.id.menu_timkiem:
                        fragment = new button_2();
                        loadFragment(fragment);
                        return true;

                    case R.id.menu_lichsubooking:
                        fragment = new BookingHotel();
                        loadFragment(fragment);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed(){
        if (drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

    public void animateNavigationDrawer(){
        drawerLayout.setScrimColor(getResources().getColor(R.color.Gold));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                final float xOffSet = drawerView.getWidth() * slideOffset;
                final float xOffSetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffSet - xOffSetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }



    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.continer,fragment);
        fragmentTransaction.commit();
    }


}