import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;

public class BancoTest {
    
    // Metodo de prueba para el metodo agregarUsuarios
    @Test
    public void testAgregarUsuarios() {
        // Creamos una instancia de la clase PlataformaBancaria (suponiendo que tengamos esta clase)
        PlataformaBancaria plataforma = new PlataformaBancaria();
        
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
        plataforma = new PlataformaBancaria();
        // Agregamos algunos usuarios de prueba
        plataforma.agregarUsuarios("123456", "Juan Pérez", "Calle 123", "1234567890", "juan@example.com", "contraseña");
        plataforma.agregarUsuarios("789012", "María López", "Avenida 456", "0987654321", "maria@example.com", "123456");
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
}
