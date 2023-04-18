package Interfaz;

import Datos.*;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfazFiguras extends JFrame implements ActionListener {

    private JComboBox<String> opcionesFiguras;
    private JLabel label1, label2, label3, label4, resultado1, resultado2;
    private JTextField textField1, textField2;
    private JButton calcularButton;

    public InterfazFiguras() {
        super("Calcular datos de figuras geométricas");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.setBackground(new Color(177, 150, 246)); // Verde claro

        opcionesFiguras = new JComboBox<String>(new String[]{"Círculo", "Cuadrado", "Rectángulo", "Triángulo"});
        opcionesFiguras.addActionListener(this);
        panel.add(new JLabel("Seleccione una figura geométrica:"));
        panel.add(opcionesFiguras);

        label1 = new JLabel("Ingrese el valor del primer parámetro:");
        panel.add(label1);

        textField1 = new JTextField(10);
        panel.add(textField1);

        label2 = new JLabel("Ingrese el valor del segundo parámetro:");
        panel.add(label2);

        textField2 = new JTextField(10);
        panel.add(textField2);

        label3 = new JLabel("Área:");
        panel.add(label3);

        resultado1 = new JLabel("");
        panel.add(resultado1);

        label4 = new JLabel("Perímetro:");
        panel.add(label4);

        resultado2 = new JLabel("");
        panel.add(resultado2);

        calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(this);
        calcularButton.setBackground(new Color(102, 0, 102)); // Morado oscuro
        calcularButton.setForeground(Color.WHITE); // Letras blancas
        panel.add(calcularButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == opcionesFiguras) {
            String figura = (String) opcionesFiguras.getSelectedItem();
            switch (figura) {
                case "Círculo":
                    label1.setText("Ingrese el valor del radio:");
                    label2.setVisible(false);
                    textField2.setVisible(false);
                    break;
                case "Cuadrado":
                    label1.setText("Ingrese el valor del lado:");
                    label2.setVisible(false);
                    textField2.setVisible(false);
                    break;
                case "Rectángulo":
                    label1.setText("Ingrese el valor de la base:");
                    label2.setText("Ingrese el valor de la altura:");
                    label2.setVisible(true);
                    textField2.setVisible(true);
                    break;
                case "Triángulo":
                    label1.setText("Ingrese el valor de la base:");
                    label2.setText("Ingrese el valor de la altura:");
                    label2.setVisible(true);
                    textField2.setVisible(true);
                    break;
            }
            resultado1.setText("");
            resultado2.setText("");
        } else if (e.getSource() == calcularButton) {
            String figura = (String) opcionesFiguras.getSelectedItem();
            try {
                double valor1 = Double.parseDouble(textField1.getText());
                double valor2 = Double.parseDouble(textField2.getText());
                FiguraBase figuraGeometrica;
                switch (figura) {
                    case "Círculo":
                        figuraGeometrica = new Circulo(valor1);
                        resultado1.setText(Double.toString(figuraGeometrica.area()));
                        resultado2.setText(Double.toString(figuraGeometrica.perimetro()));
                        break;
                    case "Cuadrado":
                        figuraGeometrica = new Cuadrado(valor1);
                        resultado1.setText(Double.toString(figuraGeometrica.area()));
                        resultado2.setText(Double.toString(figuraGeometrica.perimetro()));
                        break;
                    case "Rectángulo":
                        figuraGeometrica = new Rectangulo(valor1, valor2);
                        resultado1.setText(Double.toString(figuraGeometrica.area()));
                        resultado2.setText(Double.toString(figuraGeometrica.perimetro()));
                        break;
                    case "Triángulo":
                        figuraGeometrica = new Triangulo(valor1, valor2);
                        resultado1.setText(Double.toString(figuraGeometrica.area()));
                        resultado2.setText(Double.toString(figuraGeometrica.perimetro()));

                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Seleccione una figura geométrica válida.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
