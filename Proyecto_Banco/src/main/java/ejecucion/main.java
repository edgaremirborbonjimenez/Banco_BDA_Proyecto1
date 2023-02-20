/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejecucion;

import dominio.Cliente;
import dominio.Cuenta;
import excepciones.PersistenciaException;
import implementaciones.ConexionBD;
import implementaciones.*;
import interfaces.IClienteDAO;
import interfaces.IConexionBD;
import interfaces.ICuentaDAO;
import java.sql.Date;
import presentacion.Menu;
import dominio.*;

/**
 *
 * @author trinu
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistenciaException {
        // TODO code application logic here
        IConexionBD bd = new ConexionBD("jdbc:mysql://localhost/bancoBDA", "root", "14584Pen");
        IClienteDAO clienteDao = new ClienteDAO(bd);
        ICuentaDAO cuentaDao = new CuentaDAO(bd);
        //Cliente cliente = new Cliente("Daniel", "Peña", "García", "2002-11-10", "6441942558", "14584Pen");
                Cliente cliente = new Cliente(3,"Emir", "Borbon", "", null, "6421068907", "123456");
                Cliente cliente2 = new Cliente(4,"Oscar", "Minjarez", "", null, "6421068907", "321321");

                /**
        //clienteDao.registrarCliente(cliente);
        Cuenta cuenta= cuentaDao.generarCuenta(cliente,800.0);
        System.out.println(cuenta);
        
        Cuenta cuenta2= cuentaDao.generarCuenta(cliente2,800.0);
        System.out.println(cuenta2);
        
        Transferencia transferencia = cuentaDao.tranferencia(cuenta, cuenta2, 400.0);
        System.out.println(transferencia);
        
        Retiros retiro = cuentaDao.generarRetiro(cuenta2, 200.0, "564654");
        System.out.println(retiro);
        */
        
        Menu menu = new Menu(clienteDao, cuentaDao);
        menu.setVisible(true);
    }

}
