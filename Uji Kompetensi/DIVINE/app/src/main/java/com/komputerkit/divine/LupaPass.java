package com.komputerkit.divine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.komputerkit.divine.Regristasi.ApiClient1;
import com.komputerkit.divine.Regristasi.LupapassRequest;
import com.komputerkit.divine.Regristasi.LupapassResponse;
import com.komputerkit.divine.Regristasi.RegisterRequest;
import com.komputerkit.divine.Regristasi.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LupaPass extends AppCompatActivity {

    EditText etNew;
    Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_pass);
        getSupportActionBar().hide();

        etNew = findViewById(R.id.etNew);
        btnCreate = findViewById(R.id.btnCreatepass);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etNew.getText().toString())){
                    String message = "All input required...";
                    Toast.makeText(LupaPass.this, message, Toast.LENGTH_LONG).show();
                }else {
                    LupapassRequest lupapassRequest = new LupapassRequest();
                    lupapassRequest.setPassword(etNew.getText().toString());
                    lupapassRequest(lupapassRequest);
                }
            }
        });

    }

    public void lupapassRequest(LupapassRequest lupapassRequest){

        Call<LupapassResponse> lupapassResponseCall = ApiClient1.getService().lupapassuser(lupapassRequest);
        lupapassResponseCall.enqueue(new Callback<LupapassResponse>() {
            @Override
            public void onResponse(Call<LupapassResponse> call, Response<LupapassResponse> response) {

                if (response.isSuccessful()){
                    String message = "Successful...";
                    Toast.makeText(LupaPass.this, message, Toast.LENGTH_LONG).show();

                    startActivity(new Intent(LupaPass.this, regristasi2.class));
                    finish();
                }else {
                    String message = "An error occuredplese try again later...";
                    Toast.makeText(LupaPass.this, message, Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<LupapassResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(LupaPass.this, message, Toast.LENGTH_LONG).show();
            }
        });

    }

    public void showToast(String pesan){
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
    }

    public void btnCreatepass(View view) {
        Intent intent = new Intent(this, regristasi2.class);
        startActivity(intent);
        showToast("Change password success");
    }
}