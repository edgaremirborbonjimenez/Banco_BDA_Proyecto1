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

    /**
     * Método que registra a clientes en la BD
     *
     * @param cliente Cliente que se va a registrar
     * @return Cliente que se registó
     * @throws PersistenciaException En caso de que haya un posible error
     */
    Cliente registrarCliente(Cliente cliente) throws PersistenciaException;

    /**
     * Consulta al cliente dependiendo su número celular
     *
     * @param celular Celular del cliente
     * @return Cliente que se consultó
     * @throws PersistenciaException En caso de que haya un posible error
     */
    Cliente iniciaCliente(String celular) throws PersistenciaException;

    /**
     * Actualiza en la BD el cliente, por su id
     *
     * @param id Id del cliente
     * @param nombre Nuevo nombre del cliente
     * @param apellidoP Nuevo apellido paterno del cliente
     * @param apellidoM Nuevo apellido materno del cliente
     * @return El número de arrenglones alterados
     * @throws PersistenciaException En caso de que haya un posible error
     */
    int actualizarNombreCliente(Integer id, String nombre, String apellidoP, String apellidoM) throws PersistenciaException;

    /**
     * Actualizar la fecha de nacimiento del cliente
     *
     * @param id Id del cliente
     * @param fechaNacimiento Nueva fecha de nacimiento
     * @return Numero de filas afectadas
     * @throws PersistenciaException En caso de que haya un posible error
     */
    int actualizarFechaNacimiento(Integer id, String fechaNacimiento) throws PersistenciaException;

    /**
     * Actualizar el celular del cliente, por su id
     *
     * @param id Id del cliente
     * @param celular Nuevo celular del cliente
     * @return Numero de filas afectadas
     * @throws PersistenciaException En caso de que haya un posible error
     */
    int actualizarCelular(Integer id, String celular) throws PersistenciaException;

    /**
     * Actualiza su contraseña por su id
     *
     * @param id Id del cliente
     * @param contrasena Contraseña nueva
     * @return Numero de filas afectadas
     * @throws PersistenciaException En caso de que haya un posible error
     */
    int actualizarContrasena(Integer id, String contrasena) throws PersistenciaException;

}
