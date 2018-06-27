package me.fjdevel.reconocimientodeplacas.controllers;

import java.util.List;

import me.fjdevel.reconocimientodeplacas.Models.Placa;
import retrofit2.http.GET;

/**
 * Created by darkghost on 27/06/18.
 */

public interface GlazedAPI {
    @GET("placa")
    Class<List<Placa>> obtenerPlacas();
}
