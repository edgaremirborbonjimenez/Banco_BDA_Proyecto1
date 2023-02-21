/**
* Cliente.java
* 15-feb-2023 19:38:58
*/ 

package dominio;
//importanciones

import java.sql.Date;



/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 * @author Daniel Armando Peña García 000000229185
 */
public class Cliente {
    
    private Integer id;
    private Integer idDireccion;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String celular;
    private String contrasena;
    private int edad;

    /**
     * 
     * @return Una cadena de atributos correspondiente al cliente
     */
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + ", celular=" + celular + ", contrasena=" + contrasena + ", edad=" + edad + '}';
    }

    /**
     * Constructor por defecto
     */
    public Cliente() {
    }

    /**
     * 
     * @param id id del cliente
     * @param nombre nombre del cliente
     * @param apellidoPaterno apellido Paterno del cliente
     * @param apellidoMaterno apellido Materno del cliente
     * @param fechaNacimiento fecha de nacimiento del cliente
     * @param celular numero de celular del cliente
     * @param contrasena contraseña del cliente
     * @param idDireccion el id de la direccion del cliente
     */
    public Cliente(Integer id, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String celular, String contrasena, Integer idDireccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.contrasena = contrasena;
        this.idDireccion = idDireccion;
    }

    /**
     * 
     * @param nombre nombre del cliente
     * @param apellidoPaterno apellido Paterno del cliente
     * @param apellidoMaterno apellido Materno del cliente
     * @param fechaNacimiento fecha de nacimiento del cliente
     * @param celular numero de celular del cliente
     * @param contrasena contraseña del cliente
     * @param idDireccion el id de la direccion del cliente 
     */
    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String celular, String contrasena, Integer idDireccion) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.contrasena = contrasena;
        this.idDireccion = idDireccion;
    }

    /**
     * Regresa la direccion del cliente
     * 
     * @return id de la direccion del cliente
     */
    public Integer getIdDireccion() {
        return idDireccion;
    }

    /**
     * Establece el id de la direccion del cliente
     * 
     * @param idDireccion id de la direccion del cliente
     */
    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }
    
    /**
     * Regresa el id del cliente
     * 
     * @return id del cliente
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el id del cliente
     * 
     * @param id id del cliente
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Regresa el nombre del cliente
     * 
     * @return Nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente
     * 
     * @param nombre Nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa el apellido Paterno del cliente
     * 
     * @return 
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido Paterno del cliente
     * 
     * @param apellidoPaterno Apellido Paterno del cliente
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Regresa apellido Materno del cliente
     * 
     * @return Apellido Materno del cliente
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido Materno del cliente
     * 
     * @param apellidoMaterno Apellido Materno del cliente
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Regresa la fecha de nacimiento del cliente
     * 
     * @return Fecha de nacimiento del cliente
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento
     * 
     * @param fechaNacimiento Fecha de nacimiento 
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Regresa el celular del cliente
     * 
     * @return Celular del cliente
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Establece el celular del cliente
     * 
     * @param celular Celular del cliente
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Regresa la contraseña del cliente
     * 
     * @return Contraseña del cliente
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del cliente
     * 
     * @param contrasena Contraseña del cliente
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
