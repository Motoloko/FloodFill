/*
    Clase que se va a encargar de comunicar a cada cuadro en el mapa
 */

package floodfill;

import java.util.Random;

public class Cuadro {
    // Un 0 indica que no existen elementos en esa posicion
    public int arriba, abajo, derecha, izquierda, valor, color;
    Random rnd = new Random();
    
    Cuadro(){
        //Asignar un valor aleatorio
        valor = (rnd.nextInt(4) + 1);
        System.out.print(valor + " ");
    }
    
    public void mostrarVecinos(){
        System.out.println("Arriba: " + arriba);
        System.out.println("Abajo: " + abajo);
        System.out.println("Izquierda: " + izquierda);
        System.out.println("Derecha: " + derecha);
    }
}
