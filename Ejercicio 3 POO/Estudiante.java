import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que representa a un estudiante universitario con sus datos personales y resultados de exámenes.
 */

public class Estudiante {
    private String nombre;
    private String apellido;
    private String codigoUnico;
    private Date fechaNacimiento;
    private String correoElectronico;
    private ArrayList<Examen> resultadosExamenes;


    /**
     * Constructor de la clase Estudiante.
     *
     * @param nombre           El nombre del estudiante.
     * @param apellido         El apellido del estudiante.
     * @param codigoUnico      El código único del estudiante.
     * @param fechaNacimiento  La fecha de nacimiento del estudiante (en formato yyyy-MM-dd).
     * @param correoElectronico El correo electrónico del estudiante.
     */

    public Estudiante(String nombre, String apellido, String codigoUnico, Date fechaNacimiento, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoUnico = codigoUnico;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.resultadosExamenes = new ArrayList<>();
    }

    // Get y Set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public ArrayList<Examen> getResultadosExamenes() {
        return resultadosExamenes;
    }

    public void agregarResultadoExamen(Examen examen) {
        resultadosExamenes.add(examen);
    }
}