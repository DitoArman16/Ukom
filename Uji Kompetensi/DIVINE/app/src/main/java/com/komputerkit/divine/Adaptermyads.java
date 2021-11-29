package com.komputerkit.divine;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adaptermyads extends RecyclerView.Adapter<Adaptermyads.ViewHolder>{

    List<Modelmyads> mModelmyads;
    private Context context;

    public Adaptermyads(List<Modelmyads> modelmyadsList) {
        this.mModelmyads = modelmyadsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_ads,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptermyads.ViewHolder viewHolder, int i) {
//        Modelmyads isi_item_ads = mModelmyads.get(i);
        viewHolder.tvJudul.setText(mModelmyads.get(i).getMenu());
        viewHolder.tvHarga.setText(String.valueOf(mModelmyads.get(i).getHarga()));
        viewHolder.tvAlamat.setText(mModelmyads.get(i).getAlamat());

        Glide.with(viewHolder.itemView.getContext())
                .load("" + mModelmyads.get(i).getGambar())
                .into(viewHolder.imbItem);

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),TamAds.class);
                intent.putExtra("Judul",mModelmyads.get(i).getMenu());
                intent.putExtra("Hargai",mModelmyads.get(i).getHarga());
                intent.putExtra("Alamat",mModelmyads.get(i).getAlamat());
                intent.putExtra("Kondisi",mModelmyads.get(i).getMenu());
                intent.putExtra("Detail",mModelmyads.get(i).getKategori());
                intent.putExtra("Gambar",mModelmyads.get(i).getGambar());

                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mModelmyads.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvJudul, tvHarga, tvAlamat;
        ImageButton imbItem;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imbItem = itemView.findViewById(R.id.imbItem);
            tvJudul = itemView.findViewById(R.id.tvjuduli);
            tvHarga = itemView.findViewById(R.id.tvhargai);
            tvAlamat = itemView.findViewById(R.id.tvalamati);
            cardView = itemView.findViewById(R.id.crdMyads);
        }
    }
}
