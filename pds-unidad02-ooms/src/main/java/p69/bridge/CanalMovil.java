package p69.bridge;

/** Implementador concreto. Simula el registro mediante la aplicacion movil. */
public class CanalMovil implements CanalInscripcion {
    @Override
    public String registrar(String estudiante, String programa) {
        return estudiante + " | " + programa + " | Movil: registro en aplicacion movil";
    }
}
