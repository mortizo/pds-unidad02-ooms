/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p63.decorator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author morti
 */
public abstract class PersonajeDecorador implements IPersonaje{
    
    IPersonaje personaje;
    List<IPersonaje> personajeList;

    public PersonajeDecorador() {
        personajeList=new ArrayList<IPersonaje>();
    }

    @Override
    public abstract String metodo();
    
}
