package Datos;
public class Estudiante {

    public String nI, nom;
    public double pat;
    public int estrato;

    public Estudiante(String nI, String nom, double pat, int estrato) {
        this.nI = nI;
        this.nom = nom;
        this.pat = pat;
        this.estrato = estrato;
    }

    public double matricula() {
        double pagmat = 50000;
        if ((pat > 2000000) && (estrato > 3)) {
            pagmat = pagmat + (0.03* pat);
        }
        return pagmat;
    }

}