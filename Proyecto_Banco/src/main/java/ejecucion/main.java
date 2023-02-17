/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejecucion;

import excepciones.PersistenciaException;
import implementaciones.ConexionBD;
import implementaciones.*;
import interfaces.IClienteDAO;
import interfaces.IConexionBD;
import interfaces.ICuentaDAO;
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
        IConexionBD bd = new ConexionBD("jdbc:mysql://localhost/banco", "root", "14584Pen");
        IClienteDAO clienteDao = new ClienteDAO(bd);
        ICuentaDAO cuentaDao = new CuentaDAO(bd);
        //Cliente cliente = new Cliente("Daniel", "Peña", "García", "2002-11-10", "6441942558", "14584Pen");
        //clienteDao.registrarCliente(cliente);
        Menu menu = new Menu(clienteDao,cuentaDao);
        menu.setVisible(true);
    }

}
