/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.adapter;

/**
 *
 * @author Mauricio Ortiz
 */
public class Adapter implements PagoBanco{

    private BancoPacifico bancoPacifico = new BancoPacifico();
    private BancoPichincha bancoPichincha = new BancoPichincha();
    
    
    @Override
    public boolean pagado(int id, int couta) {
        var retorno=false;        
    
        if(this.bancoPichincha.obtienePago(id, couta) 
                || this.bancoPacifico.pagado(couta, id)){
            retorno=true;
        }
        return retorno;
    }
    
}
