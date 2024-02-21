package org.example.banco;

public class Usuarios {
    private String IdUser ;
    private String NombreUser;
    private  String Direccion;
    private String NumeIdenti;
    private  String CorreoUser;
    private  String ContraseUser;

    public Usuarios(){

    }
    public Usuarios ( String IdUser ,String NombreUser, String Direccion,String NumeIdenti,String CorreoUser,String ContraseUser){
        this.IdUser = IdUser;
        this.NombreUser= NombreUser;
        this.NumeIdenti= NumeIdenti;
        this.Direccion = Direccion;
        this.CorreoUser=CorreoUser;
        this.ContraseUser=ContraseUser;
    }
    public String getIdUser() {
        return IdUser;
    }

    public String getNombreUser() {
        return NombreUser;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getNumeIdenti() {
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

    public void setNumeIdenti(String numeIdenti) {
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
