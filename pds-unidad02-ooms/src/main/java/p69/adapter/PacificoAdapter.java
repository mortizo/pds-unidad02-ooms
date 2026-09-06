package p69.adapter;

/** Adapter que traduce PagoBanco a la API de Banco del Pacifico. */
public class PacificoAdapter implements PagoBanco {

    private final BancoPacifico banco;

    public PacificoAdapter(BancoPacifico banco) {
        if (banco == null) {
            throw new IllegalArgumentException("El banco no puede ser nulo");
        }
        this.banco = banco;
    }

    @Override
    public boolean pagado(int id, int cuota) {
        return banco.pagado(cuota, id);
    }
}
