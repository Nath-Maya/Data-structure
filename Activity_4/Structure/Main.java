package Activity_4.Structure;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        //Toma de datos de prueba para Grades
        Grades studentGrades = new Grades(0.0, 0.0, 0.0);
        studentGrades.captureGrades(new java.util.Scanner(System.in)); 
    }
}


