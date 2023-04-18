package Datos;

public class Empleado {

    private String codigo_empleado;
    public String nombre;
    private double horas_trabajadas=0, valor_hora;
    public double porcentaje_rtfte;

    public Empleado(String nombre, double porcentaje_rtfte) {
        this.nombre = nombre;
        this.porcentaje_rtfte = porcentaje_rtfte;
    }

    public String getCodigoEmpleado() {
        return this.codigo_empleado;
    }

    public void setCodigoEmpleado(String codigo) {
        // Se podrían agregar condiciones para establecer un código
        // por eso hice esta variable privada
        this.codigo_empleado = codigo;
    }

    public double getHorasTrabajadas() {
        return this.horas_trabajadas;
    }

    public void addHorasTrabajadas(double horas) {
        this.horas_trabajadas += Math.abs(horas);
    }

    public void resetHorasTrabajadas() {
        this.horas_trabajadas = 0;
    }

    public double getValorHora() {
        return this.valor_hora;
    }

    public void setValorHora(double valor) {
        if (valor >= 4833) {
            this.valor_hora = valor;
        }
        else {
            this.valor_hora = 4833;
            System.out.println("El valor mínimo de la hora trabajada en Colombia es 4833");
        }
    }

    public double salarioBruto() {
        return (this.valor_hora*this.horas_trabajadas);
    }

    public double rtfte() {
        return (this.salarioBruto()*(this.porcentaje_rtfte/100));
    }

    public double salarioNeto() {
        return (this.salarioBruto() - this.rtfte());
    }

}