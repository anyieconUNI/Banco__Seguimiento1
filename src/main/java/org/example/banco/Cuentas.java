package org.example.banco;
import java.util.ArrayList;
import java.util.List;
public class Cuentas {
    private String IdCuenta;
    private List<Usuarios> IdUser = new ArrayList<>();
    private String Saldo;
    private  List<TipoTransferencias> RegisTransacciones = new ArrayList<>();
    private List<RegistroTransferencia> RegisTransferencias = new ArrayList<>();

    public Cuentas(){

    }
    public Cuentas(String IdCuenta,List<Usuarios> IdUser, String Saldo ,List<TipoTransferencias> RegisTransacciones,List<RegistroTransferencia> RegisTransferencias){
        this.IdCuenta=IdCuenta;
        this.IdUser=IdUser;
        this.Saldo=Saldo;
        this.RegisTransacciones=RegisTransacciones;
        this.RegisTransferencias=RegisTransferencias;
    }

    public String getIdCuenta() {
        return IdCuenta;
    }

    public List<Usuarios> getIdUser() {
        return IdUser;
    }

    public String getSaldo() {
        return Saldo;
    }

    public List<RegistroTransferencia> getRegisTransferencias() {
        return RegisTransferencias;
    }

    public List<TipoTransferencias> getRegisTransacciones() {
        return RegisTransacciones;
    }

    public void setIdCuenta(String idCuenta) {
        IdCuenta = idCuenta;
    }

    public void setIdUser(List<Usuarios> idUser) {
        IdUser = idUser;
    }

    public void setSaldo(String saldo) {
        Saldo = saldo;
    }

    public void setRegisTransacciones(List<TipoTransferencias> regisTransacciones) {
        RegisTransacciones = regisTransacciones;
    }

    public void setRegisTransferencias(List<RegistroTransferencia> regisTransferencias) {
        RegisTransferencias = regisTransferencias;
    }
}
