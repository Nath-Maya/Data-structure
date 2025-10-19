package Activity_3;

import java.util.Scanner;

public class MatrixOperationsMenu {

    public static void iniciar(GenerateMatrix generateMatrix) {

        // Colores ANSI
        final String BLUE_BRIGHT = "\u001B[94m";
        final String RESET = "\u001B[0m";

        // Menu para seleccionar operacion con matrices
        Scanner entrada = new Scanner(System.in);
        int seleccion;

        do {

            // Menu para seleccionar operacion con matrices
            System.out.println(BLUE_BRIGHT + "Operaciones a Realizar con las matrices:" + RESET);
            System.out.print("\n1. Suma de matrices");
            System.out.print("\n2. Resta de matrices");
            System.out.print("\n3. Producto escalar");
            System.out.print("\n4. Multiplicacion de matrices");
            System.out.print("\n5. Salir");

            System.out.print("\nIngrese el numero que corresponde a la operacion que desea realizar:");

            seleccion = entrada.nextInt();

            // Captura de la opcion suministrada por el usuario, sobre la operacion que se
            // va a realizar.
            switch (seleccion) {
                case 1:
                    System.out.print("\nSUMA DE MATRICES.\n");

                    // Crea un nuevo objeto suma de tipo SumMatrix, usando las matrices que me
                    // entrega matrixGenerator a travez de sus getters
                    SumMatrix suma = new SumMatrix(generateMatrix.getMatrix1(), generateMatrix.getMatrix2());

                    suma.sumMatrices(); // Llama al metodo para sumar las matrices
                    suma.displaySumMatrix(); // Llama al metodo para mostrar la matriz resultante
                    break;

                case 2:
                    System.out.print("\nRESTA DE MATRICES.\n");

                    // Crea un nuevo objeto resta de tipo MatrixSubtraction, usando las matrices que
                    // me entrega matrixGenerator a travez de sus getters
                    MatrixSubtraction resta = new MatrixSubtraction(generateMatrix.getMatrix1(),
                            generateMatrix.getMatrix2());

                    resta.subtractMatrices(); // Llama al metodo para restar las matrices
                    resta.displaySubtract(); // Llama al metodo para mostrar la matriz resultante
                    break;
                case 3:
                    System.out.print("PRODUCTO ESCALAR.\n");

                    // Seleccionar la matriz a utilizar
                    int[][] selectedMatrix = ScalarMatrix.selectMatrix(generateMatrix);
                    System.out.print("Ingrese el valor escalar para multiplicar la matriz seleccionada: ");

                    // Leer el valor escalar
                    int scalarValue = entrada.nextInt();
                    // Crear una instancia de ScalarMatrix y realizar el producto escalar
                    ScalarMatrix escalar = new ScalarMatrix(selectedMatrix, scalarValue);

                    escalar.scalarProduct(); // Llama al metodo para calcular el producto escalar
                    escalar.displayScalar(); // Llama al metodo para mostrar el resultado del producto escalar
                    break;
                case 4:
                    System.out.print("\nMULTIPLICACION DE MATRICES.\n");

                    // Crea un nuevo objeto multiplicacion de tipo MultiplicationMatrix, usando las
                    // matrices que me
                    // entrega matrixGenerator a travez de sus getters
                    MultiplicationMatrix multiplicacion = new MultiplicationMatrix(generateMatrix.getMatrix1(),
                            generateMatrix.getMatrix2());
                    multiplicacion.multiplyMatrices(); // Llama al metodo para multiplicar las matrices
                    multiplicacion.displayMultiplication(); // Llama al metodo para mostrar la matriz resultante

                    break;
                case 5:
                    System.out.print("\nHas salido del programa...⛔");
                    break;
                default:
                    System.out.print("\nOpcion no valida. Por favor seleccione una opcion del 1 al 5.");
                    break;
            }

        } while (seleccion != 5);
        entrada.close();
    }

}
