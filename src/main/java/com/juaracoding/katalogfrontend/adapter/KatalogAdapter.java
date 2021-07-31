package com.juaracoding.katalogfrontend.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.juaracoding.katalogfrontend.R;
import com.juaracoding.katalogfrontend.entity.Katalog;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class KatalogAdapter extends RecyclerView.Adapter<KatalogAdapter.KatalogViewHolder>{

    private ArrayList<Katalog> dataKlog;
    private Context context;

    public KatalogAdapter(ArrayList<Katalog> dataKlog, Context context) {
        this.dataKlog = dataKlog;
        this.context = context;
    }

    @NonNull
    @Override
    public KatalogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_item_katalog, parent, false);
        return new KatalogAdapter.KatalogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KatalogViewHolder holder, int position) {
        Glide.with(context).load(dataKlog.get(position).getId())
                            .into(holder.viewimage1);
        holder.Txviewproduct.setText(dataKlog.get(position).getNamaproduk());
        holder.Txtviewprice.setText(dataKlog.get(position).getPrice());
        holder.Txtviewdescription.setText(dataKlog.get(position).getDescription());
        holder.Txtviewvariant.setText(dataKlog.get(position).getVariant());
    }

    @Override
    public int getItemCount() {
        return (dataKlog !=null) ? dataKlog.size(): 0;
    }

    public class KatalogViewHolder extends RecyclerView.ViewHolder {
        public ImageView viewimage1;
        public TextView Txviewproduct, Txtviewprice, Txtviewdescription, Txtviewvariant;
        public  KatalogViewHolder(@NonNull View katalogView) {
            super(katalogView);
            viewimage1 = katalogView.findViewById(R.id.image1);
            Txviewproduct = katalogView.findViewById(R.id.product);
            Txtviewprice = katalogView.findViewById(R.id.price);
            Txtviewdescription = katalogView.findViewById(R.id.description);
            Txtviewvariant = katalogView.findViewById(R.id.variant);

        }

    }



}
