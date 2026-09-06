package p69.adapter;

/** Cliente que depende unicamente de la interfaz Target. */
public class Cliente {

    private final PagoBanco pagoBanco;

    public Cliente(PagoBanco pagoBanco) {
        if (pagoBanco == null) {
            throw new IllegalArgumentException("El servicio de pagos no puede ser nulo");
        }
        this.pagoBanco = pagoBanco;
    }

    public boolean verificarPago(int id, int cuota) {
        return pagoBanco.pagado(id, cuota);
    }
}
