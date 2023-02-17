/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cliente;
import dominio.Cuenta;
import dominio.Movimiento;
import dominio.Retiros;
import dominio.Transferencia;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ICuentaDAO;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;

/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 */
public class CuentaDAO implements ICuentaDAO {

    private static final Logger LOG = Logger.getLogger(CuentaDAO.class.getName());

    private final IConexionBD generadorConexiones;

    public CuentaDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }

    @Override
    public List<Cuenta> consultarCuentas() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Transferencia tranferencia(Cuenta cuentaUsuario, Cuenta cuentaDestino, double monto) throws PersistenciaException {
        BigDecimal saldo = new BigDecimal(0.0);
        BigDecimal mont = new BigDecimal(monto);
        try (
                 Connection con = this.generadorConexiones.crearConexion();  PreparedStatement comandoStart = con.prepareStatement("START transaction");  PreparedStatement comandoSelect = con.prepareStatement("select* from cuentas where id = ?");  PreparedStatement comandoUpdate = con.prepareStatement("update cuentas set saldo=saldo+? where id=?");  PreparedStatement comandoUpdate2 = con.prepareStatement("update cuentas set saldo=saldo-? where id=?");  PreparedStatement comandoSelect2 = con.prepareStatement("select* from cuentas where id = ?");  PreparedStatement comandoInsertTran = con.prepareStatement("insert into transferencias(idCuentaUsuario,idCuentaDestino,monto) value(?,?,?)",
                Statement.RETURN_GENERATED_KEYS);  PreparedStatement comandoCommit = con.prepareStatement("COMMIT");  PreparedStatement comandoRollback = con.prepareStatement("ROLLBACK");) {

            comandoStart.execute();
            comandoSelect.setString(1, cuentaUsuario.getId());
            comandoSelect.executeQuery();
            ResultSet resultador = comandoSelect.executeQuery();

            if (resultador.next()) {
                saldo = resultador.getBigDecimal("saldo");
            }
            if (saldo.compareTo(new BigDecimal(monto)) < 0) {
                comandoRollback.execute();
                throw new PersistenciaException("Saldo insuficiente");
            }

            comandoUpdate2.setDouble(1, monto);
            comandoUpdate2.setString(2, cuentaUsuario.getId());
            comandoUpdate2.executeUpdate();

            comandoSelect.setString(1, cuentaUsuario.getId());
            resultador = comandoSelect.executeQuery();
            BigDecimal saldo3 = new BigDecimal(0.0);
            if (resultador.next()) {
                saldo3 = resultador.getBigDecimal("saldo");
            }
            if (saldo3.compareTo(saldo) == 0) {
                comandoRollback.execute();
                throw new PersistenciaException("Hubo un error en la transaccion");
            }

            comandoSelect2.setString(1, cuentaDestino.getId());
            resultador = comandoSelect2.executeQuery();
            if (resultador.next()) {
                saldo = resultador.getBigDecimal("saldo");
            }
            comandoUpdate.setDouble(1, monto);
            comandoUpdate.setString(2, cuentaDestino.getId());
            comandoUpdate.executeUpdate();

            comandoSelect2.setString(1, cuentaDestino.getId());
            resultador = comandoSelect2.executeQuery();
            BigDecimal saldo2 = new BigDecimal(0.0);
            if (resultador.next()) {
                saldo2 = resultador.getBigDecimal("saldo");
            }

            if (saldo.compareTo(saldo2) == 0) {
                comandoRollback.execute();
                throw new PersistenciaException("Hubo un error en la transaccion");
            }

            comandoInsertTran.setString(1, cuentaUsuario.getId());
            comandoInsertTran.setString(2, cuentaDestino.getId());
            comandoInsertTran.setDouble(3, monto);

            comandoInsertTran.executeUpdate();

            resultador = comandoInsertTran.getGeneratedKeys();

            Transferencia transferencia = null;
            if (resultador.next()) {
                transferencia = new Transferencia(
                        resultador.getInt(1),
                        cuentaUsuario.getId(), cuentaDestino.getId(),
                        monto,
                        null);
            }
            comandoCommit.execute();

            return transferencia;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo proceder la transferencia: " + e.getMessage());
            throw new PersistenciaException("No se pudo proceder la transferencia");
        }

    }

    @Override
    public Retiros generarRetiro(Cuenta cuenta, double monto, String contrasena) throws PersistenciaException {
        SecureRandom numRandom = new SecureRandom();
        int folio;
        BigDecimal mont = new BigDecimal(monto);
        try (
                 Connection con = this.generadorConexiones.crearConexion();
                PreparedStatement commStart = con.prepareStatement("start transaction");
                PreparedStatement commCommit = con.prepareStatement("COMMIT");
                PreparedStatement commRollback = con.prepareStatement("ROLLBACK");
                PreparedStatement commSelect = con.prepareStatement("select* from cuentas where id =?");
                PreparedStatement commSelect2 = con.prepareStatement("select* from retiros where id =?");
                PreparedStatement commInsertRetiro = con.prepareStatement("insert into retiros(idCuenta,monto,folio,constraseña,disponible) value(?,?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);) {

            commStart.execute();

            commSelect.setString(1, cuenta.getId());
            ResultSet resultado = commSelect.executeQuery();
            BigDecimal saldo = new BigDecimal(0.0);
            if (resultado.next()) {
                saldo = resultado.getBigDecimal("saldo");
            }

            if (saldo.compareTo(mont) < 0) {
                commRollback.execute();
                throw new PersistenciaException("Saldo insuficiente");
            }
            folio = numRandom.nextInt(1000000000);
            commInsertRetiro.setString(1, cuenta.getId());
            commInsertRetiro.setDouble(2, monto);
            commInsertRetiro.setInt(3, folio);
            commInsertRetiro.setString(4, contrasena);
            commInsertRetiro.setString(5, "pendiente");

            commInsertRetiro.executeUpdate();
            resultado = commInsertRetiro.getGeneratedKeys();
            Integer id = null;
            if (resultado.next()) {
                id = resultado.getInt(1);
            }

            commSelect2.setInt(1, id);
            resultado = commSelect2.executeQuery();
            Retiros retiro = null;

            if (resultado.next()) {
                retiro = new Retiros(resultado.getInt("id"), resultado.getString("idCuenta"), monto, folio, contrasena, "pendiente", null,resultado.getTimestamp("fecha").getTime());
            }
            return retiro;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo generar el Retiro: " + e.getMessage());
            throw new PersistenciaException("No se pudo generar el Retiro");
        }

    }

    @Override
    public List<Movimiento> hisotrialMovimientos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
