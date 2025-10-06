package CalculadoraAreas;

public class Cuadrado {
    //Atributos
    private double lado;

    //Constructor
    public Cuadrado(double lado) {
        this.lado = lado;
    }

    //Metodo
    public double calcularArea() {
        return Math.pow(lado, 2);
    }
}
