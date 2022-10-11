/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.decorator;

/**
 *
 * @author morti
 */
public class NotificacionImpl implements Notificacion{

    @Override
    public String send() {
        return "Usted ha sido notificado por el sistema";
    }
    
}
