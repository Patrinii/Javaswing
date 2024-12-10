import javax.swing.*;
import java.awt.event.*;

public class QuintoExercicio {
    private JFrame frame;
    private JTextField valoresField;
    private JComboBox<String> operacoesBox;
    private JButton calcularButton;

    public QuintoExercicio() {
        // Configuração da Janela
        frame = new JFrame("Programa Frame - V2 LP5");
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Campo Valores
        JLabel valoresLabel = new JLabel("Valores:");
        valoresLabel.setBounds(20, 20, 100, 20);
        frame.add(valoresLabel);

        valoresField = new JTextField();
        valoresField.setBounds(80, 20, 120, 20); // Ajustado para ter o mesmo tamanho do JComboBox
        frame.add(valoresField);

        // Combobox Operações (abaixo do campo de entrada)
        String[] operacoes = {"Somar", "Multiplicar"};
        operacoesBox = new JComboBox<>(operacoes);
        operacoesBox.setBounds(80, 50, 120, 20); // Mesmo tamanho da caixa de texto
        frame.add(operacoesBox);

        // Botão Calcular (ao lado do Combobox)
        calcularButton = new JButton("Calcular");
        calcularButton.setBounds(210, 50, 100, 20);
        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String valoresText = valoresField.getText();
                if (valoresText.isEmpty() || !valoresText.contains(",")) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira dois números separados por vírgula.");
                    return;
                }

                try {
                    String[] valores = valoresText.split(",");
                    if (valores.length != 2) {
                        JOptionPane.showMessageDialog(frame, "Insira exatamente dois números separados por vírgula.");
                        return;
                    }

                    double numero1 = Double.parseDouble(valores[0].trim());
                    double numero2 = Double.parseDouble(valores[1].trim());
                    String operacaoSelecionada = (String) operacoesBox.getSelectedItem();

                    double resultado = 0;
                    if ("Somar".equals(operacaoSelecionada)) {
                        resultado = numero1 + numero2;
                    } else if ("Multiplicar".equals(operacaoSelecionada)) {
                        resultado = numero1 * numero2;
                    }

                    JOptionPane.showMessageDialog(frame, "O resultado é: " + resultado);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira números válidos.");
                }
            }
        });
        frame.add(calcularButton);

        // Tornar a janela visível
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new QuintoExercicio();
    }
}
