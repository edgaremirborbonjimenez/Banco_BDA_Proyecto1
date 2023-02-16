/**
 * PersistenciaException.java
 * 15-feb-2023 19:45:36
 */
package excepciones;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class PersistenciaException extends Exception {

    /**
     *
     */
    public PersistenciaException() {
    }

    /**
     *
     * @param msj
     */
    public PersistenciaException(String msj) {
        super(msj);
    }

    /**
     *
     * @param msj
     * @param thrwbl
     */
    public PersistenciaException(String msj, Throwable thrwbl) {
        super(msj, thrwbl);
    }

    /**
     *
     * @param thrwbl
     */
    public PersistenciaException(Throwable thrwbl) {
        super(thrwbl);
    }

    /**
     *
     * @param msj
     * @param thrwbl
     * @param bln
     * @param bln1
     */
    public PersistenciaException(String msj, Throwable thrwbl, boolean bln, boolean bln1) {
        super(msj, thrwbl, bln, bln1);
    }

}
