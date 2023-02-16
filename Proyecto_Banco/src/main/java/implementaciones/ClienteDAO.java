/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cliente;
import excepciones.PersistenciaException;
import interfazesImplementaciones.IClienteDAO;
import interfazesImplementaciones.IConexionBD;
import java.util.logging.Logger;

/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 */
public class ClienteDAO implements IClienteDAO {

    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
    
    private final IConexionBD generadorConexiones;

    public ClienteDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }
    
    

    @Override
    public Cliente registrarCliente(Cliente cliente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente ingresarCliente(Cliente cliente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
