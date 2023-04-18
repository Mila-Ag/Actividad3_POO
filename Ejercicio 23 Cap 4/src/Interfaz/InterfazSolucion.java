package Interfaz;

import Datos.Soluciones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class InterfazSolucion extends JFrame {

    private JLabel labelA, labelB, labelC, labelX1, labelX2;
    private JTextField campoA, campoB, campoC, campoX1, campoX2;
    private JButton botonCalcular;

    public InterfazSolucion() {
        initComponents();
        getContentPane().setBackground(new Color(255, 255, 204));
        setLayout(null);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initComponents() {
        labelA = new JLabel("Valor de a:");
        labelA.setBounds(50, 30, 100, 30);
        add(labelA);

        campoA = new JTextField();
        campoA.setBounds(150, 30, 100, 30);
        add(campoA);

        labelB = new JLabel("Valor de b:");
        labelB.setBounds(50, 70, 100, 30);
        add(labelB);

        campoB = new JTextField();
        campoB.setBounds(150, 70, 100, 30);
        add(campoB);

        labelC = new JLabel("Valor de c:");
        labelC.setBounds(50, 110, 100, 30);
        add(labelC);

        campoC = new JTextField();
        campoC.setBounds(150, 110, 100, 30);
        add(campoC);

        botonCalcular = new JButton("Calcular");
        botonCalcular.setBounds(150, 150, 100, 30);
        botonCalcular.setBackground(new Color(255, 204, 0));
        add(botonCalcular);

        labelX1 = new JLabel("x1 = ");
        labelX1.setBounds(50, 200, 50, 30);
        add(labelX1);

        campoX1 = new JTextField();
        campoX1.setBounds(80, 200, 100, 30);
        campoX1.setEditable(false);
        add(campoX1);

        labelX2 = new JLabel("x2 = ");
        labelX2.setBounds(200, 200, 50, 30);
        add(labelX2);

        campoX2 = new JTextField();
        campoX2.setBounds(230, 200, 100, 30);
        campoX2.setEditable(false);
        add(campoX2);

        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(campoA.getText());
                    double b = Double.parseDouble(campoB.getText());
                    double c = Double.parseDouble(campoC.getText());

                    Soluciones ecuacion = new Soluciones(a, b, c);
                    double[] soluciones = ecuacion.resultado();

                    if (soluciones.length == 2) {
                        DecimalFormat df = new DecimalFormat("#.#####");
                        df.setRoundingMode(RoundingMode.CEILING);
                        campoX1.setText(df.format(soluciones[0]));
                        campoX2.setText(df.format(soluciones[1]));
                    } else {
                        campoX1.setText("");
                        campoX2.setText("");
                        JOptionPane.showMessageDialog(null, "Esta ecuación no tiene solución en los reales");
                    }
                } catch (NumberFormatException ex) {
                    campoX1.setText("");
                    campoX2.setText("");
                    JOptionPane.showMessageDialog(null, "Error: Uno o más campos contienen valores inválidos");
                }
            }
        });
    }

    public static void main(String[] args) {
        InterfazSolucion solucioni = new InterfazSolucion();
    }
}
