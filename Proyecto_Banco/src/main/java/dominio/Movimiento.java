/**
 * Movimiento.java
 * 15-feb-2023 20:45:18
 */
package dominio;
//importanciones

import java.sql.Timestamp;


/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 * @author Daniel Armando Peña García 000000229185
 */
public class Movimiento {
    
    private Integer cuenta;
    private Timestamp fecha;

    /**
     * Constructor
     * 
     * @param cuenta Cuenta del movimiento
     * @param fecha fecha en la que se realizó el movimiento
     */
    public Movimiento(Integer cuenta, Timestamp fecha) {
        this.cuenta = cuenta;
        this.fecha = fecha;
    }

    /**
     * 
     * @return 
     */
    public Integer getCuenta() {
        return cuenta;
    }

    /**
     * 
     * @param cuenta 
     */
    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * 
     * @return 
     */
    public Timestamp getFecha() {
        return fecha;
    }

    /**
     * 
     * @param fecha 
     */
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Movimiento{" + "cuenta=" + cuenta + ", fecha=" + fecha + '}';
    }
}
