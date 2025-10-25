package Activity_3;

public class MatrixMultiplication {

    // Atributos
    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] resultMultiplication;

    // Constructor
    public MatrixMultiplication(int[][] matrix1, int[][] matrix2) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
    }

    // Metodo para multiplicar las matrices
    public int[][] multiplyMatrices() {

        // Validacion de dimensiones
        if (matrix1[0].length != matrix2.length) {
            System.out.println("El numero de columnas de la primera matriz debe ser igual al numero de filas de la segunda matriz para ser multiplicadas. ⚠️");
            return null;
        }

        // Inicializar la matriz
        resultMultiplication = new int[matrix1.length][matrix2[0].length];

        // Multiplicacion de las matrices
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    resultMultiplication[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return resultMultiplication;
    }

    public void displayMultiplication() {

        // Colores ANSI
        final String GREEN_BRIGHT = "\u001B[92m";
        final String RESET = "\u001B[0m";

        // Mostrar la matriz resultante
        if (resultMultiplication != null) {
            System.out.println(GREEN_BRIGHT + "\nResultado de la MULTIPLICACION ✖️ de las matrices:" + RESET);
            for (int[] row : resultMultiplication) {
                for (int value : row) {
                    System.out.print(value + "\t");
                }
                System.out.println();
            }
        }
    }
    
}
