package org.example.banco;
import java.util.ArrayList;
import java.util.List;
public class Cuentas {
    private int IdCuenta;
    private List<Usuarios> IdUser = new ArrayList<>();
    private int Saldo;
    private  List<TipoTransferencias> RegisTransacciones = new ArrayList<>();
    private List<RegistroTransferencia> RegisTransferencias = new ArrayList<>();

    public Cuentas(){

    }
    public Cuentas(int IdCuenta,List<Usuarios> IdUser, int Saldo ,List<TipoTransferencias> RegisTransacciones,List<RegistroTransferencia> RegisTransferencias){
        this.IdCuenta=IdCuenta;
        this.IdUser=IdUser;
        this.Saldo=Saldo;
        this.RegisTransacciones=RegisTransacciones;
        this.RegisTransferencias=RegisTransferencias;
    }

    public int getIdCuenta() {
        return IdCuenta;
    }

    public List<Usuarios> getIdUser() {
        return IdUser;
    }

    public int getSaldo() {
        return Saldo;
    }

    public List<RegistroTransferencia> getRegisTransferencias() {
        return RegisTransferencias;
    }

    public List<TipoTransferencias> getRegisTransacciones() {
        return RegisTransacciones;
    }

    public void setIdCuenta(int idCuenta) {
        IdCuenta = idCuenta;
    }

    public void setIdUser(List<Usuarios> idUser) {
        IdUser = idUser;
    }

    public void setSaldo(int saldo) {
        Saldo = saldo;
    }

    public void setRegisTransacciones(List<TipoTransferencias> regisTransacciones) {
        RegisTransacciones = regisTransacciones;
    }

    public void setRegisTransferencias(List<RegistroTransferencia> regisTransferencias) {
        RegisTransferencias = regisTransferencias;
    }
}
