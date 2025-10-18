package Activity_3;

import java.util.Scanner;

public class GenerateMatrix {

    // ATRIBUTOS DE LA CLASE
    // Declarar dos matrices de enteros
    private int[][] matrix1;
    private int[][] matrix2;

    // CONSTRUCTOR DE LA CLASE
    public GenerateMatrix(int rows1, int cols1, int rows2, int cols2) {

        this.matrix1 = new int[rows1][cols1];
        this.matrix2 = new int[rows2][cols2];

    }

    // METODOS DE LA CLASE

    // Metodo para llenar las matrices con valores ingresados por el usuario
    public void fillMatrices(Scanner inputScanner) {

        System.out.println("Ingrese los valores para la matriz 1:");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                // Llenar matrix1
                matrix1[i][j] = inputScanner.nextInt();
            }
        }

        System.out.println("Ingrese los valores para la matriz 2:");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                // Llenar matrix2
                matrix2[i][j] = inputScanner.nextInt();
            }
        }

    }

    // Metodo para mostrar las matrices
    public void displayMatrices() {
        System.out.println("Matriz 1:");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Matriz 2:");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }

    }

}
