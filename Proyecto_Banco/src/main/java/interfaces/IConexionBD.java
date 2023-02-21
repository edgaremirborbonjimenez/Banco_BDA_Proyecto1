package interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 */
public interface IConexionBD {
    
    /**
     * Crea la conexión entre la base de datos y java
     * 
     * @return La conexión
     * @throws SQLException En caso de que haya un error de tipo SQLException
     */
    Connection crearConexion() throws SQLException;
}
