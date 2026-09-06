package p69.bridge;

/** Implementador concreto. Simula la atencion en ventanilla. */
public class CanalPresencial implements CanalInscripcion {
    @Override
    public String registrar(String estudiante, String programa) {
        return estudiante + " | " + programa + " | Presencial: registro en ventanilla";
    }
}
