package me.fjdevel.octo.views;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.fjdevel.octo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardPlatesFragment extends Fragment {


    public DashboardPlatesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard_plates, container, false);
    }

}
