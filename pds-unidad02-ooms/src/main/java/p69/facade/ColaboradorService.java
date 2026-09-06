package p69.facade;

import java.util.Map;

/** Subsistema de colaboradors. Simula su propio registro en memoria. */
public class ColaboradorService {
    private final Map<Integer, InfoPersona> personas = Map.of(
            3001, new InfoPersona(3001, "Elena Ruiz", "Colaborador"));

    /** @return informacion de la persona, o null si no pertenece a este servicio. */
    public InfoPersona buscar(int id) {
        return personas.get(id);
    }
}
