package p69.bridge;

/** Abstraccion refinada: funciona con cualquiera de los canales. */
public class InscripcionGrado extends Inscripcion {
    public InscripcionGrado(CanalInscripcion canal) {
        super(canal);
    }

    @Override
    public String getPrograma() {
        return "Grado";
    }
}
