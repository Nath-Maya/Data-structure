
# Actividad 3 — Operaciones con matrices 🧮

Objetivo

Crear un programa con menú que permita trabajar con dos matrices de enteros: crearlas, llenarlas, mostrarlas (con posiciones) y realizar operaciones (suma, resta, multiplicación por escalar y multiplicación matricial). Todo debe implementarse usando funciones y paso de parámetros. ✨

Funcionalidades principales

- Generar dos matrices de enteros de cualquier tamaño, insertar elementos e imprimirlas con sus posiciones 📋
- Sumar y restar las matrices (validando dimensiones) ➕➖
- Multiplicar una matriz por un escalar (pedir un entero y calcular el producto escalar) 🔢✖️
- Multiplicar las dos matrices (validando compatibilidad de dimensiones) ✖️🔁
- Salir

Validaciones rápidas

- Dimensiones > 0
- Suma/ resta: mismas filas y columnas
- Multiplicación matricial: columnas de A == filas de B
- Verificar que las matrices estén creadas antes de operar ✅

Uso breve

1. Ejecuta el programa y usa el menú para crear/llenar las matrices.
2. Selecciona la operación que quieras realizar.


Clases y métodos

- GenerateMatrix
	- GenerateMatrix(int rows1, int cols1, int rows2, int cols2)
		- Crea dos matrices con las dimensiones indicadas.
	- void fillMatrices(Scanner inputScanner, int[][] matrix, String matrixName)
		- Llena la matriz indicada leyendo enteros desde el teclado. Muestra un contador para cada número (p. ej. "Número # 1").
	- void displayMatrices(int[][] matrix, String matrixName)
		- Imprime la matriz por filas y columnas.
	- int[][] getMatrix1() / int[][] getMatrix2()
		- Devuelven las matrices para operaciones externas.

- TwoDimensionalStructure
	- public static void main(String[] args)
		- Controla el flujo del programa:
			1. Pide fila y columna de la matriz 1 y luego sus valores (formato "Elemento # n:").
			2. Pide fila y columna de la matriz 2 y luego sus valores.
			3. Muestra ambas matrices.
	- private static void fillMatrixSequential(Scanner scanner, int[][] matrix)
		- Helper que pide valores secuencialmente mostrando "Elemento # n:".
	- private static void copyMatrix(int[][] src, int[][] dest)
		- Copia los valores de una matriz fuente a una destino (misma dimensión).

- MatrixGenerator
	- MatrixGenerator()
		- Clase que administra la creación y almacenamiento de las dos matrices.
	- void sizeMatrix()
		- Pide al usuario filas y columnas para ambas matrices e inicializa los arreglos.
	- void fillMatrices(Scanner inputScanner, int[][] matrix, String matrixName)
		- Llena la matriz indicada leyendo valores del usuario (muestra "Numero # n").
	- void displayMatrices(int[][] matrix, String matrixName)
		- Imprime la matriz con un encabezado y formato de tabla.
	- int[][] getMatrix1() / int[][] getMatrix2()
		- Devuelven las matrices internas.

- MatrixAdd
	- MatrixAdd(int[][] matrix1, int[][] matrix2)
		- Constructor que recibe las dos matrices a sumar.
	- int[][] sumMatrices()
		- Valida dimensiones, realiza la suma y devuelve la matriz resultante.
	- void displaySumMatrix()
		- Muestra la matriz suma si fue calculada.

- MatrixSubtraction
	- MatrixSubtraction(int[][] matrix1, int[][] matrix2)
		- Constructor que recibe las dos matrices a restar.
	- int[][] subtractMatrices()
		- Valida dimensiones, realiza la resta y devuelve la matriz resultante.
	- void displaySubtract()
		- Muestra la matriz resta si fue calculada.

- MatrixScalar
	- MatrixScalar(int[][] matrix, int scalar)
		- Constructor que recibe la matriz a escalar y el valor escalar.
	- int[][] scalarProduct()
		- Calcula el producto escalar y devuelve la matriz resultante.
	- void displayScalar()
		- Muestra la matriz resultante del producto escalar.
	- static int[][] selectMatrix(MatrixGenerator generateMatrix)
		- Permite al usuario elegir la matriz 1 o 2 (devuelve la seleccionada).

- MatrixMultiplication
	- MatrixMultiplication(int[][] matrix1, int[][] matrix2)
		- Constructor que recibe las dos matrices a multiplicar.
	- int[][] multiplyMatrices()
		- Valida compatibilidad de dimensiones, realiza la multiplicación y devuelve el resultado.
	- void displayMultiplication()
		- Muestra la matriz resultante de la multiplicación si fue calculada.

- MatrixOperationsMenu
	- static void iniciar(MatrixGenerator generateMatrix)
		- Muestra un menú con opciones (suma, resta, escalar, multiplicación) y llama a las clases correspondientes para ejecutar y mostrar resultados.

