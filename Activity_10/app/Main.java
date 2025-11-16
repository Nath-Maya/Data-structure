package Activity_10.app;

import Activity_10.manager.BudgetManager;
import java.util.Scanner;

public class Main {

    // Colores ANSI
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instanciar el gestor de presupuestos con persistencia
        String storagePath = "Activity_10/data/presupuestos.dat";

        // archivo por defecto dentro de data/
        BudgetManager manager = new BudgetManager(storagePath);

        // Bucle del MENU
        //Cada opcion se llama a un metodo del gestor de presupuestos, que maneja la logica interna
        String option;
        do {
            printMenu();
            System.out.print("Opciones a seleccionar: ");
            option = scanner.nextLine().trim();
            switch (option) {
                case "1":
                    manager.registerBudget(scanner);
                    break;
                case "2":
                    manager.showAll();
                    break;
                case "3":
                    manager.saveToFile();
                    break;
                case "4":
                    manager.loadFromFile();
                    break;
                case "5":
                    manager.searchById(scanner);
                    break;
                case "6":
                    manager.deleteById(scanner);
                    break;
                case "0":
                    System.out.println(GREEN + "🔚 Saliendo del programa presupuestos." + RESET);
                    break;
                default:
                    System.out.println(RED + "Opcion seleccionada errada, intente nuevamente" + RESET);
            }
        } while (!option.equals("0"));

        scanner.close();
    }

    private static void printMenu() {
        System.out.println(BLUE + "PROMGRAMA DE PRESUPUESTOS 💰 - Artes graficas" + RESET);
        System.out.println("1. 👉 Ingresar presupuesto");
        System.out.println("2. 💻 Mostrar todos los presupuestos");
        System.out.println("3. 💾 Guardar listado en archivo");
        System.out.println("4. ♻️ Recuperar datos desde archivo");
        System.out.println("5. 🔍 Buscar presupuesto por ID");
        System.out.println("6. ⛔ Eliminar presupuesto por ID");
        System.out.println("0. SALIR");
        System.out.println(BLUE + "********************************************************" + RESET);
    }
}
