package p69.facade;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PersonaFacadeTest {
    @ParameterizedTest
    @CsvSource({"1001,Estudiante,Ana Torres", "2001,Docente,Luis Vega",
            "3001,Colaborador,Elena Ruiz", "4001,Proveedor,Carlos Molina"})
    void clienteConsultaLosCuatroSubsistemas(int id, String tipo, String nombre) {
        InfoPersona persona = new Cliente(new PersonaFacade()).obtenerInfoPersona(id);
        assertNotNull(persona);
        assertEquals(id, persona.getId());
        assertEquals(tipo, persona.getTipo());
        assertEquals(nombre, persona.getNombre());
    }

    @Test
    void devuelveNullSiNingunServicioEncuentraLaPersona() {
        assertNull(new Cliente(new PersonaFacade()).obtenerInfoPersona(9999));
    }

    @Test
    void rechazaIdentificadoresNoPositivos() {
        PersonaFacade fachada = new PersonaFacade();
        assertThrows(IllegalArgumentException.class, () -> fachada.buscarPersona(0));
        assertThrows(IllegalArgumentException.class, () -> fachada.buscarPersona(-1));
    }

    @Test
    void primeraCoincidenciaEvitaConsultarLosServiciosPosteriores() {
        DocenteService docente = new DocenteService() {
            @Override
            public InfoPersona buscar(int id) {
                fail("No se debe consultar docente si estudiante ya encontro la persona");
                return null;
            }
        };
        PersonaFacade fachada = new PersonaFacade(new EstudianteService(),
                docente, new ColaboradorService(), new ProveedorService());
        assertEquals("Estudiante", fachada.buscarPersona(1001).getTipo());
    }
}
