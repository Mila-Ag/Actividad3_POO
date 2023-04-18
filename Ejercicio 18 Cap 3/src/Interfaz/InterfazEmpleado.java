package Interfaz;

import Datos.Empleado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
public class InterfazEmpleado extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel nombreLabel, codigoEmpleadoLabel, salarioBrutoLabel, salarioNetoLabel;
    private JTextField nombreTextField, codigoEmpleadoTextField, salarioBrutoTextField, salarioNetoTextField;
    private JButton calcularButton, limpiarButton;
    private Empleado empleado;

    public InterfazEmpleado() {
        this.setTitle("Calculadora de Salario del Empleado");
        this.setSize(400, 300);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(173, 214, 245));


        nombreLabel = new JLabel("Nombre: ");
        nombreLabel.setBounds(50, 50, 150, 20);
        panel.add(nombreLabel);

        nombreTextField = new JTextField();
        nombreTextField.setBounds(200, 50, 150, 20);
        panel.add(nombreTextField);

        codigoEmpleadoLabel = new JLabel("Código Empleado: ");
        codigoEmpleadoLabel.setBounds(50, 80, 150, 20);
        panel.add(codigoEmpleadoLabel);

        codigoEmpleadoTextField = new JTextField();
        codigoEmpleadoTextField.setBounds(200, 80, 150, 20);
        panel.add(codigoEmpleadoTextField);

        salarioBrutoLabel = new JLabel("Salario Bruto: ");
        salarioBrutoLabel.setBounds(50, 110, 150, 20);
        panel.add(salarioBrutoLabel);

        salarioBrutoTextField = new JTextField();
        salarioBrutoTextField.setBounds(200, 110, 150, 20);
        salarioBrutoTextField.setEditable(false);
        panel.add(salarioBrutoTextField);

        salarioNetoLabel = new JLabel("Salario Neto: ");
        salarioNetoLabel.setBounds(50, 140, 150, 20);
        panel.add(salarioNetoLabel);

        salarioNetoTextField = new JTextField();
        salarioNetoTextField.setBounds(200, 140, 150, 20);
        salarioNetoTextField.setEditable(false);
        panel.add(salarioNetoTextField);

        calcularButton = new JButton("Calcular");
        calcularButton.setBounds(50, 200, 100, 30);
        calcularButton.addActionListener(this);
        panel.add(calcularButton);

        limpiarButton = new JButton("Limpiar");
        limpiarButton.setBounds(200, 200, 100, 30);
        limpiarButton.addActionListener(this);
        panel.add(limpiarButton);

        empleado = new Empleado("", 0);

        this.setContentPane(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcularButton) {
            empleado.nombre = nombreTextField.getText();
            empleado.setCodigoEmpleado(codigoEmpleadoTextField.getText());
            empleado.setValorHora(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de la hora trabajada: ")));
            empleado.addHorasTrabajadas(Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de horas trabajadas: ")));
            salarioBrutoTextField.setText(String.valueOf(empleado.salarioBruto()));
            salarioNetoTextField.setText(String.valueOf(empleado.salarioNeto()));
        }
        else if (e.getSource() == limpiarButton) {
            nombreTextField.setText("");
            codigoEmpleadoTextField.setText("");
            salarioBrutoTextField.setText("");
            salarioNetoTextField.setText("");
            empleado.resetHorasTrabajadas();
        }
    }

    public static void main(String[] args) {
        InterfazEmpleado empleadoGUI = new InterfazEmpleado();
    }
}

