package com.example.myfoodapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfoodapp.R;
import com.example.myfoodapp.models.DailyMealModel;

import java.util.List;

public class DailyMealAdapter extends RecyclerView.Adapter<DailyMealAdapter.ViewModel> {
    List<DailyMealModel> list;
    Context context;

    public DailyMealAdapter(List<DailyMealModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewModel(LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_meal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewModel holder, int position) {
        holder.image.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.descript.setText(list.get(position).getDescript());
        holder.discount.setText(list.get(position).getDiscount());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewModel extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name,discount,descript;
        public ViewModel(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageview4);
            name = itemView.findViewById(R.id.textview8);
            discount = itemView.findViewById(R.id.textView10);
            descript = itemView.findViewById(R.id.textView9);

        }
    }
}
