package p69.composite;

/** Hoja que representa un texto. */
public class Texto extends FiguraComponent {

    public static final int PESO_PREDETERMINADO = 50;
    private final String contenido;

    public Texto(String contenido) {
        this(contenido, PESO_PREDETERMINADO);
    }

    public Texto(String contenido, int peso) {
        super(peso);
        if (contenido == null || contenido.isBlank()) {
            throw new IllegalArgumentException("El contenido no puede estar vacio");
        }
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    @Override
    protected String dibujar(int nivel) {
        return sangria(nivel) + "Texto: \"" + contenido + "\" (peso: " + getPeso() + ")";
    }
}
