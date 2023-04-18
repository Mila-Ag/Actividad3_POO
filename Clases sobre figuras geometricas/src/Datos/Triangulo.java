package Datos;

public class Triangulo implements FiguraBase {

    public double base, altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double area() {
        return this.base * this.altura;
    }

    public double hipotenusa() {
        return Math.sqrt(Math.pow(this.base, 2) + Math.pow(this.altura, 2));
    }

    public double perimetro() {
        return (this.base + this.altura + this.hipotenusa());
    }

    public String tipo() {
        if ((this.base == this.altura) || (this.base == 0) || (this.altura == 0)) {
            return "Isóceles";
        }
        else {
            return "Escaleno";
        }
    }

}