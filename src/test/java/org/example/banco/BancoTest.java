/*package org.example.banco;

import org.junit.Test;
import org.junit.Before;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class BancoTest {

    // Metodo de prueba para el metodo agregarUsuarios
    @Test
    public void testAgregarUsuarios() {

        // Verificamos si el usuario fue agregado correctamente

        assertEquals(2, plataforma.getUsuarios().size());
        Usuarios usuarioAgregado = plataforma.getUsuarios().get(0);
        assertEquals("123456", usuarioAgregado.getIdUser());
        assertEquals("Juan Pérez", usuarioAgregado.getNombreUser());
        assertEquals("Calle 123", usuarioAgregado.getDireccion());
        assertEquals("1234567890", usuarioAgregado.getNumeIdenti());
        assertEquals("juan@example.com", usuarioAgregado.getCorreoUser());
        assertEquals("contraseña", usuarioAgregado.getContraseUser());

    }

    private Banco plataforma;

    // Configuracion inicial para cada prueba
    @Before
    public void setUp() {
        plataforma = new Banco();
        // Agregamos algunos usuarios de prueba
        plataforma.agregarUsuarios("123456", "Juan Pérez", "Calle 123", "1234567890", "juan@example.com", "contraseña");
        plataforma.agregarUsuarios("789012", "María López", "Avenida 456", "0987654321", "maria@example.com", "123456");
        // Creamos cuentas de ahorro para los usuarios de prueba
        plataforma.crearCuentaAhorros("123456", 1000);
        plataforma.crearCuentaAhorros("789012", 2000);
    }

    // Método de prueba para el método actualizarUsuario
    @Test
    public void testActualizarUsuario() {
        // Actualizamos el usuario con el número de identificación '123456'
        plataforma.actualizarUsuario("123456", "Pedro Pérez", "Calle 456", "pedro@example.com", "nuevacontraseña");

        // Verificamos que el usuario haya sido actualizado correctamente
        Usuarios usuarioActualizado = null;
        for (Usuarios usuario : plataforma.getUsuarios()) {
            if (usuario.getNumeIdenti().equals("123456")) {
                usuarioActualizado = usuario;
                break;
            }
        }

        assertNotNull(usuarioActualizado); // Verificamos que el usuario exista
        assertEquals("Pedro Pérez", usuarioActualizado.getNombreUser()); // Verificamos el nombre actualizado
        assertEquals("Calle 456", usuarioActualizado.getDireccion()); // Verificamos la dirección actualizada
        assertEquals("pedro@example.com", usuarioActualizado.getCorreoUser()); // Verificamos el correo actualizado
        assertEquals("nuevacontraseña", usuarioActualizado.getContraseUser()); // Verificamos la contraseña actualizada
    }

    // Metodo de prueba para el metodo actualizarUsuario con un usuario que no existe
    @Test
    public void testActualizarUsuarioNoExistente() {
        // Intentamos actualizar un usuario con un número de identificación que no existe
        plataforma.actualizarUsuario("999999", "Nuevo Nombre", "Nueva Dirección", "nuevo@example.com", "nuevacontraseña");

        // Verificamos que el usuario con el número de identificación '999999' no haya sido actualizado
        Usuarios usuarioNoExistente = null;
        for (Usuarios usuario : plataforma.getUsuarios()) {
            if (usuario.getNumeIdenti().equals("999999")) {
                usuarioNoExistente = usuario;
                break;
            }
        }

        assertNull(usuarioNoExistente); // Verificamos que el usuario no exista
    }

    // Método de prueba para el método eliminarUsuarios
    @Test
    public void testEliminarUsuarios() {
        // Eliminamos un usuario existente
        plataforma.eliminarUsuarios("123456");

        // Verificamos que el usuario haya sido eliminado correctamente
        boolean usuarioEliminado = plataforma.getUsuarios().stream().noneMatch(usuario -> usuario.getNumeIdenti().equals("123456"));
        assertTrue(usuarioEliminado); // Verificamos que el usuario haya sido eliminado
        assertEquals(1, plataforma.getUsuarios().size()); // Verificamos que solo quede un usuario en la lista
    }

    // Método de prueba para el método crearCuentaAhorros
    @Test
    public void testCrearCuentaAhorros() {
        // Creamos una cuenta de ahorros para un usuario existente
        plataforma.crearCuentaAhorros("123456", 1000);

        // Verificamos que se haya creado la cuenta de ahorros correctamente
        boolean cuentaCreada = plataforma.getCuentas().stream().anyMatch(cuenta -> cuenta.getIdUser().equals("123456"));
        assertTrue(cuentaCreada); // Verificamos que se haya creado la cuenta de ahorros

        // Verificamos que el saldo inicial sea el correcto
        for (Cuentas cuenta : plataforma.getCuentas()) {
            if (cuenta.getIdUser().equals("123456")) {
                assertEquals(1000, cuenta.getSaldo()); // Verificamos que el saldo inicial sea 1000
                break;
            }
        }
    }

    //Metodo que prueba el metodo Transferencia en el caso exitosa:
    @Test

    public void testTransferirExitoso() {
        // Realizamos una transferencia exitosa de Juan Pérez a María López por $300
        String resultado = plataforma.Transferir("789012", "123456", "Alimentos", 300, LocalDate.now());

        // Verificamos que la transferencia haya sido exitosa
        assertEquals("Transferencia EXITOSA", resultado);

        // Verificamos que los saldos se hayan actualizado correctamente
        for (Cuentas cuenta : plataforma.getCuentas()) {
            if (cuenta.getIdCuenta().equals("123456")) {
                assertEquals(500, cuenta.getSaldo()); // El saldo de Juan Pérez debe ser $500 después de la transferencia
            } else if (cuenta.getIdCuenta().equals("789012")) {
                assertEquals(2300, cuenta.getSaldo()); // El saldo de María López debe ser $2300 después de la transferencia
            }
        }
    }

    // prueba para el metodo transferencia en el caso fallida:
    @Test

    public void testTranserirFallido(){
        // Intentamos realizar una transferencia fallida de Juan Pérez a María López por $1500 (saldo insuficiente)
        String resultado = plataforma.Transferir("789012", "123456", "Alimentos", 1500, LocalDate.now());

        // Verificamos que la transferencia haya fallado
        assertEquals("Transferencia fallida", resultado);

        // Verificamos que los saldos no hayan cambiado
        for (Cuentas cuenta : plataforma.getCuentas()) {
            if (cuenta.getIdCuenta().equals("123456")) {
                assertEquals(1000, cuenta.getSaldo()); // El saldo de Juan Pérez debe seguir siendo $1000
            } else if (cuenta.getIdCuenta().equals("789012")) {
                assertEquals(2000, cuenta.getSaldo()); // El saldo de María López debe seguir siendo $2000
            }
        }
    }

}*/