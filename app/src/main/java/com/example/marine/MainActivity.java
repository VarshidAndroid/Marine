package com.example.marine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ConstraintLayout menu,bar_nomtification;
    ConstraintLayout about,profile,cart,faq,condition,notification,logout;
    DrawerLayout drawer;
    NavigationView navigationView;
    Button sell_boat,service,buy_boat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(MainActivity.this);
        View headerView = navigationView.getHeaderView(0);

        sell_boat=(Button)findViewById(R.id.sell_boat);
        buy_boat=(Button)findViewById(R.id.buy_boat);
        service=(Button)findViewById(R.id.service);

        sell_boat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Sell_boat_Screen.class);
                startActivity(intent);
            }
        });

        buy_boat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Buy_boat.class);
                startActivity(intent);
            }
        });

        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Services_boat.class);
                startActivity(intent);
            }
        });











        menu = (ConstraintLayout) findViewById(R.id.side_menu);
        drawer = findViewById(R.id.drawer_layout);
        bar_nomtification=(ConstraintLayout)findViewById(R.id.notification_icon) ;



        about = (ConstraintLayout)headerView.findViewById(R.id.aboutUs);
        profile = (ConstraintLayout)headerView.findViewById(R.id.edit_profile);
        cart = (ConstraintLayout)headerView.findViewById(R.id.cart);
        faq = (ConstraintLayout)headerView.findViewById(R.id.faq);
        condition = (ConstraintLayout)headerView.findViewById(R.id.condition);
        notification = (ConstraintLayout)headerView.findViewById(R.id.notification);
        logout = (ConstraintLayout)headerView.findViewById(R.id.logout);

        bar_nomtification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Notification_Screen.class);
                startActivity(intent);
            }
        });


        about.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AboutUs_Screen.class);
                startActivity(intent);
                drawer.closeDrawer(Gravity.START);

            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Profile_Screen.class);
                startActivity(intent);
                drawer.closeDrawer(Gravity.START);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Cart_Screen.class);
                startActivity(intent);
                drawer.closeDrawer(Gravity.START);
            }
        });

        faq.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FAQ_Screen.class);
                startActivity(intent);
                drawer.closeDrawer(Gravity.START);
            }
        });

        condition.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Condition_Screen.class);
                startActivity(intent);
                drawer.closeDrawer(Gravity.START);
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Notification_Screen.class);
                startActivity(intent);
                drawer.closeDrawer(Gravity.START);
            }
        });




        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.CustomAlertDialog);
                ViewGroup viewGroup = v.findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.custom_dialog, viewGroup, false);
                Button buttonOk=dialogView.findViewById(R.id.cancle_btn);
                Button buttonyes = dialogView.findViewById(R.id.button_Logout);

                builder.setView(dialogView);
                final AlertDialog alertDialog = builder.create();
                buttonOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                buttonyes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent= new Intent(MainActivity.this,Login_Screen.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
                alertDialog.show();

            }
        });








        drawer = findViewById(R.id.drawer_layout);

        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        menu.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.START);
            }

        });



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}

