package Point_3;

//Programa que llene un vector con números enteros y posteriormente mostrar los elementos del vector y al final la cantidad de números pares y la cantidad de números impares, así como la suma total de todos los elementos del vector.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VectorNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("VECTOR CON NUMEROS ENTEROS");
        System.out.print("Programa que indicara la cantidad de numeros pares e impares");
        System.out.print("\nAl final indicara la SUMA total del vector");
        System.out.println("\nCuantos numeros va a ingresar ? ");

        //Vector para almacenor los numeros.Usuario indicara la cantidad que ingresara
        int[] wholeNumbers = new int[sc.nextInt()];
        int sum = 0;

        //Bucle para captura de los numeros
        for (int i = 0; i < wholeNumbers.length; i++) {
            System.out.print("Introduzca el numero: ");
            wholeNumbers[i] = sc.nextInt();
        }

        //Vectores para almacenar los numeros pares e impares.
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();

        //Bucle para separar los numeros pares e impares.
        //Valida en el array inicial y luego agrega con metodo .add al array que segun corresponda y cumpla la condicion de validacion.
        for (int i = 0; i < wholeNumbers.length; i++) {
            if (wholeNumbers[i] % 2 == 0) {
                evenNumbers.add(wholeNumbers[i]);
            } else {
                oddNumbers.add(wholeNumbers[i]);
            }
        }

        //Bucle para recorrer el array y realizar la suma total de los elementos
        for (int i = 0; i < wholeNumbers.length; i++) {
            sum += wholeNumbers[i];
        }

        //VISUALIZACION DE LOS RESULTADOS
        //Metodo .size para saber la cantidad de elementos del Array
        System.out.println("Vector inicial: " + Arrays.toString(wholeNumbers));
        System.out.println("PARES: " + evenNumbers.size());
        System.out.println("IMPARES: " + oddNumbers.size());
        System.out.println("SUMA: " + sum);

    }


}
