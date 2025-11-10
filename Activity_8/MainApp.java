package Activity_8;

import java.util.Scanner;


public class MainApp {

    // Colores ANSI 
    public static final String BLUE = "\u001B[34m";   
    public static final String GREEN = "\u001B[32m";  
    public static final String RED = "\u001B[31m";    
    public static final String YELLOW = "\u001B[33m"; 
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TruckQueue queue = new TruckQueue();

        // Bucle principal para el MENU
        String option;
        do {
            printMenu();
            System.out.print("Elige una opción: ");
            option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    handleInsert(queue, scanner);
                    pause(scanner);
                    break;
                case "2":
                    System.out.println(YELLOW + "\n--- 🚛 Camiones en cola (FIFO) ---" + RESET);
                    queue.display();
                    pause(scanner);
                    break;
                case "0":
                    System.out.println(GREEN + "\n¡Saliendo!...👋" + RESET);
                    break;
                default:
                    System.out.println(RED + "❌ Opcion incorrecta, inténtalo de nuevo." + RESET);
            }
        } while (!option.equals("0"));

        scanner.close();
    }


    //Imprime el menu principal del programa, moastrando las opciones disponibles
    private static void printMenu() {
        System.out.println(BLUE + "\n MENÚ PRINCIPAL " + RESET);
        System.out.println("\n1. Insertar entrada del camión 🛻");
        System.out.println("2. Mostrar los camiones 📋");
        System.out.println("0. Salir 🚪");
        System.out.println("-----------------------------------\n");
    }

    // Metodo para manejar la insertada de un nuevo camion en la cola
    private static void handleInsert(TruckQueue queue, Scanner scanner) {
        System.out.println(YELLOW + "\n--- Insertar nuevo camión ---" + RESET);

        // Leer y validar los datos del camión
        int code = readInt(scanner, "Codigo del vehiculo: ");
        String plate = readNonEmptyString(scanner, "Placa: ");
        String driver = readNonEmptyString(scanner, "Nombre del conductor: ");

        // Crear el objeto Truck y agregarlo a la cola
        Truck truck = new Truck(code, plate, driver);
        try {
            queue.enqueue(truck);
            System.out.println(GREEN + "✅ Camión agregado a la cola con exito." + RESET);
        } catch (IllegalArgumentException ex) {
            System.out.println(RED + "⚠️ " + ex.getMessage() + RESET);
        }
    }


    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value <= 0) {
                    System.out.println(RED + "El código debe ser un número positivo." + RESET);
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println(RED + "Entrada inválida. Escribe un número entero." + RESET);
            }
        }
    }

    // Metodo para leer una cadena no vacia 
    private static String readNonEmptyString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println(RED + "No puede quedar vacío, inténtalo de nuevo." + RESET);
        }
    }

    // Metodo para pausar hasta que el usuario presione ENTER
    private static void pause(Scanner scanner) {
        System.out.print("\nPresiona ENTER para continuar...");
        scanner.nextLine();
    }

    // Clase interna que representa un camión
    private static class Truck {
        private final int code;
        private final String plate;
        private final String driver;

        public Truck(int code, String plate, String driver) {
            this.code = code;
            this.plate = plate;
            this.driver = driver;
        }

        public int getCode() {
            return code;
        }

        public String getPlate() {
            return plate;
        }

        public String getDriver() {
            return driver;
        }

        @Override
        public String toString() {
            return String.format("Codigo: %d | Placa: %s | Conductor: %s", code, plate, driver);
        }
    }

    // Cola FIFO simple para Truck
    private static class TruckQueue {
        private java.util.LinkedList<Truck> list = new java.util.LinkedList<>();

        // Agregar camión al final de la cola
        public void enqueue(Truck truck) {
            if (truck == null) {
                throw new IllegalArgumentException("El camión no puede ser nulo.");
            }
            list.addLast(truck);
        }

        // Mostrar todos los camiones en la cola
        public void display() {
            if (list.isEmpty()) {
                System.out.println(YELLOW + "La cola está vacía." + RESET);
                return;
            }
            int idx = 1;
            for (Truck t : list) {
                System.out.println(idx++ + ". " + t);
            }
        }
    }
}
