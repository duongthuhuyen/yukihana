package com.example.beanikaa.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import com.example.beanikaa.MainActivity;
import com.example.beanikaa.Model.HomeHorModel;
import com.example.beanikaa.Model.HomeItemModel;
import com.example.beanikaa.Model.HomeSlideModel;
import com.example.beanikaa.R;
import com.example.beanikaa.data.Pojo.FoodNews;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {
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
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horitorier, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHorAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        List<FoodNews> foodNewsList = new ArrayList<>();

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.textView.setText(list.get(position).getText());
      /*  RequestQueue requestQueue = Volley.newRequestQueue(activity);
        String url = "http://192.168.0.100/androidapi/product/product";

        // RequestQueue requestQueue4 = Volley.newRequestQueue(activity);
        // String url = "http://192.168.0.107/androidapi/product/getProduct/3";
        JsonArrayRequest jsonArrayRequest4 = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    // JSONObject jsonObject = response.getJSONObject(i);
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        int id = jsonObject.getInt("id");

                        String thumbnal = jsonObject.getString("thumbnal");
                        String foodName = jsonObject.getString("foodName");
                        int idRestaurant = jsonObject.getInt("idRestaurant");
                        int vote = jsonObject.getInt("vote");
                        int status = jsonObject.getInt("status");
                        double price = jsonObject.getDouble("price");
                        int sale = jsonObject.getInt("sale");
                        //Date dateFrom = jsonObject.
                        //  Date dateFrom = Timestamp.valueOf(jsonObject.getString("dateFrom"));
                        // Date dateTo = Timestamp.valueOf(jsonObject.getString("dateto"));
                        String category = jsonObject.getString("Category");
                        int idCategory = jsonObject.getInt("idCategory");
                        int priority = jsonObject.getInt("priority");


                        // System.out.println("3:" + thumbnel);
                        foodNewsList.add(new FoodNews(id, thumbnal, foodName, idRestaurant, vote, status, price, sale, category, idCategory, priority));

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
                //.makeText(MainActivity.this, "erro" + error.toString(), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonArrayRequest4);
        // System.out.println(foodNewsList.get(0).getFoodName());
        System.out.println("list food have "+ foodNewsList.size());*/

        if(check)

    {
        ArrayList<HomeItemModel> homeItemModelArrayList = new ArrayList<>();
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
                        homeItemModelArrayList.add(new HomeItemModel(thumbnel, address, star, Double.toString(price)));

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

        // homeItemModelArrayList.add(new HomeItemModel(R.drawable.pizza,"Quang trung, Hà Nội",4.5,"+111"));

        updateVerticalRec.callback(position, homeItemModelArrayList);
        check = false;
    }
        holder.cardView.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
        row_index = position;
        notifyDataSetChanged();

        if (position == 0) {
            ArrayList<HomeItemModel> homeItemModelArrayList = new ArrayList<>();
            RequestQueue requestQueue1 = Volley.newRequestQueue(activity);
            String url = "http://192.168.0.100/androidapi/product/getProduct/0";
            JsonArrayRequest jsonArrayRequest1 = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            String thumbnel = jsonObject.getString("thumbnal");
                            String address = jsonObject.getString("address");
                            double star = jsonObject.getInt("vote");
                            double price = jsonObject.getDouble("price");
                            System.out.println(i + ":" + thumbnel);
                            homeItemModelArrayList.add(new HomeItemModel(thumbnel, address, star, Double.toString(price)));

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
            requestQueue1.add(jsonArrayRequest1);
            updateVerticalRec.callback(position, homeItemModelArrayList);
        } else if (position == 1) {
            ArrayList<HomeItemModel> homeItemModelArrayList = new ArrayList<>();
            RequestQueue requestQueue2 = Volley.newRequestQueue(activity);
            String url = "http://192.168.0.100/androidapi/product/getProduct/1";
            JsonArrayRequest jsonArrayRequest2 = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            String thumbnel = jsonObject.getString("thumbnal");
                            String address = jsonObject.getString("address");
                            double star = jsonObject.getInt("vote");
                            double price = jsonObject.getDouble("price");
                            System.out.println("1:" + thumbnel);
                            homeItemModelArrayList.add(new HomeItemModel(thumbnel, address, star, Double.toString(price)));

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
            requestQueue2.add(jsonArrayRequest2);

            updateVerticalRec.callback(position, homeItemModelArrayList);
        } else if (position == 2) {
            ArrayList<HomeItemModel> homeItemModelArrayList = new ArrayList<>();
            RequestQueue requestQueue3 = Volley.newRequestQueue(activity);
            String url = "http://192.168.0.100/androidapi/product/getProduct/2";
            JsonArrayRequest jsonArrayRequest3 = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            String thumbnel = jsonObject.getString("thumbnal");
                            String address = jsonObject.getString("address");
                            double star = jsonObject.getInt("vote");
                            double price = jsonObject.getDouble("price");
                            System.out.println("2:" + thumbnel);
                            homeItemModelArrayList.add(new HomeItemModel(thumbnel, address, star, Double.toString(price)));

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
            requestQueue3.add(jsonArrayRequest3);

        } else if (position == 3) {
            ArrayList<HomeItemModel> homeItemModelArrayList = new ArrayList<>();
            RequestQueue requestQueue4 = Volley.newRequestQueue(activity);
            String url = "http://192.168.0.100/androidapi/product/getProduct/3";
            JsonArrayRequest jsonArrayRequest4 = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    // JSONObject jsonObject = response.getJSONObject(i);
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            String thumbnel = jsonObject.getString("thumbnal");
                            String address = jsonObject.getString("address");
                            double star = jsonObject.getInt("vote");
                            double price = jsonObject.getDouble("price");
                            System.out.println("3:" + thumbnel);
                            homeItemModelArrayList.add(new HomeItemModel(thumbnel, address, star, Double.toString(price)));

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
            requestQueue4.add(jsonArrayRequest4);

            updateVerticalRec.callback(position, homeItemModelArrayList);
        }
    }
    });
      /*  if(select){
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
        }*/

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
            cardView = itemView.findViewById(R.id.cardviewHor);
        }
    }

}
