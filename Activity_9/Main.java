package Activity_9;

import java.util.Scanner;

public class Main {

    // METODO PRINCIPAL
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // COLORES ANSI
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_ORANGE = "\u001B[33m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_BLUE = "\u001B[34m";

        System.out.print(ANSI_BLUE + "PROGRAMA DE GESTION DE PROFESORES 👩‍🏫👨‍🏫\n\n" + ANSI_RESET);


        // instanciar la lista de profesores
        ProfessorList list = new ProfessorList();

        // Instanciar el gestor de profesores
        ProfessorManager manager = new ProfessorManager(list);

        // Bucle del MENU
        String option;
        do {
            printMenu();

            option = scanner.nextLine().trim();

            // Ejecutar la opcion seleccionada
            switch (option) {
                case "1":
                    // Registrar profesor
                    manager.registerProfessor(scanner);
                    break;
                case "2":
                    // Mostrar listado
                    manager.showAll();
                    break;
                case "3":
                    // Buscar por código
                    manager.searchByCode(scanner);
                    break;
                case "4":
                    // Eliminar por código
                    manager.deleteByCode(scanner);
                    break;
                case "5":
                    System.out.println(ANSI_ORANGE + "SALIENDO DEL PROGRAMA... 👋" + ANSI_RESET);
                    break;
                default:
                    System.out.println(ANSI_RED + "Esta opcion es incorrecta. Intente de nuevo." + ANSI_RESET);
            }
        } while (!option.equals("5"));

        scanner.close();
    }

    // Imprimir el menu principal
    private static void printMenu() {

        System.out.println("1️⃣  Registrar PROFESOR:");
        System.out.println("2️⃣  Mostrar el listado de PROFESORES:");
        System.out.println("3️⃣  Buscar un profesor por su CÓDIGO:");
        System.out.println("4️⃣  Eliminar un profesor por su CÓDIGO:");
        System.out.println("5️⃣  Salir ➡️");

    }
}
