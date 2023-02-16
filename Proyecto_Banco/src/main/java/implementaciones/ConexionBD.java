/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfazesImplementaciones.IConexionBD;
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

    public ConexionBD(String cadenaConexion, String usuario, String password) {
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.password = password;
    }

    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, password);
        return conexion;
    }

}
