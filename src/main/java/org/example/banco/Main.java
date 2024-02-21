package org.example.banco;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        List<Usuarios> usuarios = new ArrayList<>();

        // Crear usuarios de ejemplo
        banco.agregarUsuarios("111111","Juan Perez", "Calle 123", "123456789", "juan@example.com", "contrasena");
        banco.agregarUsuarios("12344","Maria Lopez", "Avenida 456", "987654321", "maria@example.com", "password");

        banco.obtenerTodosUsuarios();
        List<Usuarios> todosUsuarios = banco.obtenerTodosUsuarios();
        for (Usuarios usuario : todosUsuarios) {
            System.out.println("Nombre: " + usuario.getNombreUser());
            System.out.println("direcc: " + usuario.getDireccion());
            System.out.println("identi: " + usuario.getNumeIdenti());
            System.out.println("correo: " + usuario.getCorreoUser());
            System.out.println("contrase: " + usuario.getContraseUser());
        }
        banco.actualizarUsuario("123456789","CAMBIO","11QQQQQ","AAAAAAAAAA","AAAAAAAA");

        for (Usuarios usuario : todosUsuarios) {
            System.out.println("Nombre: " + usuario.getNombreUser());
            System.out.println("direcc: " + usuario.getDireccion());
            System.out.println("identi: " + usuario.getNumeIdenti());
            System.out.println("correo: " + usuario.getCorreoUser());
            System.out.println("contrase: " + usuario.getContraseUser());
        }

        banco.eliminarUsuarios("123456789");
        for (Usuarios usuario : todosUsuarios) {
            System.out.println("ELIMINAR USUARIOS: " );
            System.out.println("Nombre: " + usuario.getNombreUser());
            System.out.println("direcc: " + usuario.getDireccion());
            System.out.println("identi: " + usuario.getNumeIdenti());
            System.out.println("correo: " + usuario.getCorreoUser());
            System.out.println("contrase: " + usuario.getContraseUser());
        }
        banco.crearCuentaAhorros("123456789",100000);

        banco.obtenerTodasCuentas();
        List<Cuentas> cuentas = banco.obtenerTodasCuentas();

        for (Cuentas cuenta : cuentas) {
            System.out.println("CUENTASSSS: " );
            System.out.println("Nombre: " + cuenta.getIdCuenta());
            System.out.println("direcc: " + cuenta.getIdUser());
            System.out.println("identi: " + cuenta.getSaldo());
        }

        LocalDate fechaActual = LocalDate.now();
        // Formatear la fecha como una cadena
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaActual.format(formato);
        // Imprimir la fecha formateada
        System.out.println("Fecha actual: " + fechaFormateada);

    }
}
