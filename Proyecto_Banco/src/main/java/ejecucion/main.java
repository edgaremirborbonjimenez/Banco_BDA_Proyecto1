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
import interfaces.IDireccionesDAO;

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
        IConexionBD bd = new ConexionBD("jdbc:mysql://localhost/banco", "root", "bone770115");
        IClienteDAO clienteDao = new ClienteDAO(bd);
        ICuentaDAO cuentaDao = new CuentaDAO(bd);
        IDireccionesDAO direccionDAO = new DireccionDAO(bd);
        //Cliente cliente = new Cliente("Daniel", "Peña", "García", "2002-11-10", "6441942558", "14584Pen");
   
        Menu menu = new Menu(clienteDao, cuentaDao, direccionDAO);
        menu.setVisible(true);
    }

}
