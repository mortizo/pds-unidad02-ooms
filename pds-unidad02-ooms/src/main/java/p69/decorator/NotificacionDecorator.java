package p69.decorator;

import java.util.Objects;

/** Decorador base: es una Notificacion y contiene otra Notificacion. */
public abstract class NotificacionDecorator extends Notificacion {
    private final Notificacion notificacion;

    protected NotificacionDecorator(Notificacion notificacion) {
        this.notificacion = Objects.requireNonNull(notificacion,
                "La notificacion es obligatoria");
    }

    @Override
    public String send() {
        return notificacion.send();
    }
}
