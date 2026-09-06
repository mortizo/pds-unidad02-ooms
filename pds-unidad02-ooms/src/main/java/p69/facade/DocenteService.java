package p69.facade;

import java.util.Map;

/** Subsistema de docentes. Simula su propio registro en memoria. */
public class DocenteService {
    private final Map<Integer, InfoPersona> personas = Map.of(
            2001, new InfoPersona(2001, "Luis Vega", "Docente"));

    /** @return informacion de la persona, o null si no pertenece a este servicio. */
    public InfoPersona buscar(int id) {
        return personas.get(id);
    }
}
