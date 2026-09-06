package p69.adapter;

/** Adapter que traduce PagoBanco a la API de Banco Pichincha. */
public class PichinchaAdapter implements PagoBanco {

    private final BancoPichincha banco;

    public PichinchaAdapter(BancoPichincha banco) {
        if (banco == null) {
            throw new IllegalArgumentException("El banco no puede ser nulo");
        }
        this.banco = banco;
    }

    @Override
    public boolean pagado(int id, int cuota) {
        return banco.obtienePago(id, cuota);
    }
}
