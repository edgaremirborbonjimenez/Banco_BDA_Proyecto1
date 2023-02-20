/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.sql.Date;
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

    public MovimientoHistorial() {
    }

    public MovimientoHistorial(String tipo, String numCuenta, Double monto, Timestamp fecha) {
        this.tipo = tipo;
        this.numCuenta = numCuenta;
        this.monto = monto;
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    
    
    
}
