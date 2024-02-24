package org.example.banco;
import java.util.ArrayList;
import java.util.List;
public class Cuentas {
    private String IdCuenta;
    private String IdUser;
    //private List<Usuarios> IdUser = new ArrayList<>();
    private int Saldo;

    private String TipoTrans;

    public Cuentas(){

    }
    public Cuentas(String IdCuenta,String IdUser, int Saldo){
        this.IdCuenta=IdCuenta;
        this.IdUser=IdUser;
        this.Saldo=Saldo;
    }

    public String getIdCuenta() {
        return IdCuenta;
    }

    public String getIdUser() {
        return IdUser;
    }

    public int getSaldo() {
        return Saldo;
    }

    public String getTipoTrans() {
        return TipoTrans;
    }

    public void setIdCuenta(String idCuenta) {
        IdCuenta = idCuenta;
    }
    public void setIdUser(String idUser) {
        IdUser = idUser;
    }
    public void setSaldo(int saldo) {
        Saldo = saldo;
    }

    public void setTipoTrans(String tipoTrans) {
        TipoTrans = tipoTrans;
    }
}
