package Clases;

public class NumeroMayor {

    private double a, b;

    public NumeroMayor(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public String compararNumeros() {
        String resultado = "";
        if (a > b) {
            resultado = "A es mayor que B";
        } else if (a == b) {
            resultado = "A es igual a B";
        } else {
            resultado = "A es menor que B";
        }
        return resultado;
    }
}
