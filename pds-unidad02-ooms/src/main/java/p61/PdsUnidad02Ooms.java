/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package p61;

import p61.adapter.Adapter;
import p61.composite.Circulo;
import p61.composite.Dibujo;
import p61.composite.Linea;

/**
 *
 * @author Mauricio Ortiz
 */
public class PdsUnidad02Ooms {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        composite();
        adapter();
    }
    
    public static void composite(){
        System.out.println("Composite");
        
        var linea1 = new Linea();
        var linea2 = new Linea();
        var circulo1 = new Circulo();
        var dibujo1 = new Dibujo();
        var dibujo2 = new Dibujo();
                
        dibujo1.add(linea1);
        dibujo1.add(circulo1);        
        
        dibujo2.add(dibujo1);
        dibujo2.add(linea2);
        System.out.println(dibujo2.getPeso());
        
    }
    
    public static void adapter(){
        System.out.println("Adapter");
        
        var pagoBanco=new Adapter();
                
        System.out.println(pagoBanco.pagado(1, 10));
        
    }
    
    
}
