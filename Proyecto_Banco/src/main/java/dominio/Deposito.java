/**
* Deposito.java
* 21 feb. 2023 03:18:26
*/ 

package dominio;
//importanciones

import java.sql.Timestamp;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Deposito extends Movimiento{

    Integer id;
    double monto;
    Timestamp fecha;

    public Deposito(Integer id, Integer cuenta, Timestamp fecha, double monto) {
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    
}
