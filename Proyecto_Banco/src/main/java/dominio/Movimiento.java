/**
 * Movimiento.java
 * 15-feb-2023 20:45:18
 */
package dominio;
//importanciones

import java.sql.Date;
import java.time.LocalDate;


/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Movimiento {
    
    private Integer cuenta;
    private Date fecha;

    public Movimiento(Integer cuenta, Date fecha) {
        this.cuenta = cuenta;
        this.fecha = fecha;
    }

    public Integer getCuenta() {
        return cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "cuenta=" + cuenta + ", fecha=" + fecha + '}';
    }
    
    
    
    
    
}
