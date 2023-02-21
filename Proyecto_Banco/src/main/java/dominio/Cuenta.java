/**
* Cuenta.java
* 15-feb-2023 19:39:05
*/ 

package dominio;
//importanciones

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 * @author Daniel Armando Peña García 000000229185
 */
public class Cuenta {
private Integer id;
private String numCuenta;
private Date fechaApertura;
private BigDecimal saldo;
private Integer idCliente;
    
    /**
     * Constructor por defecto
     */
    public Cuenta(){

    }

    /**
     * Constructor
     * 
     * @param id Id de la cuenta
     * @param numCuenta Numero de la cuenta
     * @param fechaApertura Fecha en la que se abrió la cuenta
     * @param saldo Saldo de la cuenta
     * @param idCliente id del cliente
     */
    public Cuenta(Integer id,String numCuenta, Date fechaApertura, BigDecimal saldo, Integer idCliente) {
        this.id = id;
        this.numCuenta = numCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }

    /**
     * Constructor
     * 
     * @param numCuenta Numero de la cuenta
     * @param fechaApertura Fecha en la que se abrió la cuenta
     * @param saldo Saldo de la cuenta
     * @param idCliente id del cliente
     */
    public Cuenta(String numCuenta, Date fechaApertura, BigDecimal saldo, Integer idCliente) {
        this.numCuenta = numCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }
    
    /**
     * Regresa el id de la cuenta
     * 
     * @return Id de la cuenta
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el id de la cuenta
     * 
     * @param id Id de la cuenta
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Regresa la fecha de apertura
     * 
     * @return Fecha de apertura
     */
    public Date getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Establece la fecha de apertura
     * 
     * @param fechaApertura Fecha de apertura
     */
    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Regresa el saldo de la cuenta
     * 
     * @return saldo de la cuenta
     */
    public BigDecimal getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo de la cuenta
     * 
     * @param saldo Saldo de la cuenta
     */
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    /**
     * Regresa el id del cliente
     * 
     * @return Id del cliente
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el id del cliente
     * 
     * @param idCliente Id del cliente
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Regresa el numero de la cuenta
     * 
     * @return Numero de la cuenta
     */
    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * Establece el número de la cuenta
     * 
     * @param numCuenta Número de la cuenta
     */
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    /**
     * Regresa una cadena de atributos de la cuenta
     * 
     * @return Cadena de atributos de la cuenta
     */
    @Override
    public String toString() {
        return "Cuenta{" + "id=" + id + ", numCuenta=" + numCuenta + ", fechaApertura=" + fechaApertura + ", saldo=" + saldo + ", idCliente=" + idCliente + '}';
    }

    
}
