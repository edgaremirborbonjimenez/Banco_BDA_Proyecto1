/**
* Cuenta.java
* 15-feb-2023 19:39:05
*/ 

package dominio;
//importanciones

import java.sql.Date;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Cuenta {
private String id;
private Date fechaApertura;
private double saldo;
private Integer idCliente;
    //Constructor por omisión
    public Cuenta(){

    }

    public Cuenta(String id, Date fechaApertura, double saldo, Integer idCliente) {
        this.id = id;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    
    
}
