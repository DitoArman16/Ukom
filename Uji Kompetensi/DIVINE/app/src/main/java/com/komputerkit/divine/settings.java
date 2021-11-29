package com.komputerkit.divine;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }


    public void ivsett3(View view) {
        Intent intent = new Intent(this, privacy.class);
        startActivity(intent);
    }

    public void ivbutt3(View view) {
        Intent intent = new Intent(this, privacy.class);
        startActivity(intent);
    }


    public void showToast(String pesan){
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
    }

    public void showAlertButton(String pesan){
        AlertDialog.Builder showAlert = new AlertDialog.Builder(this);
        showAlert.setTitle("Announcement!");
        showAlert.setMessage(pesan);

        showAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(settings.this, regristasi2.class);
                startActivity(intent);
                showToast("Logout successful");
            }
        });
        showAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("Logout failed");
            }
        });
        showAlert.show();
    }

    public void tvLogout(View view) {
        showAlertButton("Do you want to Logout?");
    }

    public void tvlogall(View view) {
        showAlertButton("Do you want to Logout from all devices?");
    }
}