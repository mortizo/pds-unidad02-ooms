/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p65.estructurales.bridge;

/**
 *
 * @author morti
 */
public class Cliente {
    
    public static void main(String[] args) {
        var impl1= new Paypal();
        var impl2= new Kushki();
        
        var pagoMatriculaGrado= new PagoCorriente();
        pagoMatriculaGrado.add(impl2);
        var pagoMatriculaPosgrado= new PagoCorriente();
        pagoMatriculaPosgrado.add(impl1);
        pagoMatriculaPosgrado.add(impl2);
        
        
    }
    
}
