/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.decorator;

/**
 *
 * @author morti
 */
public class NotificacionConEmail extends NotificacionDecorator{

    public NotificacionConEmail(Notificacion notificacion) {
        super(notificacion);
    }

    @Override
    public String send() {
        return super.send()+ " Se envía por mail... "; 
    }

    
    
    
    
}
