package Interfaz;

import Datos.Empleado;

import javax.swing.*;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class InterfazEmpleado extends JFrame {

    private JTextField txtNombre;
    private JTextField txtValorHora;
    private JTextField txtNumHoras;
    private JTextArea txtResultado;

    public InterfazEmpleado() {
        setTitle("Calculadora de salario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblValorHora = new JLabel("Salario por hora:");
        JLabel lblNumHoras = new JLabel("Número de horas trabajadas:");
        txtNombre = new JTextField(20);
        txtValorHora = new JTextField(10);
        txtNumHoras = new JTextField(10);
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBackground(new Color(70, 30, 130));
        btnCalcular.setForeground(Color.WHITE);
        txtResultado = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(txtResultado);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(177, 150, 246));
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblValorHora);
        panel.add(txtValorHora);
        panel.add(lblNumHoras);
        panel.add(txtNumHoras);
        panel.add(btnCalcular);
        panel.add(scrollPane);
        add(panel);

        btnCalcular.addActionListener(e -> calcularSalario());
    }

    private void calcularSalario() {
        String nombre = txtNombre.getText();
        double valorHora = Double.parseDouble(txtValorHora.getText());
        double numHoras = Double.parseDouble(txtNumHoras.getText());

        Empleado empleado = new Empleado(nombre, valorHora, numHoras);
        double salario = empleado.salario();

        if (salario > 450000) {
            txtResultado.setText(nombre + " gana un salario mensual de $" + salario);
        } else {
            txtResultado.setText(nombre);
        }
    }

}
