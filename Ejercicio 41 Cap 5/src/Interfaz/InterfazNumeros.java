package Interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazNumeros extends JFrame implements ActionListener {

    private final JTextField inputField;
    private final JButton calcularButton;
    private final JLabel resultadoLabel;

    public InterfazNumeros() {

        setTitle("Encuentra el número mayor");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel inputPanel = new JPanel(new GridLayout(0, 1));
        JLabel inputLabel = new JLabel("Ingrese hasta 10 números separados por comas:");
        inputPanel.add(inputLabel);


        inputField = new JTextField();
        inputPanel.add(inputField);


        calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(this);
        calcularButton.setBackground(Color.BLUE.darker());
        calcularButton.setForeground(Color.WHITE);
        inputPanel.add(calcularButton);


        JPanel resultadoPanel = new JPanel(new FlowLayout());
        resultadoPanel.setBackground(new Color(125, 187, 246)); // Azul claro
        resultadoLabel = new JLabel("");
        resultadoPanel.add(resultadoLabel);


        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.CENTER);
        add(resultadoPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcularButton) {

            String inputString = inputField.getText();
            String[] inputArray = inputString.split(",");


            double[] numeros = new double[inputArray.length];
            for (int i = 0; i < inputArray.length; i++) {
                try {
                    numeros[i] = Double.parseDouble(inputArray[i]);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Ingrese solo números válidos.");
                    return;
                }
            }


            clases.Numeros serieNumeros = new clases.Numeros(numeros);
            serieNumeros.ordenarSerie();
            double mayor = serieNumeros.valores[numeros.length - 1];


            resultadoLabel.setText("El mayor valor es: " + mayor);
        }
    }

    public static void main(String[] args) {
        new InterfazNumeros();
    }
}
