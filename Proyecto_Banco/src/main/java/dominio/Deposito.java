/**
* Deposito.java
* 21 feb. 2023 03:18:26
*/ 

package dominio;
//importanciones

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Deposito extends Movimiento{

    Integer id;
    BigDecimal monto;
    Timestamp fecha;

    public Deposito(Integer id, Integer cuenta, Timestamp fecha, BigDecimal monto) {
        super(cuenta, fecha);
        this.monto = monto;
        this.fecha = fecha;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    
}
