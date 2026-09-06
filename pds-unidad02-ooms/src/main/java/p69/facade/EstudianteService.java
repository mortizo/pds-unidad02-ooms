package p69.facade;

import java.util.Map;

/** Subsistema de estudiantes. Simula su propio registro en memoria. */
public class EstudianteService {
    private final Map<Integer, InfoPersona> personas = Map.of(
            1001, new InfoPersona(1001, "Ana Torres", "Estudiante"));

    /** @return informacion de la persona, o null si no pertenece a este servicio. */
    public InfoPersona buscar(int id) {
        return personas.get(id);
    }
}
