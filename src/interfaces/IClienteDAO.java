/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfazesImplementaciones;

import dominio.Cliente;
import excepciones.PersistenciaException;

/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 */
public interface IClienteDAO {

    Cliente registrarCliente(Cliente cliente) throws PersistenciaException;
    Cliente ingresarCliente(Cliente cliente) throws PersistenciaException;
    
    
}
