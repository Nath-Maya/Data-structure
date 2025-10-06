package CalculadoraAreas;

public class AreaFiguras {

    //Funcion para calcular el area de un cuadrado: lado ^ 2 o lado x lado
    public static double areaCuadrado(double lado ){
        return Math.pow(lado, 2);
    }

    //Funcion para calcular el area del triangulo: base x altura / 2
    public static double areaTriangulo(double base, double altura){
        return (base*altura)/2;
    }

    //Funcion para calcular el area de un circulo: radio^2.numero pi
    public static double areaCirculo (double radio) {
        return Math.PI*Math.pow(radio, 2);
    }

    public static double areaTrapesio( double baseMayor, double baseMenor, double altura) {
        return (baseMenor+baseMayor)*altura/2;
    }
}
