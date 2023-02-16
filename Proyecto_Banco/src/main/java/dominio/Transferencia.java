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
    private String idCuentaSalida;
    private String idCuentaEntrada;
    private double monto;

    public Transferencia(Integer id, String idCuentaSalida,
            String idCuentaEntrada, double monto, LocalDate fecha,
            String idCuenta) {
        
        super(idCuenta, fecha);
        
        this.id = id;
        this.idCuentaSalida = idCuentaSalida;
        this.idCuentaEntrada = idCuentaEntrada;
        this.monto = monto;
    }

    public Transferencia(String idCuentaSalida, String idCuentaEntrada, 
            double monto, String idCuenta, LocalDate fecha) {
        super(idCuenta, fecha);
        
        this.idCuentaSalida = idCuentaSalida;
        this.idCuentaEntrada = idCuentaEntrada;
        this.monto = monto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdCuentaSalida() {
        return idCuentaSalida;
    }

    public void setIdCuentaSalida(String idCuentaSalida) {
        this.idCuentaSalida = idCuentaSalida;
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
