package Activity_4.Structure;

import java.util.Scanner;

public class Birthdate {

    Scanner inputScanner = new Scanner(System.in);

    // ATRIBUTOS
    // Estructura arreglo para fecha de nacimiento : dia, mes, año
    // Me permite limitar los datos a almacenar, en este caso 3 datos

    private int[] birthdateArray = new int[3];

    // CONSTRUCTOR
    public Birthdate(int birthday, int birthMonth, int birthYear) {
        this.birthdateArray[0] = birthday; // dia se asigna en el index 0
        this.birthdateArray[1] = birthMonth; // mes se asigna en el index 1
        this.birthdateArray[2] = birthYear; // año se asigna en el index 2
    }

    // METODO GETTER
    public int[] getBirthdateArray() {
        return birthdateArray;
    }

    // METODO PARA CAPTURAR FECHA DE NACIMIENTO DESDE CONSOLA
    public void captureBirthdate(Scanner inputScanner) {

        System.out.println("🗓️ Ingrese su fecha de nacimiento (día/mes/año) en formato de Números:");

        System.out.print("Día: ");

        // Capturar y validar que el dia este entre 1 y 31
        birthdateArray[0] = inputScanner.nextInt();
        while (birthdateArray[0] < 1 || birthdateArray[0] > 31) {
            System.out.println("Día ❌. Por favor ingrese un día entre 1 y 31.");
            System.out.print("Día: ");
            birthdateArray[0] = inputScanner.nextInt();
        }

        System.out.print("Mes: ");

        // Capturar y validar que el mes este entre 1 y 12
        birthdateArray[1] = inputScanner.nextInt();
        while (birthdateArray[1] < 1 || birthdateArray[1] > 12) {
            System.out.println("Mes ❌. Por favor ingrese un mes entre 1 y 12.");
            System.out.print("Mes: ");
            birthdateArray[1] = inputScanner.nextInt();
        }

        System.out.print("Año: ");

        // Capturar y validar que el año no sea negativo
        birthdateArray[2] = inputScanner.nextInt();
        while (birthdateArray[2] < 0) {
            System.out.println("Año ❌. Por favor ingrese un numero que no sea negativo.");
            System.out.print("Año: ");
            birthdateArray[2] = inputScanner.nextInt();
        }

        //Impresion de la fecha de nacimiento capturada
        System.out.println("☑️ Fecha de nacimiento ingresada con exito: " + birthdateArray[0] + "/" + birthdateArray[1] + "/" + birthdateArray[2]);   
    }
}
