
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author a21pablosp
 */
public class main {
    public static void main(String[] args) {
        String[] ficheros = {"FICHERO1.txt", "FICHERO2.txt", "FICHERO3.txt","FICHERO4.txt"}; // Puedes ajustar la lista de ficheros
        ListaEncadenada listaEncadenada = new ListaEncadenada();
        List<Thread> hilosLectores = new LinkedList<>();

        for (String fichero : ficheros) {
            Thread hilo = new Thread(new HiloLector(fichero, listaEncadenada));
            hilosLectores.add(hilo);
            hilo.start();
        }

        for (Thread hilo : hilosLectores) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Aquí puedes volcar la lista encadenada en un nuevo fichero
        try (FileWriter fw = new FileWriter("output.txt")) {
            for (Persona persona : listaEncadenada.lista) {
                fw.write(persona.longitud + " " + persona.iniciales + " " + persona.cadena + "\n");
                System.out.println(persona.longitud + " " + persona.iniciales + " " + persona.cadena );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

