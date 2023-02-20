/**
 * DireccionDAO.java
 * 20 feb. 2023 13:08:04
 */
package implementaciones;
//importanciones

import dominio.Cliente;
import dominio.Direcciones;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IDireccionesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class DireccionDAO implements IDireccionesDAO {

    private static final Logger LOG
            = Logger.getLogger(ClienteDAO.class.getName());

    private final IConexionBD generadorConexiones;

    public DireccionDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }

    @Override
    public Direcciones consultaDireccion(Cliente cliente) throws PersistenciaException {
        Integer id_cliente = cliente.getId();
        String consulta = "SELECT * FROM clientes "
                + "WHERE idCliente = ?";
        try (
                Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(consulta);) {
            comando.setInt(1, id_cliente);
            ResultSet resultado = comando.executeQuery();
            
            if(resultado.next()){
                Integer id = resultado.getInt("id");
                String calle = resultado.getString("calle");
                String colonia = resultado.getString("colonia");
                String numExterior = resultado.getString("numExterior");
                Direcciones direccion = new Direcciones(id, calle, colonia, numExterior, id_cliente);
                return direccion;
            }
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    @Override
    public Direcciones insertarDireccion(Direcciones direccion) throws PersistenciaException {
        Direcciones regresaDireccion = null;
        String calle = direccion.getCalle();
        String colonia = direccion.getColonia();
        String numExterior = direccion.getNumExterior();
        Integer id_cliente = direccion.getId_cliente();
        String insert = "INSERT INTO Direcciones(calle, colonia, numExterior, idCliente) "
                + "VALUES(?, ?, ?, ?)";
        try (
                Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, calle);
            comando.setString(2, colonia);
            comando.setString(3, numExterior);
            comando.setInt(4, id_cliente);
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                Integer id = resultado.getInt(Statement.RETURN_GENERATED_KEYS);
                regresaDireccion = new Direcciones(id, calle, colonia, numExterior, id_cliente);
                return regresaDireccion;
            }
            LOG.log(Level.WARNING, "Se insertó el direccion pero no se generó id");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

}
