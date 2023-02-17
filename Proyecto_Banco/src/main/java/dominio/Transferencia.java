/**
 * Transferencia.java
 * 15-feb-2023 20:44:47
 */
package dominio;
//importanciones

import java.time.LocalDate;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Transferencia extends Movimiento {

    private Integer id;
    private String idCuentaEntrada;
    private double monto;

    public Transferencia(Integer id, String idCuentaSalida,
            String idCuentaEntrada, double monto, Long fecha) {
        
        super(idCuentaSalida, fecha);
        
        this.id = id;
        this.idCuentaEntrada = idCuentaEntrada;
        this.monto = monto;
    }

    public Transferencia(String idCuentaSalida, String idCuentaEntrada, 
            double monto, Long fecha) {
        super(idCuentaSalida, fecha);
        
        this.idCuentaEntrada = idCuentaEntrada;
        this.monto = monto;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getIdCuentaEntrada() {
        return idCuentaEntrada;
    }

    public void setIdCuentaEntrada(String idCuentaEntrada) {
        this.idCuentaEntrada = idCuentaEntrada;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
}
