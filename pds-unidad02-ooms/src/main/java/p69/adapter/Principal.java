package p69.adapter;

/** Demostracion del mismo cliente trabajando con APIs bancarias incompatibles. */
public class Principal {

    public static void main(String[] args) {
        Cliente clientePichincha = new Cliente(
                new PichinchaAdapter(new BancoPichincha()));
        Cliente clientePacifico = new Cliente(
                new PacificoAdapter(new BancoPacifico()));

        mostrarResultado("Banco Pichincha", 1001, 2,
                clientePichincha.verificarPago(1001, 2));
        mostrarResultado("Banco Pichincha", 1002, 3,
                clientePichincha.verificarPago(1002, 3));
        mostrarResultado("Banco del Pacifico", 2002, 3,
                clientePacifico.verificarPago(2002, 3));
        mostrarResultado("Banco del Pacifico", 2001, 4,
                clientePacifico.verificarPago(2001, 4));
    }

    private static void mostrarResultado(String banco, int id, int cuota,
            boolean pagado) {
        System.out.printf("%s | estudiante=%d | cuota=%d | %s%n",
                banco, id, cuota, pagado ? "PAGADA" : "PENDIENTE");
    }
}
