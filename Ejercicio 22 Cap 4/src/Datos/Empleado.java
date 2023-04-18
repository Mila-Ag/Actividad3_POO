package Datos;

public class Empleado {

    public String nombre;
    public double valorHora, numHoras;

    public Empleado(String nombre, double valorHora, double numHoras) {
        this.nombre = nombre;
        this.valorHora = valorHora;
        this.numHoras = numHoras;
    }

    public double salario() {
        return valorHora * numHoras;
    }

}

