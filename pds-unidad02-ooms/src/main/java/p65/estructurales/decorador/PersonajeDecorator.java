/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p65.estructurales.decorador;

/**
 *
 * @author morti
 */
public abstract class PersonajeDecorator implements IPersonaje{
    
    protected IPersonaje personaje;

    public PersonajeDecorator(IPersonaje personaje) {
        this.personaje = personaje;
    }
    
    
}
