package com.example.beanikaa.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.PlatformVpnProfile;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.beanikaa.Model.HomeSlideModel;
import com.example.beanikaa.R;

import java.util.List;

import okhttp3.internal.platform.Platform;

public class HomeSlideAdapter extends RecyclerView.Adapter<HomeSlideAdapter.ViewModel>{
    List<HomeSlideModel> list;
    Context context;

    public HomeSlideAdapter(List<HomeSlideModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewModel(LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_horitorier,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewModel holder, int position) {
     //  int ima = context.getResources().getIdentifier(context.getPackageName()+":drawable/" + list.get(position).getImage(), null, context.getPackageName());
      //int ima = context.getResources().getIdentifier(list.get(position).getImage(),"drawable",context.getPackageName());
        //System.out.println("hi:"+ima);
       // holder.image.setImageResource(ima);
        String url ="http://192.168.0.100/androidapi/upload/"+list.get(position).getImage()+".jpg";
        Glide.with(context).load(url).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewModel extends RecyclerView.ViewHolder {
        ImageView image;
       // TextView name,discount,descript;
        public ViewModel(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.hor_slide);


        }
    }
}
