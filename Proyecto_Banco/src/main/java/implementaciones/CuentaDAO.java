/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cliente;
import dominio.Cuenta;
import dominio.MovimientoHistorial;
import dominio.Retiros;
import dominio.Transferencia;
import encriptador.Encriptador;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 * @author Daniel Armando Peña García 000000229185
 */
public class CuentaDAO implements ICuentaDAO {

    private static final Logger LOG = Logger.getLogger(CuentaDAO.class.getName());

    private final IConexionBD generadorConexiones;

    /**
     *
     * @param generadorConexiones
     */
    public CuentaDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }

    /**
     * Ingresa una cuenta en la BD con respecto al cliente y su id, junto con su
     * monto inicial
     *
     * @param cliente Cliente a la que está afiliada la cuenta
     * @param montoInicial Monto inicial con lo que iniciará la cuenta
     * @return Cuenta que se guardó en la base de datos.
     * @throws PersistenciaException En caso de que haya un error
     */
    @Override
    public Cuenta ingresarCuenta(Cliente cliente, double montoInicial) throws PersistenciaException {
        try (
                Connection con = this.generadorConexiones.crearConexion(); PreparedStatement commInsertCuenta = con.prepareStatement("insert into cuentas(idCliente,saldo) value (?,?)",
                Statement.RETURN_GENERATED_KEYS); PreparedStatement commSelect = con.prepareStatement("Select* from cuentas where id = ?");) {

            commInsertCuenta.setInt(1, cliente.getId());
            commInsertCuenta.setDouble(2, montoInicial);

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

    /**
     * Genera una transferencia Con una cuenta del cliente para transferir a
     * otra cuenta
     *
     * @param cuentaUsuario Cuenta que envia la transferencia
     * @param cuentaDestino Cuenta que recibe la transferencia
     * @param monto Monto de la transferencia
     * @return Un objeto de tipo Transferencia
     * @throws PersistenciaException En caso de que haya un error
     */
    @Override
    public Transferencia tranferencia(Cuenta cuentaUsuario, Cuenta cuentaDestino, double monto) throws PersistenciaException {
        BigDecimal saldo = new BigDecimal(0.0);
        BigDecimal mont = new BigDecimal(monto);
        try (
                Connection con = this.generadorConexiones.crearConexion(); PreparedStatement comandoStart = con.prepareStatement("START transaction"); PreparedStatement comandoSelect = con.prepareStatement("select* from cuentas where numCuenta = ?"); PreparedStatement comandoUpdate2 = con.prepareStatement("update cuentas set saldo=saldo-? "
                + "where numCuenta=?"); PreparedStatement comandoUpdate = con.prepareStatement(
                        "update cuentas set saldo=saldo+? where numCuenta=?"); PreparedStatement comandoSelect2 = con.prepareStatement("select* from cuentas where numCuenta = ?"); PreparedStatement comandoInsertTran = con.prepareStatement(
                "insert into transferencias(idCuentaUsuario,idCuentaDestino,monto) value(?,?,?)",
                Statement.RETURN_GENERATED_KEYS); PreparedStatement commSelectTran = con.prepareStatement("Select* from transferencias where id =?"); PreparedStatement comandoCommit = con.prepareStatement("COMMIT"); PreparedStatement comandoRollback = con.prepareStatement("ROLLBACK");) {

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

    /**
     * Genera un retiro a nombre de una cuenta, asignando un monto que va a
     * retirar y una contraseña
     *
     * @param cuenta A la cuenta que se le va a retirar
     * @param monto Monto que se va a retirar
     * @param contrasena Contraseña que se le asigna
     * @return Un objeto de tipo Retiro
     * @throws PersistenciaException En caso de que haya algun error
     */
    @Override
    public Retiros generarRetiro(Cuenta cuenta, double monto, String contrasena) throws PersistenciaException {
        SecureRandom numRandom = new SecureRandom();
        int folio;
        BigDecimal mont = new BigDecimal(monto);
        try (
                Connection con = this.generadorConexiones.crearConexion(); PreparedStatement commStart = con.prepareStatement("start transaction"); PreparedStatement commCommit = con.prepareStatement("COMMIT"); PreparedStatement commRollback = con.prepareStatement("ROLLBACK"); PreparedStatement commSelect = con.prepareStatement("select* from cuentas where numCuenta =?"); PreparedStatement commSelect2 = con.prepareStatement("select* from retiros where id =?"); PreparedStatement commInsertRetiro = con.prepareStatement("insert into retiros(idCuenta,monto,folio,contrasena,disponible) value(?,?,?,?,?)",
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

    /**
     * Consulta el historial de todos los movimientos de cierta cuenta
     * 
     * @param cuenta Cuenta a la que se le consulta los movimientos
     * @return Una lista con todos los movimientos
     * @throws PersistenciaException En caso de que haya algun error
     */
    @Override
    public List<MovimientoHistorial> hisotrialMovimientos(Cuenta cuenta) throws PersistenciaException {
        ArrayList<MovimientoHistorial> historial = new ArrayList<>();
        try (
                Connection con = this.generadorConexiones.crearConexion(); PreparedStatement commSR = con.prepareStatement(
                "select R.id,R.idCuenta,C.numCuenta,R.monto,R.folio,R.disponible,R.fechaRetirado from retiros R "
                + "inner join cuentas C on C.id=R.idCuenta "
                + "WHERE C.id = ? and disponible=\"retirado\""); PreparedStatement commSTransferenciaEnviado = con.prepareStatement(
                        "select T.id,T.idCuentaUsuario,T.idCuentaDestino,C.numCuenta,T.monto,T.fecha from transferencias T"
                        + " inner join cuentas C on C.id=T.idCuentaDestino "
                        + "where T.idCuentaUsuario = ?"); PreparedStatement commSTransferenciaRecivida = con.prepareStatement(
                        "select T.id,T.idCuentaUsuario,C.numCuenta,T.idCuentaDestino,T.monto,T.fecha from transferencias T "
                        + "inner join cuentas C on C.id=T.idCuentaUsuario "
                        + "where T.idCuentaDestino = ?"); PreparedStatement commSDepositos = con.prepareStatement(
                        "select idCuenta,C.numCuenta,fecha,monto from depositos D "
                        + "inner join cuentas C on C.id=D.idCuenta "
                        + "where idCuenta=?");) {

            commSR.setInt(1, cuenta.getId());
            ResultSet resultados = commSR.executeQuery();
            MovimientoHistorial h = null;
            while (resultados.next()) {
                String numCuenta = resultados.getString("numCuenta");
                BigDecimal monto = resultados.getBigDecimal("monto");
                Timestamp fecha = resultados.getTimestamp("fechaRetirado");
                h = new MovimientoHistorial("Retiraste", numCuenta, monto.doubleValue(), fecha);
                historial.add(h);
            }

            commSTransferenciaEnviado.setInt(1, cuenta.getId());
            resultados = commSTransferenciaEnviado.executeQuery();

            while (resultados.next()) {
                String numCuenta = resultados.getString("numCuenta");
                BigDecimal monto = resultados.getBigDecimal("monto");
                Timestamp fecha = resultados.getTimestamp("fecha");
                h = new MovimientoHistorial("Enviaste", numCuenta, monto.doubleValue(), fecha);
                historial.add(h);
            }

            commSTransferenciaRecivida.setInt(1, cuenta.getId());
            resultados = commSTransferenciaRecivida.executeQuery();
            while (resultados.next()) {
                String numCuenta = resultados.getString("numCuenta");
                BigDecimal monto = resultados.getBigDecimal("monto");
                Timestamp fecha = resultados.getTimestamp("fecha");
                h = new MovimientoHistorial("Recibiste", numCuenta, monto.doubleValue(), fecha);
                historial.add(h);
            }

            commSDepositos.setInt(1, cuenta.getId());
            resultados = commSDepositos.executeQuery();
            while (resultados.next()) {
                String numCuenta = resultados.getString("numCuenta");
                BigDecimal monto = resultados.getBigDecimal("monto");
                Timestamp fecha = resultados.getTimestamp("fecha");
                h = new MovimientoHistorial("Deposito", numCuenta, monto.doubleValue(), fecha);
                historial.add(h);
            }

            return historial;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo consultar el historial de movimientos: " + e.getMessage());
            throw new PersistenciaException("No se pudo consultar el historial de movimientos");
        }

    }

    /**
     * Realiza el reterio en la BD
     *
     * @param folio Validar el folio asignado en el retiro
     * @param contrasena Contraseña que debe coinicider con el de la BD
     * @return Verdadero si logró retirarlo, falso en caso contrario
     * @throws PersistenciaException En caso que haya algun error
     */
    @Override
    public boolean procederRetiro(Integer folio, String contrasena) throws PersistenciaException {
        Encriptador en = new Encriptador();
        try (
                Connection con = this.generadorConexiones.crearConexion(); PreparedStatement commSRetiro = con.prepareStatement("select id,idCuenta,monto,fecha,folio,contrasena,disponible,fechaRetirado from retiros where folio = ? and contrasena=?"); PreparedStatement commSCuenta = con.prepareStatement("select id,numCuenta,fechaApertura,saldo,idCliente from cuentas where id=?"); PreparedStatement commUCuenta = con.prepareStatement("update cuentas set saldo=saldo-? where id=?"); PreparedStatement commURetiro = con.prepareStatement("update retiros set disponible=\"retirado\", fechaRetirado = curtime() where id=?");) {
            commSRetiro.setInt(1, folio);
            commSRetiro.setString(2, en.encriptar(contrasena));
            ResultSet resultado = commSRetiro.executeQuery();
            Retiros retiro = null;
            if (resultado.next()) {
                retiro = new Retiros(
                        resultado.getInt("id"),
                        resultado.getInt("idCuenta"),
                        resultado.getBigDecimal("monto").doubleValue(),
                        resultado.getInt("folio"),
                        resultado.getString("contrasena"),
                        resultado.getString("disponible"),
                        resultado.getTimestamp("fechaRetirado"),
                        resultado.getTimestamp("fecha"));
            } else {
                throw new PersistenciaException("Folio o contrasena incoerentes");
            }
            Timestamp curdateTime = Timestamp.valueOf(LocalDateTime.now());
            long restaMilisegundos = curdateTime.getTime() - retiro.getFechaGenerada().getTime();
            long minutos = restaMilisegundos / (60 * 1000);
            System.out.println("MINUTOS: " + minutos);
            if (minutos > 10.0) {
                throw new PersistenciaException("Excedio el limite de tiempo");
            }
            if (retiro.getDisponible().compareTo("cancelado") == 0 || retiro.getDisponible().compareTo("retirado") == 0) {
                throw new PersistenciaException("Retiro no disponible");
            }
            commSCuenta.setInt(1, retiro.getCuenta());
            resultado = commSCuenta.executeQuery();
            double saldo = 0.0;
            if (resultado.next()) {
                saldo = resultado.getBigDecimal("saldo").doubleValue();
            }

            if (saldo < retiro.getMonto()) {
                throw new PersistenciaException("Saldo de cuenta insuficiente");
            }

            commUCuenta.setDouble(1, retiro.getMonto());
            commUCuenta.setInt(2, retiro.getCuenta());
            int cambios = commUCuenta.executeUpdate();

            if (cambios == 0) {
                throw new PersistenciaException("No se pudo proceder el retiro");

            }
            commURetiro.setInt(1, retiro.getId());
            commURetiro.executeUpdate();
            return true;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo proceder el retiro: " + e.getMessage());
            throw new PersistenciaException("No se pudo proceder el retiro");
        }

    }

    
    /**
     * Consulta todas los números de cuenta de el cliente especificado en el parámetro
     *
     * @param cliente Cliente del que se quiere conocer todas las cuentas
     * @return Lista de todos los números de cuenta de tipo String
     * @throws PersistenciaException En caso de que haya algun error
     */
    @Override
    public LinkedList<String> listaCuentas(Cliente cliente) throws PersistenciaException {

        LinkedList<String> listaCuentas = new LinkedList<>();
        String consulta = "SELECT numCuenta FROM Cuentas "
                + "WHERE idCliente = ?";

        try (
                Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(consulta);) {
            comando.setInt(1, cliente.getId());
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                String numCuenta = resultado.getString("numCuenta");
                listaCuentas.add(numCuenta);

            }
            return listaCuentas;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo consultar el historial de movimientos: " + e.getMessage());
        }
        return null;
    }

    /**
     * Consulta la cuenta por su numero de cuenta
     *
     * @param numCuenta Numero de cuenta
     * @return Un objeto de tipo cuenta
     */
    @Override
    public Cuenta consultarCuenta(String numCuenta) {
        String consulta = "SELECT * FROM Cuentas "
                + "WHERE numCuenta = ?";
        try (
                Connection conexion = generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(consulta);) {
            comando.setString(1, numCuenta);
            Cuenta cuenta = null;
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                Integer id = resultado.getInt("id");
                String numCuentaExtraida = resultado.getString("numCuenta");
                Date fechaApertura = resultado.getDate("fechaApertura");
                BigDecimal saldo = resultado.getBigDecimal("saldo");
                Integer idCliente = resultado.getInt("idCliente");
                cuenta = new Cuenta(id, numCuenta, fechaApertura, saldo, idCliente);
                return cuenta;
            }
            LOG.log(Level.WARNING, "Se insertó el cliente pero no se generó id");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

}
