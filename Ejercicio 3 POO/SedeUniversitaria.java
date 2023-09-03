import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa una sede universitaria con su lista de estudiantes y resultados de exámenes.
 */
public class SedeUniversitaria {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Examen> resultadosExamenes;

    /**
     * Constructor de la clase SedeUniversitaria.
     * Inicializa las listas de estudiantes y resultados de exámenes.
     */
    public SedeUniversitaria() {
        estudiantes = new ArrayList<>();
        resultadosExamenes = new ArrayList<>();
    }

    /**
     * Registra un estudiante en la sede universitaria.
     *
     * @param estudiante Estudiante a registrar.
     */
    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    /**
     * Agrega el resultado de un examen a la sede universitaria.
     *
     * @param examen Examen a agregar.
     */

    public void agregarResultadoExamen(Examen examen) {
        resultadosExamenes.add(examen);
    }

    /**
     * Calcula estadísticas de los resultados de los exámenes.
     * Calcula el promedio, mediana, moda y desviación estándar de las notas de los exámenes.
     */
    public void calcularEstadisticas() {
        for (Examen examen : resultadosExamenes) {
            List<Double> notas = examen.getNotasEstudiantes();
            if (!notas.isEmpty()) {
                double promedio = calcularPromedio(notas);
                double mediana = calcularMediana(notas);
                double moda = calcularModa(notas);
                double desviacionEstandar = calcularDesviacionEstandar(notas);
    
                System.out.println("Estadísticas para el examen '" + examen.getNombreExamen() + "':");
                System.out.println("Promedio: " + promedio);
                System.out.println("Mediana: " + mediana);
                System.out.println("Moda: " + moda);
                System.out.println("Desviación Estándar: " + desviacionEstandar);
            }
        }
    }

    /**
     * Muestra la nota más baja y más alta en cada examen.
     */
    public void mostrarNotaMasBajaAlta() {
        for (Examen examen : resultadosExamenes) {
            List<Double> notas = examen.getNotasEstudiantes();
            if (!notas.isEmpty()) {
                double notaMasBaja = Collections.min(notas);
                double notaMasAlta = Collections.max(notas);
    
                System.out.println("Notas más baja y más alta para el examen '" + examen.getNombreExamen() + "':");
                System.out.println("Nota más baja: " + notaMasBaja);
                System.out.println("Nota más alta: " + notaMasAlta);
            }
        }
    }

    private double calcularPromedio(List<Double> notas) {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }
    
    private double calcularMediana(List<Double> notas) {
        Collections.sort(notas);
        int n = notas.size();
        if (n % 2 == 0) {
            // Si hay un número par de notas, se calcula el promedio de las dos del medio.
            int medio1 = n / 2 - 1;
            int medio2 = n / 2;
            return (notas.get(medio1) + notas.get(medio2)) / 2.0;
        } else {
            // Si hay un número impar de notas, se devuelve la nota del medio.
            return notas.get(n / 2);
        }
    }
    
    private double calcularModa(List<Double> notas) {
        if (notas.isEmpty()) {
            return 0.0; // En caso de que la lista esté vacía, la moda es 0.
        }
    
        // Creamos un arreglo de frecuencias para cada nota posible.
        int[] frecuencias = new int[101]; // Suponemos notas entre 0 y 100.
    
        // Contamos las frecuencias de cada nota.
        for (double nota : notas) {
            int notaEntera = (int) Math.round(nota); // Redondeamos la nota a un número entero.
            if (notaEntera >= 0 && notaEntera <= 100) {
                frecuencias[notaEntera]++;
            }
        }
    
        // Encontramos la nota (o notas) con la mayor frecuencia.
        int modaFrecuencia = 0;
        List<Double> modaNotas = new ArrayList<>();
    
        for (int i = 0; i <= 100; i++) {
            if (frecuencias[i] > modaFrecuencia) {
                modaFrecuencia = frecuencias[i];
                modaNotas.clear();
                modaNotas.add((double) i);
            } else if (frecuencias[i] == modaFrecuencia) {
                modaNotas.add((double) i);
            }
        }
    
        // Si hay múltiples modas, retornamos la primera encontrada.
        if (!modaNotas.isEmpty()) {
            return modaNotas.get(0);
        }
    
        return 0.0; // Si no se encontró ninguna moda, retornamos 0.
    }
    
    private double calcularDesviacionEstandar(List<Double> notas) {
        double promedio = calcularPromedio(notas);
        double sumaCuadrados = 0;
        for (double nota : notas) {
            sumaCuadrados += Math.pow(nota - promedio, 2);
        }
        double varianza = sumaCuadrados / notas.size();
        return Math.sqrt(varianza);

    }
    
    /**
     * Obtiene la lista de estudiantes registrados en la sede.
     *
     * @return Lista de estudiantes.
     */

        public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    /**
     * Obtiene la lista de resultados de exámenes registrados en la sede.
     *
     * @return Lista de resultados de exámenes.
     */

    public ArrayList<Examen> getResultadosExamenes() {
        return resultadosExamenes;
    }
}