/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p65.estructurales.decorador;

/**
 *
 * @author morti
 */
public class Lanza extends PersonajeDecorator{

    public Lanza(IPersonaje personaje) {
        super(personaje);
    }

    @Override
    public String combatir() {
        return personaje.combatir()+" +10 puntos de lanza";
    }
    
}
