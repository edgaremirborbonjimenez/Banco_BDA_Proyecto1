/**
* IDepositoDAO.java
* 21 feb. 2023 03:18:14
*/ 

package interfaces;

import dominio.Deposito;
import excepciones.PersistenciaException;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface IDepositoDAO {

    Deposito ingresarDeposito(String monto) throws PersistenciaException;
    Deposito consultarDeposito(Deposito deposito) throws PersistenciaException;
}
