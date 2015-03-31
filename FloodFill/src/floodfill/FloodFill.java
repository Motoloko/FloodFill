/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package floodfill;

/**
 *
 * @author Gerardo
 */
public class FloodFill {
    
    Cuadro matrizCuadro [][] = new Cuadro[12][12];
   
    FloodFill(){
        System.out.println("Creando mapa");
        for(int i=0 ; i<12 ; i++){
            for(int j=0 ; j<12 ; j++){
                matrizCuadro[i][j] = new Cuadro();
                
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        FloodFill flood = new FloodFill();
    }
    
}
