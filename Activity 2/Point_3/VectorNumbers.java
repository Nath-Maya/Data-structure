package Point_3;

//Programa que llene un vector con números enteros y posteriormente mostrar los elementos del vector y al final la cantidad de números pares y la cantidad de números impares, así como la suma total de todos los elementos del vector.

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

        //Bucle para captura de los numeros
        for (int i = 0; i < wholeNumbers.length; i++) {
            System.out.print("Introduzca el numero: ");
            wholeNumbers[i] = sc.nextInt();
        }

        //Vectores para almacenar los numeros pares e impares.
        //Con el mismo tamaño del array inicial, ya que se desconoce de que tamaño seran finalmente.
        int[] evenNumbers = new int[wholeNumbers.length];
        int[] oddNumbers = new int[wholeNumbers.length];

        //Bucle para separar los numeros pares e impares.
        for (int i = 0; i < wholeNumbers.length; i++) {
            if (wholeNumbers[i] % 2 == 0) {
                evenNumbers[i] = wholeNumbers[i];
            } else {
                oddNumbers[i] = wholeNumbers[i];
            }
        }

        //VISUALIZACION DE LOS RESULTADOS
        System.out.println("Vector inicial: " + Arrays.toString(wholeNumbers));
        System.out.println("PARES: " + evenNumbers.length);
        System.out.println("IMPARES: " + oddNumbers.length);

    }


}
