package org.example.banco;

import org.example.banco.Banco;
import org.example.banco.Cuentas;
import org.example.banco.Usuarios;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import java.util.Map;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class BancoTest {
    
    // Metodo de prueba para el metodo agregarUsuarios
    @Test
    public void testAgregarUsuarios() {
        // Creamos una instancia de la clase PlataformaBancaria (suponiendo que tengamos esta clase)
        Banco plataforma = new Banco();
        
        // Llamamos al metodo agregarUsuarios con datos de usuario simulados
        plataforma.agregarUsuarios("123456", "Juana Peralta", "Calle 123", "1234567890", "juana@mail", "contraseña");
        
        // Verificamos si el usuario fue agregado correctamente

        assertEquals(1, plataforma.getUsuarios().size()); 
        Usuarios usuarioAgregado = plataforma.getUsuarios().get(0);
        assertEquals("123456", usuarioAgregado.getIdUser());
        assertEquals("Juana Peralta", usuarioAgregado.getNombreUser());
        assertEquals("Calle 123", usuarioAgregado.getDireccion()); 
        assertEquals("1234567890", usuarioAgregado.getNumeIdenti()); 
        assertEquals("juana@mail", usuarioAgregado.getCorreoUser()); 
        assertEquals("contraseña", usuarioAgregado.getContraseUser()); 
    
    }
    // Prueba metodo 2

    // Configuracion inicial para cada prueba
    @Before
    public void setUp() {
        Banco banco= new Banco();
        // Agregamos algunos usuarios de prueba
        banco.agregarUsuarios("123456", "Juan Pérez", "Calle 123", "1234567890", "juan@example.com", "contraseña");
        banco.agregarUsuarios("789012", "María López", "Avenida 456", "0987654321", "maria@example.com", "123456");
    }
    
    // Método de prueba para el método actualizarUsuario
    @Test
    public void testActualizarUsuario() {
        Banco banco= new Banco();
        // Actualizamos el usuario con el número de identificación '123456'
        banco.actualizarUsuario("123456", "Pedro Pérez", "Calle 456", "pedro@example.com", "nuevacontraseña");

        // Verificamos que el usuario haya sido actualizado correctamente
        Usuarios usuarioActualizado = null;
        for (Usuarios usuario : banco.getUsuarios()) {
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
        Banco banco= new Banco();
        // Intentamos actualizar un usuario con un número de identificación que no existe
        banco.actualizarUsuario("999999", "Nuevo Nombre", "Nueva Dirección", "nuevo@example.com", "nuevacontraseña");
        
        // Verificamos que el usuario con el número de identificación '999999' no haya sido actualizado
        Usuarios usuarioNoExistente = null;
        for (Usuarios usuario : banco.getUsuarios()) {
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
        Banco banco= new Banco();
        // Eliminamos un usuario existente
        banco.eliminarUsuarios("123456");
        
        // Verificamos que el usuario haya sido eliminado correctamente
        boolean usuarioEliminado = banco.getUsuarios().stream().noneMatch(usuario -> usuario.getNumeIdenti().equals("123456"));
        assertTrue(usuarioEliminado); // Verificamos que el usuario haya sido eliminado
        assertEquals(0, banco.getUsuarios().size()); // Verificamos que solo quede un usuario en la lista
    }
    
    // Método de prueba para el método crearCuentaAhorros
    @Test
    public void testCrearCuentaAhorros() {
        // Creamos una cuenta de ahorros para un usuario existente
        Banco banco= new Banco();
        banco.crearCuentaAhorros("123456", 1000);
        
        // Verificamos que se haya creado la cuenta de ahorros correctamente
        boolean cuentaCreada = banco.getCuentas().stream().anyMatch(cuenta -> cuenta.getIdUser().equals("123456"));
        assertTrue(cuentaCreada); // Verificamos que se haya creado la cuenta de ahorros
        
        // Verificamos que el saldo inicial sea el correcto
        for (Cuentas cuenta : banco.getCuentas()) {
            if (cuenta.getIdUser().equals("123456")) {
                assertEquals(1000, cuenta.getSaldo()); // Verificamos que el saldo inicial sea 1000
                break;
            }
        }
    }

    @Test
    public  void  testTranferirExitosa(){
        Banco banco = new Banco();
        banco.agregarUsuarios("123456", "Juana Peralta", "Calle 123", "1234567890", "juana@mail", "contraseña");
        banco.agregarUsuarios("1234563", "Juana Peralta", "Calle 123", "123453", "juana@mail", "contraseña");

        String emisor =banco.crearCuentaAhorros("123456",2000);
        String receptor =banco.crearCuentaAhorros("1234563",200);
        LocalDate fecha = LocalDate.of(2024, 2, 20);
        String TransferenciaResultado = banco.Transferir(receptor, emisor, "Facturas", 300, fecha);
        Assert.assertEquals("Transferencia exitosa", TransferenciaResultado);

    }
    @Test
    public  void  testTranferirFalida(){
        Banco banco = new Banco();
        banco.agregarUsuarios("123456", "Juana Peralta", "Calle 123", "1234567890", "juana@mail", "contraseña");
        banco.agregarUsuarios("1234563", "Juana Peralta", "Calle 123", "123453", "juana@mail", "contraseña");

        String emisor =banco.crearCuentaAhorros("123456",2000);
        String receptor =banco.crearCuentaAhorros("1234563",200);
        LocalDate fecha = LocalDate.of(2024, 2, 20);
        String TransferenciaResultado = banco.Transferir(receptor, emisor, "Facturas", 11300, fecha);
        Assert.assertEquals("Transferencia fallida", TransferenciaResultado);
    }
    @Test
    public void ObtenerTransfeRangoExitosa(){
        Banco banco = new Banco();
        banco.agregarUsuarios("123456", "Juana Peralta", "Calle 123", "1234567890", "juana@mail", "contraseña");
        banco.agregarUsuarios("1234563", "Juana Peralta", "Calle 123", "123453", "juana@mail", "contraseña");

        String emisor =banco.crearCuentaAhorros("123456",2000);
        String receptor =banco.crearCuentaAhorros("1234563",200);
        LocalDate fecha = LocalDate.of(2024, 2, 20);
        banco.Transferir(receptor, emisor, "Facturas", 100, fecha);
        LocalDate fechaInicio = LocalDate.of(2024, 2, 20);
        LocalDate fechaFin = LocalDate.of(2024, 3, 29);
        String Resultado = banco.ObtenerTransfeRango("1234563",fechaInicio,fechaFin);

        Assert.assertTrue(Resultado.contains("Categoría:Facturas Cantidad:100 Fecha:" +LocalDate.of(2024, 2, 20)));
    }
    @Test
    public void ObtenerTransfeRangoFallida(){
        Banco banco = new Banco();
        banco.agregarUsuarios("123456", "Juana Peralta", "Calle 123", "1234567890", "juana@mail", "contraseña");
        banco.agregarUsuarios("1234563", "Juana Peralta", "Calle 123", "123453", "juana@mail", "contraseña");

        String emisor =banco.crearCuentaAhorros("123456",2000);
        String receptor =banco.crearCuentaAhorros("1234563",200);
        LocalDate fecha = LocalDate.of(2024, 2, 20);
        banco.Transferir(receptor, emisor, "Facturas", 100, fecha);
        LocalDate fechaInicio = LocalDate.of(2024, 2, 20);
        LocalDate fechaFin = LocalDate.of(2024, 3, 29);
        String Resultado = banco.ObtenerTransfeRango("12345637",fechaInicio,fechaFin);

        Assert.assertEquals("Sus movimientos:\n", Resultado);
    }

    @Test
    public void ObtenerTodasCuentasExitosa(){
        Banco banco = new Banco();
        banco.agregarUsuarios("123456", "Juana Peralta", "Calle 123", "1234567890", "juana@mail", "contraseña");
        banco.agregarUsuarios("1234563", "Juana Peralta", "Calle 123", "123453", "juana@mail", "contraseña");

        banco.crearCuentaAhorros("123456",2000);
        banco.crearCuentaAhorros("1234563",200);

        String resultado =banco.ObtenerTodasCuentas();
        Assert.assertTrue(resultado.contains("Usuario:123456"));
        Assert.assertTrue(resultado.contains("Usuario:1234563"));

    }
    @Test
    public void ObtenerTodasCuentasFallida() {
        Banco banco = new Banco();
        String resultado = banco.ObtenerTodasCuentas();
        Assert.assertEquals("Todas las cuentas \n ", resultado);
    }
    // Prueba para método  Obtener un porcentaje de gastos y de ingresos dado el mes. A la vez debe discriminar los gastos según la categoría.
    @Before
    public void setUp() {
        // Configurar el banco y agregar algunas transacciones de prueba
        banco = new Banco();
        banco.getTransferencias().add(new RegistroTransferencia("1", "usuario1", "usuario2", "Comida", 100, LocalDate.of(2024, 1, 15)));
        banco.getTransferencias().add(new RegistroTransferencia("2", "usuario2", "usuario1", "Transporte", 50, LocalDate.of(2024, 1, 20)));
        banco.getTransferencias().add(new RegistroTransferencia("3", "usuario1", "usuario2", "Comida", 80, LocalDate.of(2024, 2, 10)));
        banco.getTransferencias().add(new RegistroTransferencia("4", "usuario2", "usuario1", "Alquiler", 200, LocalDate.of(2024, 2, 15)));
    }
    
    @Test
    public void testObtenerPorcentajeGastosIngresos() {
        // Calcular el porcentaje de gastos e ingresos para el mes de enero (mes 1)
        Map<String, Double> porcentajeGastosIngresos = banco.obtenerPorcentajeGastosIngresos("1");
        
        // Verificar el porcentaje de gastos para la categoría "Comida" (se espera 66.67%)
        assertEquals(66.67, porcentajeGastosIngresos.get("Comida"), 0.01);
        
        // Verificar el porcentaje de gastos para la categoría "Transporte" (se espera 33.33%)
        assertEquals(33.33, porcentajeGastosIngresos.get("Transporte"), 0.01);
        
        // Verificar el porcentaje de ingresos (se espera 0% porque no hay ingresos en enero)
        assertEquals(0, porcentajeGastosIngresos.get("Ingresos"), 0.01);
    }
}
