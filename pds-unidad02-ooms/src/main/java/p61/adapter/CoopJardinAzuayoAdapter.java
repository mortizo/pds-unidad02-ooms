/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.adapter;

/**
 *
 * @author morti
 */
public class CoopJardinAzuayoAdapter implements PagoBanco{

    private CoopJardinAzuayo coopJardinAzuayo = new CoopJardinAzuayo();
    
    @Override
    public boolean pagado(int id, int couta) {
            return false;
    }
    
}
