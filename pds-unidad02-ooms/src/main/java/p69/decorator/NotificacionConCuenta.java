package p69.decorator;

/** Agrega una cuenta de red social, sin acceder a servicios externos. */
public class NotificacionConCuenta extends NotificacionDecorator {
    private final String cuenta;

    public NotificacionConCuenta(Notificacion notificacion, String cuenta) {
        super(notificacion);
        this.cuenta = textoObligatorio(cuenta, "La cuenta");
    }

    @Override
    public String send() {
        return super.send() + "\n[SIMULADO] Red social para: " + cuenta;
    }
}
