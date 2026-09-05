package p69.composite;

/** Cliente que demuestra una composicion de figuras con varios niveles. */
public class Principal {

    public static void main(String[] args) {
        FiguraComponent linea = new Linea();
        FiguraComponent circulo = new Circulo();
        FiguraComponent titulo = new Texto("Patron Composite");

        Dibujo encabezado = new Dibujo("Encabezado");
        encabezado.add(titulo);
        encabezado.add(new Linea(75));

        Dibujo escena = new Dibujo("Escena principal");
        escena.add(linea);
        escena.add(circulo);
        escena.add(encabezado);

        String representacion = escena.dibujar();

        System.out.println("Peso total: " + escena.getPeso());
        System.out.println("Caracteres generados: " + representacion.length());
    }
}
