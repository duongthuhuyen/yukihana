package com.example.beanikaa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.beanikaa.Model.HomeItemModel;
import com.example.beanikaa.data.Pojo.FoodNews;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

  //  ImageView clickdemo;
    //public static List<FoodNews> foodNewsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     /*   RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
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
                        foodNewsList.add(new FoodNews(id,thumbnal, foodName, idRestaurant,vote,status,price,sale,category,idCategory,priority));

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
*/
    }
}