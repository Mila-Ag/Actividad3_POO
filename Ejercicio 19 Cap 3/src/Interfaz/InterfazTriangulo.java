package Interfaz;


import Datos.Triangulo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazTriangulo extends JFrame {

    private JLabel ladoLabel, perimetroLabel, alturaLabel, areaLabel;
    private JTextField ladoTextField;

    public InterfazTriangulo() {
        initComponents();
    }

    private void initComponents() {
        ladoLabel = new JLabel("Ingrese el valor del lado:");
        perimetroLabel = new JLabel("Perimetro: ");
        alturaLabel = new JLabel("Altura: ");
        areaLabel = new JLabel("Área: ");
        ladoTextField = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora de valores en Triangulos Equilateros");
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new java.awt.GridLayout(4, 2, 10, 10));
        panel.add(ladoLabel);
        panel.add(ladoTextField);
        panel.add(perimetroLabel);
        panel.add(new JLabel());
        panel.add(alturaLabel);
        panel.add(new JLabel());
        panel.add(areaLabel);
        panel.add(new JLabel());
        panel.setBackground(new Color(143, 188, 143));

        ladoTextField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                calcularValores();
            }
        });

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private void calcularValores() {
        double lado = Double.parseDouble(ladoTextField.getText());
        Triangulo triangulo = new Triangulo(lado);
        double perimetro = triangulo.perimetro();
        double altura = triangulo.altura();
        double area = triangulo.area();
        perimetroLabel.setText("Perimetro: " + perimetro);
        alturaLabel.setText("Altura: " + altura);
        areaLabel.setText("Area: " + area);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazTriangulo().setVisible(true);
            }
        });
    }
}
