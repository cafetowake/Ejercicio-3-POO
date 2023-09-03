public class DriverProgram {
    public static void main(String[] args) {
        SedeUniversitaria sede = new SedeUniversitaria();

        
        System.out.println("Información de estudiantes registrados:");
        for (Estudiante estudiante : sede.getEstudiantes()) {
            System.out.println(estudiante.toString());
        }

        System.out.println("\nInformación de resultados de exámenes:");
        for (Examen examen : sede.getResultadosExamenes()) {
            System.out.println(examen.toString());
        }

        // Calcular estadísticas y mostrar nota más baja y más alta
        sede.calcularEstadisticas();
        sede.mostrarNotaMasBajaAlta();
    }
}
