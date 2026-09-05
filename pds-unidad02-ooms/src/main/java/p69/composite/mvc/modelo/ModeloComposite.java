package p69.composite.mvc.modelo;

import p69.composite.Circulo;
import p69.composite.Dibujo;
import p69.composite.Linea;
import p69.composite.Texto;

/**
 * Modelo de la demostracion MVC. Construye una jerarquia fija para explicar
 * el patron Composite sin mezclar la preparacion de datos con la interfaz.
 */
public class ModeloComposite {

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
