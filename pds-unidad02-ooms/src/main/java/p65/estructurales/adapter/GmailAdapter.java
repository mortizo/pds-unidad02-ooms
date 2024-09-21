/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p65.estructurales.adapter;

/**
 *
 * @author morti
 */
public class GmailAdapter implements ServicioCorreo{
    
    private GmailAPIv1 gmailv1= new GmailAPIv1();

    @Override
    public void enviarCorreo(String direccion, String asunto, String mensaje) {
        this.gmailv1.sentMessage(asunto, mensaje, direccion);
    }
    
}
