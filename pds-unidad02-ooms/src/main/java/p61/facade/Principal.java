/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.facade;

/**
 *
 * @author morti
 */
public class Principal {
    
    public static void main(String[] args) {
        var persona= new PersonaFacade();
        System.out.println(persona.info(10, TipoPersona.ESTUDIANTE));
        
    }
    
}
