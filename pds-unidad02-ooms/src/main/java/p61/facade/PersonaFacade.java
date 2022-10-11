/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.facade;

/**
 *
 * @author morti
 */
public class PersonaFacade {
    
        private Colaborador colaborador = new Colaborador();
    private Docente docente = new Docente();
    private Estudiante estudiante = new Estudiante();
    private Proveedor proveedor = new Proveedor();

    public String info(int id, TipoPersona tipo) {
        var retorno = "";

        switch (tipo) {
            case ESTUDIANTE:
                retorno = estudiante.info(id);
                break;
            case COLABORADOR:
                retorno = colaborador.info(id);
                break;
            case DOCENTE:
                retorno = docente.info(id);
                break;
            case PROVEEDOR:
                retorno = proveedor.info(id);
                break;
        }

        return retorno;
    }
    
}
