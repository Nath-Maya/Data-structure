import java.util.Scanner;

public class MenuCalculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Menu para seleccionar opciones de la calculadora
        System.out.println("CALCULADORA");
        System.out.println("Seleccione la opcion que desea calcular: ");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");

        //Variable de la opcion que tomara el dato suministrado por el usuario por medio de la consola.
        int op = sc.nextInt();

        //Toma del primer numero
        System.out.println("Ingrese el primer numero: ");
        int number1 = sc.nextInt();

        //Toma del segundo numero
        System.out.println("Ingrese el segundo numero: ");
        int number2 = sc.nextInt();

        }
    }
}
