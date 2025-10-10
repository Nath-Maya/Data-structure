package Point_1B;

import java.util.Arrays;
import java.util.Scanner;

public class TenOrderedNumbersV2 {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);

        System.out.println("Este programa ordenara de menor a mayor 10 numeros ");

        //Crear un array con capacidad de almacenar 10 numeros
        int[] numbers = new int[10];

        System.out.println("Digite los numeros a ser ordenados :");

        //Bucle para Ingresar los numeros (desde teclado) e introducirlos en el array
        for (int i = 0; i < numbers.length; i++) {
            //Solicitud de ingreso de cada numero al array
            System.out.println("Número #" + (i + 1) + " - ");
            numbers[i] = sc.nextInt();
        }

        //Mostrar array antes de ordenar
        System.out.println("Numeros ingresados (sin ordenar):" + Arrays.toString(numbers));

        //Metodo para ordenar los numeros
        Arrays.sort(numbers);

        //Mostrar array despues de ordenar
        System.out.println("Numeros ordenados:" );
        //Bucle for para imprimir los numeros ordenados
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        sc.close();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("⏱ Tiempo de ejecucion: " + totalTime + " ms");
    }
}
