package Activity_6;

import java.util.Scanner;

/**
 * Punto de entrada de la aplicación.
 * Crea la lista y el gestor, y arranca el bucle principal.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();
        PatientManager manager = new PatientManager(list, scanner);

        // Ejecutar la aplicación (menú)
        manager.run();

        scanner.close();
    }
}
