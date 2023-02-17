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
    private Long fecha;

    public Movimiento(String idCuenta, Long fecha) {
        this.idCuenta = idCuenta;
        this.fecha = fecha;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Long getFecha() {
        return fecha;
    }

    public void setFecha(Long fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
}
