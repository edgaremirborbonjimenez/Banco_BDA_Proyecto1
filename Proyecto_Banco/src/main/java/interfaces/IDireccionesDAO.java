/**
* IDireccionesDAO.java
* 20 feb. 2023 13:05:55
*/ 

package interfaces;

import dominio.Cliente;
import dominio.Direcciones;
import excepciones.PersistenciaException;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface IDireccionesDAO {
    
    Direcciones consultaDireccion(Cliente cliente) throws PersistenciaException;
    Direcciones insertarDireccion(Direcciones direccion) throws PersistenciaException;
}
