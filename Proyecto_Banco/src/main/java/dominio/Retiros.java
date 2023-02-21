/**
 * Retiros.java
 * 15-feb-2023 20:35:11
 */
package dominio;
//importanciones

import java.sql.Timestamp;

/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 * @author Daniel Armando Peña García 000000229185
 */
public class Retiros extends Movimiento {

    private Integer id;
    private double monto;
    private Timestamp fechaGenerada;
    private Integer folio;
    private String contrasena;
    private String disponible;
    private Timestamp fechaRetirado;

    /**
     * Constructor
     * 
     * @param id Id del retiro
     * @param cuenta Cuenta a la que se le realiza el retiro
     * @param monto Monto del retiro
     * @param folio Folio del retiro
     * @param contrasena Contraseña del retiro
     * @param disponible Disponibilidad del retiro
     * @param fechaRetirado Fecha en la que se retiro
     * @param fechaGenerada Fecha en la que se generó el retiro
     */
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

    /**
     * 
     * @param cuenta Cuenta a la que se le realiza el retiro
     * @param monto Monto del retiro
     * @param folio Folio del retiro
     * @param contrasena Contraseña del retiro
     * @param disponible Disponibilidad del retiro
     * @param fechaRetirado Fecha en la que se retiro
     * @param fechaGenerada Fecha en la que se generó el retiro
     */
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
    
    /**
     * Regresa el id del retiro
     * 
     * @return El id del retiro
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el id del retiro
     * 
     * @param id Id del retiro
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Regresa el monto del retiro
     * 
     * @return Monto del retiro
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Establece el monto del retiro
     * 
     * @param monto Monto del retiro
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Regresa la fecha en la que se solicita el retiro
     * 
     * @return La fecha en la que se solicita el retiro
     */
    public Timestamp getFechaGenerada() {
        return fechaGenerada;
    }

    /**
     * Establece la fecha en la que se solicita el retiro
     * 
     * @param fechaGenerada Fecha en la que se solicita el retiro
     */
    public void setFechaGenerada(Timestamp fechaGenerada) {
        this.fechaGenerada = fechaGenerada;
    }

    /**
     * Regresa el folio del retiro
     * 
     * @return El folio del retiro
     */
    public Integer getFolio() {
        return folio;
    }

    /**
     * Establece el folio del retiro
     * 
     * @param folio Folio del retiro
     */
    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    /**
     * Regresa la contraseña del retiro
     * 
     * @return la contraseña del retiro
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del retiro
     * 
     * @param contrasena la contraseña del retiro
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Regresa la dispoibilidad del retiro
     * 
     * @return Disponibilidad del retiro
     */
    public String getDisponible() {
        return disponible;
    }

    /**
     * Establece la dispoibilidad del retiro
     * 
     * @param disponible la dispoibilidad del retiro
     */
    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    /**
     * Regresa la fecha del retiro
     * 
     * @return La fecha del retiro
     */
    public Timestamp getFechaRetirado() {
        return fechaRetirado;
    }

    /**
     * Establece la fecha del retiro
     * 
     * @param fechaRetirado la fecha del retiro
     */
    public void setFechaRetirado(Timestamp fechaRetirado) {
        this.fechaRetirado = fechaRetirado;
    }

    /**
     * Regresa una cadena de atributos del Retiro
     * 
     * @return Una cadena de atributos del Retiro
     */
    @Override
    public String toString() {
        return "Retiros{" + "id=" + id + ", monto=" + monto + ", fechaGenerada=" + fechaGenerada + ", folio=" + folio + ", contrasena=" + contrasena + ", disponible=" + disponible + ", fechaRetirado=" + fechaRetirado + '}';
    }

}
