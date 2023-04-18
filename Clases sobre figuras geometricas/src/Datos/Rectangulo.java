package Datos;

public class Rectangulo implements FiguraBase {

    public double base, altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double area() {
        return (base * altura);
    }

    public double perimetro() {
        return ((2*base) + (2*altura));
    }

}