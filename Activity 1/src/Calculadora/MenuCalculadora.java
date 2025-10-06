package Calculadora;

import java.util.Scanner;

public class MenuCalculadora {
    public static void  iniciar() {
        Scanner sc = new Scanner(System.in);

        //Menu para seleccionar opciones de la calculadora
        System.out.println("CALCULADORA");
        System.out.println("==========================================");
        System.out.println("Opciones de operaciones: ");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");

        //Captura del dato de entrada que suministra el usuario que corresponde a la opcion.
        System.out.println("Ingrese el numero de la opcion que desea ejecutar: ");
        int op = sc.nextInt();

        //Toma del primer numero para realizar el calculo
        System.out.println("Ingrese el primer numero: ");
        int number1 = sc.nextInt();

        //Toma del segundo numero para realizar el calculo
        System.out.println("Ingrese el segundo numero: ");
        int number2 = sc.nextInt();

        //Estructura caso para seleccionar la opcion de operacion a realizar.
        switch (op) {
            case 1:
                System.out.print("Resultado de la Suma: " + Operaciones.suma(number1, number2));
                break;
            case 2:
                System.out.print("Resultado de la Resta: " + Operaciones.resta(number1, number2));
                break;
            case 3:
                System.out.print("Resultado de la Multiplicacion: " + Operaciones.multiplicacion(number1, number2));
                break;
            case 4:
                System.out.print("Resultado de la Division: " + Operaciones.division(number1, number2));
                break;

                default:
                    System.out.println("La opcion no existe");
        }
        sc.close();
    }
}
