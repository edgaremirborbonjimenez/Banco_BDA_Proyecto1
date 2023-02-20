/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cliente;
import dominio.Cuenta;
import dominio.Movimiento;
import dominio.MovimientoHistorial;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;

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
    public Cuenta generarCuenta(Cliente cliente, double montoInicial) throws PersistenciaException {
        try (
                 Connection con = this.generadorConexiones.crearConexion();  PreparedStatement commInsertCuenta = con.prepareStatement("insert into cuentas(saldo,idCliente) value (?,?)",
                Statement.RETURN_GENERATED_KEYS);  PreparedStatement commSelect = con.prepareStatement("Select* from cuentas where id = ?");) {

            commInsertCuenta.setDouble(1, montoInicial);
            commInsertCuenta.setDouble(2, cliente.getId());

            commInsertCuenta.executeUpdate();
            ResultSet resultado = commInsertCuenta.getGeneratedKeys();
            Integer id = null;
            // Cuenta cuenta = null;
            if (resultado.next()) {
                id = resultado.getInt(1);
            } else {
                throw new PersistenciaException("No se pudo generar la cuenta");
            }
            commSelect.setInt(1, id);
            resultado = commSelect.executeQuery();
            Cuenta cuenta = null;
            if (resultado.next()) {
                cuenta = new Cuenta(id,
                        resultado.getString("numCuenta"),
                        new Date(resultado.getTimestamp("fechaApertura").getTime()),
                        resultado.getBigDecimal("saldo"),
                        resultado.getInt("idCliente"));
            }
            return cuenta;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo generar la cuenta: " + e.getMessage());
            throw new PersistenciaException("No se pudo generar la cuenta");
        }
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
                 Connection con = this.generadorConexiones.crearConexion();  PreparedStatement comandoStart = con.prepareStatement("START transaction");  PreparedStatement comandoSelect = con.prepareStatement("select* from cuentas where numCuenta = ?");  PreparedStatement comandoUpdate2 = con.prepareStatement("update cuentas set saldo=saldo-? where numCuenta=?");  PreparedStatement comandoUpdate = con.prepareStatement("update cuentas set saldo=saldo+? where numCuenta=?");  PreparedStatement comandoSelect2 = con.prepareStatement("select* from cuentas where numCuenta = ?");  PreparedStatement comandoInsertTran = con.prepareStatement("insert into transferencias(idCuentaUsuario,idCuentaDestino,monto) value(?,?,?)",
                Statement.RETURN_GENERATED_KEYS);  PreparedStatement commSelectTran = con.prepareStatement("Select* from transferencias where id =?");  PreparedStatement comandoCommit = con.prepareStatement("COMMIT");  PreparedStatement comandoRollback = con.prepareStatement("ROLLBACK");) {

            comandoStart.execute();
            comandoSelect.setString(1, cuentaUsuario.getNumCuenta());
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
            comandoUpdate2.setString(2, cuentaUsuario.getNumCuenta());
            comandoUpdate2.executeUpdate();

            comandoSelect.setString(1, cuentaUsuario.getNumCuenta());
            resultador = comandoSelect.executeQuery();
            BigDecimal saldo3 = new BigDecimal(0.0);
            if (resultador.next()) {
                saldo3 = resultador.getBigDecimal("saldo");
            }
            if (saldo3.compareTo(saldo) == 0) {
                comandoRollback.execute();
                throw new PersistenciaException("Hubo un error en la transaccion");
            }
            comandoSelect2.setString(1, cuentaDestino.getNumCuenta());
            resultador = comandoSelect2.executeQuery();
            if (resultador.next()) {
                saldo = resultador.getBigDecimal("saldo");
            }

            comandoUpdate.setDouble(1, monto);
            comandoUpdate.setString(2, cuentaDestino.getNumCuenta());
            comandoUpdate.executeUpdate();

            comandoSelect2.setString(1, cuentaDestino.getNumCuenta());
            resultador = comandoSelect2.executeQuery();
            BigDecimal saldo2 = new BigDecimal(0.0);
            if (resultador.next()) {
                saldo2 = resultador.getBigDecimal("saldo");
            }

            if (saldo.compareTo(saldo2) == 0) {
                comandoRollback.execute();
                throw new PersistenciaException("Hubo un error en la transaccion");
            }

            comandoInsertTran.setInt(1, cuentaUsuario.getId());
            comandoInsertTran.setInt(2, cuentaDestino.getId());
            comandoInsertTran.setDouble(3, monto);

            comandoInsertTran.executeUpdate();

            resultador = comandoInsertTran.getGeneratedKeys();

            Integer id = null;
            if (resultador.next()) {
                id = resultador.getInt(1);
            } else {
                comandoRollback.execute();
                throw new PersistenciaException("No se pudo generar la transaccion");
            }
            commSelectTran.setInt(1, id);
            resultador = commSelectTran.executeQuery();
            Transferencia transferencia = null;
            if (resultador.next()) {

            }
            transferencia = new Transferencia(id,
                    resultador.getInt("idCuentaUsuario"),
                    resultador.getInt("idCuentaDestino"),
                    monto,
                    resultador.getTimestamp("fecha"));

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
                PreparedStatement commSelect = con.prepareStatement("select* from cuentas where numCuenta =?"); 
                PreparedStatement commSelect2 = con.prepareStatement("select* from retiros where id =?");  
                PreparedStatement commInsertRetiro = con.prepareStatement("insert into retiros(idCuenta,monto,folio,contrasena,disponible) value(?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);) {

            commStart.execute();

            commSelect.setString(1, cuenta.getNumCuenta());
            ResultSet resultado = commSelect.executeQuery();
            BigDecimal saldo = new BigDecimal(0.0);
            if (resultado.next()) {
                saldo = resultado.getBigDecimal("saldo");
            } else {
                commRollback.execute();
                throw new PersistenciaException("Error cuenta inexistente");
            }
            if (saldo.compareTo(mont) < 0) {
                commRollback.execute();
                throw new PersistenciaException("Saldo insuficiente");
            }
            folio = numRandom.nextInt(1000000000);
            commInsertRetiro.setInt(1, cuenta.getId());
            commInsertRetiro.setDouble(2, monto);
            commInsertRetiro.setInt(3, folio);
            commInsertRetiro.setString(4, contrasena);
            commInsertRetiro.setString(5, "pendiente");
            commInsertRetiro.executeUpdate();
            resultado = commInsertRetiro.getGeneratedKeys();
            Integer id = null;
            if (resultado.next()) {
                id = resultado.getInt(1);
            } else {
                commRollback.execute();
                throw new PersistenciaException("No se pudo generar el Retiro");
            }
            commSelect2.setInt(1, id);
            resultado = commSelect2.executeQuery();
            Retiros retiro = null;
            if (resultado.next()) {
                retiro = new Retiros(id,
                        resultado.getInt("idCuenta"),
                        monto,
                        resultado.getInt("folio"),
                        resultado.getString("contrasena"),
                        resultado.getString("disponible").toString(),
                        null,
                        resultado.getTimestamp("fecha"));
                System.out.println("Aqui!!!!!!!!!!!!!");
            }

            commCommit.execute();
            return retiro;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo generar el Retiro: " + e.getMessage());
            throw new PersistenciaException("No se pudo generar el Retiro");
        }

    }

    @Override
    public List<MovimientoHistorial> hisotrialMovimientos(Cuenta cuenta) throws PersistenciaException {
        ArrayList <MovimientoHistorial> historial = new ArrayList<>();
        try (
            Connection con = this.generadorConexiones.crearConexion();
            PreparedStatement commSR = con.prepareStatement(
                    "select R.id,R.idCuenta,C.numCuenta,R.monto,R.folio,R.disponible,R.fechaRetirado from retiros R "
                    + "inner join cuentas C on C.id=R.idCuenta "
                    + "WHERE C.id = ? and disponible=\"retirado\"");
            PreparedStatement commSTransferenciaEnviado = con.prepareStatement(
                    "select T.id,T.idCuentaUsuario,T.idCuentaDestino,C.numCuenta,T.monto,T.fecha from transferencias T"
                            + " inner join cuentas C on C.id=T.idCuentaDestino "
                            + "where T.idCuentaUsuario = ?");
            PreparedStatement commSTransferenciaRecivida = con.prepareStatement(
                    "select T.id,T.idCuentaUsuario,C.numCuenta,T.idCuentaDestino,T.monto,T.fecha from transferencias T "
                            + "inner join cuentas C on C.id=T.idCuentaUsuario "
                            + "where T.idCuentaDestino = ?");
                ) {
            
            commSR.setInt(1, cuenta.getId());
            ResultSet resultados = commSR.executeQuery();
            MovimientoHistorial h = null;
            while(resultados.next()){
            String numCuenta = resultados.getString("numCuenta");
            BigDecimal monto = resultados.getBigDecimal("monto");
            Timestamp fecha = resultados.getTimestamp("fechaRetirado");
             h = new MovimientoHistorial("Retiraste", numCuenta, monto.doubleValue(), fecha);
            historial.add(h);
            }
            
            commSTransferenciaEnviado.setInt(1, cuenta.getId());
            resultados = commSTransferenciaEnviado.executeQuery();
            
            while(resultados.next()){
            String numCuenta = resultados.getString("numCuenta");
            BigDecimal monto = resultados.getBigDecimal("monto");
            Timestamp fecha = resultados.getTimestamp("fecha");
             h = new MovimientoHistorial("Enviaste", numCuenta, monto.doubleValue(), fecha);
             historial.add(h);
            }
            
            commSTransferenciaRecivida.setInt(1, cuenta.getId());
            resultados = commSTransferenciaRecivida.executeQuery();
            while(resultados.next()){
            String numCuenta = resultados.getString("numCuenta");
            BigDecimal monto = resultados.getBigDecimal("monto");
            Timestamp fecha = resultados.getTimestamp("fecha");
             h = new MovimientoHistorial("Recibiste", numCuenta, monto.doubleValue(), fecha);
             historial.add(h);
            }
            return historial;
            
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo consultar el historial de movimientos: " + e.getMessage());
            throw new PersistenciaException("No se pudo consultar el historial de movimientos");
        }

    }

    @Override
    public DefaultComboBoxModel<Cuenta> listaCuentas(Cliente cliente) throws PersistenciaException {

        List<Cuenta> listaCuentas = new LinkedList<>();
        String consulta = "SELECT * FROM Cuentas "
                + "WHERE id_cliente = ?";

        try (
                 Connection conexion = generadorConexiones.crearConexion();  PreparedStatement comando = conexion.prepareStatement(consulta);) {
            comando.setInt(1, cliente.getId());
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String numCuenta = resultado.getString("numCuenta");
                Date fechaApertura = resultado.getDate("fechaApertura");
                BigDecimal saldo = resultado.getBigDecimal("saldo");
                Integer id_cliente = resultado.getInt("idcliente");
                Cuenta cuenta = new Cuenta(id, numCuenta, fechaApertura, saldo, id_cliente);
                listaCuentas.add(cuenta);
            }

        } catch (SQLException e) {

        }
        return null;
    }

}
