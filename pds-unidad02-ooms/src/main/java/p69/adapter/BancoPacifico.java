package p69.adapter;

import java.util.HashSet;
import java.util.Set;

/** Adaptee cuya API recibe cuota e identificador en un orden diferente. */
public class BancoPacifico {

    private final Set<String> pagos = new HashSet<>();

    public BancoPacifico() {
        registrarPago(2001, 1);
        registrarPago(2001, 2);
        registrarPago(2002, 3);
    }

    /** Operacion original: primero recibe la cuota y despues el id. */
    public boolean pagado(int cuota, int id) {
        return pagos.contains(clave(id, cuota));
    }

    public void registrarPago(int id, int cuota) {
        pagos.add(clave(id, cuota));
    }

    private String clave(int id, int cuota) {
        return id + ":" + cuota;
    }
}
