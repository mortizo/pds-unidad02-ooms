package p69.decorator;

/** Agrega informacion de correo; no conecta con un servidor de correo. */
public class NotificacionConEmail extends NotificacionDecorator {
    private final String email;

    public NotificacionConEmail(Notificacion notificacion, String email) {
        super(notificacion);
        this.email = textoObligatorio(email, "El email");
    }

    @Override
    public String send() {
        return super.send() + "\n[SIMULADO] Email para: " + email;
    }
}
