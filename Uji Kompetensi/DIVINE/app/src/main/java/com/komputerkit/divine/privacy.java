package com.komputerkit.divine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class privacy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
    }

    public void ivbutt2(View view) {
        Intent intent = new Intent(this, createpass.class);
        startActivity(intent);
    }
}