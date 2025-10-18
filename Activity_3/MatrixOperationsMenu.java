package Activity_3;


import java.util.Scanner;

public class MatrixOperationsMenu {

    public static void iniciar() {

        //Colores ANSI
        final String RED_BRIGHT = "\u001B[91m";
        final String RESET = "\u001B[0m";

        //Menu para seleccionar operacion con matrices
        Scanner entrada = new Scanner(System.in);
        int seleccion;

        //Menu para seleccionar operacion con matrices
        System.out.println(RED_BRIGHT + "Operaciones a Realizar con las matrices:" + RESET);
        System.out.print("\n1. Suma de matrices");
        System.out.print("\n2. Resta de matrices");
        System.out.print("\n3. Producto escalar");
        System.out.print("\n4. Multiplicacion de matrices");
        System.out.print("\n5. Salir");

        System.out.print("\nIngrese el numero que corresponde a la operacion que desea realizar:");

        seleccion = entrada.nextInt();

        //Captura de la opcion suministrada por el usuario, sobre la operacion que se va a realizar.
        switch (seleccion) {
            case 1:
                System.out.print("SUMA DE MATRICES.");
                break;
            case 2:
                System.out.print("RESTA DE MATRICES.");
                break;
            case 3:
                System.out.print("PRODUCTO ESCALAR.");
                break;
            case 4:
                System.out.print("MULTIPLICACION DE MATRICES.");
                break;
            case 5:
                System.out.print("SALIR.");
                break;
            default:
                System.out.print("Opcion no valida. Por favor seleccione una opcion del 1 al 5.");
                break;
        }

        entrada.close();

    }
}
