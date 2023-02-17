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
    Cliente iniciaCliente(Cliente cliente) throws PersistenciaException;
    Cliente actualizarCliente(Cliente cliente) throws PersistenciaException;
    
}
