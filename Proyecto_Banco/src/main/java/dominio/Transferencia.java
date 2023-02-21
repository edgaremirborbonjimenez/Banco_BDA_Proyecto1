/**
 * Transferencia.java
 * 15-feb-2023 20:44:47
 */
package dominio;
//importanciones

import java.sql.Timestamp;

/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 * @author Daniel Armando Peña García 000000229185
 */
public class Transferencia extends Movimiento {

    private Integer id;
    private Integer cuentaEntrada;
    private double monto;

    /**
     * Constructor
     *
     * @param id Id de la transferencia
     * @param cuentaSalida Cuenta de la que sale la transferencia
     * @param cuentaEntrada Cuenta a la que le entra la transferencia
     * @param monto Monto de la transferencia
     * @param fecha Fecha en la que se realizó la transferencia
     */
    public Transferencia(Integer id, Integer cuentaSalida,
            Integer cuentaEntrada, double monto, Timestamp fecha) {

        super(cuentaSalida, fecha);

        this.id = id;
        this.cuentaEntrada = cuentaEntrada;
        this.monto = monto;
    }

    /**
     *
     * @param cuentaSalida Cuenta de la que sale la transferencia
     * @param cuentaEntrada Cuenta a la que le entra la transferencia
     * @param monto Monto de la transferencia
     * @param fecha Fecha en la que se realizó la transferencia
     */
    public Transferencia(Integer cuentaSalida, Integer cuentaEntrada,
            double monto, Timestamp fecha) {
        super(cuentaSalida, fecha);

        this.cuentaEntrada = cuentaEntrada;
        this.monto = monto;
    }

        /**
     * Regresa id de la transferencia
     * 
     * @return id de la transferencia
     */

    public Integer getId() {
        return id;
    }

    /**
     * Establece el id de la transferencia
     * 
     * @param id id de la transferencia
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Regresa la cuenta que recibe la transferencia
     * 
     * @return la cuenta que recibe la transferencia
     */


    public Integer getCuentaEntrada() {
        return cuentaEntrada;
    }

    /**
     * Establece la cuenta que recibe la transferencia
     * 
     * @param cuentaEntrada la cuenta que recibe la transferencia
     */
    public void setCuentaEntrada(Integer cuentaEntrada) {
        this.cuentaEntrada = cuentaEntrada;
    }

    /**
     * Regresa el monto de la transferencia
     * 
     * @return el monto de la transferencia
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Establece el monto de la transferencia
     * 
     * @param monto el monto de la transferencia
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Regresa una cadena de atributos de la transferencia
     * 
     * @return Regresa una cadena de atributos de la transferencia
     */
    @Override
    public String toString() {
        return "Transferencia{" + "id=" + id + ", cuentaEntrada=" + cuentaEntrada + ", monto=" + monto + '}';
    }

}
