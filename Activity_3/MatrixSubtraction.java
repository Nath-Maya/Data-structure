package Activity_3;

public class MatrixSubtraction {

      // Atributos
    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] resultSubtract;

    // Constructor
    public MatrixSubtraction(int[][] matrix1, int[][] matrix2) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
    }

    // Metodo para restar las matrices
    public int[][] subtractMatrices() {

        // Validacion de dimensiones
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.out.println("Las matrices deben tener las mismas dimensiones para ser restadas. ⚠️");
            return null;
        }

        // Inicializar la matriz
        resultSubtract = new int[matrix1.length][matrix1[0].length];

        // Suma de las matrices
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                resultSubtract[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return resultSubtract;
    }

    public void displaySubtract() {

        // Colores ANSI
        final String GREEN_BRIGHT = "\u001B[92m";
        final String RESET = "\u001B[0m";

        // Mostrar la matriz resultante
        if (resultSubtract != null) {
            System.out.println(GREEN_BRIGHT + "\nResultado de la RESTA ➖ de las matrices:" + RESET);
            for (int[] row : resultSubtract) {
                for (int value : row) {
                    System.out.print(value + "\t");
                }
                System.out.println();
            }
        }
    }
    
}
