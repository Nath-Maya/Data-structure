package Point_1A;

import java.util.Arrays;
import java.util.Scanner;

//1. Programa que lea 10 números por teclado, los almacene en un array y los ordene de menor a mayor y los muestre.

public class TenOrderedNumbers {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);

        System.out.println("Este programa ordenara de menor a mayor 10 numeros ");

        //Crear un array con capacidad de almacenar 10 numeros
        int[] unorderedNumbers = new int[10];

        System.out.println("Digite los numeros a ser ordenados :");

        //Bucle para Ingresar los numeros (desde teclado) e introducirlos en el array
        for (int i = 0; i < unorderedNumbers.length; i++) {
            //Solicitud de ingreso de cada numero al array
            System.out.println("Número #" + (i + 1) + " - ");
            unorderedNumbers[i] = sc.nextInt();
        }

        //Mostrar array antes de ordenar
        System.out.println("Numeros ingresados (sin ordenar):" + Arrays.toString(unorderedNumbers));

        //Metodo para ordenar los numeros
        Arrays.sort(unorderedNumbers);
        //Mostrar array despues de ordenar
        System.out.println("Numeros ordenados:" + Arrays.toString(unorderedNumbers));

        sc.close();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("⏱ Tiempo de ejecucion: " + totalTime + " ms");
    }
}
