package me.fjdevel.reconocimientodeplacas.controllers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;
import me.fjdevel.reconocimientodeplacas.Models.Placa;
import me.fjdevel.reconocimientodeplacas.R;

import static me.fjdevel.reconocimientodeplacas.R.layout.listadodeplacas;

/**
 * Created by darkghost on 27/06/18.
 */

public class AdapterPlacasList extends ArrayAdapter<Placa> {
    public AdapterPlacasList(@NonNull Context context, @NonNull List<Placa> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)  getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView==null){
            convertView = inflater.inflate(listadodeplacas,parent,false);
        }
        Placa placa = getItem(position);
        CheckBox checkBox = convertView.findViewById(R.id.reportelista);
        TextView placalist = convertView.findViewById(R.id.placalist);
        checkBox.setChecked(placa.getReporte());
        placalist.setText(placa.getPlaca());
        return convertView;
    }
}
