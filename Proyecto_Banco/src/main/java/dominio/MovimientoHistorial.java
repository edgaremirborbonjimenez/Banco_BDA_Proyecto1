package dominio;

import java.sql.Timestamp;

/**
 *
 * @author trinu
 */
public class MovimientoHistorial {

    String tipo;
    String numCuenta;
    Double monto;
    Timestamp fecha;

    /**
     * Constructor por defecto
     */
    public MovimientoHistorial() {
    }

    /**
     * Constructor
     *
     * @param tipo Tipo de movimiento
     * @param numCuenta numero de cuenta a la que se realizó el movimiento
     * @param monto Monto que se manejó en el movimiento
     * @param fecha Fecha en la que se realizó el movimiento
     */
    public MovimientoHistorial(String tipo, String numCuenta, Double monto, Timestamp fecha) {
        this.tipo = tipo;
        this.numCuenta = numCuenta;
        this.monto = monto;
        this.fecha = fecha;
    }

    /**
     * Regresa el tipo del movimiento
     *
     * @return El tipo del movimiento
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo del movimiento
     *
     * @param tipo Tipo del movimiento
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Regresa el numero de cuenta a la que se le realizó el movimiento
     *
     * @return El numero de cuenta a la que se le realizó el movimiento
     */
    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * Establece el numero de cuenta
     *
     * @param numCuenta Numero de cuenta
     */
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    /**
     * Regresa el monto del movimiento
     *
     * @return El monto del movimiento
     */
    public Double getMonto() {
        return monto;
    }

    /**
     * Establece el monto del movimiento
     *
     * @param monto Monto del movimiento
     */
    public void setMonto(Double monto) {
        this.monto = monto;
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
     * @param fecha La fecha del movimiento
     */
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    /**
     * Regresa una cadena de atributos del movimiento
     *
     * @return Una cadena de atributos del movimiento
     */
    @Override
    public String toString() {
        return "MovimientoHistorial{" + "tipo=" + tipo + ", numCuenta=" + numCuenta + ", monto=" + monto + ", fecha=" + fecha + '}';
    }
}
