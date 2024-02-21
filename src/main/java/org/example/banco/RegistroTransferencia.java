package org.example.banco;
import java.util.ArrayList;
import java.util.List;

public class RegistroTransferencia {
    private String IdTransferencia;
    private String UserDestino;
    private String UserEmisor;
    private List<Categoria> Categoria = new ArrayList<>();
    private String Cantidad;

    public RegistroTransferencia(){

    }
    public RegistroTransferencia(String IdTransferencia,String UserDestino,String UserEmisor, List<Categoria> Categoria,String Cantidad){
        this.IdTransferencia=IdTransferencia;
        this.UserDestino= UserDestino;
        this.UserEmisor=UserEmisor;
        this.Categoria=Categoria;
        this.Cantidad=Cantidad;
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

    public List<org.example.banco.Categoria> getCategoria() {
        return Categoria;
    }

    public String getCantidad() {
        return Cantidad;
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

    public void setCategoria(List<org.example.banco.Categoria> categoria) {
        Categoria = categoria;
    }

    public void setCantidad(String cantidad) {
        Cantidad = cantidad;
    }
}
