/**
 * Retiros.java
 * 15-feb-2023 20:35:11
 */
package dominio;
//importanciones

import java.sql.Date;
import java.time.LocalDate;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Retiros extends Movimiento {

    private Integer id;
    private String idCuenta;
    private double monto;
    private Date fechaGenerada;
    private Integer folio;
    private String contrasena;
    private String disponible;
    private Date fechaRetirado;

    public Retiros(Integer id, String idCuenta, double monto, Integer folio,
            String contrasena, String disponible, Date fechaRetirado,
            Date fechaGenerada) {

        super(idCuenta, fechaRetirado);
        this.id = id;
        this.idCuenta = idCuenta;
        this.monto = monto;
        this.fechaGenerada = fechaGenerada;
        this.folio = folio;
        this.contrasena = contrasena;
        this.disponible = disponible;
        this.fechaRetirado = fechaRetirado;
    }

    public Retiros(String idCuenta, double monto, Integer folio, 
            String contrasena, String disponible, Date fechaRetirado, 
            Date fechaGenerada) {
        
        super(idCuenta, fechaRetirado);
        this.idCuenta = idCuenta;
        this.monto = monto;
        this.fechaGenerada = fechaGenerada;
        this.folio = folio;
        this.contrasena = contrasena;
        this.disponible = disponible;
        this.fechaRetirado = fechaRetirado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechaGenerada() {
        return fechaGenerada;
    }

    public void setFechaGenerada(Date fechaGenerada) {
        this.fechaGenerada = fechaGenerada;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public Date getFechaRetirado() {
        return fechaRetirado;
    }

    public void setFechaRetirado(Date fechaRetirado) {
        this.fechaRetirado = fechaRetirado;
    }

}
