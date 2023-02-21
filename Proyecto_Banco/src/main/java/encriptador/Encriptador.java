/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encriptador;

/**
 *
 * @author Edgar Emir Borbon Jimenez 00000233184
 */
public class Encriptador {

    public Encriptador() {
    }

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
