/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejecucion;

import dominio.Cuenta;
import excepciones.PersistenciaException;
import implementaciones.ConexionBD;
import implementaciones.*;
import interfaces.IClienteDAO;
import interfaces.IConexionBD;
import interfaces.ICuentaDAO;
import java.sql.Date;
import presentacion.Menu;

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
        IConexionBD bd = new ConexionBD("jdbc:mysql://localhost/banco_bda", "root", "bone770115");
        IClienteDAO clienteDao = new ClienteDAO(bd);
        ICuentaDAO cuentaDao = new CuentaDAO(bd);
        //Cliente cliente = new Cliente("Daniel", "Peña", "García", "2002-11-10", "6441942558", "14584Pen");
        //clienteDao.registrarCliente(cliente);
                //Cuenta cuenta = new Cuenta("232285e4-ac24-11ed-94ce-2cfda1e2a95b", new Date(2023, 02, 13), 800, 3);
        //cuentaDao.generarRetiro(cuenta, 100.0, "123456");
        Menu menu = new Menu(clienteDao, cuentaDao);
        menu.setVisible(true);
    }

}
