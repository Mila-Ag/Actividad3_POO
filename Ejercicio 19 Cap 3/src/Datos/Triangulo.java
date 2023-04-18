package Datos;

import java.util.Scanner;

public class Triangulo {

    public double lado;

    public Triangulo(double lado) {
        this.lado = lado;
    }

    public Triangulo() {
    }

    public double perimetro() {
        return (lado*3);
    }

    public double altura() {
        return Math.sqrt(Math.pow(lado, 2)*Math.pow((lado/2), 2));
    }

    public double area() {
        return (this.lado * this.altura())/2;
    }

}