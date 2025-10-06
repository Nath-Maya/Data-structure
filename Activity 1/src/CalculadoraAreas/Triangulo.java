package CalculadoraAreas;

public class Triangulo {
    //Atributos
    private double base;
    private double altura;

    //Constructor
    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    //Metodo
    public double calcularArea() {
        return (base * altura) / 2;
    }
}
