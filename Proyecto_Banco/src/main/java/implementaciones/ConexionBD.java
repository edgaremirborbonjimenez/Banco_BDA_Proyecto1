package implementaciones;

import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 */
public class ConexionBD implements IConexionBD {

    private final String cadenaConexion;
    private final String usuario;
    private final String password;

        /**
     * Constructor que pide acceder a la base de datos con usuario y contraseña
     * 
     * @param cadenaConexion Ubicación de la base de datos
     * @param usuario Usuario de la base de datos
     * @param password Contraseña para ingresar a la base de datos
     */
    public ConexionBD(String cadenaConexion, String usuario, String password) {
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.password = password;
    }

    /**
     * Crea la conexión entre la base de datos y java
     * 
     * @return La conexión
     * @throws SQLException En caso de que haya un error de tipo SQLException
     */
    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, password);
        return conexion;
    }

}
