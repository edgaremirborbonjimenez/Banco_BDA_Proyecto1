/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cliente;
import excepciones.PersistenciaException;
import interfaces.IClienteDAO;
import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel Armando Peña García ID: 229185
 * @author Edgar Emir Borbon Jimenez 00000233184
 */
public class ClienteDAO implements IClienteDAO {

    private static final Logger LOG
            = Logger.getLogger(ClienteDAO.class.getName());

    private final IConexionBD generadorConexiones;

    public ClienteDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente)
            throws PersistenciaException {
        String insert = "INSERT INTO CLIENTES(nombre, apellidoP, apellidoM, "
                + "fechaNacimiento, celular, contraseña)"
                + "VALUES(?,?,?,?,?,?);";

        Cliente regresaCliente = null;
        try (
                
                Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando
                = conexion.prepareStatement(insert,
                        Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, cliente.getNombre());
            comando.setString(2, cliente.getApellidoPaterno());
            comando.setString(3, cliente.getApellidoMaterno());
            comando.setString(4, cliente.getFechaNacimiento());
            comando.setString(5, cliente.getCelular());
            comando.setString(6, cliente.getContrasena());
            comando.executeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
                Integer id = resultado.getInt(
                        Statement.RETURN_GENERATED_KEYS);
                regresaCliente = new Cliente(id, cliente.getNombre(),
                        cliente.getApellidoPaterno(),
                        cliente.getApellidoMaterno(),
                        cliente.getFechaNacimiento(), cliente.getCelular(),
                        cliente.getContrasena());
                return regresaCliente;
            }
            LOG.log(Level.WARNING, "Se insertó el cliente pero no se generó id");
            throw new PersistenciaException("Se insertó el cliente pero no se generó id");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No se pudo insertar al cliente: " + e.getMessage());
        }
    }

    @Override
    public Cliente iniciaCliente(Cliente cliente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
