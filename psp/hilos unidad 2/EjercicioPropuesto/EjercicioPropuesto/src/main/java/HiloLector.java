
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author a21pablosp
 */
class HiloLector implements Runnable {
    String fichero;
    ListaEncadenada listaEncadenada;

    public HiloLector(String fichero, ListaEncadenada listaEncadenada) {
        this.fichero = fichero;
        this.listaEncadenada = listaEncadenada;
    }

    @Override
    public void run() {
        procesarFichero();
    }

    private void procesarFichero() {
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String cadena = linea.trim();
                int longitud = cadena.length();
                String iniciales = (longitud > 0) ? cadena.substring(0, 1) : "";

                Persona persona = new Persona(longitud, iniciales, cadena);
                listaEncadenada.insertar(persona);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
