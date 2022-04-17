package com.example.beanikaa.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.beanikaa.Adapter.HomeSlideAdapter;
import com.example.beanikaa.Model.HomeSlideModel;
import com.example.beanikaa.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class SlideFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match

    RecyclerView slideMealRec;
    HomeSlideAdapter slideMealAdapter;
    List<HomeSlideModel> slideMealModelList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_slide,container,false);
        slideMealRec = root.findViewById(R.id.home_hor_slide);
        slideMealModelList = new ArrayList<>();
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        String url = "http://192.168.0.107/androidapi/product/getSlide";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0;i<response.length();i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String thumbnel = jsonObject.getString("thumbnal");
                        //Toast.makeText(getContext(), thumbnel, Toast.LENGTH_SHORT).show();
                        System.out.println("slide:"+thumbnel);
                        slideMealModelList.add(new HomeSlideModel(thumbnel));
                       // int id = jsonObject.getInt("id");
                        //Toast.makeText(MainActivity.this,id+" "+name,Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                //  Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("erro "+error.toString());
                Toast.makeText(getContext(),"erro"+error.toString(),Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
       // slideMealModelList.add(new HomeSlideModel("../res/drawable/mi_xao.jpg"));


        slideMealAdapter = new HomeSlideAdapter(slideMealModelList,getContext());
        slideMealRec.setAdapter(slideMealAdapter);
        slideMealRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        slideMealRec.setHasFixedSize(true);
        slideMealRec.setNestedScrollingEnabled(false);

        return root;
    }
}