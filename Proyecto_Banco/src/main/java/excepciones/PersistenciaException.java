/**
 * PersistenciaException.java
 * 15-feb-2023 19:45:36
 */
package excepciones;

/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 * @author Daniel Armando Peña García 000000229185
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor por defecto
     */
    public PersistenciaException() {
    }

    /**
     * Constructor que indica el mensaje de error
     *
     * @param msj Mensaje de error
     */
    public PersistenciaException(String msj) {
        super(msj);
    }

    /**
     * Constructor que indica el mensaje y el error especifico
     *
     * @param msj Mensaje de error
     * @param thrwbl Error especifico
     */
    public PersistenciaException(String msj, Throwable thrwbl) {
        super(msj, thrwbl);
    }

    /**
     * Constructor que indica el error especifico
     *
     * @param thrwbl Error especifico
     */
    public PersistenciaException(Throwable thrwbl) {
        super(thrwbl);
    }

    /**
     * Constructor que inicializa todos los valores de la clase padre, mensaje 
     *
     * @param msj Mensaje de error
     * @param thrwbl Error especificado
     * @param bln
     * @param bln1
     */
    public PersistenciaException(String msj, Throwable thrwbl, boolean bln, boolean bln1) {
        super(msj, thrwbl, bln, bln1);
    }

}
