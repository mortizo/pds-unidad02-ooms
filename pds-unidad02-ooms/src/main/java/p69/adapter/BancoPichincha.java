package p69.adapter;

import java.util.HashSet;
import java.util.Set;

/** Adaptee que representa la API propia de Banco Pichincha. */
public class BancoPichincha {

    private final Set<String> pagos = new HashSet<>();

    public BancoPichincha() {
        registrarPago(1001, 1);
        registrarPago(1001, 2);
        registrarPago(1002, 1);
    }

    /** Operacion original de la API del banco. */
    public boolean obtienePago(int id, int cuota) {
        return pagos.contains(clave(id, cuota));
    }

    public void registrarPago(int id, int cuota) {
        pagos.add(clave(id, cuota));
    }

    private String clave(int id, int cuota) {
        return id + ":" + cuota;
    }
}
