/**
 * Retiros.java
 * 15-feb-2023 20:35:11
 */
package dominio;
//importanciones

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Retiros extends Movimiento {

    private Integer id;
    private double monto;
    private Timestamp fechaGenerada;
    private Integer folio;
    private String contrasena;
    private String disponible;
    private Timestamp fechaRetirado;

    public Retiros(Integer id, Integer cuenta, double monto, Integer folio,
            String contrasena, String disponible, Timestamp fechaRetirado,
            Timestamp fechaGenerada) {

        super(cuenta, fechaRetirado);
        this.id = id;
        this.monto = monto;
        this.fechaGenerada = fechaGenerada;
        this.folio = folio;
        this.contrasena = contrasena;
        this.disponible = disponible;
        this.fechaRetirado = fechaRetirado;
    }

    public Retiros(Integer cuenta, double monto, Integer folio, 
            String contrasena, String disponible, Timestamp fechaRetirado, 
            Timestamp fechaGenerada) {
        
        super(cuenta, fechaRetirado);
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Timestamp getFechaGenerada() {
        return fechaGenerada;
    }

    public void setFechaGenerada(Timestamp fechaGenerada) {
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

    public Timestamp getFechaRetirado() {
        return fechaRetirado;
    }

    public void setFechaRetirado(Timestamp fechaRetirado) {
        this.fechaRetirado = fechaRetirado;
    }

    @Override
    public String toString() {
        return "Retiros{" + "id=" + id + ", monto=" + monto + ", fechaGenerada=" + fechaGenerada + ", folio=" + folio + ", contrasena=" + contrasena + ", disponible=" + disponible + ", fechaRetirado=" + fechaRetirado + '}';
    }

}
