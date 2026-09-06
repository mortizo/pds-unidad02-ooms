package p69.decorator;

/** Componente concreto: mensaje basico generado al registrar una matricula. */
public class NotificacionImpl extends Notificacion {
    private final String mensaje;

    public NotificacionImpl(String mensaje) {
        this.mensaje = textoObligatorio(mensaje, "El mensaje");
    }

    @Override
    public String send() {
        return mensaje;
    }
}
