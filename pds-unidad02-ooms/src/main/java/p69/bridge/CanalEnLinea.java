package p69.bridge;

/** Implementador concreto. Simula el registro mediante el portal web. */
public class CanalEnLinea implements CanalInscripcion {
    @Override
    public String registrar(String estudiante, String programa) {
        return estudiante + " | " + programa + " | En linea: registro en portal web";
    }
}
