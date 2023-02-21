
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
     * Genera un retiro a nombre de una cuenta, asignando un monto que va a
     * retirar y una contraseña
     *
     * @param cuenta A la cuenta que se le va a retirar
     * @param monto Monto que se va a retirar
     * @param contrasena Contraseña que se le asigna
     * @return Un objeto de tipo Retiro
     * @throws PersistenciaException En caso de que haya algun error
     */
    Retiros generarRetiro(Cuenta cuenta,double monto,String contrasena) throws PersistenciaException;
    /**
     * Consulta el historial de todos los movimientos de cierta cuenta
     * 
     * @param cuenta Cuenta a la que se le consulta los movimientos
     * @return Una lista con todos los movimientos
     * @throws PersistenciaException En caso de que haya algun error
     */
    List<MovimientoHistorial> hisotrialMovimientos(Cuenta cuenta)throws PersistenciaException;
    
    /**
     * Realiza el reterio en la BD
     *
     * @param folio Validar el folio asignado en el retiro
     * @param contrasena Contraseña que debe coinicider con el de la BD
     * @return Verdadero si logró retirarlo, falso en caso contrario
     * @throws PersistenciaException En caso que haya algun error
     */
    boolean procederRetiro(Integer folio,String contrasena)throws PersistenciaException;
    /**
     * Consulta todas los números de cuenta de el cliente especificado en el parámetro
     *
     * @param cliente Cliente del que se quiere conocer todas las cuentas
     * @return Lista de todos los números de cuenta de tipo String
     * @throws PersistenciaException En caso de que haya algun error
     */
    LinkedList<String> listaCuentas(Cliente cliente) throws PersistenciaException;
    
    /**
     * Consulta la cuenta por su numero de cuenta
     *
     * @param numCuenta Numero de cuenta
     * @return Un objeto de tipo cuenta
     */
    Cuenta consultarCuenta(String numCuenta) throws PersistenciaException;
    
}
