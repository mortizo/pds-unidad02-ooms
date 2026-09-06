package p69.adapter;

/** Target: interfaz uniforme que conoce y utiliza el cliente. */
public interface PagoBanco {

    boolean pagado(int id, int cuota);
}
