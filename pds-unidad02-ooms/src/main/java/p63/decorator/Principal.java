/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p63.decorator;

/**
 *
 * @author morti
 */
public class Principal {
    public static void main(String[] args) {
        PersonajeAldeano pA= new PersonajeAldeano();
        PersonajeDecorador c1 = new Camisa();
        PersonajeDecorador c2 = new Camisa();
        PersonajeDecorador c3 = new Camisa();
        PersonajeDecorador c4 = new Camisa();
        c1.personajeList.add(c2);
        c1.personajeList.add(c3);
        c1.personajeList.add(c4);
        c4.personaje=pA;
        
        System.out.println(c4.metodo());
    }
}
