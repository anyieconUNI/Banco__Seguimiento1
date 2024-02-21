package org.example.banco;

public class TipoTransferencias {
    private String IdTipoTransferencia;
    private String NameTransferencia;
    public  TipoTransferencias(){

    }
    public TipoTransferencias(String IdTipoTransferencia,String NameTransferencia){
        this.IdTipoTransferencia= IdTipoTransferencia;
        this.NameTransferencia =NameTransferencia;
    }

    public String getIdTipoTransferencia() {
        return IdTipoTransferencia;
    }

    public String getNameTransferencia() {
        return NameTransferencia;
    }

    public void setIdTipoTransferencia(String idTipoTransferencia) {
        IdTipoTransferencia = idTipoTransferencia;
    }

    public void setNameTransferencia(String nameTransferencia) {
        NameTransferencia = nameTransferencia;
    }
}
