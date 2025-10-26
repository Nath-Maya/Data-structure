package Activity_4.Structure;

import java.util.Scanner;

public class Grades {

    Scanner inputScanner = new Scanner(System.in);

    // ATRIBUTOS
    // Estructura de Hashmap para almacenar las notas (nota 1, nota 2 , nota 3)
    private java.util.HashMap<String, Double> gradesMap = new java.util.HashMap<>();

    // CONSTRUCTOR
    public Grades(double grade1, double grade2, double grade3) {
        this.gradesMap.put("Nota 1", grade1); // nota 1 se asigna con la clave "Nota 1"
        this.gradesMap.put("Nota 2", grade2); // nota 2 se asigna con la clave "Nota 2"
        this.gradesMap.put("Nota 3", grade3); // nota 3 se asigna con la clave "Nota 3"
    }

    // METODO GETTER
    public java.util.HashMap<String, Double> getGradesMap() {
        return gradesMap;
    }

    // METODO PARA CAPTURAR NOTAS DESDE CONSOLA
    public void captureGrades(Scanner inputScanner) {
        System.out.println("📝 Ingresar las notas del estudiante:");

        // Iterar sobre las claves del HashMap para capturar cada nota
        for (String key : gradesMap.keySet()) {
            System.out.print(key + ": ");
            double grade = inputScanner.nextDouble();
            while (grade < 0 || grade > 5) {
                System.out.println("⚠️ Nota incorrecta. Debe estar entre 0 y 5. Intente nuevamente:");
                System.out.print(key + ": ");
                grade = inputScanner.nextDouble();
            }
            gradesMap.put(key, grade);
        }
    }

}
