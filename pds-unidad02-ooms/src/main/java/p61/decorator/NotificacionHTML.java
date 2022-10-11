/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.decorator;

/**
 *
 * @author morti
 */
public class NotificacionHTML extends NotificacionDecorator{
    
    @Override
    public String send() {
        return this.formatoHTML();
    }
    
    public String formatoHTML(){
        return "Formato HTML agregado";
    }
    
}
