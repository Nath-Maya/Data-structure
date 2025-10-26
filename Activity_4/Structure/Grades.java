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

    // Constructor vacio para inicializar el objeto sin notas
    public Grades() {
    }

    // GETTERS
    public java.util.HashMap<String, Double> getGradesMap() {
        return gradesMap;
    }

    // METODO PARA CALCULAR EL PROMEDIO DE LAS NOTAS
    public double calculateAverage() {
        double sum = 0.0;
        for (double grade : gradesMap.values()) {
            sum += grade;
        }
        return gradesMap.size() > 0 ? sum / gradesMap.size() : 0.0;
    }
}
