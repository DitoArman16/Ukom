package com.komputerkit.divine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.komputerkit.divine.Rest.ApiClient;
import com.komputerkit.divine.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class home extends AppCompatActivity {

    ApiInterface ApiInterface;
    private RecyclerView aRecyclerView;
    private RecyclerView.Adapter aAdapter;
    private RecyclerView.LayoutManager aLayoutManager;
    public static home hm;


//    RecyclerView recyclerView;
//    Adapterhome adapter;
//    List<Kategori> kategoriList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        BottomNavigationView navview = findViewById(R.id.bottom_nav);

        navview.setSelectedItemId(R.id.home);

        navview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , home.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.account:
                        startActivity(new Intent(getApplicationContext()
                                , username.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.upload:
                        startActivity(new Intent(getApplicationContext()
                                , uploadproduk.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.myads:
                        startActivity(new Intent(getApplicationContext()
                                , Myads.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        aRecyclerView = (RecyclerView) findViewById(R.id.rcvHome);
        aLayoutManager = new LinearLayoutManager(this);
        aRecyclerView.setLayoutManager(aLayoutManager);
        ApiInterface = ApiClient.getClient().create(com.komputerkit.divine.Rest.ApiInterface.class);
        hm = this;

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(home.this, 2);
        aRecyclerView.setLayoutManager(layoutManager);
        aRecyclerView.setAdapter(aAdapter);

//        load();
        panggilRetrofit();

    }

    public void panggilRetrofit(){

        Call<GetModelhome> kategoriCall = ApiInterface.GetModelhome();
        kategoriCall.enqueue(new Callback<GetModelhome>() {
            @Override
            public void onResponse(Call<GetModelhome> call, Response<GetModelhome>
                    response) {
                List<Modelhome> modelhomeList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(modelhomeList.size()));
                aAdapter = new Adapterhome(modelhomeList);
                aRecyclerView.setAdapter(aAdapter);
            }

            @Override
            public void onFailure(Call<GetModelhome> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }


//    public void load(){
//        recyclerView = findViewById(R.id.rcvHome);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        RecyclerView.LayoutManager LayoutManager = new GridLayoutManager(home.this, 2);
//        recyclerView.setLayoutManager(LayoutManager);
//        recyclerView.setAdapter(adapter);
//    }

}