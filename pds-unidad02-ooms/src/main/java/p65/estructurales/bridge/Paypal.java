/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p65.estructurales.bridge;

/**
 *
 * @author morti
 */
public class Paypal implements PasarelaPago {

    @Override
    public String pagar() {
        return "Pagó con Paypal...";
    }
    
}
