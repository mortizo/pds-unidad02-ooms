package p69.composite.mvc.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ModeloCompositeTest {

    @Test
    void preparaUnaDemostracionConComposicionesAnidadas() {
        ModeloComposite modelo = new ModeloComposite();

        assertEquals(4, modelo.getRaiz().getHijos().size());
        assertEquals(575, modelo.getPesoTotal());
        assertTrue(modelo.getDescripcion().contains("Dibujo: Encabezado"));
        assertTrue(modelo.getDescripcion().contains("Dibujo: Detalles"));
    }
}
