/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cuenta;
import dominio.Movimiento;
import dominio.Retiros;
import dominio.Transferencia;
import excepciones.PersistenciaException;
import interfazesImplementaciones.IConexionBD;
import interfaces.ICuentaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

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
    public Transferencia generarTranferencia(Cuenta cuentaUsuario,Cuenta cuentaDestino,double monto) throws PersistenciaException {
            double saldo=0.0;

        try (
                 Connection con = this.generadorConexiones.crearConexion();
                PreparedStatement comandoStart = con.prepareStatement("START transaction");
                PreparedStatement comandoSelect = con.prepareStatement("select* from cuentas  where id= ?");
                PreparedStatement comandoUpdate = con.prepareStatement("update cuentas set saldo = saldo + ? where id = ?");
                PreparedStatement comandoSelect2 = con.prepareStatement("select C.id,saldo from cuentas C where C.id= ? and C.saldo=?");
                PreparedStatement comandoRollback = con.prepareStatement("rollback");
                PreparedStatement comandoTransferencia = con.prepareStatement("insert into  transferencias (idCuentaUsuario,idCuentaDestino,monto) value(?,?,?)");
                PreparedStatement comandoCommit = con.prepareStatement("commit");
                ) {
            comandoStart.executeQuery();
            comandoSelect.setString(1, cuentaUsuario.getId());
            return null;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo proceder con la transaccion: " + e.getMessage());
            throw new PersistenciaException("No se pudo proceder con la transaccion");
        }

    }

    @Override
    public Retiros generarRetiro() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Movimiento> hisotrialMovimientos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
