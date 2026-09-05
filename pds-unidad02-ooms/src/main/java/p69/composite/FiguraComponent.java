package p69.composite;

/**
 * Componente base del patron Composite.
 * Permite tratar de la misma manera figuras simples y dibujos compuestos.
 */
public abstract class FiguraComponent {

    private final int peso;

    protected FiguraComponent(int peso) {
        if (peso < 0) {
            throw new IllegalArgumentException("El peso no puede ser negativo");
        }
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    /**
     * Construye la representacion del componente, la imprime y la devuelve.
     *
     * @return representacion textual de la figura o del dibujo completo
     */
    public final String dibujar() {
        String resultado = representar();
        System.out.println(resultado);
        return resultado;
    }

    /**
     * Devuelve la representacion sin escribir en la consola.
     * Es util para vistas graficas y otros clientes del modelo.
     *
     * @return representacion textual completa
     */
    public final String representar() {
        return dibujar(0);
    }

    protected abstract String dibujar(int nivel);

    protected final String sangria(int nivel) {
        return "  ".repeat(nivel);
    }
}
