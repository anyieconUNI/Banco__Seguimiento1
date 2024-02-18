package org.example.banco;

public class Usuarios {
    private int IdUser ;
    private String NombreUser;
    private  String Direccion;
    private int NumeIdenti;
    private  String CorreoUser;
    private  String ContraseUser;

    public Usuarios(){

    }
    public Usuarios ( int IdUser ,String NombreUser, String Direccion,int NumeIdenti,String CorreoUser,String ContraseUser){
        this.IdUser = IdUser;
        this.NombreUser= NombreUser;
        this.NumeIdenti= NumeIdenti;
        this.Direccion = Direccion;
        this.CorreoUser=CorreoUser;
        this.ContraseUser=ContraseUser;
    }
    public int getIdUser() {
        return IdUser;
    }

    public String getNombreUser() {
        return NombreUser;
    }

    public String getDireccion() {
        return Direccion;
    }

    public int getNumeIdenti() {
        return NumeIdenti;
    }

    public String getCorreoUser() {
        return CorreoUser;
    }

    public String getContraseUser() {
        return ContraseUser;
    }

    public void setNombreUser(String nombreUser) {
        NombreUser = nombreUser;
    }

    public void setNumeIdenti(int numeIdenti) {
        NumeIdenti = numeIdenti;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public void setCorreoUser(String correoUser) {
        CorreoUser = correoUser;
    }

    public void setContraseUser(String contraseUser) {
        ContraseUser = contraseUser;
    }
}
