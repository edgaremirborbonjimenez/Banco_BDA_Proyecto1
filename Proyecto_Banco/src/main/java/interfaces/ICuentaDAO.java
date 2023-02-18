
package interfaces;

import dominio.Cliente;
import dominio.Cuenta;
import dominio.Movimiento;
import dominio.Retiros;
import dominio.Transferencia;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 */
public interface ICuentaDAO {

    Cuenta generarCuenta(Cliente cliente) throws PersistenciaException;
    List<Cuenta> consultarCuentas() throws PersistenciaException;
    Transferencia tranferencia(Cuenta cuentaUsario,Cuenta cuentaDestino,double monto) throws PersistenciaException;
    Retiros generarRetiro(Cuenta cuenta,double monto,String contrasena) throws PersistenciaException;
    List<Movimiento> hisotrialMovimientos()throws PersistenciaException;
}
