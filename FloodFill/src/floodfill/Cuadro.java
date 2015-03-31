/*
    Clase que se va a encargar de comunicar a cada cuadro en el mapa
 */

package floodfill;

import java.util.Random;

public class Cuadro {
    public int arriba, abajo, derecha, izquierda, valor, color;
    Random rnd = new Random();
    
    Cuadro(){
        //Asignar un valor aleatorio
        valor = (rnd.nextInt(4) + 1);
        System.out.print(valor + " ");
    }
    
    
}
