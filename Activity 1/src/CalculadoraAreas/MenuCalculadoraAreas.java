package CalculadoraAreas;

import java.util.Scanner;

public class MenuCalculadoraAreas {
    public static void iniciar() {

        Scanner entrada = new Scanner(System.in);

        //Menu para seleccionar Figura geometrica
        System.out.println("CALCULADORA DE AREAS DE FIGURAS GEOMETRICAS:");
        System.out.println("==========================================");
        System.out.print("\nLista de figuras:");
        System.out.print("\n1.Cuadrado");
        System.out.print("\n2.Triangulo");
        System.out.print("\n3.Circulo");
        System.out.print("\n4.Trapesoide");

        //Captura de la opcion suministrada por el usuario, sobre la figura que se va a calcular area.
        System.out.print("\nA Que figura le desea calcular el area?");

        //Captura la opcion que el usuario selecciona
        int seleccion = entrada.nextInt();

        //Estructura de caso para seleccionar la figura a la cual se desea clacular el area

        switch (seleccion) {
            case 1:
                System.out.print("Vamos a calcular el area del CUADRADO \uD83D\uDFEA.");
                System.out.print("\nLado del cuadrado: ");
                double lado = entrada.nextDouble();

                Cuadrado cuadrado = new Cuadrado(lado);
                System.out.print("Area del CUADRADO: " + cuadrado.calcularArea());

                break;
            case 2:
                System.out.print("Vamos a calcular el area del TRIANGULO.\uD83D\uDD3A");
                System.out.print("\nBase: ");
                double base = entrada.nextDouble();
                System.out.print("Altura: ");
                double altura = entrada.nextDouble();

                Triangulo triangulo = new Triangulo(base, altura);
                System.out.print("Area del TRIANGULO: " + triangulo.calcularArea());
                break;
            case 3:
                System.out.print("Vamos a calcular el area del CIRCULO.\uD83D\uDFE1");
                System.out.print("\nRadio del circulo: ");
                double radio = entrada.nextDouble();

                Circulo circulo = new Circulo(radio);
                System.out.print("Area del CIRCULO: " + circulo.calcularArea());
                break;

            case 4:
                System.out.print("Vamos a calcular el area del TRAPESOIDE. \uD83C\uDE34");
                System.out.print("\nBase mayor: ");
                double baseMayor = entrada.nextDouble();

                System.out.print("Base menor: ");
                double baseMenor = entrada.nextDouble();

                System.out.print("Altura trapesoide: ");
                double alturaTrapesio = entrada.nextDouble();

                Trapesoide trapesoide = new Trapesoide(baseMayor, baseMenor, alturaTrapesio);
                System.out.print("Area del TRAPESOIDE: " + trapesoide.calcularArea());
                break;

        }
    }
}
