/**
 * Transferencia.java
 * 15-feb-2023 20:44:47
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
public class Transferencia extends Movimiento {

    private Integer id;
    private Integer cuentaEntrada;
    private double monto;

    public Transferencia(Integer id, Integer cuentaSalida,
            Integer cuentaEntrada, double monto, Timestamp fecha) {
        
        super(cuentaSalida, fecha);
        
        this.id = id;
        this.cuentaEntrada = cuentaEntrada;
        this.monto = monto;
    }

    public Transferencia(Integer cuentaSalida, Integer cuentaEntrada, 
            double monto, Timestamp fecha) {
        super(cuentaSalida, fecha);
        
        this.cuentaEntrada = cuentaEntrada;
        this.monto = monto;
    }

    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Integer getCuentaEntrada() {
        return cuentaEntrada;
    }

    public void setCuentaEntrada(Integer cuentaEntrada) {
        this.cuentaEntrada = cuentaEntrada;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "id=" + id + ", cuentaEntrada=" + cuentaEntrada + ", monto=" + monto + '}';
    }
    
}
