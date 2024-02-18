package org.example.banco;

public class Categoria {
    private  int IdCategoria;
    private String NameCategoria;

    public Categoria(){

    }
    public Categoria(int IdCategoria,String NameCategoria){
        this.IdCategoria=IdCategoria;
        this.NameCategoria=NameCategoria;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public String getNameCategoria() {
        return NameCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        IdCategoria = idCategoria;
    }

    public void setNameCategoria(String nameCategoria) {
        NameCategoria = nameCategoria;
    }
}
