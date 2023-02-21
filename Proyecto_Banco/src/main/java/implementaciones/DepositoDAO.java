/**
* DepositoDAO.java
* 21 feb. 2023 03:26:21
*/ 

package implementaciones;
//importanciones

import dominio.Deposito;
import excepciones.PersistenciaException;
import interfaces.IDepositoDAO;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class DepositoDAO implements IDepositoDAO{

    //Constructor por omisión
    public DepositoDAO(){

    }

    @Override
    public Deposito ingresarDeposito(String monto) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Deposito consultarDeposito(Deposito deposito) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
