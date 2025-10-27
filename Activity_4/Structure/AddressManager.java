package Activity_4.Structure;

import java.util.Scanner;

public class AddressManager {

    public Address captureAddress(Scanner inputScanner) {

        System.out.println("🏠 Ingrese a continuacion los datos de su direccion");

        // Declarar variables
        String address, stratum, neighborhood, city;

        System.out.print("Dirección: ");
        address = inputScanner.nextLine();
        while (address == null || address.trim().isEmpty()) {
            System.out.println("⚠️ La dirección no puede estar vacía. Intente nuevamente:");
            System.out.print("Dirección: ");
            address = inputScanner.nextLine();
        }

        // Capturar y validar que el estrato esté entre 1 y 6
        // Con integer.parseInt convierto el String a int para hacer la validacion
        // Luego vuelvo a convertirlo a String para almacenarlo en el arreglo.
        System.out.print("Estrato (1 a 6): ");
        String estratoInput = inputScanner.nextLine();
        while (true) {
            try {
                int estrato = Integer.parseInt(estratoInput.trim());
                if (estrato >= 1 && estrato <= 6) {
                    stratum = String.valueOf(estrato);
                    break;
                } else {
                    System.out.println("⚠️ Estrato incorrecto. Debe estar entre 1 y 6. Intente nuevamente:");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Ingrese un número válido entre 1 y 6:");
            }
            System.out.print("Estrato (1 a 6): ");
            estratoInput = inputScanner.nextLine();
        }

        // Capturar barrio y validar que no esten vacios
        System.out.print("Barrio: ");
        neighborhood = inputScanner.nextLine();
        while (neighborhood == null || neighborhood.trim().isEmpty()) {
            System.out.println("⚠️ El barrio no puede estar vacío. Intente nuevamente:");
            System.out.print("Barrio: ");
            neighborhood = inputScanner.nextLine();
        }

        // Capturar ciudad y validar que no esten vacios
        System.out.print("Ciudad: ");
        city = inputScanner.nextLine();
        while (city == null || city.trim().isEmpty()) {
            System.out.println("⚠️ La ciudad no puede estar vacía. Intente nuevamente:");
            System.out.print("Ciudad: ");
            city = inputScanner.nextLine();
        }

        // Impresion de la direccion capturada
        Address addressObj = new Address(address, stratum, neighborhood, city);
        System.out.println("☑️ Dirección ingresada con éxito: " + addressObj);
        return addressObj;

    }

}
