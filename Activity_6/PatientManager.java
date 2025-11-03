package Activity_6;

import java.util.List;
import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario. Presenta el menú y
 * delega operaciones a DoublyLinkedList. Mantiene únicamente la lógica de
 * interacción (responsabilidad única).
 */
public class PatientManager {

    // Códigos ANSI para colorear la salida en consola
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";

    private DoublyLinkedList list;
    private Scanner scanner;

    public PatientManager(DoublyLinkedList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }

    // Muestra el menú y procesa las opciones hasta que el usuario elige salir
    public void run() {
        String option;
        do {
            printMenu();
            System.out.print("Seleccione una opción: ");
            option = scanner.nextLine().trim();
            switch (option) {
                case "1":
                    registerPatient();
                    break;
                case "2":
                    showListAsc();
                    break;
                case "3":
                    showListDesc();
                    break;
                case "4":
                    updatePatient();
                    break;
                case "5":
                    searchByAge();
                    break;
                case "6":
                    deletePatient();
                    break;
                case "7":
                    System.out.println(GREEN + "Gracias, hasta luego. Saliendo..." + RESET);
                    break;
                default:
                    System.out.println(RED + "Opción inválida. Intente nuevamente." + RESET);
            }
        } while (!option.equals("7"));
    }

    // Imprime el menú principal con colores
    private void printMenu() {
        System.out.println(BLUE + "==============================" + RESET);
        System.out.println(BLUE + "   🏥 Bienvenido a la Clínica" + RESET);
        System.out.println(BLUE + "==============================" + RESET);
        System.out.println("1. REGISTRAR PACIENTE");
        System.out.println("2. MOSTRAR LISTADO ASC X CÓDIGO");
        System.out.println("3. MOSTRAR LISTADO DSC X CÓDIGO");
        System.out.println("4. ACTUALIZAR PACIENTE");
        System.out.println("5. BUSCAR PACIENTE POR EDAD");
        System.out.println("6. ELIMINAR DATOS DE PACIENTE");
        System.out.println("7. SALIR");
    }

    // Registrar paciente con validaciones (código entero y único, edad entero)
    private void registerPatient() {
        System.out.println(YELLOW + "\n--- Registrar paciente ---" + RESET);

        int code = readIntWithPrompt("Ingrese el código (entero): ");
        // Validar duplicado
        if (list.findByCode(code) != null) {
            System.out.println(RED + "Ya existe un paciente con ese código. Registro cancelado." + RESET);
            return;
        }

        System.out.print("Nombre: ");
        String name = scanner.nextLine().trim();

        System.out.print("Apellido: ");
        String lastName = scanner.nextLine().trim();

        System.out.print("Dirección: ");
        String address = scanner.nextLine().trim();

        System.out.print("Teléfono: ");
        String phone = scanner.nextLine().trim();

        int age = readIntWithPrompt("Edad (entero): ");

        Patient p = new Patient(code, name, lastName, address, phone, age);
        list.addLast(p);
        System.out.println(GREEN + "Paciente registrado correctamente." + RESET);
    }

    // Mostrar listado ascendente por código
    private void showListAsc() {
        System.out.println(YELLOW + "\n--- Listado ASC por código ---" + RESET);
        if (list.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }
        List<Patient> patients = list.toListAscByCode();
        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    // Mostrar listado descendente por código
    private void showListDesc() {
        System.out.println(YELLOW + "\n--- Listado DSC por código ---" + RESET);
        if (list.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }
        List<Patient> patients = list.toListDescByCode();
        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    // Actualizar paciente por código
    private void updatePatient() {
        System.out.println(YELLOW + "\n--- Actualizar paciente ---" + RESET);
        int code = readIntWithPrompt("Ingrese el código del paciente a actualizar: ");
        Patient existing = list.findByCode(code);
        if (existing == null) {
            System.out.println(RED + "Paciente no encontrado." + RESET);
            return;
        }
        System.out.println("Deje en blanco para mantener el valor actual.");

        System.out.print("Nombre (actual: " + existing.getName() + "): ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty()) existing.setName(name);

        System.out.print("Apellido (actual: " + existing.getLastName() + "): ");
        String lastName = scanner.nextLine().trim();
        if (!lastName.isEmpty()) existing.setLastName(lastName);

        System.out.print("Dirección (actual: " + existing.getAddress() + "): ");
        String address = scanner.nextLine().trim();
        if (!address.isEmpty()) existing.setAddress(address);

        System.out.print("Teléfono (actual: " + existing.getPhone() + "): ");
        String phone = scanner.nextLine().trim();
        if (!phone.isEmpty()) existing.setPhone(phone);

        String ageInput;
        System.out.print("Edad (actual: " + existing.getAge() + "): ");
        ageInput = scanner.nextLine().trim();
        if (!ageInput.isEmpty()) {
            try {
                int age = Integer.parseInt(ageInput);
                existing.setAge(age);
            } catch (NumberFormatException e) {
                System.out.println(RED + "Edad inválida. Manteniendo la anterior." + RESET);
            }
        }
        System.out.println(GREEN + "Paciente actualizado." + RESET);
    }

    // Buscar pacientes por edad
    private void searchByAge() {
        System.out.println(YELLOW + "\n--- Buscar por edad ---" + RESET);
        int age = readIntWithPrompt("Ingrese la edad a buscar: ");
        List<Patient> found = list.findByAge(age);
        if (found.isEmpty()) {
            System.out.println("No se encontraron pacientes con esa edad.");
            return;
        }
        for (Patient p : found) {
            System.out.println(p);
        }
    }

    // Eliminar paciente por código
    private void deletePatient() {
        System.out.println(YELLOW + "\n--- Eliminar paciente ---" + RESET);
        int code = readIntWithPrompt("Ingrese el código del paciente a eliminar: ");
        boolean removed = list.deleteByCode(code);
        if (removed) {
            System.out.println(GREEN + "Paciente eliminado correctamente." + RESET);
        } else {
            System.out.println(RED + "Paciente no encontrado." + RESET);
        }
    }

    // Utilidad: leer entero con prompt y validación
    private int readIntWithPrompt(String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                value = Integer.parseInt(line);
                return value;
            } catch (NumberFormatException e) {
                System.out.println(RED + "Entrada inválida. Por favor ingrese un número entero." + RESET);
            }
        }
    }
}
