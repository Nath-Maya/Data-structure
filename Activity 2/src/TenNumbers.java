package Activity;

import java.util.Scanner;

//1. Programa que lea 10 números por teclado, los almacene en un array y los ordene de menor a mayor y los muestre.

public class TenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Este programa ordenara de menor a mayor 10 numeros que ud ingresara ");
        //Crear un array con 10 posiciones
        int[] arr = new int[10];

        System.out.println("Ingresar los numeros que desea ordenar :");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            System.out.println(arr[i]);
        }
    }
}
