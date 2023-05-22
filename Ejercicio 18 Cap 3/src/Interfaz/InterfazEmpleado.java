package Interfaz;

import Datos.Empleado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazEmpleado extends JFrame implements ActionListener {

    private JLabel codigoLabel, nombreLabel, horasLabel, valorLabel, rtfteLabel, salarioBrutoLabel, salarioNetoLabel;
    private JTextField codigoText, nombreText, horasText, valorText, rtfteText, salarioBrutoText, salarioNetoText;
    private JButton calcularButton, limpiarButton;

    public InterfazEmpleado() {
        super("Calculadora de salario neto");

        codigoLabel = new JLabel("Código:");
        nombreLabel = new JLabel("Nombre:");
        horasLabel = new JLabel("Horas trabajadas al mes:");
        valorLabel = new JLabel("Valor hora trabajada:");
        rtfteLabel = new JLabel("Porcentaje de retención en la fuente:");
        salarioBrutoLabel = new JLabel("Salario bruto:");
        salarioNetoLabel = new JLabel("Salario neto:");

        codigoText = new JTextField(10);
        nombreText = new JTextField(10);
        horasText = new JTextField(10);
        valorText = new JTextField(10);
        rtfteText = new JTextField(10);
        salarioBrutoText = new JTextField(10);
        salarioNetoText = new JTextField(10);
        salarioBrutoText.setEditable(false);
        salarioNetoText.setEditable(false);

        calcularButton = new JButton("Calcular");
        limpiarButton = new JButton("Limpiar");

        calcularButton.addActionListener(this);
        limpiarButton.addActionListener(this);

        JPanel panel = new JPanel(new GridLayout(8,2));
        panel.add(codigoLabel);
        panel.add(codigoText);
        panel.add(nombreLabel);
        panel.add(nombreText);
        panel.add(horasLabel);
        panel.add(horasText);
        panel.add(valorLabel);
        panel.add(valorText);
        panel.add(rtfteLabel);
        panel.add(rtfteText);
        panel.add(salarioBrutoLabel);
        panel.add(salarioBrutoText);
        panel.add(salarioNetoLabel);
        panel.add(salarioNetoText);
        panel.add(calcularButton);
        panel.add(limpiarButton);

        setContentPane(panel);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcularButton) {
            String codigo = codigoText.getText();
            String nombre = nombreText.getText();
            double horas = Double.parseDouble(horasText.getText());
            double valor = Double.parseDouble(valorText.getText());
            double porcentaje = Double.parseDouble(rtfteText.getText());

            Empleado empleado = new Empleado(nombre, porcentaje);
            empleado.setCodigoEmpleado(codigo);
            empleado.setValorHora(valor);
            empleado.addHorasTrabajadas(horas);

            salarioBrutoText.setText(String.format("%.2f", empleado.salarioBruto()));
            salarioNetoText.setText(String.format("%.2f", empleado.salarioNeto()));
        }
        else if (e.getSource() == limpiarButton) {
            codigoText.setText("");
            nombreText.setText("");
            horasText.setText("");
            valorText.setText("");
            rtfteText.setText("");
            salarioBrutoText.setText("");
            salarioNetoText.setText("");
        }
    }

    public static void main(String[] args) {
        InterfazEmpleado interfaz = new InterfazEmpleado();
        interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}