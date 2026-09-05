package p69.composite.mvc.modelo;

import p69.composite.Circulo;
import p69.composite.Dibujo;
import p69.composite.FiguraComponent;
import p69.composite.Linea;
import p69.composite.Texto;

/** Modelo editable de la demostracion MVC del patron Composite. */
public class ModeloComposite {

    public enum TipoComponente {
        LINEA, CIRCULO, TEXTO, DIBUJO
    }

    private final Dibujo raiz;

    public ModeloComposite() {
        raiz = crearDemostracion();
    }

    public Dibujo getRaiz() {
        return raiz;
    }

    public int getPesoTotal() {
        return raiz.getPeso();
    }

    public String getDescripcion() {
        return raiz.representar();
    }

    public FiguraComponent agregar(Dibujo padre, TipoComponente tipo,
            String detalle, int peso) {
        if (padre == null || !contiene(raiz, padre)) {
            throw new IllegalArgumentException(
                    "Seleccione un dibujo valido como destino");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("Seleccione un tipo de componente");
        }

        FiguraComponent nuevo;
        switch (tipo) {
            case LINEA:
                nuevo = new Linea(peso);
                break;
            case CIRCULO:
                nuevo = new Circulo(peso);
                break;
            case TEXTO:
                nuevo = new Texto(detalle, peso);
                break;
            case DIBUJO:
                nuevo = new Dibujo(detalle);
                break;
            default:
                throw new IllegalArgumentException("Tipo no reconocido");
        }
        padre.add(nuevo);
        return nuevo;
    }

    public boolean eliminar(FiguraComponent componente) {
        Dibujo padre = getPadre(componente);
        if (padre == null) {
            return false;
        }
        padre.delete(componente);
        return true;
    }

    public Dibujo getPadre(FiguraComponent componente) {
        if (componente == null || componente == raiz) {
            return null;
        }
        return buscarPadre(raiz, componente);
    }

    private Dibujo buscarPadre(Dibujo candidato, FiguraComponent buscado) {
        for (FiguraComponent hijo : candidato.getHijos()) {
            if (hijo == buscado) {
                return candidato;
            }
            if (hijo instanceof Dibujo) {
                Dibujo encontrado = buscarPadre((Dibujo) hijo, buscado);
                if (encontrado != null) {
                    return encontrado;
                }
            }
        }
        return null;
    }

    private boolean contiene(Dibujo candidato, FiguraComponent buscado) {
        if (candidato == buscado) {
            return true;
        }
        for (FiguraComponent hijo : candidato.getHijos()) {
            if (hijo == buscado
                    || hijo instanceof Dibujo && contiene((Dibujo) hijo, buscado)) {
                return true;
            }
        }
        return false;
    }

    private Dibujo crearDemostracion() {
        Dibujo encabezado = new Dibujo("Encabezado");
        encabezado.add(new Texto("Patron Composite"));
        encabezado.add(new Linea(75));

        Dibujo detalles = new Dibujo("Detalles");
        detalles.add(new Circulo(120));
        detalles.add(new Texto("Jerarquia parte-todo", 30));

        Dibujo escena = new Dibujo("Escena principal");
        escena.add(new Linea());
        escena.add(new Circulo());
        escena.add(encabezado);
        escena.add(detalles);
        return escena;
    }
}
