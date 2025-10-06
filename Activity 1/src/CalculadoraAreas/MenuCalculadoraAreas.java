package CalculadoraAreas;

import java.util.Scanner;

public class MenuCalculadoraAreas {
    public static void iniciar(){

        Scanner entrada = new Scanner(System.in);

        //Menu para seleccionar Figura geometrica
        System.out.println("CALCULADORA DE AREAS DE FIGURAS GEOMETRICAS: ");
        System.out.print("Seleccione la figura de la cual desea saber el area");
        System.out.print("1.Cuadrado");
        System.out.print("2.Triangulo");
        System.out.print("3.Circulo");
        System.out.print("4.Trapesoide");

        //Captura de la opcion suministrada por el usuario, sobre la figura que se va a calcular area.
        System.out.print("Ingrese el numero de la figura a la cual desea calcular el area");

        int seleccion = entrada.nextInt();
    }
}
