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
public class NotificacionDecorator implements Notificacion {
    
    private List<Notificacion> notificaciones = new ArrayList<Notificacion>();

    @Override
    public String send() {
        var retorno="Usted ha sido notificado ";
        for(var notificacion: this.notificaciones){
            retorno+=notificacion.send();
        }
        return retorno;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }
    
    
    
}
