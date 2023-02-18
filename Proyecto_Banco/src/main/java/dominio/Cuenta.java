/**
* Cuenta.java
* 15-feb-2023 19:39:05
*/ 

package dominio;
//importanciones

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Cuenta {
private Integer id;
private String numCuenta;
private Date fechaApertura;
private BigDecimal saldo;
private Integer idCliente;
    //Constructor por omisión
    public Cuenta(){

    }

    public Cuenta(Integer id,String numCuenta, Date fechaApertura, BigDecimal saldo, Integer idCliente) {
        this.id = id;
        this.numCuenta = numCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }

    public Cuenta(String numCuenta, Date fechaApertura, BigDecimal saldo, Integer idCliente) {
        this.numCuenta = numCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "id=" + id + ", numCuenta=" + numCuenta + ", fechaApertura=" + fechaApertura + ", saldo=" + saldo + ", idCliente=" + idCliente + '}';
    }

    
}
