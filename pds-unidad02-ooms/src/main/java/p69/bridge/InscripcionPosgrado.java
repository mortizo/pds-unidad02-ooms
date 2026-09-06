package p69.bridge;

/** Abstraccion refinada: agregar un programa no exige duplicar los canales. */
public class InscripcionPosgrado extends Inscripcion {
    public InscripcionPosgrado(CanalInscripcion canal) {
        super(canal);
    }

    @Override
    public String getPrograma() {
        return "Posgrado";
    }
}
