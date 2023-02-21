/**
 * DepositoDAO.java
 * 21 feb. 2023 03:26:21
 */
package implementaciones;
//importanciones

import dominio.Cuenta;
import dominio.Deposito;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IDepositoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class DepositoDAO implements IDepositoDAO {

    private final IConexionBD generadorConexiones;
    private static final Logger LOG = Logger.getLogger(CuentaDAO.class.getName());

    public DepositoDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }

    @Override
    public Deposito ingresarDeposito(Cuenta cuenta, double monto) throws PersistenciaException {
        String insert = "INSERT INTO Depositos(idCuenta, monto)"
                + "VALUES(?,?)";
        String select = "SELECT * FROM DEPOSITOS WHERE id = ?";
        try (
                Connection con = generadorConexiones.crearConexion();
                PreparedStatement crear = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement consulta = con.prepareStatement(select);
                PreparedStatement comandoUpdate = con.prepareStatement("update cuentas set saldo=saldo+? "
                        + "where id=?");
            ) {
            crear.setInt(1, cuenta.getId());
            crear.setDouble(2, monto);
            crear.executeUpdate();
            ResultSet resultado = crear.getGeneratedKeys();
            Integer id = null;
            if (resultado.next()) {
                id = resultado.getInt(Statement.RETURN_GENERATED_KEYS);
            }
            consulta.setInt(1, id);
            ResultSet resultadoConsulta = consulta.executeQuery();
            Deposito deposito = null;
            if (resultadoConsulta.next()) {
                Timestamp fecha = resultadoConsulta.getTimestamp("fecha");
                deposito = new Deposito(id, cuenta.getId(), fecha, monto);
            }
            comandoUpdate.setDouble(1, monto);
            comandoUpdate.setInt(2, cuenta.getId());
            int num= comandoUpdate.executeUpdate();
            if (num==0) {
                throw new PersistenciaException("No se pudo hacer el deposito");
            }
            
            return deposito;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo proceder la transferencia: " + e.getMessage());
            throw new PersistenciaException("No se pudo hace el deposito");
        }
    }

    @Override
    public Deposito consultarDeposito(Deposito deposito) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
