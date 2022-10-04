/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.composite;

/**
 *
 * @author Mauricio Ortiz
 */
 
public class Circulo extends FiguraComponent{

    @Override
    public void dibujar() {
        System.out.println("Dibuja Círculo");
    }

    @Override
    public int getPeso() {
        return 200;
    }
    
}
