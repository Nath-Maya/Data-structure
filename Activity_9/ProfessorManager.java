package Activity_9;

import java.util.Scanner;

// Gestor de profesores
public class ProfessorManager {

    // Color ANSI
    String ANSI_RESET = "\u001B[0m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_BLUE = "\u001B[34m";

    // ATRIBUTOS
    private ProfessorList list;

    // CONSTRUCTOR
    public ProfessorManager(ProfessorList list) {
        this.list = list;
    }

    // METODOS PRINCIPALES

    // Registrar profesor
    public void registerProfessor(Scanner scanner) {

        System.out.println(ANSI_BLUE + "\n--- 📋 REGISTRO DE PROFESOR ---" + ANSI_RESET);

        int code;
        while (true) { // validar que el código sea entero y que no exista previamente
            System.out.print("Ingrese el codigo del profesor: ");
            String line = scanner.nextLine();
            try {
                code = Integer.parseInt(line.trim());
                // Validar código duplicado
                if (list.findByCode(code) != null) {
                    System.out.println(ANSI_RED + "⚠️ Ya existe un profesor con ese codigo. Intente con otro." + ANSI_RESET);
                    continue; // volver a pedir
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "❌ Incorrecto. Debe ingresar un numero entero para el codigo." + ANSI_RESET);
            }
        }

        // Capturar los datos
        // Nombre, Apellido, Telefono

        System.out.print("Nombre: ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Apellido: ");
        String lastName = scanner.nextLine().trim();

        System.out.print("Telefono o # Celular: ");
        String phone = scanner.nextLine().trim();

        Professor p = new Professor(code, firstName, lastName, phone);
        list.add(p);
        System.out.println(ANSI_GREEN + "👌 Profesor registrado SATISFACTORIAMENTE." + ANSI_RESET);
    }

    // Mostrar listado
    public void showAll() {
        System.out.println(ANSI_BLUE + "\n 🗂️ --- LISTA DE PROFESORES ---" + ANSI_RESET);
        list.printAll();
    }

    // Buscar profesor por codigo
    public void searchByCode(Scanner scanner) {
        System.out.print("\nIngrese el codigo del profesor que desea buscar 🔎: ");
        String line = scanner.nextLine();
        int code;
        // Validar que el codigo ingresado sea un numero entero
        try {
            code = Integer.parseInt(line.trim());
        } catch (NumberFormatException e) {
            System.out.println("Codigo incorrecto. Debe ser un numero entero.");
            return;
        }
        // Buscar el profesor
        Professor p = list.findByCode(code);
        if (p == null) {
            System.out.println(ANSI_RED + "Profesor no ❓ encontrado." + ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "🟢 ENCONTRADO: " + p + ANSI_RESET);
        }
    }

    // Eliminar por código
    public void deleteByCode(Scanner scanner) {
        System.out.print("\nIngrese el codigo del profesor que desea ELIMINAR ❌: ");
        // Validar que el codigo ingresado sea un numero entero
        String line = scanner.nextLine();
        int code;
        try {
            code = Integer.parseInt(line.trim());
        } catch (NumberFormatException e) {
            System.out.println("Formato de codigo invalido.");
            return;
        }
        // Intentar eliminar el profesor
        boolean removed = list.deleteByCode(code);
        if (removed) {
            System.out.println(ANSI_GREEN + "⛔ Profesor eliminado exitosamente." + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Profesor no ❓ encontrado." + ANSI_RESET);
        }
    }
}
