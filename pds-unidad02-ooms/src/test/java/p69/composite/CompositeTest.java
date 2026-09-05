package p69.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class CompositeTest {

    @Test
    void lasHojasTienenElPesoEsperado() {
        assertEquals(100, new Linea().getPeso());
        assertEquals(200, new Circulo().getPeso());
        assertEquals(50, new Texto("Hola").getPeso());
    }

    @Test
    void elPesoIncluyeTodosLosNivelesDeLaComposicion() {
        Dibujo interior = new Dibujo("Interior");
        interior.add(new Texto("Titulo", 25));
        interior.add(new Linea(75));

        Dibujo raiz = new Dibujo("Raiz");
        raiz.add(new Circulo(150));
        raiz.add(interior);

        assertEquals(250, raiz.getPeso());
    }

    @Test
    void permiteAgregarYEliminarComponentes() {
        Dibujo dibujo = new Dibujo("Prueba");
        FiguraComponent linea = new Linea();

        dibujo.add(linea);
        assertEquals(1, dibujo.getHijos().size());

        dibujo.delete(linea);
        assertTrue(dibujo.getHijos().isEmpty());
    }

    @Test
    void dibujarDevuelveEImprimeLaJerarquiaCompleta() {
        Dibujo dibujo = new Dibujo("Lienzo");
        dibujo.add(new Linea());
        dibujo.add(new Texto("Composite"));

        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        PrintStream consolaOriginal = System.out;
        String representacion;
        try {
            System.setOut(new PrintStream(salida, true, StandardCharsets.UTF_8));
            representacion = dibujo.dibujar();
        } finally {
            System.setOut(consolaOriginal);
        }

        assertTrue(representacion.contains("Dibujo: Lienzo"));
        assertTrue(representacion.contains("  Linea"));
        assertTrue(representacion.contains("  Texto: \"Composite\""));
        assertEquals(representacion + System.lineSeparator(),
                salida.toString(StandardCharsets.UTF_8));
    }

    @Test
    void protegeLaComposicionContraDatosInvalidos() {
        Dibujo dibujo = new Dibujo("Valido");

        assertThrows(IllegalArgumentException.class, () -> new Linea(-1));
        assertThrows(IllegalArgumentException.class, () -> new Texto(" "));
        assertThrows(IllegalArgumentException.class, () -> dibujo.add(null));
        assertThrows(UnsupportedOperationException.class,
                () -> dibujo.getHijos().add(new Circulo()));
        assertFalse(dibujo.getHijos().contains(null));
    }
}
