/**
 * Deposito.java
 * 21 feb. 2023 03:18:26
 */
package dominio;
//importanciones

import java.sql.Timestamp;

/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 * @author Daniel Armando Peña García 000000229185
 */
public class Deposito extends Movimiento {

    Integer id;
    double monto;
    Timestamp fecha;

    /**
     * Constructor
     *
     * @param id Id del deposito
     * @param cuenta Cuenta a la que se le deposita
     * @param fecha fecha en la que se le depositó
     * @param monto Monto del deposito
     */
    public Deposito(Integer id, Integer cuenta, Timestamp fecha, double monto) {
        super(cuenta, fecha);
        this.monto = monto;
        this.fecha = fecha;
        this.id = id;
    }

    /**
     * Regresa el id del deposito
     *
     * @return id del deposito
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el id del deposito
     *
     * @param id Id del deposito
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Regresa el monto del deposito
     *
     * @return Monto del deposito
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Establece el monto del deposito
     *
     * @param monto Monto del deposito
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Regresa la fecha del deposito
     *
     * @return Fecha del deposito
     */
    public Timestamp getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del deposito
     *
     * @param fecha Fecha del deposito
     */
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
