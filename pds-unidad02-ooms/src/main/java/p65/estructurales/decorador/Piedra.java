/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p65.estructurales.decorador;

/**
 *
 * @author morti
 */
public class Piedra extends PersonajeDecorator{

    public Piedra(IPersonaje personaje) {
        super(personaje);
    }

    @Override
    public String combatir() {
        return personaje.combatir()+" 5 puntos de píedra ";
    }
    
}
