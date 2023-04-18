package Datos;


import javax.swing.JOptionPane;

public class Soluciones {

    public double a, b, c;

    public Soluciones(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] resultado() {
        double discriminante = Math.pow(b, 2)-(4*a*c);
        if (discriminante < 0) {
            JOptionPane.showMessageDialog(null, "Esta ecuación no tiene solución en los reales");
            double[] array = {0, 0};
            return array;
        }
        else {
            double[] array = {(-(this.b)+Math.sqrt(discriminante))/(2*this.a), (-(this.b)-Math.sqrt(discriminante))/(2*this.a)};
            return array;
        }
    }

}