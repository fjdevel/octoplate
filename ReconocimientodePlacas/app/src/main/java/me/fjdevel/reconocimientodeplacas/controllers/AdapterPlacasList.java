package me.fjdevel.reconocimientodeplacas.controllers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

import me.fjdevel.reconocimientodeplacas.Models.Placa;

/**
 * Created by darkghost on 27/06/18.
 */

public class AdapterPlacasList extends ArrayAdapter<Placa> {
    public AdapterPlacasList(@NonNull Context context, @NonNull List<Placa> objects) {
        super(context, 0, objects);
    }
}
