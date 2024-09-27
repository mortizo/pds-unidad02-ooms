/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p65.estructurales.facade;

import java.time.LocalDate;

/**
 *
 * @author morti
 */
public class ReservaFacade {
    
    private Autenticacion autenticacion;
    private Pago pago;
    private Vuelo vuelo;

    public ReservaFacade() {
        this.autenticacion = new Autenticacion();
        this.pago = new Pago();
        this.vuelo = new Vuelo();
    }
    
    
    public double reservarVuelo(String origen, String destino, LocalDate fecha){
        
        return 0;
    }
    
    
    
}
