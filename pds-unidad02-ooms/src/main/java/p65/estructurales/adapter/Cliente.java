/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p65.estructurales.adapter;

/**
 *
 * @author morti
 */
public class Cliente {
    public static void main(String[] args) {
        ServicioCorreo sC=new GmailAdapter();
        //ServicioCorreo sC=new OutlookAdapter();
        
        sC.enviarCorreo("mortizo@ups.edu.ec", "Test Correo", "Hola Mundo !!!");
    }
}
