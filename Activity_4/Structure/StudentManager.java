package Activity_4.Structure;

import java.util.Scanner;

public class StudentManager {
    private Scanner input = new Scanner(System.in);

    public Student createStudent() {

        System.out.println("INGRESO DATOS DEL ESTUDIANTE\n");

        System.out.print("Código de identificación del estudiante: ");
        int idCode = input.nextInt();
        input.nextLine();

        System.out.print("Nombre del estudiante: ");
        String name = input.nextLine();

        System.out.print("Apellido del estudiante: ");
        String lastName = input.nextLine();

        System.out.print("Edad del estudiante: ");
        int age = input.nextInt();

        // Crear gestores para capturar fecha de nacimiento, dirección y calificaciones
        BirthdateManager birthdateManager = new BirthdateManager();
        AddressManager addressManager = new AddressManager();
        GradesManager gradesManager = new GradesManager();

        // Capturar fecha de nacimiento, dirección y calificaciones
        Birthdate birthdate = birthdateManager.captureBirthdate(input);
        Address address = addressManager.captureAddress(input);
        Grades grades = gradesManager.captureGrades(input);


        // Crear y retornar el objeto Estudiante
        Student student = new Student(idCode, name, lastName, age, birthdate, address, grades);

        System.out.println("\n👨‍🎓 Estudiante creado exitosamente ✅ :\n" + student);
        return student;
    }

}
