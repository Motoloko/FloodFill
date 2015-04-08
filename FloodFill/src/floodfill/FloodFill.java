/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floodfill;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Gerardo
 */
public class FloodFill extends JApplet implements ActionListener {

    Cuadro matrizCuadro[][] = new Cuadro[12][12];
    Cuadro cucuadro = new Cuadro();
    int[][] mat2= new int[12][12];
    public JButton[][] tablero = new JButton[12][12];
    public JPanel ventana = new JPanel();
    //Color unno = new Color(Color.yellow);
    FloodFill() {
        System.out.println("Creando mapa");    

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                matrizCuadro[i][j] = new Cuadro();
                tablero[i][j] = new JButton();
                if (matrizCuadro[i][j].valor == 1) {
                    tablero[i][j].setBackground(Color.yellow);
                }
                if (matrizCuadro[i][j].valor == 2) {
                    tablero[i][j].setBackground(Color.white);
                }
                if (matrizCuadro[i][j].valor == 3) {
                    tablero[i][j].setBackground(Color.black);
                }
                if (matrizCuadro[i][j].valor == 4) {
                    tablero[i][j].setBackground(Color.red);
                }
            }
            System.out.println("");
        }
        actualizarCuadros();
    }
    
    void actualizarCuadros() {
        //Esta funcion debera de decirle a cada cuadrito que cuadros estan cerca de el

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                // Primer fila
                if (i == 0) {
                    matrizCuadro[i][j].arriba = 0;
                    matrizCuadro[i][j].abajo = matrizCuadro[i + 1][j].valor;
                }

                if (i == 11) {
                    matrizCuadro[i][j].abajo = 0;
                    matrizCuadro[i][j].arriba = matrizCuadro[i - 1][j].valor;
                }

                if (j == 0) {
                    matrizCuadro[i][j].izquierda = 0;
                    matrizCuadro[i][j].derecha = matrizCuadro[i][j + 1].valor;
                }

                if (j == 11) {
                    matrizCuadro[i][j].derecha = 0;
                    matrizCuadro[i][j].izquierda = matrizCuadro[i][j - 1].valor;
                }

                if (i > 0 && i < 11 && j > 0 && j < 11) {
                    matrizCuadro[i][j].arriba = matrizCuadro[i - 1][j].valor;
                    matrizCuadro[i][j].abajo = matrizCuadro[i + 1][j].valor;
                    matrizCuadro[i][j].izquierda = matrizCuadro[i][j - 1].valor;
                    matrizCuadro[i][j].derecha = matrizCuadro[i][j + 1].valor;
                }

            }
        }

    }

    public void agregar() {
        setLayout(new BorderLayout());
        ventana.setLayout(new BorderLayout());

        ventana.setLayout(new GridLayout(12, 12));

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                ventana.add(tablero[i][j]);

            }
        }

        add("Center", ventana);

    }
<<<<<<< HEAD
//
=======
    
    //Cambia los valores del boton
    void cambiarNumeros(){
        for(int i=0 ; i<12; i++){
            for(int j=0; j<12; j++){
                tablero[i][j].setText(String.valueOf(mat2[i][j]));
            }
        }
    }
    
    void reEnum(){
        int numActual = 1;
        mat2[0][0] = 1;
        //Solo primera linea
        for(int i=1 ; i < 12 ; i++){
            //es el mismo que a la izquierda
            if(matrizCuadro[0][i].valor == matrizCuadro[0][i-1].valor)
            {
                mat2[0][i] = numActual;
            }
            else
            {
                numActual++;
                mat2[0][i] = numActual;
            }
        }
        
        //apartir de la 2da linea
        for(int i=1; i<12;i++){
            for(int j=0; j<12; j++){
                int error = 0;
                //Revisar a la izquierda
                if(j>0){
                    if(matrizCuadro[i][j].valor == matrizCuadro[i][j-1].valor){
                        mat2[i][j] = mat2[i][j-1];
                    }
                    else
                        error++;
                }
                
                //revisar arriba
                if(matrizCuadro[i][j].valor == matrizCuadro[i-1][j].valor){
                    mat2[i][j] = mat2[i-1][j];
                }
                else{
                    if(j==0){
                        numActual++;
                        mat2[i][j] = numActual;
                    }
                    else
                        error++;
                }
                
                if(error > 1){
                        numActual++;
                        mat2[i][j] = numActual;
                    }
                
            }
        }
        
        cambiarNumeros();
    }
    
>>>>>>> origin/master
    public static void main(String[] args) {
        FloodFill flood = new FloodFill();
        JFrame marco = new JFrame("Flood FIll");
        // Ejemplo donde muestra cuales son los vecinos del ultimo elemento
        flood.matrizCuadro[11][11].mostrarVecinos();
        flood.agregar();

        JFrame.setDefaultLookAndFeelDecorated(true);
        marco.getContentPane().add(flood, BorderLayout.CENTER);
        marco.setBounds(0, 0, 700, 700);
        marco.setLocationRelativeTo(null);
        marco.setResizable(false);
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        flood.reEnum();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
