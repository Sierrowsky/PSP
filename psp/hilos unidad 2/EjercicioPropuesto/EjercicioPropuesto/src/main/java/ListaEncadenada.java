
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a21pablosp
 */
class ListaEncadenada {
    List<Persona> lista = Collections.synchronizedList(new LinkedList<>());

    public void insertar(Persona persona) {
        lista.add(persona);
    }

}
