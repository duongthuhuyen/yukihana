package com.example.myfoodapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myfoodapp.R;
import com.example.myfoodapp.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeVerAdapter extends RecyclerView.Adapter<HomeVerAdapter.ViewModel> {
    Context context;
    ArrayList<HomeVerModel> homeVerModelList;

    public HomeVerAdapter(Context context, ArrayList<HomeVerModel> homeVerModelList) {
        this.context = context;
        this.homeVerModelList = homeVerModelList;
    }

    @NonNull
    @Override
    public ViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewModel(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewModel holder, int position) {
        String url = "http://192.168.0.100/androidapi/upload/"+homeVerModelList.get(position).getImage()+".jpg";
        Glide.with(context).load(url).into(holder.imageView);
       // holder.imageView.setImageResource(homeVerModelList.get(position).getImage());
        holder.name.setText(homeVerModelList.get(position).getName());
        holder.price.setText(homeVerModelList.get(position).getPrice());
        holder.rating.setText(homeVerModelList.get(position).getRating());
        holder.timing.setText(homeVerModelList.get(position).getTimig());
    }

    @Override
    public int getItemCount() {
        return homeVerModelList.size();
    }

    public class ViewModel extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,timing,rating,price;
        public ViewModel(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ver_image);
            name = itemView.findViewById(R.id.name);
            timing = itemView.findViewById(R.id.timing);
            rating = itemView.findViewById(R.id.rate);
            price = itemView.findViewById(R.id.ver_price);
        }
    }
}
