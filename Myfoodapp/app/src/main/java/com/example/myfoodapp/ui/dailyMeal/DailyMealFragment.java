package com.example.myfoodapp.ui.dailyMeal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfoodapp.R;
import com.example.myfoodapp.adapters.DailyMealAdapter;
import com.example.myfoodapp.models.DailyMealModel;

import java.util.ArrayList;
import java.util.List;


public class DailyMealFragment extends Fragment {


    RecyclerView dailyMealRec;
    DailyMealAdapter dailyMealAdapter;
    List<DailyMealModel> dailyMealModelList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        //retu
        View root = inflater.inflate(R.layout.daily_meal_fragment,container,false);
        dailyMealRec = root.findViewById(R.id.daily_meal_rec);
        dailyMealModelList = new ArrayList<>();
        dailyMealModelList.add(new DailyMealModel(R.drawable.dinner,"Dinner","Sale 20%","Description","Description"));
        dailyMealModelList.add(new DailyMealModel(R.drawable.breakfast,"Breakfast","Sale 20%","Description","Description"));
        dailyMealModelList.add(new DailyMealModel(R.drawable.lunch,"Lunch","Sale 20%","Description","Description"));
        dailyMealModelList.add(new DailyMealModel(R.drawable.annhe,"Eat Easy","Sale 20%","Description","Description"));

        dailyMealAdapter = new DailyMealAdapter(dailyMealModelList,getContext());
        dailyMealRec.setAdapter(dailyMealAdapter);
        dailyMealRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        dailyMealRec.setHasFixedSize(true);
        dailyMealRec.setNestedScrollingEnabled(false);
        return root;
    }
}