package Datos;


public class Cuadrado implements FiguraBase {

    public double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double area() {
        return Math.pow(this.lado, 2);
    }

    public double perimetro() {
        return (4 * this.lado);
    }

}