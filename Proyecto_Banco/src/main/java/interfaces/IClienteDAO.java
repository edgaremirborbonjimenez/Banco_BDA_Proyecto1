/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Cliente;
import excepciones.PersistenciaException;

/**
 *
 * @author Daniel Armando Peña García ID: 229185
 * @author Edgar Emir Borbon Jimenez 00000233184
 */
public interface IClienteDAO {

    Cliente registrarCliente(Cliente cliente) throws PersistenciaException;
    Cliente iniciaCliente(String telefono, String contrasena) throws PersistenciaException;
    int actualizarNombreCliente(Integer id, String nombre, String apellidoP, String apellidoM) throws PersistenciaException;
    int actualizarFechaNacimiento(Integer id, String fechaNacimiento) throws PersistenciaException;
    int actualizarCelular(Integer id, String celular) throws PersistenciaException;
    int actualizarContrasena(Integer id, String contrasena) throws PersistenciaException;
    
}
