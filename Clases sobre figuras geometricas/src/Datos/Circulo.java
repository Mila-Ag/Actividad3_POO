package Datos;
public class Circulo implements FiguraBase {

    public double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double area() {
        return (Math.PI * Math.pow(this.radio, 2));
    }

    public double perimetro() {
        return (2 * Math.PI * this.radio);
    }

}