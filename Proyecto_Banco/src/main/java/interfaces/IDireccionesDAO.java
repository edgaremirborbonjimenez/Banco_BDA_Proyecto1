/**
* IDireccionesDAO.java
* 20 feb. 2023 13:05:55
*/ 

package interfaces;

import dominio.Direcciones;
import excepciones.PersistenciaException;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface IDireccionesDAO {
    
    /**
     * Ingresa en la BD una direccion
     * 
     * @param direccion Direccion
     * @return Un objeto de tipo Direccion
     * @throws PersistenciaException En caso de que haya algun error
     */
    Direcciones insertarDireccion(Direcciones direccion) throws PersistenciaException;
}
