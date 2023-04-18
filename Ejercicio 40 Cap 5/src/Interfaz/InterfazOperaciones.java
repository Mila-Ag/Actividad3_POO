package Interfaz;

import Datos.OperacionesAritmeticas;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class InterfazOperaciones extends JFrame implements ActionListener {

    private JTextField entradaNumeros;
    private JTextArea resultados;

    public InterfazOperaciones() {

        setTitle("Operaciones Aritméticas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);


        JLabel etiquetaNumeros = new JLabel("Introduzca los números (separados por coma):");
        entradaNumeros = new JTextField(20);
        JButton botonCalcular = new JButton("Calcular");
        botonCalcular.addActionListener(this);
        botonCalcular.setBackground(new Color(102, 51, 0));
        botonCalcular.setForeground(Color.WHITE);
        resultados = new JTextArea(10, 20);
        resultados.setEditable(false);

        // Añadir los componentes a la ventana
        JPanel panel = new JPanel();
        panel.setBackground(new Color(204, 153, 102));
        panel.add(etiquetaNumeros);
        panel.add(entradaNumeros);
        panel.add(botonCalcular);
        panel.add(new JScrollPane(resultados));
        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String entrada = entradaNumeros.getText();
        String[] numerosString = entrada.split(",");
        double[] numeros = new double[numerosString.length];
        for (int i=0; i<numerosString.length; i++) {
            numeros[i] = Double.parseDouble(numerosString[i]);
        }


        OperacionesAritmeticas operaciones = new OperacionesAritmeticas(numeros);
        String resultadoString = operaciones.obtenerOperaciones();
        resultados.setText(resultadoString);
    }

    public static void main(String[] args) {
        new InterfazOperaciones();
    }

}
