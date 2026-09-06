package p69.facade;

import java.util.Map;

/** Subsistema de proveedors. Simula su propio registro en memoria. */
public class ProveedorService {
    private final Map<Integer, InfoPersona> personas = Map.of(
            4001, new InfoPersona(4001, "Carlos Molina", "Proveedor"));

    /** @return informacion de la persona, o null si no pertenece a este servicio. */
    public InfoPersona buscar(int id) {
        return personas.get(id);
    }
}
