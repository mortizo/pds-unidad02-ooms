package p69.facade;

/** Demostracion por consola con datos ficticios y un id inexistente. */
public class Principal {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(new PersonaFacade());
        for (int id : new int[]{1001, 2001, 3001, 4001, 9999}) {
            InfoPersona persona = cliente.obtenerInfoPersona(id);
            System.out.println(persona == null
                    ? id + " | Persona no encontrada" : persona);
        }
    }
}
