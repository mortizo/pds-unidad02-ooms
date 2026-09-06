package p69.decorator;

/** Componente comun. send devuelve una simulacion, sin realizar envios reales. */
public abstract class Notificacion {
    public abstract String send();

    protected static String textoObligatorio(String texto, String campo) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException(campo + " es obligatorio");
        }
        return texto.strip();
    }
}
