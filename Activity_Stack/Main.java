package Activity_Stack;

import java.util.Scanner;


public class Main {

    // Colores ANSI para consola
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();

        // Bucle principal para el MENU
        String option;
        do {
            printMenu();
            System.out.print("Seleccione una opción: ");
            option = scanner.nextLine().trim();

            // Procesar la opcion elegida
            switch (option) {
                case "1":
                    insertArticle(stack, scanner);
                    pause(scanner);
                    break;
                case "2":
                    System.out.println(YELLOW + "\n--- ARTICULOS EN LA PILA 📋 ---" + RESET);
                    stack.display();
                    pause(scanner);
                    break;
                    case "3":
                        try {
                            Article removed = stack.popOrThrow();
                            System.out.println(GREEN + "🗑️ Artículo eliminado: " + removed + RESET);
                        } catch (java.util.EmptyStackException e) {
                            System.out.println(RED + "⚠️ No hay artículos para eliminar." + RESET);
                        }
                        pause(scanner);
                        break;
                case "0":
                    System.out.println(GREEN + "\nSaliendo del programa..." + RESET);
                    break;
                default:
                    System.out.println(RED + "Opción incorrecta." + RESET);
            }
        } while (!option.equals("0"));

        scanner.close();
    }

    // Imprime el menú principal con formato y color
    private static void printMenu() {
        System.out.println(BLUE + "\n**************** MENÚ DEL PROGRAMA 🛒 *************" + RESET);
    System.out.println("\n1. Insertar un artículo 📝");
    System.out.println("2. Ver los elementos de la PILA 📋 (LIFO)");
    System.out.println("3. Eliminar artículo (pop) 🗑️");
    System.out.println("0. Salir 🚪\n");
        
    }

    // Inserta un artículo leyendo los datos desde la consola
    private static void insertArticle(Stack stack, Scanner scanner) {
    System.out.println(YELLOW + "\n--- � Insertar un artículo ---" + RESET);
    int code = readInt(scanner, "👉 Ingrese el código del artículo: ", 1);

        String name = readNonEmptyString(scanner, "Ingrese el nombre: ", "El nombre no puede quedar vacío. Por favor ingresa un nombre válido.");
        String detail = readNonEmptyString(scanner, "Ingrese detalle: ", "El detalle no puede quedar vacío. Por favor ingresa un detalle válido.");

        double price = readDouble(scanner, "Ingrese valor: ", 0.0);

    Article article = new Article(code, name, detail, price);
    stack.push(article);
    System.out.println(GREEN + "✅ ✨ Artículo agregado con éxito!" + RESET);
    }

    // Leer double con validación
    private static double readDouble(Scanner scanner, String prompt, double minValue) {
        double value;
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                value = Double.parseDouble(line);
                if (value < minValue) {
                    System.out.println(RED + "El valor debe ser mayor o igual a " + minValue + "." + RESET);
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println(RED + "Entrada inválida. Por favor escribe un número válido (p. ej. 12000 o 12000.50)." + RESET);
            }
        }
    }

    // Leer entero con validación y mínimo aceptable
    private static int readInt(Scanner scanner, String prompt, int minValue) {
        int value;
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                value = Integer.parseInt(line);
                if (value < minValue) {
                    System.out.println(RED + "El código debe ser un número entero positivo mayor o igual a " + minValue + "." + RESET);
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println(RED + "Entrada INCORRECTA. Por favor escribe un número entero." + RESET);
            }
        }
    }

    // Leer cadena no vacía con mensaje de error personalizado
    private static String readNonEmptyString(Scanner scanner, String prompt, String errorMessage) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println(RED + errorMessage + RESET);
        }
    }

    // Pausa hasta que el usuario presione ENTER
    private static void pause(Scanner scanner) {
        System.out.print("\nPresione ENTER para continuar...");
        scanner.nextLine();
    }
}
