package Point_2;

//Programa que lea 5 números por teclado, los copie a otro array multiplicados por 2 y muestre el segundo array.

import java.util.Arrays;
import java.util.Scanner;

public class FiveNumbers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Este programa duplicara 5 los numeros ingresados");

        //Crear el array con la misma capacidad del primer array
        int [] fiveNumbers = new int[5];

        System.out.println("Ingrese los 5 numeros que desea duplicar: ");

        //Bucle para almacenar los numeros ingresados por teclado, al arrray fiveNumbers
        for (int i = 0; i < fiveNumbers.length; i++) {
            System.out.println("Número #" + (i + 1) + " - ");
            fiveNumbers[i] = sc.nextInt();
        }

        // Crear el array para los numeros duplicados, iterar en el array fivenumbers y aplicar la multiplicacion para realizar el duplicado
        int [] duplicatedNumbers = new int[fiveNumbers.length];
        for (int i = 0; i < fiveNumbers.length; i++) {
            duplicatedNumbers[i] = fiveNumbers[i]*2;
        }

        //Mostrar array inicial
        System.out.println("Numeros sin duplicar:" + Arrays.toString(fiveNumbers));

        //Mostrar array FINAL
        System.out.println("Numeros DUPLICADOS:" + Arrays.toString(duplicatedNumbers));
    }
}
