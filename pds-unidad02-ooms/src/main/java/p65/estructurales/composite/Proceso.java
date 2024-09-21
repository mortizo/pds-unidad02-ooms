/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p65.estructurales.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author morti
 */
public class Proceso extends Normativa{

    private List<Normativa> normativaList;

    public Proceso() {
        this.normativaList = new ArrayList<Normativa>();
    }

    public void add(Normativa norma) {
        this.normativaList.add(norma);
    }
    

    @Override
    public String mostrarContenido() {
        String retorno="";
        for(Normativa n:normativaList)
            retorno=retorno+n.mostrarContenido()+"\n";        
        return retorno;
    }

    
}
