package p69.composite.mvc.controlador;

import p69.composite.mvc.modelo.ModeloComposite;
import p69.composite.mvc.vista.VistaComposite;

/** Controlador que comunica la vista Swing con el modelo de demostracion. */
public class ControladorComposite {

    private final ModeloComposite modelo;
    private final VistaComposite vista;

    public ControladorComposite(ModeloComposite modelo, VistaComposite vista) {
        this.modelo = modelo;
        this.vista = vista;
        registrarEventos();
    }

    public void iniciar() {
        vista.setVisible(true);
    }

    private void registrarEventos() {
        vista.alDibujar(evento -> vista.mostrarComposicion(
                modelo.getRaiz(), modelo.getDescripcion()));
        vista.alCalcularPeso(evento -> vista.mostrarPeso(modelo.getPesoTotal()));
    }
}
