package p69.facade;

import java.util.Objects;

/**
 * Fachada: coordina los cuatro subsistemas y oculta sus detalles al cliente.
 * Si un id aparece en varios servicios, devuelve la primera coincidencia:
 * estudiante, docente, colaborador y proveedor, en ese orden.
 */
public class PersonaFacade {
    private final EstudianteService estudianteService;
    private final DocenteService docenteService;
    private final ColaboradorService colaboradorService;
    private final ProveedorService proveedorService;

    public PersonaFacade() {
        this(new EstudianteService(), new DocenteService(),
                new ColaboradorService(), new ProveedorService());
    }

    public PersonaFacade(EstudianteService estudianteService,
            DocenteService docenteService, ColaboradorService colaboradorService,
            ProveedorService proveedorService) {
        this.estudianteService = Objects.requireNonNull(estudianteService);
        this.docenteService = Objects.requireNonNull(docenteService);
        this.colaboradorService = Objects.requireNonNull(colaboradorService);
        this.proveedorService = Objects.requireNonNull(proveedorService);
    }

    /** @return primera coincidencia, o null si no existe la persona. */
    public InfoPersona buscarPersona(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El id debe ser positivo");
        }
        InfoPersona persona = estudianteService.buscar(id);
        if (persona == null) {
            persona = docenteService.buscar(id);
        }
        if (persona == null) {
            persona = colaboradorService.buscar(id);
        }
        if (persona == null) {
            persona = proveedorService.buscar(id);
        }
        return persona;
    }
}
