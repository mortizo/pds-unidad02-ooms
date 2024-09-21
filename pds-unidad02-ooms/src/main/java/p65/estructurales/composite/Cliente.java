/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p65.estructurales.composite;

/**
 *
 * @author morti
 */
public class Cliente {
    
    public static void main(String[] args) {
        var pol= new Politica();
        pol.setTitulo("Política de correo electrónico institucional");
        pol.setContenido("La Universidad podrá solicitar sin previo aviso un "
                + "doble factor de autenticación");
        pol.setResponsable("Mauricio Ortiz");        
        
        var proceso= new Proceso();
        proceso.add(pol);        
        proceso.add(pol);        
        proceso.add(pol);        
        proceso.add(pol);
        
        System.out.println(proceso.mostrarContenido());
        
    }
    
}
