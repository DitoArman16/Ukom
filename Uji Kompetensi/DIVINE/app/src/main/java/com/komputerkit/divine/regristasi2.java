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
import com.komputerkit.divine.Regristasi.LoginRequest;
import com.komputerkit.divine.Regristasi.LoginResponse;
import com.komputerkit.divine.Regristasi.RegisterRequest;
import com.komputerkit.divine.Regristasi.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class regristasi2 extends AppCompatActivity {

    EditText etPhone, etUser, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regristasi2);
        getSupportActionBar().hide();

        etUser = findViewById(R.id.etuser);
        etPassword = findViewById(R.id.etPass);
        etPhone = findViewById(R.id.etPhone2);
        btnLogin = findViewById(R.id.btnlogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etUser.getText().toString()) || TextUtils.isEmpty(etPassword.getText().toString()) || TextUtils.isEmpty(etPhone.getText().toString())) {
                    String message = "All input required...";
                    Toast.makeText(regristasi2.this, message, Toast.LENGTH_LONG).show();
                } else {
                    LoginRequest loginRequest = new LoginRequest();
                    loginRequest.setEmail(etUser.getText().toString());
                    loginRequest.setPassword(etPassword.getText().toString());
                    loginRequest.setLevel(etPhone.getText().toString());
                    loginRequest(loginRequest);
                }
            }
        });
    }

    public void loginRequest(LoginRequest loginRequest){

        Call<LoginResponse> loginResponseCall = ApiClient1.getService().loginuser(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if (response.isSuccessful()){
                    String message = "Successful...";
                    Toast.makeText(regristasi2.this, message, Toast.LENGTH_LONG).show();

                    startActivity(new Intent(regristasi2.this, home.class));
                    finish();
                }else {
                    String message = "An error occuredplese try again later...";
                    Toast.makeText(regristasi2.this, message, Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(regristasi2.this, message, Toast.LENGTH_LONG).show();
            }
        });

    }

    public void btnlogin(View view) {
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }

    public void tvLupapass(View view) {
        Intent intent = new Intent(this, LupaPass.class);
        startActivity(intent);
    }
}