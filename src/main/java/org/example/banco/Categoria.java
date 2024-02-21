package org.example.banco;

public class Categoria {
    private  String IdCategoria;
    private String NameCategoria;

    public Categoria(){

    }
    public Categoria(String IdCategoria,String NameCategoria){
        this.IdCategoria=IdCategoria;
        this.NameCategoria=NameCategoria;
    }

    public String getIdCategoria() {
        return IdCategoria;
    }

    public String getNameCategoria() {
        return NameCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        IdCategoria = idCategoria;
    }

    public void setNameCategoria(String nameCategoria) {
        NameCategoria = nameCategoria;
    }
}
