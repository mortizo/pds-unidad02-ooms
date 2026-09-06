package p69.facade;

import java.util.Objects;

/** Resultado comun que la fachada entrega al cliente. Datos ficticios de clase. */
public final class InfoPersona {
    private final int id;
    private final String nombre;
    private final String tipo;

    public InfoPersona(int id, String nombre, String tipo) {
        if (id <= 0) {
            throw new IllegalArgumentException("El id debe ser positivo");
        }
        this.id = id;
        this.nombre = Objects.requireNonNull(nombre, "nombre");
        this.tipo = Objects.requireNonNull(tipo, "tipo");
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }

    @Override
    public String toString() {
        return id + " | " + nombre + " | " + tipo;
    }
}
