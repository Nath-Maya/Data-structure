package Activity_4.Structure;

public class Main {

    public static void main(String[] args) {

        // COLOR ANSI PARA CONSOLA
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_FUCSIA = "\u001B[95m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RED = "\u001B[31m";

        System.out.println(ANSI_FUCSIA + "\n👩‍💻 Programa de Gestion de Datos y Notas de Estudiantes 📚\n" + ANSI_RESET);

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        StudentManager studentManager = new StudentManager();

        String respuesta;

        // Bucle para crear múltiples estudiantes
        do {
            studentManager.createStudent(scanner);
            System.out.print(ANSI_RED + "\n¿Desea ingresar otro estudiante? (S/N): " + ANSI_RESET);
            respuesta = scanner.next();
            scanner.nextLine(); // consumir newline
        } while (respuesta.equalsIgnoreCase("S") || respuesta.equalsIgnoreCase("Y"));

        // Cuando el usuario responde N, mostrara las estadisticas
        System.out.println(ANSI_GREEN + "\n--- 📈 ESTADISTICAS DE ESTUDIANTES ---" + ANSI_RESET);

        // Verificar si hay estudiantes registrados
        if (studentManager.getStudents().isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            double avgAge = studentManager.calculateAverageAge();
            System.out.printf(ANSI_BLUE + "👉 Promedio de edades: %.2f\n" + ANSI_RESET, avgAge);

            // Mostrar mayores de edad
            System.out.println(ANSI_BLUE + "\n 👉 Estudiantes mayores de edad (>=18):" + ANSI_RESET);
            java.util.List<Student> adults = studentManager.getAdults();
            if (adults.isEmpty()) {
                System.out.println("  Ninguno");
            } else {
                for (Student s : adults) {
                    System.out.println(s);
                }
            }

            // Estudiante con mayor promedio
            System.out.println(ANSI_BLUE + "\n👉 Estudiante con mayor promedio:" + ANSI_RESET);
            java.util.Optional<Student> best = studentManager.getStudentWithHighestAverage();
            if (best.isPresent()) {
                System.out.println(best.get());
            } else {
                System.out.println("  Ninguno");
            }

            // Estudiante con menor promedio
            System.out.println(ANSI_BLUE + "\n👉 Estudiante con menor promedio:" + ANSI_RESET);
            java.util.Optional<Student> worst = studentManager.getStudentWithLowestAverage();
            if (worst.isPresent()) {
                System.out.println(worst.get());
            } else {
                System.out.println("  Ninguno");
            }

            // Estudiante con la nota1 más baja
            System.out.println(ANSI_BLUE + "\n👉 Estudiante con la nota1 más baja:" + ANSI_RESET);
            java.util.Optional<Student> lowestNota1 = studentManager.getStudentWithLowestNota1();
            if (lowestNota1.isPresent()) {
                System.out.println(lowestNota1.get());
            } else {
                System.out.println("  Ninguno");
            }
        }

        scanner.close();

    }
}
