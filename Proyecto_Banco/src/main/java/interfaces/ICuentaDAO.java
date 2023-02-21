
package interfaces;

import dominio.Cliente;
import dominio.Cuenta;
import dominio.MovimientoHistorial;
import dominio.Retiros;
import dominio.Transferencia;
import excepciones.PersistenciaException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 */
public interface ICuentaDAO {

    /**
     * Ingresa una cuenta en la BD con respecto al cliente y su id, junto con su
     * monto inicial
     *
     * @param cliente Cliente a la que está afiliada la cuenta
     * @param montoInicial Monto inicial con lo que iniciará la cuenta
     * @return Cuenta que se guardó en la base de datos.
     * @throws PersistenciaException En caso de que haya un error
     */
    Cuenta generarCuenta(Cliente cliente, double montoInicial) throws PersistenciaException;
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
    Transferencia tranferencia(Cuenta cuentaUsuario,Cuenta cuentaDestino,double monto) throws PersistenciaException;
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
    Retiros generarRetiro(Cuenta cuenta,double monto,String contrasena) throws PersistenciaException;
    List<MovimientoHistorial> hisotrialMovimientos(Cuenta cuenta)throws PersistenciaException;
    boolean procederRetiro(Integer folio,String contrasena)throws PersistenciaException;
    LinkedList<String> listaCuentas(Cliente cliente) throws PersistenciaException;
    Cuenta consultarCuenta(String numCuenta) throws PersistenciaException;
    
}
