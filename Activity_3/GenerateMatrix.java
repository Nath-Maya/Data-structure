package Activity_3;

import java.util.Scanner;

public class GenerateMatrix {

    // ATRIBUTOS DE LA CLASE
    // Declarar dos matrices de enteros
    private int[][] matrix1;
    private int[][] matrix2;

    // CONSTRUCTOR DE LA CLASE
    public GenerateMatrix(int rows1, int cols1, int rows2, int cols2) {

        this.matrix1 = new int[rows][cols];
        this.matrix2 = new int[rows][cols];

    }

    // METODOS DE LA CLASE

    // Metodo para llenar las matrices con valores ingresados por el usuario
    public void fillMatrices(Scanner inputScanner, int[][] matrix, String matrixName) {

        System.out.println("Ingrese los valores para la" + matrixName + ":");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("Elemento [%d][%d]: ", i, j);
                matrix[i][j] = inputScanner.nextInt();
            }
        }

    }

    // Metodo para mostrar las matrices
    public void displayMatrices(int[][] matrix, String matrixName) {
        System.out.println("Valores de Matriz " + matrixName + ":");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }

    }

    // Metodos getter para acceder a las matrices desde fuera de la clase
    public int[][] getMatrix1() {
        return matrix1;
    }

    public int[][] getMatrix2() {
        return matrix2;
    }

}
