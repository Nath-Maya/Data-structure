package Activity_4.Structure;

import java.util.Scanner;

public class Address {

    Scanner inputScanner = new Scanner(System.in);

    // ATRIBUTOS
    // Estructura de arreglo para direccion: direccion, estrato, barrio y ciudad

    private String[] addressArray = new String[4];

    // CONSTRUCTOR
    public Address(String address, String stratum, String neighborhood, String city) {
        this.addressArray[0] = address; // direccion se asigna en el index 0
        this.addressArray[1] = stratum; // estrato se asigna en el index 1
        this.addressArray[2] = neighborhood; // barrio se asigna en el index 2
        this.addressArray[3] = city; // ciudad se asigna en el index 3
    }

    // METODO GETTER
    public String[] getAddressArray() {
        return addressArray;
    }

    // METODO PARA CAPTURAR DIRECCION DESDE CONSOLA
    public void captureAddress(Scanner inputScanner) {

        System.out.println("🏠 Ingrese su dirección:");

        System.out.print("Dirección: ");
        addressArray[0] = inputScanner.nextLine();

        // Capturar y validar que el estrato esté entre 1 y 6
        //Con integer.parseInt convierto el String a int para hacer la validacion
        //Luego vuelvo a convertirlo a String para almacenarlo en el arreglo.
        System.out.print("Estrato (1 a 6): ");
        while (true) {
            String input = inputScanner.nextLine();
            try {
                int estrato = Integer.parseInt(input);
                if (estrato >= 1 && estrato <= 6) {
                    addressArray[1] = String.valueOf(estrato);
                    break; 
                } else {
                    System.out.println("⚠️ Estrato incorrecto. Debe estar entre 1 y 6. Intente nuevamente:");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Ingrese un número válido entre 1 y 6:");
            }
        }

        System.out.print("Barrio: ");
        addressArray[2] = inputScanner.nextLine();

        System.out.print("Ciudad: ");
        addressArray[3] = inputScanner.nextLine();

        // Impresion de la direccion capturada
        System.out.println("☑️ Dirección ingresada con éxito: " + addressArray[0] + ", " + addressArray[1] + ", "
                + addressArray[2] + ", " + addressArray[3]);
    }
}
