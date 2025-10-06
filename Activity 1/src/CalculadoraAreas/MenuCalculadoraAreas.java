package CalculadoraAreas;

import java.util.Scanner;

public class MenuCalculadoraAreas {
    public static void iniciar() {

        Scanner entrada = new Scanner(System.in);

        //Menu para seleccionar Figura geometrica
        System.out.println("CALCULADORA DE AREAS DE FIGURAS GEOMETRICAS: ");
        System.out.println("==========================================");
        System.out.print("\nSeleccione la figura de la cual desea saber el area");
        System.out.print("\n1.Cuadrado");
        System.out.print("\n2.Triangulo");
        System.out.print("\n3.Circulo");
        System.out.print("\n4.Trapesoide");

        //Captura de la opcion suministrada por el usuario, sobre la figura que se va a calcular area.
        System.out.print("Que figura desea calcular?");

        //Captura la opcion que el usuario selecciona
        int seleccion = entrada.nextInt();

        //Estructura de caso para seleccionar la figura a la cual se desea clacular el area

        switch (seleccion) {
            case 1:
                System.out.print("Vamos a calcular el area del CUADRADO.");
                System.out.print("\nLado del cuadrado: ");
                double lado = entrada.nextDouble();

                double areaCuadrado = AreaFiguras.areaCuadrado(lado);
                System.out.print("Area del CUADRADO: " + areaCuadrado);

                break;
            case 2:
                System.out.print("Vamos a calcular el area del TRIANGULO.");
                System.out.print("\nBase: ");
                double base = entrada.nextDouble();
                System.out.print("Altura: ");
                double altura = entrada.nextDouble();

                double areaTriangulo = AreaFiguras.areaTriangulo(base, altura);
                System.out.print("Area del TRIANGULO: " + areaTriangulo);
                break;
            case 3:
                System.out.print("Vamos a calcular el area del CIRCULO.");
                System.out.print("\nRadio del circulo: ");
                double radio = entrada.nextDouble();

                double areaCirculo = AreaFiguras.areaCirculo(radio);
                System.out.print("Area del CIRCULO: " + areaCirculo);
                break;

            case 4:
                System.out.print("Vamos a calcular el area del TRAPESOIDE.");
                System.out.print("\nBase mayor: ");
                double baseMayor = entrada.nextDouble();

                System.out.print("Base menor: ");
                double baseMenor = entrada.nextDouble();

                System.out.print("Altura trapesoide: ");
                double alturaTrapesio = entrada.nextDouble();

                double areaTrapesoide = AreaFiguras.areaTrapesio(baseMayor, baseMenor, alturaTrapesio);
                System.out.print("Area del TRAPESOIDE: " + areaTrapesoide);
                break;

        }
    }
}
