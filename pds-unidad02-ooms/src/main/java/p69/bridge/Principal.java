package p69.bridge;

/** Cliente: combina las dos dimensiones por composicion, no por seis subclases. */
public class Principal {
    public static void main(String[] args) {
        System.out.println("BRIDGE - Simulacion de inscripciones (datos ficticios)");
        CanalInscripcion[] canales = {
            new CanalPresencial(), new CanalEnLinea(), new CanalMovil()
        };
        for (CanalInscripcion canal : canales) {
            Inscripcion grado = new InscripcionGrado(canal);
            Inscripcion posgrado = new InscripcionPosgrado(canal);
            System.out.println(grado.inscribir("Ana Torres"));
            System.out.println(posgrado.inscribir("Luis Vega"));
        }
    }
}
