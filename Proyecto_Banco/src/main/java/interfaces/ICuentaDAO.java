
package interfaces;

import dominio.Cliente;
import dominio.Cuenta;
import dominio.Movimiento;
import dominio.MovimientoHistorial;
import dominio.Retiros;
import dominio.Transferencia;
import excepciones.PersistenciaException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 */
public interface ICuentaDAO {

    Cuenta generarCuenta(Cliente cliente, double montoInicial) throws PersistenciaException;
    List<Cuenta> consultarCuentas() throws PersistenciaException;
    Transferencia tranferencia(Cuenta cuentaUsario,Cuenta cuentaDestino,double monto) throws PersistenciaException;
    Retiros generarRetiro(Cuenta cuenta,double monto,String contrasena) throws PersistenciaException;
    List<MovimientoHistorial> hisotrialMovimientos(Cuenta cuenta)throws PersistenciaException;
    DefaultComboBoxModel<Cuenta> listaCuentas(Cliente cliente) throws PersistenciaException;
}
