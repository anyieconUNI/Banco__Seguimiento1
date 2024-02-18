package org.example.banco;

public class TipoTransferencias {
    private int IdTipoTransferencia;
    private String NameTransferencia;
    public  TipoTransferencias(){

    }
    public TipoTransferencias(int IdTipoTransferencia,String NameTransferencia){
        this.IdTipoTransferencia= IdTipoTransferencia;
        this.NameTransferencia =NameTransferencia;
    }

    public int getIdTipoTransferencia() {
        return IdTipoTransferencia;
    }

    public String getNameTransferencia() {
        return NameTransferencia;
    }

    public void setIdTipoTransferencia(int idTipoTransferencia) {
        IdTipoTransferencia = idTipoTransferencia;
    }

    public void setNameTransferencia(String nameTransferencia) {
        NameTransferencia = nameTransferencia;
    }
}
