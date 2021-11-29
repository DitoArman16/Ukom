package com.komputerkit.divine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class TamAds extends AppCompatActivity {

    ImageView imgAdetail;
    TextView tv1,tv2,tv3,tv4,tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tam_ads);

        Intent mIntent = getIntent();
        imgAdetail = (ImageView) findViewById(R.id.imgAdetail);
        tv1 = (TextView) findViewById(R.id.tvAjudul);
        tv2 = (TextView) findViewById(R.id.tvAharga);
        tv3 = (TextView) findViewById(R.id.tvAalamat);
        tv4 = (TextView) findViewById(R.id.tvAkondisi);
        tv5 = (TextView) findViewById(R.id.tvAdetail);

        tv1.setText(mIntent.getStringExtra("Judul"));
        tv2.setText(Integer.toString(mIntent.getIntExtra("Hargai", 0)));
        tv3.setText(mIntent.getStringExtra("Alamat"));
        tv4.setText(mIntent.getStringExtra("Kondisi"));
        tv5.setText(mIntent.getStringExtra("Detail"));

        Glide.with(TamAds.this)
                .load("" + mIntent.getStringExtra("Gambar"))
                .into(imgAdetail);
    }

}