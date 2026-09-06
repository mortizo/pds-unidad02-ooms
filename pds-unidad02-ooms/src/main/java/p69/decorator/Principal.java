package p69.decorator;

/** Demostracion sin MVC, con datos ficticios y sin envios reales. */
public class Principal {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Notificacion basica = new NotificacionImpl("Matricula registrada: Ana Torres");

        System.out.println("=== Notificacion basica ===");
        cliente.enviar(basica);

        System.out.println("\n=== Decoradores individuales ===");
        cliente.enviar(new NotificacionHTML(basica));
        cliente.enviar(new NotificacionConEmail(basica, "ana@example.com"));
        cliente.enviar(new NotificacionConTelefono(basica, "0000000000"));
        cliente.enviar(new NotificacionConCuenta(basica, "@ana_demo"));

        System.out.println("\n=== Composicion dinamica: HTML + Email + SMS + Cuenta ===");
        Notificacion completa = new NotificacionHTML(basica);
        completa = new NotificacionConEmail(completa, "ana@example.com");
        completa = new NotificacionConTelefono(completa, "0000000000");
        completa = new NotificacionConCuenta(completa, "@ana_demo");
        cliente.enviar(completa);

        System.out.println("\n=== La notificacion original no cambia ===");
        cliente.enviar(basica);
    }
}
