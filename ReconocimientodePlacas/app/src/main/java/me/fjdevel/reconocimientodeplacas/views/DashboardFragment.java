package me.fjdevel.reconocimientodeplacas.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import me.fjdevel.reconocimientodeplacas.Models.Placa;
import me.fjdevel.reconocimientodeplacas.R;
import me.fjdevel.reconocimientodeplacas.controllers.AdapterPlacasList;
import me.fjdevel.reconocimientodeplacas.controllers.GlazedAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
        final View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final ListView listaplacasregistradas = view.findViewById(R.id.listaplacasrobadas);
        AppCompatButton btnregistrar = view.findViewById(R.id.btnregistar);
        final AppCompatCheckBox reportecheck = view.findViewById(R.id.reportederobo);
        final AppCompatEditText placa =  view.findViewById(R.id.etplaca);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.14:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final GlazedAPI glazedAPI = retrofit.create(GlazedAPI.class);
        Call<List<Placa>> callplacas = glazedAPI.obtenerPlacas();
        callplacas.enqueue(new Callback<List<Placa>>() {
            @Override
            public void onResponse(Call<List<Placa>> call, Response<List<Placa>> response) {
                if (response.isSuccessful()){
                    listaplacasregistradas.setAdapter(new AdapterPlacasList(view.getContext(),response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Placa>> call, Throwable t) {
                Toast.makeText(view.getContext(),"Url:"+call.request().url().toString()+" ha fallado: "+t.toString(),Toast.LENGTH_LONG).show();
            }
        });

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Boolean reporte=Boolean.FALSE;
                if (reportecheck.isChecked()){
                    reporte = Boolean.TRUE;
                }
                Call call = glazedAPI.registrarPlaca(placa.getText().toString(),reporte);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        if (response.isSuccessful()){
                            Toast.makeText(view.getContext(),"Placa registrada",Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Toast.makeText(view.getContext(),"Url:"+call.request().url().toString()+" ha fallado: "+t.toString(),Toast.LENGTH_LONG).show();

                    }
                });
            }
        });

        return view;
    }

}
