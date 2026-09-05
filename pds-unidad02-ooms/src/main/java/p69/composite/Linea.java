package p69.composite;

/** Hoja que representa una linea. */
public class Linea extends FiguraComponent {

    public static final int PESO_PREDETERMINADO = 100;

    public Linea() {
        super(PESO_PREDETERMINADO);
    }

    public Linea(int peso) {
        super(peso);
    }

    @Override
    protected String dibujar(int nivel) {
        return sangria(nivel) + "Linea (peso: " + getPeso() + ")";
    }
}
