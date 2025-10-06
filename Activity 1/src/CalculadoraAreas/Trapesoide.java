package CalculadoraAreas;

public class Trapesoide {
    //Atributos
    private double baseMenor;
    private double altura;
    private double baseMayor;

    //Constructor
    public Trapesoide(double baseMenor, double altura, double baseMayor) {
        this.baseMenor = baseMenor;
        this.altura = altura;
        this.baseMayor = baseMayor;
    }

    //Metodo
    public double calcularArea() {
        return (baseMenor + baseMayor) * altura;
    }
}
