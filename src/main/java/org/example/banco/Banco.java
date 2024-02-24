package org.example.banco;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Banco {

    private  List<Usuarios> usuarios = new ArrayList<>();
    private  List<Cuentas> cuentas = new ArrayList<>();
    private List<RegistroTransferencia> transferencias = new ArrayList<>();
    public Banco() {
        this.usuarios = new ArrayList<>();
        this.cuentas=new ArrayList<>();
        this.transferencias = new ArrayList<>();
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

    public String generarNumeroAleatorio(){
        Random random = new Random();
        StringBuilder nuemroIdvuenta = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            nuemroIdvuenta.append(random.nextInt(10));
        }
        return nuemroIdvuenta.toString();
    }
    public String crearCuentaAhorros(String IdUser, int Saldo){
        String IdCuentas = generarNumeroAleatorio();
        Cuentas nuevaCuenta=new Cuentas(IdCuentas,IdUser,Saldo);
        cuentas.add(nuevaCuenta);
        return IdCuentas;
    }
    public List<Cuentas> obtenerTodasCuentas() {
        return cuentas;
    }
    public String Transferir(String userDestino, String userEmisor, String categoria, int cantidad, LocalDate fechaTransferencia) {
        String idTransferencia = generarNumeroAleatorio();
        for (Cuentas cuenta : cuentas) {
            int valorTotal = cantidad + 200;
            if(cuenta.getIdCuenta().equals(userEmisor) && cuenta.getSaldo() >= valorTotal) {
                RegistroTransferencia nuevaTransfe = new RegistroTransferencia(idTransferencia, userDestino, userEmisor, categoria, cantidad, fechaTransferencia);
                transferencias.add(nuevaTransfe);
                String unos= actualizarSaldoEmisor(valorTotal,userEmisor);
                String uno = actualizarReceptor(valorTotal,userDestino);
                return "Transferencia EXITOSA"+uno +" decontar"+unos;
            }
        }
        return "Transferencia fallida";
    }
    public String actualizarSaldoEmisor(int valorTotal,String userEmisor){
        for (Cuentas cuenta : cuentas) {
            if (cuenta.getIdCuenta().equals(userEmisor) && cuenta.getSaldo() >= valorTotal) {
                if (cuenta.getIdCuenta().equals(userEmisor)) {
                    int nuevoSaldo = cuenta.getSaldo() - valorTotal;
                    cuenta.setSaldo(nuevoSaldo);
                    cuenta.setTipoTrans("Salida");
                    return "su saldo "+cuenta.getSaldo()+cuenta.getTipoTrans();
                }
            }
        }
        return "no encontrado";
    }
    public String actualizarReceptor(int valorTotal,String userDestino){
        for (Cuentas cuenta : cuentas) {
            if (cuenta.getIdCuenta().equals(userDestino) && cuenta.getSaldo() >= valorTotal) {
                if (cuenta.getIdCuenta().equals(userDestino)) {
                    int nuevoSaldo = cuenta.getSaldo() + valorTotal -200;
                    cuenta.setSaldo(nuevoSaldo);
                    cuenta.setTipoTrans("Entrada");
                    return "su saldo receptor "+cuenta.getSaldo()+cuenta.getTipoTrans();
                }
            }
        }
        return "no encontrado";
    }
    public String BuscarIdenSaldo(String NumeroIdenti, String Contraseña) {
        for (Usuarios usuario : usuarios) {
            if (usuario.getNumeIdenti().equals(NumeroIdenti) && usuario.getContraseUser().equals(Contraseña)) {
                for (Cuentas cuenta : cuentas) {
                    if (cuenta.getIdUser().equals(NumeroIdenti)) {
                        String saldo = "Su saldo es: " + cuenta.getSaldo();
                        String transacciones = obtenerTransaccionesAsociadas(cuenta.getIdCuenta(),cuenta.getTipoTrans(),NumeroIdenti );
                        return saldo + "\n" + transacciones;
                    }
                }
            }
        }
        return "No se ha encontrado usuario o contraseña";
    }

    public String obtenerTransaccionesAsociadas(String idCuenta,String tipo,String NumeroIdenti) {
        StringBuilder movimientos = new StringBuilder("Sus movimientos:\n");
        for (RegistroTransferencia transferencia : transferencias) {
            if (transferencia.getUserDestino().equals(idCuenta) || transferencia.getUserEmisor().equals(idCuenta)) {
                movimientos.append("Categoría:"+transferencia.getCategoria() + " Cantidad:" + transferencia.getCantidad()
                        +" Fecha:" +transferencia.getFechaTransferencia() +" Tipo de transferencia:"+ tipo +NumeroIdenti).append("\n");

            }
        }
        return movimientos.toString();
    }

    public List<RegistroTransferencia> obtenerTodasTransfi() {
        return transferencias;
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Cuentas> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuentas> cuentas) {
        this.cuentas = cuentas;
    }

    public List<RegistroTransferencia> getTransferencias() {
        return transferencias;
    }

    public void setTransferencias(List<RegistroTransferencia> transferencias) {
        this.transferencias = transferencias;
    }
}
