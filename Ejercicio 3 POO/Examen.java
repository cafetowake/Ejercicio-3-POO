import java.util.ArrayList;

/**
 * Clase que representa un examen con su nombre y las notas de los estudiantes que lo realizaron.
 */

public class Examen {
    private String nombreExamen;
    private ArrayList<Double> notasEstudiantes;

    /**
     * Constructor de la clase Examen.
     *
     * @param nombreExamen El nombre del examen.
     */

    public Examen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
        this.notasEstudiantes = new ArrayList<>();
    }

    // Getters y setters
    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    /**
     * Obtiene la lista de notas de los estudiantes que realizaron el examen.
     *
     * @return Lista de notas de estudiantes.
     */

    public ArrayList<Double> getNotasEstudiantes() {
        return notasEstudiantes;
    }

    /**
     * Agrega la nota de un estudiante al examen.
     *
     * @param nota Nota del estudiante.
     */

    public void agregarNotaEstudiante(Double nota) {
        notasEstudiantes.add(nota);
    }
}
