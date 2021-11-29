package com.komputerkit.divine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class username extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);
        getSupportActionBar().hide();

        BottomNavigationView navview = findViewById(R.id.bottom_nav);

        navview.setSelectedItemId(R.id.account);

        navview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                ,home.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.account:
                        startActivity(new Intent(getApplicationContext()
                                ,username.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.upload:
                        startActivity(new Intent(getApplicationContext()
                                ,uploadproduk.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.myads:
                        startActivity(new Intent(getApplicationContext()
                                , Myads.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }

    public void tvsett(View view) {
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);
    }

    public void ivbutt(View view) {
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);
    }

    public void tveditprofile(View view) {
        Intent intent = new Intent(this, editprofile.class);
        startActivity(intent);
    }

    public void ivbuttep(View view) {
        Intent intent = new Intent(this, editprofile.class);
        startActivity(intent);
    }

    public void btnLog22(View view) {
        Intent intent = new Intent(this, regristasi.class);
        startActivity(intent);
    }
}