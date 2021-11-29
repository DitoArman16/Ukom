package com.komputerkit.divine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.komputerkit.divine.Regristasi.ApiClient1;
import com.komputerkit.divine.Regristasi.RegisterRequest;
import com.komputerkit.divine.Regristasi.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class regristasi extends AppCompatActivity {

    EditText etUse, etPas, etWa, etAlmat;
    TextView tvLog;
    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regristasi);
        getSupportActionBar().hide();

        etPas = findViewById(R.id.etPassword1);
        etUse = findViewById(R.id.etUsrname1);
        etWa = findViewById(R.id.etPhone2);
        tvLog = findViewById(R.id.tvlogin);
        etAlmat = findViewById(R.id.etAlamat);
        btnReg = findViewById(R.id.btnregister);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etUse.getText().toString()) || TextUtils.isEmpty(etPas.getText().toString()) || TextUtils.isEmpty(etWa.getText().toString())){
                    String message = "All input required...";
                    Toast.makeText(regristasi.this, message, Toast.LENGTH_LONG).show();
                }else {
                    RegisterRequest registerRequest = new RegisterRequest();
                    registerRequest.setEmail(etUse.getText().toString());
                    registerRequest.setPassword(etPas.getText().toString());
                    registerRequest.setLevel(etWa.getText().toString());
                    registerRequest.setRelasi(etAlmat.getText().toString());
                    registerUser(registerRequest);
                }
            }
        });

    }

    public void registerUser(RegisterRequest registerRequest){

        Call<RegisterResponse> registerResponseCall = ApiClient1.getService().registerusers(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                if (response.isSuccessful()){
                    String message = "Successful...";
                    Toast.makeText(regristasi.this, message, Toast.LENGTH_LONG).show();

                    startActivity(new Intent(regristasi.this, regristasi2.class));
                    finish();
                }else {
                    String message = "An error occuredplese try again later...";
                    Toast.makeText(regristasi.this, message, Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(regristasi.this, message, Toast.LENGTH_LONG).show();
            }
        });

    }

    //Intent//
    public void btnregister(View view) {
        Intent intent = new Intent(this, regristasi2.class);
        startActivity(intent);
    }

    public void tvlogin(View view) {
        Intent intent = new Intent(this, regristasi2.class);
        startActivity(intent);
    }
    //CLose//
}