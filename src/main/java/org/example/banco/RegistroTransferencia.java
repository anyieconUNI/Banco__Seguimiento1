package org.example.banco;
import java.util.ArrayList;
import java.util.List;

public class RegistroTransferencia {
    private int IdTransferencia;
    private int UserDestino;
    private int UserEmisor;
    private List<Categoria> Categoria = new ArrayList<>();
    private int Cantidad;

    public RegistroTransferencia(){

    }
    public RegistroTransferencia(int IdTransferencia,int UserDestino,int UserEmisor, List<Categoria> Categoria,int Cantidad){
        this.IdTransferencia=IdTransferencia;
        this.UserDestino= UserDestino;
        this.UserEmisor=UserEmisor;
        this.Categoria=Categoria;
        this.Cantidad=Cantidad;
    }

    public int getIdTransferencia() {
        return IdTransferencia;
    }

    public int getUserDestino() {
        return UserDestino;
    }

    public int getUserEmisor() {
        return UserEmisor;
    }

    public List<org.example.banco.Categoria> getCategoria() {
        return Categoria;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setIdTransferencia(int idTransferencia) {
        IdTransferencia = idTransferencia;
    }

    public void setUserDestino(int userDestino) {
        UserDestino = userDestino;
    }

    public void setUserEmisor(int userEmisor) {
        UserEmisor = userEmisor;
    }

    public void setCategoria(List<org.example.banco.Categoria> categoria) {
        Categoria = categoria;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }
}
