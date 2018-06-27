package me.fjdevel.reconocimientodeplacas.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.fjdevel.reconocimientodeplacas.R;
import me.fjdevel.reconocimientodeplacas.controllers.GlazedAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {


    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GlazedAPI glazedAPI = retrofit.create(GlazedAPI.class);



        return view;
    }

}
