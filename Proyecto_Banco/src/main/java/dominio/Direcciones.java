/**
 * Domicilio.java
 * 20 feb. 2023 13:02:45
 */
package dominio;
//importanciones

/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 * @author Daniel Armando Peña García 000000229185
 */
public class Direcciones {

    private Integer id;
    private String calle;
    private String colonia;
    private String numExterior;

    /**
     * Constructor
     * 
     * @param id Id de la direccion
     * @param calle nombre de la calle
     * @param colonia nombre de la colonia
     * @param numExterior numero exterior
     */
    public Direcciones(Integer id, String calle, String colonia, String numExterior) {
        this.id = id;
        this.calle = calle;
        this.colonia = colonia;
        this.numExterior = numExterior;
    }

    /**
     * Cosntructor
     * 
     * @param calle nombre de la calle
     * @param colonia nombre de la colonia
     * @param numExterior numero exterior 
     */
    public Direcciones(String calle, String colonia, String numExterior) {
        this.calle = calle;
        this.colonia = colonia;
        this.numExterior = numExterior;
    }

    /**
     * Regresa el id de la direccion
     * 
     * @return Id de la direccion
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el id de la direccion
     * 
     * @param id Id de la direccion
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Regresa el nombre de la calle
     * 
     * @return El nombre de la calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece el nombre de la calle
     * 
     * @param calle El nombre de la calle
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Regresa el nombre de la colonia
     * 
     * @return El nombre de la colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece el nombre de la colonia
     * 
     * @param colonia El nombre de la colonia
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Regresa el numero exterior
     * 
     * @return El numero exterior
     */
    public String getNumExterior() {
        return numExterior;
    }

    /**
     * Establece el número exterior
     * 
     * @param numExterior Numero exterior
     */
    public void setNumExterior(String numExterior) {
        this.numExterior = numExterior;
    }

    /**
     * Regresa cadena de atributos del domicilio
     * 
     * @return Cadena de atributos del domicilio
     */
    @Override
    public String toString() {
        return "Domicilio{" + "id=" + id + ", calle=" + calle + ", colonia=" + colonia + ", numExterior=" + numExterior + '}';
    }
}
