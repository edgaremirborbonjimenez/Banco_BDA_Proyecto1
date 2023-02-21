package encriptador;

/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 * @author Daniel Armando Peña García 000000229185
 */
public class Encriptador {

    /**
     * Constructor por defecto
     */
    public Encriptador() {
    }

    /**
     * Encriptador de textos
     * 
     * @param texto Texto a encriptar
     * @return Texto encriptado
     */
    public String encriptar(String texto) {
        char[] arr = texto.toCharArray();
        String cadena="";
        int num;
        for (int i = 0; i < arr.length; i++) {
            num = (int) arr[i];
            num += 1;
            cadena+=(char)num;
        }
        return cadena;
    }

    /**
     * Desencripta un texto
     * 
     * @param contrasena Texto a desencriptar
     * @return Texto desencriptado
     */
    public String desencriptar(String contrasena) {
        char[] arr = contrasena.toCharArray();
        String cadena="";
        int num;
        for (int i = 0; i < arr.length; i++) {
            num = (int) arr[i];
            num -= 1;
            cadena+=(char)num;
        }
        return cadena;
    }
}
