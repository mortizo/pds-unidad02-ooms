package p69.composite;

/** Hoja que representa un circulo. */
public class Circulo extends FiguraComponent {

    public static final int PESO_PREDETERMINADO = 200;

    public Circulo() {
        super(PESO_PREDETERMINADO);
    }

    public Circulo(int peso) {
        super(peso);
    }

    @Override
    protected String dibujar(int nivel) {
        return sangria(nivel) + "Circulo (peso: " + getPeso() + ")";
    }
}
