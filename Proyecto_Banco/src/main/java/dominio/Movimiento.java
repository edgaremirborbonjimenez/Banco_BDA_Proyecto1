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
     * Regresa la cuenta del movimiento
     *
     * @return La cuenta del movimiento
     */
    public Integer getCuenta() {
        return cuenta;
    }

    /**
     * Establece la cuenta del movimiento
     *
     * @param cuenta La cuenta del movimiento
     */
    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Regresa la fecha del movimiento
     *
     * @return La fecha del movimiento
     */
    public Timestamp getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del movimiento
     *
     * @param fecha Fecha del movimiento
     */
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    /**
     * Regresa cadena de atributos del movimiento
     *
     * @return Cadena de atributos del movimiento
     */
    @Override
    public String toString() {
        return "Movimiento{" + "cuenta=" + cuenta + ", fecha=" + fecha + '}';
    }
}
