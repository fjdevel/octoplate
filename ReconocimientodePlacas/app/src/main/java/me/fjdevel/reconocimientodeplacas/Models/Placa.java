package me.fjdevel.reconocimientodeplacas.Models;

/**
 * Created by darkghost on 27/06/18.
 */

public class Placa {
    private int id;
    private Boolean reporte;
    private String placa;
    private int imagen;

    public Placa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getReporte() {
        return reporte;
    }

    public void setReporte(Boolean reporte) {
        this.reporte = reporte;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
