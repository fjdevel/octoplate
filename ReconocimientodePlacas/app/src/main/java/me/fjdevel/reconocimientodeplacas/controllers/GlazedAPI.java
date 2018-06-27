package me.fjdevel.reconocimientodeplacas.controllers;

import java.util.List;

import me.fjdevel.reconocimientodeplacas.Models.Placa;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by darkghost on 27/06/18.
 */

public interface GlazedAPI {
    @GET("placa/")
    Call<List<Placa>> obtenerPlacas();

    @FormUrlEncoded
    @POST("placa/")
    Call<Void> registrarPlaca(@Field("placa") String placa,@Field("reporte") Boolean reporte);

    @Multipart
    @POST("subirimagen")
    Call<Void> subirimagen(@Part MultipartBody.Part imagen);
}
