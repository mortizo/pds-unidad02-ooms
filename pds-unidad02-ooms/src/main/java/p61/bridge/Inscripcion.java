/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.bridge;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */
public abstract class Inscripcion {
    
    private InscripcionImpl inscripcionImpl;
    private NivelEstudio nivelEstudio;

    public Inscripcion(InscripcionImpl inscripcionImpl) {
        this.inscripcionImpl = inscripcionImpl;
    }
    
    public void inscribir(){
        System.out.println("Estudiante inscrito...");
    }
    
    public abstract boolean controlNivelEstudio();

    public NivelEstudio getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(NivelEstudio nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }
    
    
    
}
