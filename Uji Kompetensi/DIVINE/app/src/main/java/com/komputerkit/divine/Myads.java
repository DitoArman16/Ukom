package com.komputerkit.divine;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.komputerkit.divine.Rest.ApiClient;
import com.komputerkit.divine.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Myads extends AppCompatActivity {

    com.komputerkit.divine.Rest.ApiInterface ApiInterface;
    private RecyclerView aRecyclerView;
    private RecyclerView.Adapter aAdapter;
    private RecyclerView.LayoutManager aLayoutManager;
    public static Myads ma;

    RecyclerView recyclerView;
    Adaptermyads adapter;
    List<Modelmyads> item_adsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myads);
        getSupportActionBar().hide();

        BottomNavigationView navview = findViewById(R.id.bottom_nav);

        navview.setSelectedItemId(R.id.myads);

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

        aRecyclerView = (RecyclerView) findViewById(R.id.rcvMyads);
        aLayoutManager = new LinearLayoutManager(this);
        aRecyclerView.setLayoutManager(aLayoutManager);
        ApiInterface = ApiClient.getClient().create(com.komputerkit.divine.Rest.ApiInterface.class);
        ma = this;

//        load();
//        isidata();
        panggilRetrovit1();

    }

    public void panggilRetrovit1(){

        Call<GetModelmyads> modelmyadsCall = ApiInterface.GetModelmyads();
        modelmyadsCall.enqueue(new Callback<GetModelmyads>() {
            @Override
            public void onResponse(Call<GetModelmyads> call, Response<GetModelmyads>
                    response) {
                List<Modelmyads> modelmyadsList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(modelmyadsList.size()));
                aAdapter = new Adaptermyads(modelmyadsList);
                aRecyclerView.setAdapter(aAdapter);
            }

            @Override
            public void onFailure(Call<GetModelmyads> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });

    }

//    public void load(){
//        recyclerView = findViewById(R.id.rcvItemads);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }
//
//    public void isidata(){
//        item_adsList = new ArrayList<Modelmyads>();
//        item_adsList.add(new Modelmyads("Nokia 445", "Rp 400.000", "Jl. Mangga 2"));
//        item_adsList.add(new Modelmyads("Nokia 445", "Rp 400.000", "Jl. Mangga 2"));
//        item_adsList.add(new Modelmyads("Nokia 445", "Rp 400.000", "Jl. Mangga 2"));
//        item_adsList.add(new Modelmyads("Nokia 445", "Rp 400.000", "Jl. Mangga 2"));
//        item_adsList.add(new Modelmyads("Nokia 445", "Rp 400.000", "Jl. Mangga 2"));
//        item_adsList.add(new Modelmyads("Nokia 445", "Rp 400.000", "Jl. Mangga 2"));
//        item_adsList.add(new Modelmyads("Nokia 445", "Rp 400.000", "Jl. Mangga 2"));
//        item_adsList.add(new Modelmyads("Nokia 445", "Rp 400.000", "Jl. Mangga 2"));
//        item_adsList.add(new Modelmyads("Nokia 445", "Rp 400.000", "Jl. Mangga 2"));
//        item_adsList.add(new Modelmyads("Nokia 445", "Rp 400.000", "Jl. Mangga 2"));
//
//        adapter = new Adaptermyads(this, item_adsList);
//        recyclerView.setAdapter(adapter);
//    }

}