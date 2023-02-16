/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejecucion;

import implementaciones.ConexionBD;
import interfazesImplementaciones.*;
import implementaciones.*;
import presentacion.Menu;

/**
 *
 * @author trinu
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IConexionBD bd = new ConexionBD("jdbc:mysql://localhost/activitas_ecologicos", "root", "bone770115");
        IClienteDAO clienteDao = new ClienteDAO(bd);
        ICuentaDAO cuentaDao = new CuentaDAO(bd);
        Menu menu = new Menu(clienteDao,cuentaDao);
    }

}
