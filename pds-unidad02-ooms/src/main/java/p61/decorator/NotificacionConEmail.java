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
    
    private String correo;
    
    @Override
    public String send() {
        return this.getCorreo();
    }
    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
    
    
}
