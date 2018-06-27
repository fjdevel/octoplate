package me.fjdevel.reconocimientodeplacas.controllers;

import java.util.List;

import me.fjdevel.reconocimientodeplacas.Models.Placa;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by darkghost on 27/06/18.
 */

public interface GlazedAPI {
    @GET("placa/")
    Call<List<Placa>> obtenerPlacas();

    @FormUrlEncoded
    @POST("placa/")
    Call<Void> registrarPlaca(@Field("placa") String placa);
}
