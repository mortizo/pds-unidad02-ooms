package p69.decorator;

/** Agrega informacion de SMS, sin enviar mensajes reales. */
public class NotificacionConTelefono extends NotificacionDecorator {
    private final String telefono;

    public NotificacionConTelefono(Notificacion notificacion, String telefono) {
        super(notificacion);
        this.telefono = textoObligatorio(telefono, "El telefono");
    }

    @Override
    public String send() {
        return super.send() + "\n[SIMULADO] SMS para: " + telefono;
    }
}
