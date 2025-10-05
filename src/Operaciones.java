public class Operaciones {

    //Funcion para realizar operacion de  Suma
    public static int suma(int a, int b) {
        return a + b;
    }

    //Funcion para realizar operacion de Resta
    public static int resta(int a, int b) {
        return a - b;
    }

    //Funcion para realizar operacion de Multiplicacion
    public static int multiplicacion(int a, int b) {
        return a * b;
    }

    //Funcion para realizar operacion de Division
    public static int division(int a, int b) {

        //Validamos que el denominador no sea 0 para que la division pueda realizarse
        if (b == 0) {
            System.out.println("El segundo numero no puede ser cero");
            return 0;
        }

        return a / b;
    }
}
