package Activity_4.Structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {

    // Lista para almacenar los estudiantes creados
    private List<Student> students = new ArrayList<>();

    // Crea un estudiante usando el Scanner proporcionado, lo almacena en la lista
    // interna y lo retorna.
    public Student createStudent(Scanner input) {

        System.out.println("\n➡️ INGRESO DATOS DEL ESTUDIANTE\n");

        // Validar que el código sea un entero válido. Si el usuario ingresa un
        // valor no numérico, se volverá a solicitar hasta obtener un entero.
        int idCode;
        while (true) {
            System.out.print("Código de identificación del estudiante: ");
            String idLine = input.nextLine();
            try {
                idCode = Integer.parseInt(idLine.trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("❌ Código incorrecto. Debe ser numeros enteros.");
            }
        }

        // Capturar nombre, apellido y edad
        System.out.print("Nombre del estudiante: ");
        String name = input.nextLine();

        System.out.print("Apellido del estudiante: ");
        String lastName = input.nextLine();

        System.out.print("Edad del estudiante: ");
        int age = input.nextInt();
        input.nextLine();

        // Crear gestores para capturar fecha de nacimiento, dirección y calificaciones
        BirthdateManager birthdateManager = new BirthdateManager();
        AddressManager addressManager = new AddressManager();
        GradesManager gradesManager = new GradesManager();

        // Capturar fecha de nacimiento, dirección y calificaciones
        Birthdate birthdate = birthdateManager.captureBirthdate(input);
        // consumir newline si es necesario antes de nextLine en address
        input.nextLine();
        Address address = addressManager.captureAddress(input);
        Grades grades = gradesManager.captureGrades(input);
        // Consumir el newline que queda después de nextDouble() dentro de captureGrades
        input.nextLine();

        // Crear y almacenar el objeto Student
        Student student = new Student(idCode, name, lastName, age, birthdate, address, grades);
        students.add(student);

        System.out.println("\n👨‍🎓 Estudiante creado exitosamente ✅ :\n" + student);
        return student;
    }

    // Devuelve la lista de estudiantes
    public List<Student> getStudents() {
        return students;
    }

    // Calcula el promedio de edades de los estudiantes registrados
    public double calculateAverageAge() {
        if (students.isEmpty())
            return 0.0;
        double sum = 0.0;
        for (Student s : students) {
            sum += s.getAge();
        }
        return sum / students.size();
    }

    // Devuelve la lista de estudiantes mayores de edad (edad >= 18)
    public List<Student> getAdults() {
        List<Student> adults = new ArrayList<>();
        for (Student s : students) {
            if (s.getAge() >= 18)
                adults.add(s);
        }
        return adults;
    }

    // Devuelve el estudiante con mayor promedio (si existe)
    public java.util.Optional<Student> getStudentWithHighestAverage() {
        if (students.isEmpty())
            return java.util.Optional.empty();
        Student best = null;
        for (Student s : students) {
            if (best == null || s.getAverageGrade() > best.getAverageGrade()) {
                best = s;
            }
        }
        return java.util.Optional.ofNullable(best);
    }

    // Devuelve el estudiante con menor promedio (si existe)
    public java.util.Optional<Student> getStudentWithLowestAverage() {
        if (students.isEmpty())
            return java.util.Optional.empty();
        Student worst = null;
        for (Student s : students) {
            if (worst == null || s.getAverageGrade() < worst.getAverageGrade()) {
                worst = s;
            }
        }
        return java.util.Optional.ofNullable(worst);
    }

    // Devuelve el estudiante que obtuvo la nota más baja en "Nota 1"
    public java.util.Optional<Student> getStudentWithLowestNota1() {
        if (students.isEmpty())
            return java.util.Optional.empty();
        Student lowest = null;
        double lowestValue = Double.MAX_VALUE;
        for (Student s : students) {
            if (s.getGrades() == null || s.getGrades().getGradesMap() == null)
                continue;
            Double nota1 = s.getGrades().getGradesMap().get("Nota 1");
            if (nota1 == null)
                continue;
            if (nota1 < lowestValue) {
                lowestValue = nota1;
                lowest = s;
            }
        }
        return java.util.Optional.ofNullable(lowest);
    }

}
