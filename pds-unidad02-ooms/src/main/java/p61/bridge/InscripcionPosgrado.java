/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.bridge;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */
public class InscripcionPosgrado extends Inscripcion {

    public InscripcionPosgrado(InscripcionImpl inscripcionImpl) {
        super(inscripcionImpl);
    }

    
    @Override
    public boolean controlNivelEstudio() {
        var retorno = false;
        if(this.getNivelEstudio().equals(NivelEstudio.POSGRADO)){
            retorno=true;
        }
        return retorno;
    }
}
