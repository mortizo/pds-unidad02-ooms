/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio Ortiz
 */
public class Dibujo extends FiguraComponent {

    private List<FiguraComponent> hijos = new ArrayList<FiguraComponent>();    
    
    @Override
    public void dibujar() {
        for(var hijo: this.hijos){
            hijo.dibujar();
        }
    }

    @Override
    public int getPeso() {
        var retorno=0;
        for(var hijo: this.hijos){
            retorno+=hijo.getPeso();
        }
        return retorno;
    }
    
    public void add(FiguraComponent figura){
        this.hijos.add(figura);
    }
    
    public void delete(FiguraComponent figura){
        this.hijos.remove(figura);
    }

    public List<FiguraComponent> getHijos() {
        return hijos;
    }
    
    
    
}
