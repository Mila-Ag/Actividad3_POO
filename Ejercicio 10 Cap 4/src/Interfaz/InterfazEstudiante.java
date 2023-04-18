package Interfaz;

import Datos.Estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazEstudiante extends JFrame {

    private JTextField nIField, nomField, patField, estratoField;
    private JLabel nILabel, nomLabel, patLabel, estratoLabel, matLabel;

    public InterfazEstudiante() {
        setTitle("Calculadora de matricula");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.setBackground(new Color(163, 228, 215));

        nILabel = new JLabel("Numero de Inscripcion: ");
        nIField = new JTextField(4);

        nomLabel = new JLabel("Nombre: ");
        nomField = new JTextField(4);

        patLabel = new JLabel("Patrimonio: ");
        patField = new JTextField(4);

        estratoLabel = new JLabel("Estrato social: ");
        estratoField = new JTextField(4);

        matLabel = new JLabel("");

        JButton calcularButton = new JButton("Calcular");
        calcularButton.setBackground(new Color(43, 96, 70));
        calcularButton.setForeground(Color.WHITE);
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nI = nIField.getText();
                String nom = nomField.getText();
                double pat = Double.parseDouble(patField.getText());
                int estrato = Integer.parseInt(estratoField.getText());

                Estudiante estudiante = new Estudiante(nI, nom, pat, estrato);
                double matricula = estudiante.matricula();

                matLabel.setText("Matricula: $" + String.valueOf(matricula));
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(163, 228, 215));
        buttonPanel.add(calcularButton);

        panel.add(nILabel);
        panel.add(nIField);
        panel.add(nomLabel);
        panel.add(nomField);
        panel.add(patLabel);
        panel.add(patField);
        panel.add(estratoLabel);
        panel.add(estratoField);
        panel.add(buttonPanel);
        panel.add(matLabel);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        InterfazEstudiante window = new InterfazEstudiante();
    }
}
