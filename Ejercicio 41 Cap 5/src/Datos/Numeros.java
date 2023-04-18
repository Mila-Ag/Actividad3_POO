package clases;

import java.util.Arrays;

public class Numeros {
    public double[] valores;

    public Numeros(double[] valores) {
        this.valores = valores;
    }

    public void ordenarSerie() {
        for (int i = 0; i < this.valores.length; i++) {
            for (int j = 0; j < this.valores.length - i - 1; j++) {
                if (this.valores[j] > this.valores[j + 1]) {
                    double aux = this.valores[j];
                    this.valores[j] = this.valores[j + 1];
                    this.valores[j + 1] = aux;
                }
            }
        }
    }

    public double[] obtenerSerieOrdenada() {
        double[] ans = Arrays.copyOf(this.valores, this.valores.length);

        for (int i = 0; i < (ans.length - 1); i++) {
            for (int j = 0; j < ans.length - i - 1; j++) {
                if (ans[j] > ans[j + 1]) {
                    double aux = ans[j];
                    ans[j] = ans[j + 1];
                    ans[j + 1] = aux;
                }
            }
        }

        return ans;
    }

    public String obtenerCsv() {
        String ans = "";

        for (int i = 0; i < this.valores.length; i++) {
            ans += String.valueOf(this.valores[i]) + ",";
        }
        ans = ans.substring(0, ans.length() - 1);

        return ans;
    }
}
