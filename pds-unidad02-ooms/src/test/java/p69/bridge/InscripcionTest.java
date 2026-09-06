package p69.bridge;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {
    static Stream<Arguments> combinaciones() {
        return Stream.of(
            Arguments.of(new InscripcionGrado(new CanalPresencial()),
                    "Grado | Presencial: registro en ventanilla"),
            Arguments.of(new InscripcionGrado(new CanalEnLinea()),
                    "Grado | En linea: registro en portal web"),
            Arguments.of(new InscripcionGrado(new CanalMovil()),
                    "Grado | Movil: registro en aplicacion movil"),
            Arguments.of(new InscripcionPosgrado(new CanalPresencial()),
                    "Posgrado | Presencial: registro en ventanilla"),
            Arguments.of(new InscripcionPosgrado(new CanalEnLinea()),
                    "Posgrado | En linea: registro en portal web"),
            Arguments.of(new InscripcionPosgrado(new CanalMovil()),
                    "Posgrado | Movil: registro en aplicacion movil")
        );
    }

    @ParameterizedTest
    @MethodSource("combinaciones")
    void combinaProgramasYCanales(Inscripcion inscripcion, String resultado) {
        assertEquals("Ana | " + resultado, inscripcion.inscribir("Ana"));
    }

    @Test
    void delegaEnUnCanalNuevoSinModificarLosProgramas() {
        CanalInscripcion canal = (estudiante, programa) -> programa + ":" + estudiante;
        assertEquals("Grado:Ana", new InscripcionGrado(canal).inscribir("  Ana  "));
        assertEquals("Posgrado:Luis", new InscripcionPosgrado(canal).inscribir("Luis"));
    }

    @Test
    void permiteUnProgramaNuevoSinModificarLosCanales() {
        Inscripcion tecnologias = new Inscripcion(new CanalMovil()) {
            @Override
            public String getPrograma() {
                return "Tecnologias";
            }
        };
        assertEquals("Ana | Tecnologias | Movil: registro en aplicacion movil",
                tecnologias.inscribir("Ana"));
    }

    @Test
    void rechazaCanalNulo() {
        assertThrows(NullPointerException.class, () -> new InscripcionGrado(null));
        assertThrows(NullPointerException.class, () -> new InscripcionPosgrado(null));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "})
    void rechazaNombreInvalidoAntesDeDelegar(String nombre) {
        CanalInscripcion canal = (estudiante, programa) -> {
            fail("No debe delegar con un nombre invalido");
            return "";
        };
        assertThrows(IllegalArgumentException.class,
                () -> new InscripcionGrado(canal).inscribir(nombre));
    }
}
