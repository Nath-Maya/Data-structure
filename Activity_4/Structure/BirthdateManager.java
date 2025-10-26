package Activity_4.Structure;
import java.util.Scanner;

public class BirthdateManager {

    public Birthdate captureBirthdate(Scanner inputScanner) {

        System.out.println("🗓️ Ingrese su fecha de nacimiento (día/mes/año) en formato de Números:");

        // Declaracion de variables
        int day, month, year;

        // Capturar y validar que el dia este entre 1 y 31
        System.out.print("Día: ");
        day = inputScanner.nextInt();
        while (day < 1 || day > 31) {
            System.out.println("Día ❌. Por favor ingrese un día entre 1 y 31.");
            day = inputScanner.nextInt();
        }

        // Capturar y validar que el mes este entre 1 y 12
        System.out.print("Mes: ");
        month = inputScanner.nextInt();
        while (month < 1 || month > 12) {
            System.out.println("Mes ❌. Por favor ingrese un mes entre 1 y 12.");
            month = inputScanner.nextInt();
        }

        // Capturar y validar que el año no sea negativo
        System.out.print("Año: ");
        year = inputScanner.nextInt();
        while (true) {
            if (year >= 0) {
                break;
            }
            System.out.println("Año ❌. Por favor ingrese un año válido (no negativo).");
            year = inputScanner.nextInt();
        }

        // Imprimir fecha de nacimiento ingresada y devolver arreglo
        Birthdate birthdate = new Birthdate(day, month, year);
        System.out.println("☑️ Fecha de nacimiento ingresada con exito: " + birthdate);
        return birthdate;
    }

}
