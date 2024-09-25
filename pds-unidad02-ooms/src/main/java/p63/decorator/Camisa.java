/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p63.decorator;

import java.util.List;

/**
 *
 * @author morti
 */
public class Camisa extends PersonajeDecorador{

  
    @Override
    public String metodo() {
        String retorno=personaje.metodo();
        for(IPersonaje p:this.personajeList){
            retorno=retorno+p.metodo();
        }
        return retorno+" y camisa";
    }

  
    
}
