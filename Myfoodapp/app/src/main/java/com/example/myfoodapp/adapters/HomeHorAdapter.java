package com.example.myfoodapp.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myfoodapp.R;
import com.example.myfoodapp.models.HomeHorModel;
import com.example.myfoodapp.models.HomeVerModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder>{
    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;
    boolean check = true;
    boolean select = true;
    int row_index = -1;

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public HomeHorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item,parent,false));
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull HomeHorAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.textView.setText(list.get(position).getName());
        ArrayList<HomeVerModel> homeVerModelArrayList = new ArrayList<>();
        if(check){
            RequestQueue requestQueue = Volley.newRequestQueue(activity);
            String url = "http://192.168.0.100/androidapi/product/getProduct/0";
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            String thumbnel = jsonObject.getString("thumbnal");
                            String address = jsonObject.getString("address");
                            double star = jsonObject.getInt("vote");
                            double price = jsonObject.getDouble("price");
                            System.out.println(thumbnel);
                            homeVerModelArrayList.add(new HomeVerModel(thumbnel,"Pizza1","10:00-20:00","5.0","$20"));
                         //   homeItemModelArrayList.add(new HomeItemModel(thumbnel, address, star, Double.toString(price)));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    //  Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_LONG).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println("erro " + error.toString());
                    Toast.makeText(activity, "erro" + error.toString(), Toast.LENGTH_LONG).show();
                }
            });
            requestQueue.add(jsonArrayRequest);
          //  ArrayList<HomeVerModel> homeVerModelArrayList = new ArrayList<>();
          /*  homeVerModelArrayList.add(new HomeVerModel(R.drawable.pizza,"Pizza","10:00-20:00","5.0","$20"));
            homeVerModelArrayList.add(new HomeVerModel(R.drawable.pizza,"Pizza1","10:00-20:00","5.0","$20"));
            homeVerModelArrayList.add(new HomeVerModel(R.drawable.pizza,"Pizza2","10:00-20:00","5.0","$20"));
            homeVerModelArrayList.add(new HomeVerModel(R.drawable.pizza,"Pizza3","10:00-20:00","5.0","$20"));
    */        updateVerticalRec.callback(position,homeVerModelArrayList);
            check = false;
        }
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    row_index = position;
                    notifyDataSetChanged();
                    if(position ==0){
                        ArrayList<HomeVerModel> homeVerModelArrayList = new ArrayList<>();

             /*           homeVerModelArrayList.add(new HomeVerModel(R.drawable.pizza,"Pizza","10:00-20:00","5.0","$20"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.pizza,"Pizza1","10:00-20:00","5.0","$20"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.pizza,"Pizza2","10:00-20:00","5.0","$20"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.pizza,"Pizza3","10:00-20:00","5.0","$20"));
*/
                        updateVerticalRec.callback(position,homeVerModelArrayList);
                    }else if(position == 1){
                        ArrayList<HomeVerModel> homeVerModelArrayList = new ArrayList<>();

               /*         homeVerModelArrayList.add(new HomeVerModel(R.drawable.hambager,"Pizza","10:00-20:00","5.0","$20"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.hambager,"Pizza1","10:00-20:00","5.0","$20"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.hambager,"Pizza2","10:00-20:00","5.0","$20"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.hambager,"Pizza3","10:00-20:00","5.0","$20"));
*/
                        updateVerticalRec.callback(position,homeVerModelArrayList);
                    }else if(position == 2){
                        ArrayList<HomeVerModel> homeVerModelArrayList = new ArrayList<>();
/*
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.pho,"Pizza","10:00-20:00","5.0","$20"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.pho,"Pizza1","10:00-20:00","5.0","$20"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.pho,"Pizza2","10:00-20:00","5.0","$20"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.pho,"Pizza3","10:00-20:00","5.0","$20"));
*/
                        updateVerticalRec.callback(position,homeVerModelArrayList);
                    }else if(position == 3){
                        ArrayList<HomeVerModel> homeVerModelArrayList = new ArrayList<>();
/*
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.tempura,"Pizza","10:00-20:00","5.0","$20"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.tempura,"Pizza1","10:00-20:00","5.0","$20"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.tempura,"Pizza2","10:00-20:00","5.0","$20"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.tempura,"Pizza3","10:00-20:00","5.0","$20"));
*/
                        updateVerticalRec.callback(position,homeVerModelArrayList);
                    }
                }
            });
            if(select){
                if(position==0){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                    select = false;
                }
            }else {
                if(row_index == position){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                }else {
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);
                }
            }
        }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.hor_img);
            textView = itemView.findViewById(R.id.hor_txt);
            cardView = itemView.findViewById(R.id.hor_cardview);
        }
    }
}
