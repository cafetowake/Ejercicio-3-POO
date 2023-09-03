import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Clase principal que contiene el punto de entrada del programa.
 * Permite interactuar con el sistema de registro de estudiantes y exámenes.
 */
public class Main {
    private static SedeUniversitaria sede = new SedeUniversitaria();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de registro de estudiantes y exámenes.");

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Agregar resultado de examen");
            System.out.println("3. Calcular estadísticas");
            System.out.println("4. Mostrar nota más baja y más alta");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    // Registro de estudiante
                    System.out.println("Ingrese el nombre del estudiante:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el apellido del estudiante:");
                    String apellido = scanner.nextLine();
                    System.out.println("Ingrese el código único del estudiante:");
                    String codigoUnico = scanner.nextLine();
                    System.out.println("Ingrese la fecha de nacimiento del estudiante (yyyy-MM-dd):");
                    Date fechaNacimiento = null;
                    boolean fechaValida = false;
                    while (!fechaValida) {
                        String fechaNacimientoStr = scanner.nextLine();
                        fechaNacimiento = parseDate(fechaNacimientoStr);
                        if (fechaNacimiento != null) {
                            fechaValida = true;
                        } else {
                            System.out.println("Formato de fecha incorrecto. Use el formato yyyy-MM-dd. Intente nuevamente:");
                        }
                    }
                    System.out.println("Ingrese el correo electrónico del estudiante:");
                    String correoElectronico = scanner.nextLine();

                    Estudiante estudiante = new Estudiante(nombre, apellido, codigoUnico, fechaNacimiento, correoElectronico);
                    sede.registrarEstudiante(estudiante);
                    System.out.println("Estudiante registrado exitosamente.");
                    break;

                case 2:
                    // Agregar resultado de examen
                    System.out.println("Ingrese el código único del estudiante:");
                    String codigoEstudiante = scanner.nextLine();
                    Estudiante estudianteEncontrado = buscarEstudiantePorCodigo(sede, codigoEstudiante);

                    if (estudianteEncontrado != null) {
                        // Aquí permitimos al usuario elegir el tipo de examen
                        System.out.println("Seleccione el tipo de examen:");
                        System.out.println("1. Matemáticas");
                        System.out.println("2. Lenguaje");
                        System.out.println("3. Química");
                        System.out.println("4. Física");
                        System.out.println("5. Comprensión Lectora");
                        System.out.println("6. Estadística");

                        int tipoExamen = scanner.nextInt();
                        scanner.nextLine(); 

                        String nombreExamen = "";
                        switch (tipoExamen) {
                            case 1:
                                nombreExamen = "Matemáticas";
                                break;
                            case 2:
                                nombreExamen = "Lenguaje";
                                break;
                            case 3:
                                nombreExamen = "Química";
                                break;
                            case 4:
                                nombreExamen = "Física";
                                break;
                            case 5:
                                nombreExamen = "Comprensión Lectora";
                                break;
                            case 6:
                                nombreExamen = "Estadística";
                                break;
                            default:
                                System.out.println("Opción no válida. Selecciona un tipo de examen válido.");
                                break;
                        }

                        if (!nombreExamen.isEmpty()) {
                            System.out.println("Ingrese la nota del estudiante:");
                            double nota = scanner.nextDouble();
                            scanner.nextLine(); 

                            Examen examen = new Examen(nombreExamen);
                            examen.agregarNotaEstudiante(nota);
                            estudianteEncontrado.agregarResultadoExamen(examen);
                            System.out.println("Resultado de examen agregado exitosamente.");
                        }
                    } else {
                        System.out.println("Estudiante no encontrado. Verifique el código único.");
                    }
                    break;
                case 3:
                    sede.calcularEstadisticas();
                    System.out.println("Estadísticas calculadas exitosamente.");
                    break;

                case 4:
                    sede.mostrarNotaMasBajaAlta();
                    break;

                case 5:
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    // Método para buscar un estudiante por código único
    private static Estudiante buscarEstudiantePorCodigo(SedeUniversitaria sede, String codigo) {
        for (Estudiante estudiante : sede.getEstudiantes()) {
            if (estudiante.getCodigoUnico().equals(codigo)) {
                return estudiante;
            }
        }
        return null;
    }

    private static Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto. Use el formato yyyy-MM-dd.");
            return null;
        }
    }

    public static void procesarEstudianteYExamen(Estudiante estudiante, Examen examen) {
    }
}