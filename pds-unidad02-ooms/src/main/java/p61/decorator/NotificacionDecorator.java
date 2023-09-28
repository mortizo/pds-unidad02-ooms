/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.decorator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author morti
 */
public abstract class NotificacionDecorator implements Notificacion {
    
    protected Notificacion notificacion;

    public NotificacionDecorator(Notificacion notificacion) {
        this.notificacion=notificacion;
    }
    
    @Override
    public String send() {
        var retorno=notificacion.send();
        return retorno;
    }
 
    
}
