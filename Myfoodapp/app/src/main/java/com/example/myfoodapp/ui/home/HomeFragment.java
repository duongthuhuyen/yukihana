package com.example.myfoodapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfoodapp.R;
import com.example.myfoodapp.adapters.HomeHorAdapter;
import com.example.myfoodapp.adapters.HomeVerAdapter;
import com.example.myfoodapp.adapters.UpdateVerticalRec;
import com.example.myfoodapp.databinding.FragmentHomeBinding;
import com.example.myfoodapp.models.HomeHorModel;
import com.example.myfoodapp.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements UpdateVerticalRec {
    RecyclerView hoRecyclerView,homeVerRecyclerView;
    ArrayList<HomeHorModel> list;
    HomeHorAdapter homeHorAdapter;
    private FragmentHomeBinding binding;

    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        hoRecyclerView = root.findViewById(R.id.home_hor_rec);
        homeVerRecyclerView = root.findViewById(R.id.home_ver_rec);
        list = new ArrayList<>();
        list.add(new HomeHorModel(R.drawable.tempura,"Tempura"));
        list.add(new HomeHorModel(R.drawable.hambager,"Hambuger"));
        list.add(new HomeHorModel(R.drawable.pizza,"Pizza"));
        list.add(new HomeHorModel(R.drawable.pho,"Pho"));
        list.add(new HomeHorModel(R.drawable.pho,"Pho"));
        list.add(new HomeHorModel(R.drawable.pho,"Pho"));
        list.add(new HomeHorModel(R.drawable.pho,"Pho"));
        list.add(new HomeHorModel(R.drawable.pho,"Pho"));
        homeHorAdapter = new HomeHorAdapter(this,getActivity(),list);
        hoRecyclerView.setAdapter(homeHorAdapter);
        hoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        hoRecyclerView.setHasFixedSize(true);
        hoRecyclerView.setNestedScrollingEnabled(false);
        // home vertical
        homeVerModelList = new ArrayList<>();

        homeVerAdapter = new HomeVerAdapter(getActivity(),homeVerModelList);
        homeVerRecyclerView.setAdapter(homeVerAdapter);
        homeVerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
       // homeVerRecyclerView.setHasFixedSize(true);
        //homeVerRecyclerView.setNestedScrollingEnabled(false);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void callback(int position, ArrayList<HomeVerModel> list) {
        homeVerAdapter = new HomeVerAdapter(getContext(),list);
        homeVerAdapter.notifyDataSetChanged();
        homeVerRecyclerView.setAdapter(homeVerAdapter);

    }
}