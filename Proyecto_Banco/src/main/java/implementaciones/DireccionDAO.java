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

    /**
     * Cronstructor que inicializa la conexión con la BD
     *
     * @param generadorConexiones Conexión a la base de datos
     */
    public DireccionDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }


    /**
     * Ingresa en la BD una direccion
     * 
     * @param direccion Direccion
     * @return Un objeto de tipo Direccion
     * @throws PersistenciaException En caso de que haya algun error
     */
    @Override
    public Direcciones insertarDireccion(Direcciones direccion) throws PersistenciaException {
        Direcciones regresaDireccion = null;
        String calle = direccion.getCalle();
        String colonia = direccion.getColonia();
        String numExterior = direccion.getNumExterior();
        String insert = "INSERT INTO Direcciones(calle, colonia, numeroExterior) "
                + "VALUES(?, ?, ?)";
        try (
                Connection conexion = generadorConexiones.crearConexion(); 
                PreparedStatement comando = conexion.prepareStatement(insert,
                        PreparedStatement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, calle);
            comando.setString(2, colonia);
            comando.setString(3, numExterior);
            comando.executeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();
            if(resultado.next()){
                Integer id = resultado.getInt(
                        Statement.RETURN_GENERATED_KEYS);
                regresaDireccion = new Direcciones(id, calle, colonia, numExterior);
                return regresaDireccion;
            }
            LOG.log(Level.WARNING, "Se insertó el direccion pero no se generó id");
        } catch (SQLException e) {
            System.out.println("No se insertó direccion");
            LOG.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

}
