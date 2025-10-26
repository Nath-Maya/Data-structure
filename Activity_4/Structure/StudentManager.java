package Activity_4.Structure;

import java.util.Scanner;

public class StudentManager {
    private Scanner input = new Scanner(System.in);

    public Student createStudent() {
        System.out.print("Código de identificación del estudiante: ");
        int idCode = input.nextInt();
        input.nextLine();

        System.out.print("Nombre del estudiante: ");
        String name = input.nextLine();

        System.out.print("Apellido del estudiante: ");
        String lastName = input.nextLine();

        System.out.print("Edad del estudiante: ");
        int age = input.nextInt();
        input.nextLine();

        // Capturar datos de las estructuras anidadas
        Birthdate birthdate = new Birthdate(0, 0, 0);
        birthdate.captureBirthdate(input);
        Address address = new Address("", "", "", "");
        address.captureAddress(input);
        Grades grades = new Grades(0.0, 0.0, 0.0);
        grades.captureGrades(input);

        return new Student(idCode, name, lastName, age, birthdate, address, grades);
    }

}
