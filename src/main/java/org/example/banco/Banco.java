package org.example.banco;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Banco {

    private  List<Usuarios> usuarios = new ArrayList<>();
    public Banco() {
        this.usuarios = new ArrayList<>();
    }
    public void agregarUsuarios(String IdUser,String NombreUser,String Direccion,String NumeIdenti,String CorreoUser,String ContraseUser) {
        Usuarios nuevoUsuario = new Usuarios(IdUser,NombreUser,Direccion,NumeIdenti,CorreoUser,ContraseUser);
        usuarios.add(nuevoUsuario);
    }
    public  void actualizarUsuario(String NumeIdenti,String NombreUser,String Direccion,String CorreoUser,String ContraseUser){
        for(Usuarios usuario : usuarios){
            if(usuario.getNumeIdenti().equals(NumeIdenti)) {
                usuario.setNombreUser(NombreUser);
                usuario.setDireccion(Direccion);
                usuario.setCorreoUser(CorreoUser);
                usuario.setContraseUser(ContraseUser);
                break;
            }
        }
    }
    public void eliminarUsuarios(String NumeIdenti){
        usuarios.removeIf(usuario -> usuario.getNumeIdenti().equals(NumeIdenti));
    }
    public List<Usuarios> obtenerTodosUsuarios() {
        return usuarios;
    }
}
