/**
 * Movimiento.java
 * 15-feb-2023 20:45:18
 */
package dominio;
//importanciones

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;


/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Movimiento {
    
    private Integer cuenta;
    private Timestamp fecha;

    public Movimiento(Integer cuenta, Timestamp fecha) {
        this.cuenta = cuenta;
        this.fecha = fecha;
    }

    public Integer getCuenta() {
        return cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "cuenta=" + cuenta + ", fecha=" + fecha + '}';
    }
    
    
    
}
