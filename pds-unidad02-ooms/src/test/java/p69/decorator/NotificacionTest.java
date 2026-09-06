package p69.decorator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class NotificacionTest {
    private final Notificacion basica = new NotificacionImpl("Matricula registrada");

    @Test
    void devuelveMensajeBasico() {
        assertEquals("Matricula registrada", basica.send());
    }

    @Test
    void agregaFormatoHtml() {
        assertEquals("<html><body><p>Matricula registrada</p></body></html>",
                new NotificacionHTML(basica).send());
    }

    @Test
    void escapaTextoAlConvertirAHtml() {
        assertEquals("<html><body><p>&lt;b&gt;Ana &amp; Luis&lt;/b&gt;<br>&quot;OK&quot; &#39;si&#39;</p></body></html>",
                new NotificacionHTML(new NotificacionImpl("<b>Ana & Luis</b>\n\"OK\" 'si'")).send());
    }

    @Test
    void agregaEmail() {
        assertEquals("Matricula registrada\n[SIMULADO] Email para: ana@example.com",
                new NotificacionConEmail(basica, "ana@example.com").send());
    }

    @Test
    void agregaTelefono() {
        assertEquals("Matricula registrada\n[SIMULADO] SMS para: 0000000000",
                new NotificacionConTelefono(basica, "0000000000").send());
    }

    @Test
    void agregaCuenta() {
        assertEquals("Matricula registrada\n[SIMULADO] Red social para: @ana_demo",
                new NotificacionConCuenta(basica, "@ana_demo").send());
    }

    @Test
    void combinaSinModificarElOriginal() {
        Notificacion completa = new NotificacionConCuenta(new NotificacionConTelefono(
                new NotificacionConEmail(new NotificacionHTML(basica), "ana@example.com"),
                "0000000000"), "@ana_demo");
        String esperado = "<html><body><p>Matricula registrada</p></body></html>"
                + "\n[SIMULADO] Email para: ana@example.com"
                + "\n[SIMULADO] SMS para: 0000000000"
                + "\n[SIMULADO] Red social para: @ana_demo";
        assertEquals(esperado, completa.send());
        assertEquals(esperado, completa.send());
        assertEquals("Matricula registrada", basica.send());
    }

    @Test
    void htmlExteriorFormateaTambienLaInformacionAgregada() {
        assertEquals("<html><body><p>Matricula registrada<br>[SIMULADO] Red social para: @ana_demo</p></body></html>",
                new NotificacionHTML(new NotificacionConCuenta(basica, "@ana_demo")).send());
    }

    @Test
    void cadaCapaDelegaUnaSolaVez() {
        int[] llamadas = {0};
        Notificacion componente = new Notificacion() {
            @Override
            public String send() {
                llamadas[0]++;
                return "Mensaje";
            }
        };
        new NotificacionConCuenta(new NotificacionConTelefono(new NotificacionConEmail(
                new NotificacionHTML(componente), "ana@example.com"), "0000000000"), "@ana_demo").send();
        assertEquals(1, llamadas[0]);
    }

    @Test
    void rechazaComponenteNulo() {
        assertThrows(NullPointerException.class, () -> new NotificacionHTML(null));
        assertThrows(NullPointerException.class, () -> new NotificacionConEmail(null, "a@example.com"));
        assertThrows(NullPointerException.class, () -> new NotificacionConTelefono(null, "000"));
        assertThrows(NullPointerException.class, () -> new NotificacionConCuenta(null, "@a"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "})
    void rechazaDatosVacios(String dato) {
        assertThrows(IllegalArgumentException.class, () -> new NotificacionImpl(dato));
        assertThrows(IllegalArgumentException.class, () -> new NotificacionConEmail(basica, dato));
        assertThrows(IllegalArgumentException.class, () -> new NotificacionConTelefono(basica, dato));
        assertThrows(IllegalArgumentException.class, () -> new NotificacionConCuenta(basica, dato));
    }
}
