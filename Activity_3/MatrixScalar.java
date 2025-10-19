package Activity_3;

import java.util.Scanner;

public class MatrixScalar {

    // Atrbutos
    private int[][] matrix;
    private int scalar;
    private int[][] resultScalar;

    // Constructor
    public MatrixScalar(int[][] matrix, int scalar) {
        this.matrix = matrix;
        this.scalar = scalar;
        this.resultScalar = new int[matrix.length][matrix[0].length];
    }

    // Metodo para realizar el producto escalar
    public int[][] scalarProduct() {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                resultScalar[i][j] = matrix[i][j] * scalar;
            }

        }
        return resultScalar;

    }

    // Metodo para mostrar la matriz resultante del producto escalar
    public void displayScalar() {
        System.out.println("\nMatriz resultante del PRODUCTO ESCALAR ✴️: ");
        for (int i = 0; i < resultScalar.length; i++) {
            for (int j = 0; j < resultScalar[i].length; j++) {
                System.out.print(resultScalar[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Metodo estatico para seleccionar la matriz por parte del usuario
    public static int[][] selectMatrix(MatrixGenerator generateMatrix) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("\nCual matriz desea utilizar, 1 o 2 ?: ");
        int option = entrada.nextInt();

        if (option == 1) {
            return generateMatrix.getMatrix1();
        } else if (option == 2) {
            return generateMatrix.getMatrix2();
        } else {
            System.out.println("Opción no válida, usaremos la opcion 1 por defecto.");
            return generateMatrix.getMatrix1();
        }
    }

}
