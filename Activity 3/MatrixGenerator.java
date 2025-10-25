package Activity_3;

import java.util.Scanner;

public class MatrixGenerator {

    Scanner inputScanner = new Scanner(System.in);

    // ATRIBUTOS DE LA CLASE
    // Declarar dos matrices de enteros
    private int[][] matrix1;
    private int[][] matrix2;

    // CONSTRUCTOR DE LA CLASE
    public MatrixGenerator() {

    }

    // METODOS DE LA CLASE

    // Metodo para determinar el tamaño de las matrices
    public void sizeMatrix() {
        System.out.println("Filas de la matriz 1:");
        int rows1 = inputScanner.nextInt();
        System.out.println("Columnas de la matriz 1:");
        int cols1 = inputScanner.nextInt();
        System.out.println("Filas de la matriz 2:");
        int rows2 = inputScanner.nextInt();
        System.out.println("Columnas de la matriz 2:");
        int cols2 = inputScanner.nextInt();

        // Inicializar las matrices con el tamaño especificado
        matrix1 = new int[rows1][cols1];
        matrix2 = new int[rows2][cols2];
    }

    // Metodo para llenar las matrices con valores ingresados por el usuario
    public void fillMatrices(Scanner inputScanner, int[][] matrix, String matrixName) {

        System.out.println("Ingrese los valores para la Matriz # " + matrixName + ":");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("Numero # %d: ", i * matrix[i].length + j + 1);
                matrix[i][j] = inputScanner.nextInt();
            }
        }

    }

    // Metodo para mostrar las matrices
    public void displayMatrices(int[][] matrix, String matrixName) {
        System.out.println("----------------------------------");
        System.out.println("Valores de MATRIZ " + matrixName + ":");
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
