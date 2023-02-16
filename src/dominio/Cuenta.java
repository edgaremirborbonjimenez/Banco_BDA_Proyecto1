/**
* Cuenta.java
* 15-feb-2023 19:39:05
*/ 

package dominio;
//importanciones

import java.time.LocalDate;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Cuenta {
    
    private String id;
    private LocalDate fechaApertura;
    private float saldo;
    private Integer idCliente;
    
    
    //Constructor por omisión
    public Cuenta(){
        
    }

    public Cuenta(String id, LocalDate fechaApertura, float saldo, Integer idCliente) {
        this.id = id;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }

    public Cuenta(LocalDate fechaApertura, float saldo, Integer idCliente) {
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

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }    
}
