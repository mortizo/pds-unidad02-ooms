package p69.facade;

import java.util.Objects;

/** El cliente conoce la fachada, sin acceder directamente a los servicios. */
public class Cliente {
    private final PersonaFacade personaFacade;

    public Cliente(PersonaFacade personaFacade) {
        this.personaFacade = Objects.requireNonNull(personaFacade);
    }

    public InfoPersona obtenerInfoPersona(int id) {
        return personaFacade.buscarPersona(id);
    }
}
