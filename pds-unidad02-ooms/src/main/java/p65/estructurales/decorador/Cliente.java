/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p65.estructurales.decorador;

/**
 *
 * @author morti
 */
public class Cliente {
    public static void main(String[] args) {
        var aldeano= new Aldeano();
        var aldeanoDecorado1= new Piedra(aldeano);
        var aldeanoDecorado2= new Lanza(aldeanoDecorado1);
        var aldeanoDecorado3= new Lanza(aldeano);
        
        
        
        System.out.println(aldeano.combatir());
        System.out.println(aldeanoDecorado1.combatir());
        System.out.println(aldeanoDecorado2.combatir());
        System.out.println(aldeanoDecorado3.combatir());
        
        
    }
}
