package Interfaz;

import Clases.NumeroMayor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfazNumeroMayor extends JFrame {

    private JTextField textFieldA;
    private JTextField textFieldB;
    private JLabel labelResultado;
    private JButton buttonComparar;

    public InterfazNumeroMayor() {
        super("Comparador de números");
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(220, 200, 255)); // Color morado claro

        JLabel labelA = new JLabel("Valor de A:");
        labelA.setPreferredSize(new Dimension(80, 25));
        panel.add(labelA);

        textFieldA = new JTextField();
        textFieldA.setPreferredSize(new Dimension(150, 25));
        panel.add(textFieldA);

        JLabel labelB = new JLabel("Valor de B:");
        labelB.setPreferredSize(new Dimension(80, 25));
        panel.add(labelB);

        textFieldB = new JTextField();
        textFieldB.setPreferredSize(new Dimension(150, 25));
        panel.add(textFieldB);

        buttonComparar = new JButton("Comparar");
        panel.add(buttonComparar);

        labelResultado = new JLabel();
        labelResultado.setPreferredSize(new Dimension(200, 25));
        panel.add(labelResultado);

        buttonComparar.addActionListener(e -> {
            double a = Double.parseDouble(textFieldA.getText());
            double b = Double.parseDouble(textFieldB.getText());
            NumeroMayor nm = new NumeroMayor(a, b);
            labelResultado.setText(nm.compararNumeros());
        });

        setContentPane(panel);
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new InterfazNumeroMayor();
    }
}
