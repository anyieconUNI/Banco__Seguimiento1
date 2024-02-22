package org.example.banco;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistroTransferencia {
    private String IdTransferencia;
    private String UserDestino;
    private String UserEmisor;
    private String Categoria ;
    private int Cantidad;
    private LocalDate  fechaTransferencia;

    public RegistroTransferencia(){

    }
    public RegistroTransferencia(String IdTransferencia,String UserDestino,String UserEmisor, String Categoria,int Cantidad,LocalDate  fechaTransferencia){
        this.IdTransferencia=IdTransferencia;
        this.UserDestino= UserDestino;
        this.UserEmisor=UserEmisor;
        this.Categoria=Categoria;
        this.Cantidad=Cantidad;
        this.fechaTransferencia=fechaTransferencia;
    }

    public String getIdTransferencia() {
        return IdTransferencia;
    }

    public String getUserDestino() {
        return UserDestino;
    }

    public String getUserEmisor() {
        return UserEmisor;
    }

    public String getCategoria() {
        return Categoria;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public LocalDate getFechaTransferencia() {
        return fechaTransferencia;
    }

    public void setIdTransferencia(String idTransferencia) {
        IdTransferencia = idTransferencia;
    }

    public void setUserDestino(String userDestino) {
        UserDestino = userDestino;
    }

    public void setUserEmisor(String userEmisor) {
        UserEmisor = userEmisor;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public void setFechaTransferencia(LocalDate  fechaTransferencia) {
        this.fechaTransferencia = fechaTransferencia;
    }
}
