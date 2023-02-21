/**
* IDepositoDAO.java
* 21 feb. 2023 03:18:14
*/ 

package interfaces;

import dominio.Cuenta;
import dominio.Deposito;
import excepciones.PersistenciaException;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface IDepositoDAO {

    /**
     * Ingresa un deposito en la BD a una cuenta en especifica.
     *
     * @param cuenta Cuenta a la que se le hará un deposito
     * @param monto Monto del deposito
     * @return Un objeto de tipo Deposito
     * @throws PersistenciaException En caso de que haya un error
     */
    Deposito ingresarDeposito(Cuenta cuenta, double monto) throws PersistenciaException;
}
