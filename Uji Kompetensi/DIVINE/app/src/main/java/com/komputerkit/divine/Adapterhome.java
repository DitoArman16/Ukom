package com.komputerkit.divine;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapterhome extends RecyclerView.Adapter<Adapterhome.ViewHolder>{

    List<Modelhome> mKategoriList;
    private Context context;

    public Adapterhome(List<Modelhome> modelhomeList) {
        this.mKategoriList = modelhomeList;
    }

    @NonNull
    @Override
    public Adapterhome.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_home, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
    //    Kategori modelhome = KategoriList.get(i);
//        viewHolder.imgProduk.setImageResource(modelhome.getKategori());
        viewHolder.tvJudul.setText(mKategoriList.get(i).getMenu());
        viewHolder.tvAlamat.setText(mKategoriList.get(i).getAlamat());
        viewHolder.tvHarga.setText(String.valueOf(mKategoriList.get(i).getHarga()));
//        viewHolder.tvAlamat.setText(modelhome.getAlamat());

        Glide.with(viewHolder.itemView.getContext())
                .load("" + mKategoriList.get(i).getGambar())
                .into(viewHolder.imgProduk);

        viewHolder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),TamAds.class);
                intent.putExtra("Judul",mKategoriList.get(i).getMenu());
                intent.putExtra("Hargai",mKategoriList.get(i).getHarga());
                intent.putExtra("Alamat",mKategoriList.get(i).getAlamat());
                intent.putExtra("Kondisi",mKategoriList.get(i).getMenu());
                intent.putExtra("Detail",mKategoriList.get(i).getKategori());
                intent.putExtra("Gambar",mKategoriList.get(i).getGambar());

                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mKategoriList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvJudul, tvHarga, tvAlamat;
        ImageView imgProduk;
        CardView cardview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardview = itemView.findViewById(R.id.cvUji);
            tvJudul = itemView.findViewById(R.id.tvJudulh);
            tvHarga = itemView.findViewById(R.id.tvHargah);
            tvAlamat = itemView.findViewById(R.id.tvAlamath);
            imgProduk = itemView.findViewById(R.id.imgProd);

        }
    }
}
