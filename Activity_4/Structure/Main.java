package Activity_4.Structure;

public class Main {

    public static void main(String[] args) {

        //COLOR ANSI PARA CONSOLA
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_FUCSIA = "\u001B[95m";

        System.out.println(ANSI_FUCSIA + "\n👩‍💻 Programa de Gestion de Datos y Notas de Estudiantes 📚\n" + ANSI_RESET);

        StudentManager studentManager = new StudentManager();
        Student student = studentManager.createStudent();

    }
}
