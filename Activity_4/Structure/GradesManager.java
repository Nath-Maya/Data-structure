package Activity_4.Structure;

import java.util.Scanner;

public class GradesManager {

    // Método que captura las notas del usuario y devuelve un objeto Grades
    public Grades captureGrades(Scanner inputScanner) {

        System.out.println("📘 Ingrese las tres notas del estudiante (de 0.0 a 5.0):");

        double[] gradesArray = new double[3];

        // Capturar y validar cada nota
        for (int i = 0; i < 3; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            double grade = inputScanner.nextDouble();

            // Validar que esté en el rango permitido
            while (grade < 0.0 || grade > 5.0) {
                System.out.println("❌ Nota inválida. Debe estar entre 0.0 y 5.0.");
                System.out.print("Ingrese nuevamente la Nota " + (i + 1) + ": ");
                grade = inputScanner.nextDouble();
            }

            gradesArray[i] = grade; // Guardar nota válida
        }

        // Crear objeto Grades con las tres notas
        Grades grades = new Grades(gradesArray[0], gradesArray[1], gradesArray[2]);

        // Mostrar resumen
        System.out.println("\n✅ Notas registradas exitosamente:");
        for (String key : grades.getGradesMap().keySet()) {
            System.out.println(key + ": " + grades.getGradesMap().get(key));
        }

        // Calcular y mostrar promedio
        double average = grades.calculateAverage();
        System.out.printf("📊 Promedio final: %.2f%n", average);

        // Retornar el objeto Grades
        return grades;
    }
}
