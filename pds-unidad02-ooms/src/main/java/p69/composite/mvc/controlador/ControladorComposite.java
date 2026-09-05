package p69.composite.mvc.controlador;

import p69.composite.Dibujo;
import p69.composite.FiguraComponent;
import p69.composite.mvc.modelo.ModeloComposite;
import p69.composite.mvc.vista.VistaComposite;

/** Controlador de las operaciones interactivas de la vista. */
public class ControladorComposite {

    private final ModeloComposite modelo;
    private final VistaComposite vista;

    public ControladorComposite(ModeloComposite modelo, VistaComposite vista) {
        this.modelo = modelo;
        this.vista = vista;
        registrarEventos();
    }

    public void iniciar() {
        refrescar(modelo.getRaiz());
        vista.setVisible(true);
    }

    private void registrarEventos() {
        vista.alAgregar(evento -> agregarComponente());
        vista.alEliminar(evento -> eliminarComponente());
        vista.alSeleccionar(evento -> actualizarAcciones());
    }

    private void agregarComponente() {
        FiguraComponent seleccionado = vista.getComponenteSeleccionado();
        if (!(seleccionado instanceof Dibujo)) {
            vista.mostrarError("Seleccione un Dibujo en el arbol para agregar hijos.");
            return;
        }

        try {
            FiguraComponent nuevo = modelo.agregar((Dibujo) seleccionado,
                    vista.getTipoSeleccionado(), vista.getDetalle(),
                    vista.getPeso());
            refrescar(nuevo);
            vista.limpiarFormulario();
            vista.mostrarEstado("Componente agregado y vistas actualizadas");
        } catch (IllegalArgumentException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    private void eliminarComponente() {
        FiguraComponent seleccionado = vista.getComponenteSeleccionado();
        Dibujo padre = modelo.getPadre(seleccionado);
        if (padre == null) {
            vista.mostrarError("La raiz no puede eliminarse.");
            return;
        }
        if (vista.confirmarEliminacion() && modelo.eliminar(seleccionado)) {
            refrescar(padre);
            vista.mostrarEstado("Componente eliminado y vistas actualizadas");
        }
    }

    private void refrescar(FiguraComponent seleccionar) {
        vista.mostrarComposicion(modelo.getRaiz(), modelo.getDescripcion(),
                modelo.getPesoTotal(), seleccionar);
        actualizarAcciones();
    }

    private void actualizarAcciones() {
        FiguraComponent seleccionado = vista.getComponenteSeleccionado();
        vista.configurarAcciones(seleccionado instanceof Dibujo,
                seleccionado != null && seleccionado != modelo.getRaiz());
    }
}
