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
        banco.agregarUsuarios("123444","Maria Lopez", "Avenida 456", "9876543214", "maria@example.com", "password");

        banco.obtenerTodosUsuarios();
        List<Usuarios> todosUsuarios = banco.obtenerTodosUsuarios();
        for (Usuarios usuario : todosUsuarios) {
            System.out.println("Nombre: " + usuario.getNombreUser());
            System.out.println("direcc: " + usuario.getDireccion());
            System.out.println("identi: " + usuario.getNumeIdenti());
            System.out.println("correo: " + usuario.getCorreoUser());
            System.out.println("contrase: " + usuario.getContraseUser());
        }
        /*banco.actualizarUsuario("123456789","CAMBIO","11QQQQQ","AAAAAAAAAA","AAAAAAAA");

        for (Usuarios usuario : todosUsuarios) {
            System.out.println("Nombre: " + usuario.getNombreUser());
            System.out.println("direcc: " + usuario.getDireccion());
            System.out.println("identi: " + usuario.getNumeIdenti());
            System.out.println("correo: " + usuario.getCorreoUser());
            System.out.println("contrase: " + usuario.getContraseUser());
        }*/

        //banco.eliminarUsuarios("123456789");
       /* for (Usuarios usuario : todosUsuarios) {
            System.out.println("ELIMINAR USUARIOS: " );
            System.out.println("Nombre: " + usuario.getNombreUser());
            System.out.println("direcc: " + usuario.getDireccion());
            System.out.println("identi: " + usuario.getNumeIdenti());
            System.out.println("correo: " + usuario.getCorreoUser());
            System.out.println("contrase: " + usuario.getContraseUser());
        }*/
        String cuentaahorro =banco.crearCuentaAhorros("123456789",20000);
        String cuentaahorroem =banco.crearCuentaAhorros("987654321",20000);
        String cuentaahorrodoss =banco.crearCuentaAhorros("9876543214",20000);

        banco.obtenerTodasCuentas();
        List<Cuentas> cuentas = banco.obtenerTodasCuentas();

        for (Cuentas cuenta : cuentas) {
            System.out.println("CUENTASSSS: " );
            System.out.println("Nombre: " + cuenta.getIdCuenta());
            System.out.println("direcc: " + cuenta.getIdUser());
            System.out.println("identi: " + cuenta.getSaldo());
        }

        LocalDate fechaActual = LocalDate.now();
        String fechaFormateada = fechaActual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        LocalDate fechaTransferencia = LocalDate.parse(fechaFormateada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));


        String resultadoTransferencia = banco.Transferir(cuentaahorro,cuentaahorroem,"fiesta",1000,fechaTransferencia);
        String resultadoTransferenciaw = banco.Transferir(cuentaahorro,cuentaahorroem,"fiesta",1000,fechaTransferencia);
        System.out.println(resultadoTransferencia+resultadoTransferenciaw);
        banco.obtenerTodasTransfi();
        List<RegistroTransferencia> transferencias = banco.obtenerTodasTransfi();
        for(RegistroTransferencia transfi : transferencias){
            System.out.println("TRANSFERENCIASSSSSSSS: " );
            System.out.println("destino: " + transfi.getUserDestino());
            System.out.println("emisor: " + transfi.getUserEmisor());
            System.out.println("idtransfi: " + transfi.getIdTransferencia());
        }

        LocalDate fechaFinss= LocalDate.of(2024, 2, 29);
        String resultadoTransferencias = banco.Transferir(cuentaahorrodoss,cuentaahorroem,"SEGUNDO",10000,fechaFinss);
        System.out.println(resultadoTransferencias);
       String resultados = banco.BuscarIdenSaldo("9876543214","password");
        System.out.println(resultados);

        String resultadosemi = banco.BuscarIdenSaldo("123456789","contrasena");
        System.out.println(resultadosemi);

        LocalDate fechaInicio = LocalDate.of(2024, 2, 20);  // Reemplaza con tu fecha de inicio
        LocalDate fechaFin = LocalDate.of(2024, 3, 29);
        String ObtenerTransfeRango = banco.ObtenerTransfeRango("9876543214",fechaInicio,fechaFin);
        System.out.println(ObtenerTransfeRango);

        String hola = banco.ObtenerTodasTransFecha(fechaInicio,fechaFin);
        System.out.println(hola);
        String u = banco.ObtenerTodasCuentas();
        System.out.println(u);
    }
}
