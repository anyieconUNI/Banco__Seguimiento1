package org.example.banco;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistroTransferencia {
    private String IdTransferencia;
    private List<Usuarios> UserDestino = new ArrayList<>();
    private List<Usuarios> UserEmisor = new ArrayList<>();
    private String Categoria ;
    private int Cantidad;
    private Date fechaTransferencia;

    public RegistroTransferencia(){

    }
    public RegistroTransferencia(String IdTransferencia,List<Usuarios> UserDestino,List<Usuarios> UserEmisor, String Categoria,int Cantidad,Date fechaTransferencia){
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

    public List<Usuarios> getUserDestino() {
        return UserDestino;
    }

    public List<Usuarios> getUserEmisor() {
        return UserEmisor;
    }

    public String getCategoria() {
        return Categoria;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public Date getFechaTransferencia() {
        return fechaTransferencia;
    }

    public void setIdTransferencia(String idTransferencia) {
        IdTransferencia = idTransferencia;
    }

    public void setUserDestino(List<Usuarios> userDestino) {
        UserDestino = userDestino;
    }

    public void setUserEmisor(List<Usuarios> userEmisor) {
        UserEmisor = userEmisor;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public void setFechaTransferencia(Date fechaTransferencia) {
        this.fechaTransferencia = fechaTransferencia;
    }
}
