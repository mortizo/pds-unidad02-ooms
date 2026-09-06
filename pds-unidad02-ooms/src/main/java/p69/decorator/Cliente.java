package p69.decorator;

import java.util.Objects;

/** El cliente usa la abstraccion, sin distinguir componentes y decoradores. */
public class Cliente {
    public void enviar(Notificacion notificacion) {
        System.out.println(Objects.requireNonNull(notificacion,
                "La notificacion es obligatoria").send());
    }
}
