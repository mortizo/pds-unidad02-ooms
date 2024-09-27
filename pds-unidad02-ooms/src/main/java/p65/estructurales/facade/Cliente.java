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
public class Cliente {
    
    public static void main(String[] args) {
        var reserva= new ReservaFacade();
        reserva.reservarVuelo("Cuenca", "Quito", LocalDate.now());
    }
    
}