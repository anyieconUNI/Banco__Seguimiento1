package org.example.banco;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {
    private List<Cuentas> cuentas;
    private List<RegistroTransferencia> transferencias;
    private  List<Usuarios> usuarios = new ArrayList<>();
    private  List<Cuentas> cuentas = new ArrayList<>();
    private List<RegistroTransferencia> transferencias = new ArrayList<>();
    public Banco() {
        this.usuarios = new ArrayList<>();
        this.cuentas=new ArrayList<>();
        this.transferencias = new ArrayList<>();
    }
    /*Probar en test*/
    public void agregarUsuarios(String IdUser,String NombreUser,String Direccion,String NumeIdenti,String CorreoUser,String ContraseUser) {
        Usuarios nuevoUsuario = new Usuarios(IdUser,NombreUser,Direccion,NumeIdenti,CorreoUser,ContraseUser);
        usuarios.add(nuevoUsuario);
    }
    /*Probar en test*/public  void actualizarUsuario(String NumeIdenti,String NombreUser,String Direccion,String CorreoUser,String ContraseUser){
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
    /*Probar en test*/public void eliminarUsuarios(String NumeIdenti){
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
    /*Probar en test*/public String crearCuentaAhorros(String IdUser, int Saldo){
        String IdCuentas = generarNumeroAleatorio();
        Cuentas nuevaCuenta=new Cuentas(IdCuentas,IdUser,Saldo);
        cuentas.add(nuevaCuenta);
        return IdCuentas;
    }
    public List<Cuentas> obtenerTodasCuentas() {
        return cuentas;
    }
    /*Probar en test*/public String Transferir(String userDestino, String userEmisor, String categoria, int cantidad, LocalDate fechaTransferencia) {
        String idTransferencia = generarNumeroAleatorio();
        for (Cuentas cuenta : cuentas) {
            int valorTotal = cantidad + 200;
            if(cuenta.getIdCuenta().equals(userEmisor) && cuenta.getSaldo() >= valorTotal) {
                RegistroTransferencia nuevaTransfe = new RegistroTransferencia(idTransferencia, userDestino, userEmisor, categoria, cantidad, fechaTransferencia);
                transferencias.add(nuevaTransfe);
                String unos= actualizarSaldoEmisor(valorTotal,userEmisor);
                String uno = actualizarReceptor(valorTotal,userDestino);
                return "Transferencia exitosa";
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
    /*Probar en test*/public String BuscarIdenSaldo(String NumeroIdenti, String Contraseña) {
        for (Usuarios usuario : usuarios) {
            if (usuario.getNumeIdenti().equals(NumeroIdenti) && usuario.getContraseUser().equals(Contraseña)) {
                for (Cuentas cuenta : cuentas) {
                    if (cuenta.getIdUser().equals(NumeroIdenti)) {
                        String saldo = "Su saldo es: " + cuenta.getSaldo();
                        String transacciones = obtenerTransaccionesAsociadas(cuenta.getIdCuenta(),cuenta.getTipoTrans());
                        return saldo + "\n" + transacciones;
                    }
                }
            }
        }
        return "No se ha encontrado usuario o contraseña";
    }
    public String obtenerTransaccionesAsociadas(String idCuenta,String tipo) {
        StringBuilder movimientos = new StringBuilder("Sus movimientos:\n");
        for (RegistroTransferencia transferencia : transferencias) {
            if (transferencia.getUserDestino().equals(idCuenta) || transferencia.getUserEmisor().equals(idCuenta)) {
                movimientos.append("Categoría:"+transferencia.getCategoria() + " Cantidad:" + transferencia.getCantidad()
                        +" Fecha:" +transferencia.getFechaTransferencia() +" Tipo de transferencia:"+ tipo ).append("\n");

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
    /*Probar en test*/public String ObtenerTransfeRango(String idCuenta, LocalDate fechaInicio, LocalDate fechaFin){
        StringBuilder movimientos = new StringBuilder("Sus movimientos:\n");
        for (RegistroTransferencia transferencia : transferencias) {
            for (Cuentas cuenta : cuentas) {
                if (cuenta.getIdUser().equals(idCuenta)) {
                    if (transferencia.getUserDestino().equals(cuenta.getIdCuenta()) || transferencia.getUserEmisor().equals(cuenta.getIdCuenta())) {
                        if((transferencia.getFechaTransferencia().isAfter(fechaInicio) || transferencia.getFechaTransferencia().isEqual(fechaInicio)) && (transferencia.getFechaTransferencia().isBefore(fechaFin) || transferencia.getFechaTransferencia().isEqual(fechaFin))){
                            movimientos.append("Categoría:"+transferencia.getCategoria() + " Cantidad:" + transferencia.getCantidad() +" Fecha:" +transferencia.getFechaTransferencia()).append("\n");
                        }
                    }
                }
            }
        }
        return movimientos.toString();
    }
    /*Probar en test*/public String ObtenerTodasTransFecha(LocalDate fechaInicio, LocalDate fechaFin){
        StringBuilder movimientos = new StringBuilder("Todas las transferencias desde: "+fechaInicio+ " hasta: "+fechaFin+"\n");
        for (RegistroTransferencia transferencia : transferencias) {
                if((transferencia.getFechaTransferencia().isAfter(fechaInicio) || transferencia.getFechaTransferencia().isEqual(fechaInicio)) && (transferencia.getFechaTransferencia().isBefore(fechaFin) || transferencia.getFechaTransferencia().isEqual(fechaFin))){
                    movimientos.append("Categoría:"+transferencia.getCategoria() + " Cantidad:" + transferencia.getCantidad() +" Fecha:" +transferencia.getFechaTransferencia()).append("\n");
                }
        }
        return movimientos.toString();
    }
    /*Probar en test*/public String ObtenerTodasCuentas(){
        StringBuilder movimientos = new StringBuilder("Todas las cuentas \n ");
        for(Cuentas cuentas : cuentas){
            movimientos.append("Usuario:" + cuentas.getIdUser() ).append("\n");
        }
        return movimientos.toString();
    }
    // Obtener un porcentaje de gastos y de ingresos dado el mes. A la vez debe discriminar los gastos según la categoría.
    public Map<String, Double> obtenerPorcentajeGastosIngresos(String mes) {
        Map<String, Double> porcentajeGastosIngresos = new HashMap<>();
        Map<String, Double> totalGastos = new HashMap<>();
        double totalIngresos = 0;
        double totalGasto = 0;

        // Calcular total de ingresos y gastos por categoría
        for (RegistroTransferencia transferencia : transferencias) {
            if (transferencia.getFechaTransferencia().getMonthValue() == Integer.parseInt(mes)) {
                if (transferencia.getTipo().equals("Salida")) {
                    totalGasto += transferencia.getCantidad();
                    totalGastos.put(transferencia.getCategoria(), totalGastos.getOrDefault(transferencia.getCategoria(), 0.0) + transferencia.getCantidad());
                } else {
                    totalIngresos += transferencia.getCantidad();
                }
            }
        }
        
        // Calcular porcentaje de gastos e ingresos
        for (Map.Entry<String, Double> entry : totalGastos.entrySet()) {
            double porcentajeGasto = (entry.getValue() / totalGasto) * 100;
            porcentajeGastosIngresos.put(entry.getKey(), porcentajeGasto);
        }


        double porcentajeIngreso = (totalIngresos / (totalIngresos + totalGasto)) * 100;
        porcentajeGastosIngresos.put("Ingresos", porcentajeIngreso);
        
        return porcentajeGastosIngresos;
    }
}
