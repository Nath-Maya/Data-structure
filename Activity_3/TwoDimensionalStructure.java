package Activity_3;

public class TwoDimensionalStructure {

    public static void main(String[] args) {

        // Colores ANSI
        final String YELLOW_BRIGHT = "\u001B[93m";
        final String RESET = "\u001B[0m";

        // Encabezado
        System.out.println("\n" + YELLOW_BRIGHT +
                "✨──────────────────────────────────────────────✨");
        System.out.println(" PROGRAMA PARA OPERAR CON MATRICES  " + RESET + "\n");

        // Crear una instancia de GenerateMatrix
        GenerateMatrix matrixGenerator = new GenerateMatrix();

        // Llamar al metodo para determinar el tamaño de las matrices
        matrixGenerator.sizeMatrix();

        // Llamar al metodo para llenar las matrices
        matrixGenerator.fillMatrices(matrixGenerator.inputScanner, matrixGenerator.getMatrix1(), "1");
        matrixGenerator.fillMatrices(matrixGenerator.inputScanner, matrixGenerator.getMatrix2(), "2");

        // Llamar al metodo para mostrar las matrices
        matrixGenerator.displayMatrices(matrixGenerator.getMatrix1(), "1");
        matrixGenerator.displayMatrices(matrixGenerator.getMatrix2(), "2");


        //Menu de operaciones con matrices
        MatrixOperationsMenu.iniciar();
    }
}
