/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p65.estructurales.bridge;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author morti
 */
public abstract class ProcesoPago {
    
    private List<PasarelaPago> pasarelaPagoList;
    

    public ProcesoPago() {
        this.pasarelaPagoList= new ArrayList<>();
    }

    
    public void add(PasarelaPago pP){
        this.pasarelaPagoList.add(pP);
    }
    
    public abstract void generarPago();
    
}
