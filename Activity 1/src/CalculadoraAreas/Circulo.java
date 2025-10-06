package CalculadoraAreas;

public class Circulo {
    //Atributos
    private double radio;

    //Constructor
    public Circulo(double radio) {
        this.radio = radio;
    }
    //Metodo
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}
