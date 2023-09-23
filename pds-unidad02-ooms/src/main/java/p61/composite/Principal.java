/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.composite;

/**
 *
 * @author morti
 */
public class Principal {
    
    public static void main(String[] args) {
        var linea1 = new Linea();
        System.out.println(linea1.getPeso());
        linea1.dibujar();
        var triangulo1 = new Triangulo();
        System.out.println(triangulo1.getPeso());
        var dibujo1 = new Dibujo();
        dibujo1.add(linea1);
        dibujo1.add(triangulo1);
        System.out.println(dibujo1.getPeso());
        System.out.println(dibujo1.getHijos().size());
        var circulo1 = new Circulo();
        System.out.println(circulo1.getPeso());
        var dibujo2 = new Dibujo();
        dibujo2.add(circulo1);
        dibujo1.add(dibujo2);

        System.out.println(dibujo1.getPeso());
        
        
        
    }
    
}
