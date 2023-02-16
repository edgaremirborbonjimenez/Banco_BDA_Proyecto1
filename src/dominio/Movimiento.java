/**
 * Movimiento.java
 * 15-feb-2023 20:45:18
 */
package dominio;
//importanciones

import java.time.LocalDate;


/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Movimiento {
    
    private String idCuenta;
    private LocalDate fecha;

    public Movimiento(String idCuenta, LocalDate fecha) {
        this.idCuenta = idCuenta;
        this.fecha = fecha;
    }
    
    
    
    
}
