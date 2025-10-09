package Activity;

import java.util.Arrays;
import java.util.Scanner;

//1. Programa que lea 10 números por teclado, los almacene en un array y los ordene de menor a mayor y los muestre.

public class TenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Este programa ordenara de menor a mayor 10 numeros ");

        //Crear un array con 10 posiciones
        int[] arr = new int[10];

        System.out.println("Digite los numeros a ser ordenados :");

        //Bucle para Ingresar los numeros
        for (int i = 0; i < arr.length; i++) {
            //Solicitud de ingreso de cada numero al array
            System.out.println("Número #" + (i + 1) + " - ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Numeros ingresados (sin ordenar):" + Arrays.toString(arr));

        sc.close();
    }
}
