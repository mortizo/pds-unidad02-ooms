/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p65.estructurales.composite;

/**
 *
 * @author morti
 */
public class Politica extends Normativa{

   private String responsable;
   
   @Override
    public String mostrarContenido() {
        return "Política{" + "titulo=" + this.getTitulo() + ", contenido=" + this.getResponsable() +
                '}'+"Responsable "+this.responsable+"\n";
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    
    
    
}
