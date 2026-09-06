package p69.bridge;

import java.util.Objects;

/** Abstraccion: mantiene el puente hacia un canal, sin conocer su clase concreta. */
public abstract class Inscripcion {
    private final CanalInscripcion canal;

    protected Inscripcion(CanalInscripcion canal) {
        this.canal = Objects.requireNonNull(canal, "El canal es obligatorio");
    }

    public final String inscribir(String estudiante) {
        if (estudiante == null || estudiante.isBlank()) {
            throw new IllegalArgumentException("El nombre del estudiante es obligatorio");
        }
        return canal.registrar(estudiante.strip(), getPrograma());
    }

    public abstract String getPrograma();
}
