package p69.composite.mvc.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import p69.composite.Dibujo;
import p69.composite.FiguraComponent;
import p69.composite.Texto;
import p69.composite.mvc.modelo.ModeloComposite.TipoComponente;

class ModeloCompositeTest {

    @Test
    void preparaUnaDemostracionConComposicionesAnidadas() {
        ModeloComposite modelo = new ModeloComposite();

        assertEquals(4, modelo.getRaiz().getHijos().size());
        assertEquals(575, modelo.getPesoTotal());
        assertTrue(modelo.getDescripcion().contains("Dibujo: Encabezado"));
        assertTrue(modelo.getDescripcion().contains("Dibujo: Detalles"));
    }

    @Test
    void agregaComponentesAlDibujoSeleccionadoConPesoEditable() {
        ModeloComposite modelo = new ModeloComposite();
        FiguraComponent nuevoDibujo = modelo.agregar(modelo.getRaiz(),
                TipoComponente.DIBUJO, "Pie de pagina", 999);
        FiguraComponent nuevoTexto = modelo.agregar((Dibujo) nuevoDibujo,
                TipoComponente.TEXTO, "Fin", 40);

        assertTrue(nuevoTexto instanceof Texto);
        assertEquals(615, modelo.getPesoTotal());
        assertEquals(nuevoDibujo, modelo.getPadre(nuevoTexto));
    }

    @Test
    void eliminaUnaHojaYActualizaElPesoTotal() {
        ModeloComposite modelo = new ModeloComposite();
        FiguraComponent linea = modelo.getRaiz().getHijos().get(0);

        assertTrue(modelo.eliminar(linea));
        assertEquals(475, modelo.getPesoTotal());
        assertEquals(3, modelo.getRaiz().getHijos().size());
    }
}
