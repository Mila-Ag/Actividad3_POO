package Datos;


public class OperacionesAritmeticas {

    public double[] valores;

    public static double redondear(double valor, int lugares) {
        if (lugares < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, lugares);
        valor = valor * factor;
        long tmp = Math.round(valor);
        return (double) tmp / factor;
    }

    public OperacionesAritmeticas(double[] valores) {
        this.valores = valores;
    }

    public double[] raizCuadrada() {
        double[] ans = new double[this.valores.length];
        for (int i=0; i<this.valores.length; i++) {
            ans[i] = Math.sqrt(this.valores[i]);
        }
        return ans;
    }

    public double[] cuadrado() {
        double[] ans = new double[this.valores.length];
        for (int i=0; i<this.valores.length; i++) {
            ans[i] = Math.pow(this.valores[i], 2);
        }
        return ans;
    }

    public double[] cubo() {
        double[] ans = new double[this.valores.length];
        for (int i=0; i<this.valores.length; i++) {
            ans[i] = Math.pow(this.valores[i], 3);
        }
        return ans;
    }

    public String obtenerOperaciones() {
        double[] raices_cuadradas = this.raizCuadrada();
        double[] cuadrados = this.cuadrado();
        double[] cubos = this.cubo();

        String ans = "";
        for (int i=0; i<this.valores.length; i++) {
            ans += "Para: "+String.valueOf(redondear(this.valores[i], 2))+"\n";
            ans += "-> Su raíz cuadrada es: = "+String.valueOf(redondear(raices_cuadradas[i], 2))+"\n-> Su cuadrado es: = "+String.valueOf(redondear(cuadrados[i], 2))+"\n-> Su cubo es:  = "+String.valueOf(redondear(cubos[i], 2))+"\n\n";
        }

        return ans;
    }

}


