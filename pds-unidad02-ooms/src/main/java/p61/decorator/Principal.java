/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.decorator;

/**
 *
 * @author morti
 */
public class Principal {
    
    public static void main(String[] args) {
        var notificacionInscripcion = new NotificacionImpl();
        var funcionalidadExtra1 = new NotificacionConEmail(notificacionInscripcion);
        var funcionalidadExtra2 = new NotificacionConTelefono(funcionalidadExtra1);
        
        
        System.out.println(funcionalidadExtra2.send());
    }
    
}
