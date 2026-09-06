package p69.adapter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AdapterTest {

    @Test
    void adaptaLaOperacionDeBancoPichincha() {
        PagoBanco servicio = new PichinchaAdapter(new BancoPichincha());

        assertTrue(servicio.pagado(1001, 2));
        assertFalse(servicio.pagado(1002, 3));
    }

    @Test
    void adaptaElOrdenDeParametrosDeBancoPacifico() {
        PagoBanco servicio = new PacificoAdapter(new BancoPacifico());

        assertTrue(servicio.pagado(2002, 3));
        assertFalse(servicio.pagado(2001, 4));
    }

    @Test
    void elClienteTrabajaIgualConAmbosAdaptadores() {
        Cliente clientePichincha = new Cliente(
                new PichinchaAdapter(new BancoPichincha()));
        Cliente clientePacifico = new Cliente(
                new PacificoAdapter(new BancoPacifico()));

        assertTrue(clientePichincha.verificarPago(1001, 1));
        assertTrue(clientePacifico.verificarPago(2001, 1));
    }
}
