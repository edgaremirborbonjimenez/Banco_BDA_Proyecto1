/**
 * Domicilio.java
 * 20 feb. 2023 13:02:45
 */
package dominio;
//importanciones

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Direcciones {

    private Integer id;
    private String calle;
    private String colonia;
    private String numExterior;

    public Direcciones(Integer id, String calle, String colonia, String numExterior) {
        this.id = id;
        this.calle = calle;
        this.colonia = colonia;
        this.numExterior = numExterior;
    }

    public Direcciones(String calle, String colonia, String numExterior) {
        this.calle = calle;
        this.colonia = colonia;
        this.numExterior = numExterior;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumExterior() {
        return numExterior;
    }

    public void setNumExterior(String numExterior) {
        this.numExterior = numExterior;
    }

    @Override
    public String toString() {
        return "Domicilio{" + "id=" + id + ", calle=" + calle + ", colonia=" + colonia + ", numExterior=" + numExterior + '}';
    }
}
