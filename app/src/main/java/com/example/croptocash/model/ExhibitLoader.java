package com.example.croptocash.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.croptocash.R;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ExhibitLoader extends RecyclerView.Adapter<ExhibitLoader.MyViewHolder> {

    private final LayoutInflater inflater;
    private final List<Exhibit> rogerModelArrayList;


    public ExhibitLoader(Context ctx, List<Exhibit> rogerModelArrayList) {

        inflater = LayoutInflater.from(ctx);
        this.rogerModelArrayList = rogerModelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.exhibits_viewholder, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String exTitle = rogerModelArrayList.get(position).getTitle();
        String img1 = rogerModelArrayList.get(position).getImage1();
        String img2 = rogerModelArrayList.get(position).getImage2();
        String img3 = rogerModelArrayList.get(position).getImage3();
        String img4 = rogerModelArrayList.get(position).getImage4();
        String img5 = rogerModelArrayList.get(position).getImage5();
        int lnth = rogerModelArrayList.get(position).getLength();

        holder.image1.setVisibility(View.GONE);
        holder.image2.setVisibility(View.GONE);
        holder.image3.setVisibility(View.GONE);
        holder.image4.setVisibility(View.GONE);
        holder.image5.setVisibility(View.GONE);


        holder.title.setText(exTitle);

        if (lnth == 3) {

            Picasso.get().load(img1).into(holder.image1);
            Picasso.get().load(img2).into(holder.image2);
            Picasso.get().load(img3).into(holder.image3);

            holder.image1.setVisibility(View.VISIBLE);
            holder.image2.setVisibility(View.VISIBLE);
            holder.image3.setVisibility(View.VISIBLE);

        }

        if (lnth == 4) {

            Picasso.get().load(img1).into(holder.image1);
            Picasso.get().load(img2).into(holder.image2);
            Picasso.get().load(img3).into(holder.image3);
            Picasso.get().load(img4).into(holder.image4);

            holder.image1.setVisibility(View.VISIBLE);
            holder.image2.setVisibility(View.VISIBLE);
            holder.image3.setVisibility(View.VISIBLE);
            holder.image4.setVisibility(View.VISIBLE);

        }

        if (lnth == 5) {

            Picasso.get().load(img1).into(holder.image1);
            Picasso.get().load(img2).into(holder.image2);
            Picasso.get().load(img3).into(holder.image3);
            Picasso.get().load(img4).into(holder.image4);
            Picasso.get().load(img5).into(holder.image5);

            holder.image1.setVisibility(View.VISIBLE);
            holder.image2.setVisibility(View.VISIBLE);
            holder.image3.setVisibility(View.VISIBLE);
            holder.image4.setVisibility(View.VISIBLE);
            holder.image5.setVisibility(View.VISIBLE);

        }


//
//        if (!(img2 == "")){
//            Picasso.get().load(img2).into(holder.image2);
//            holder.image2.setVisibility(View.VISIBLE);
//
//        }
//
//        if (!(img3 == "")){
//            Picasso.get().load(img3).into(holder.image3);
//            holder.image3.setVisibility(View.VISIBLE);
//
//        }
//
//        if (!(img4 == "")){
//            Picasso.get().load(img4).into(holder.image4);
//            holder.image4.setVisibility(View.VISIBLE);
//
//        }
//
//        if (!(img5 == null)){
//            Picasso.get().load(img5).into(holder.image5);
//            holder.image4.setVisibility(View.VISIBLE);
//
//
//        }
    }

    @Override
    public int getItemCount() {
        return rogerModelArrayList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView image1, image2, image3, image4, image5;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.exhibit_title);
            image1 = (ImageView) itemView.findViewById(R.id.exhibit_images1);
            image2 = (ImageView) itemView.findViewById(R.id.exhibit_images2);
            image3 = (ImageView) itemView.findViewById(R.id.exhibit_images3);
            image4 = (ImageView) itemView.findViewById(R.id.exhibit_images4);
            image5 = (ImageView) itemView.findViewById(R.id.exhibit_images5);

        }

    }
}