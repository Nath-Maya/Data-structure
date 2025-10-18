package Activity_3;

import java.util.Scanner;

public class TwoDimensionalStructure {

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("PROGRAMA PARA REALIZAR OPERACIONES CON MATRICES");

        // Solicitar al usuario el numero de filas y columnas para las dos matrices
        System.out.println("Filas de la matriz 1");
        int rows1 = inputScanner.nextInt();
        System.out.println("Columnas de la matriz 1");
        int cols1 = inputScanner.nextInt();
        System.out.println("Filas de la matriz 2");
        int rows2 = inputScanner.nextInt();
        System.out.println("Columnas de la matriz 2");
        int cols2 = inputScanner.nextInt();

        // Crear una instancia de GenerateMatrix
        GenerateMatrix matrixGenerator = new GenerateMatrix(rows1, cols1, rows2, cols2);

        matrixGenerator.fillMatrices(inputScanner);
        matrixGenerator.displayMatrices();

        inputScanner.close();
    }
}
