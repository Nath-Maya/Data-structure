package Activity_3;

import java.util.Scanner;

public class TwoDimensionalStructure {

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        // Colores ANSI
        final String YELLOW_BRIGHT = "\u001B[93m";
        final String RESET = "\u001B[0m";

        // Encabezado
        System.out.println("\n" + YELLOW_BRIGHT +
                "✨──────────────────────────────────────────────✨");
        System.out.println(" PROGRAMA PARA OPERAR CON MATRICES  " + RESET + "\n");

        // Solicitar al usuario el número de filas y columnas para las dos matrices
        System.out.println("Filas de la matriz 1:");
        int rows1 = inputScanner.nextInt();
        System.out.println("Columnas de la matriz 1:");
        int cols1 = inputScanner.nextInt();

        System.out.println("Filas de la matriz 2:");
        int rows2 = inputScanner.nextInt();
        System.out.println("Columnas de la matriz 2:");
        int cols2 = inputScanner.nextInt();

        // Crear una instancia de GenerateMatrix
        GenerateMatrix matrixGenerator = new GenerateMatrix(rows1, cols1, rows2, cols2);

        // Llenar las matrices con valores ingresados por el usuario
        matrixGenerator.fillMatrices(inputScanner, matrixGenerator.getMatrix1(), "1");
        matrixGenerator.fillMatrices(inputScanner, matrixGenerator.getMatrix2(), "2");

        // Mostrar las matrices ingresadas por el usuario
        matrixGenerator.displayMatrices(matrixGenerator.getMatrix1(), "1");
        matrixGenerator.displayMatrices(matrixGenerator.getMatrix2(), "2");

        inputScanner.close();
    }
}
