/**
* Cliente.java
* 15-feb-2023 19:38:58
*/ 

package dominio;
//importanciones

import java.time.LocalDate;

/**
 * Descripción de la clase: 
 * 
 * @author Edgar Emir Borbon Jimenez
 */
public class Cliente {
    
    private Integer id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private String celular;
    private String contrasena;
    private int edad;

    

    public Cliente(Integer id, String nombre, String apellidoPaterno, 
            String apellidoMaterno, LocalDate fechaNacimiento, String celular, 
            String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.contrasena = contrasena;
    }

    public Cliente(String nombre, String apellidoPaterno, 
            String apellidoMaterno, LocalDate fechaNacimiento, 
            String celular) {
        
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
    }
    
    public void calcularEdad(LocalDate fechaNacimiento){
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
