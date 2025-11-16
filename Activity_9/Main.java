package Activity_9;

import java.util.Scanner;

public class Main {

    // COLORES ANSI (visibles para todos los métodos)
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_ORANGE = "\u001B[33m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";

    // METODO PRINCIPAL
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(ANSI_BLUE + "PROGRAMA DE GESTION DE PROFESORES 👩‍🏫👨‍🏫\n\n" + ANSI_RESET);


    // Instanciar el gestor moderno de profesores (lista + árbol + persistencia)
    String storage = "Activity_9/profesores.dat"; // archivo por defecto
    ProfesorManager manager = new ProfesorManager(storage);

        // Bucle del MENU
        String option;
        do {
            printMenu();

            option = scanner.nextLine().trim();

            // Ejecutar la opcion seleccionada
            switch (option) {
                case "1":
                    // Registrar profesor
                    manager.registerProfesor(scanner);
                    break;
                case "2":
                    // Mostrar listado
                    manager.showAll();
                    break;
                case "3":
                    // Crear y guardar listado en archivo
                    manager.saveToFile();
                    break;
                case "4":
                    // Recuperar datos desde archivo
                    manager.loadFromFile();
                    break;
                case "5":
                    // Buscar por código (usa árbol)
                    manager.searchByCode(scanner);
                    break;
                case "6":
                    // Eliminar por código (lista + árbol)
                    manager.deleteByCode(scanner);
                    break;
                case "7":
                    System.out.println(ANSI_ORANGE + "SALIENDO DEL PROGRAMA... 👋" + ANSI_RESET);
                    break;
                default:
                    System.out.println(ANSI_RED + "Esta opcion es incorrecta. Intente de nuevo." + ANSI_RESET);
            }
        } while (!option.equals("7"));

        scanner.close();
    }

    // Imprimir el menu principal
    private static void printMenu() {
        System.out.println(ANSI_BLUE + "******************************************" + ANSI_RESET);
        System.out.println("1. REGISTRAR PROFESOR");
        System.out.println("2. MOSTRAR LISTADO PROFESORES");
        System.out.println("3. CREAR Y GUARDAR LISTADO DE PROFESORES EN ARCHIVO");
        System.out.println("4. RECUPERAR DATOS DEL ARCHIVO");
        System.out.println("5. BUSCAR PROFESOR POR CÓDIGO (usar árbol)");
        System.out.println("6. ELIMINAR PROFESOR POR CÓDIGO");
        System.out.println("7. SALIR");
        System.out.println(ANSI_BLUE + "******************************************" + ANSI_RESET);

    }
}
