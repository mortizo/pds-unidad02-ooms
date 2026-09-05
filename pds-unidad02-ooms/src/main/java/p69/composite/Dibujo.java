package p69.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Composite que puede contener hojas u otros dibujos. */
public class Dibujo extends FiguraComponent {

    private final String nombre;
    private final List<FiguraComponent> hijos = new ArrayList<>();

    public Dibujo(String nombre) {
        super(0);
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }

    public void add(FiguraComponent figura) {
        if (figura == null) {
            throw new IllegalArgumentException("La figura no puede ser nula");
        }
        hijos.add(figura);
    }

    public void delete(FiguraComponent figura) {
        hijos.remove(figura);
    }

    public List<FiguraComponent> getHijos() {
        return Collections.unmodifiableList(hijos);
    }

    @Override
    public int getPeso() {
        return hijos.stream().mapToInt(FiguraComponent::getPeso).sum();
    }

    @Override
    protected String dibujar(int nivel) {
        StringBuilder resultado = new StringBuilder();
        resultado.append(sangria(nivel))
                .append("Dibujo: ")
                .append(nombre)
                .append(" (peso total: ")
                .append(getPeso())
                .append(")");

        for (FiguraComponent hijo : hijos) {
            resultado.append(System.lineSeparator())
                    .append(hijo.dibujar(nivel + 1));
        }
        return resultado.toString();
    }
}
