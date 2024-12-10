import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class QuartoExercicio {
    private JFrame frame;
    private JTextField inputField, maiorField, menorField, mediaField;
    private JButton okButton, exibirButton;
    private ArrayList<Integer> numeros;

    public QuartoExercicio() {
        numeros = new ArrayList<>();

        // Configuração da Janela
        frame = new JFrame("Programa Frame - V2 LP5");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Campo de entrada
        JLabel inputLabel = new JLabel("Digite o número:");
        inputLabel.setBounds(20, 20, 120, 20);
        frame.add(inputLabel);

        inputField = new JTextField();
        inputField.setBounds(140, 20, 100, 20);
        frame.add(inputField);

        // Botão OK
        okButton = new JButton("OK");
        okButton.setBounds(250, 20, 80, 20);
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                try {
                    int numero = Integer.parseInt(inputText);
                    numeros.add(numero);
                    inputField.setText("");
                    JOptionPane.showMessageDialog(frame, "Número adicionado com sucesso!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira um número válido.");
                }
            }
        });
        frame.add(okButton);

        // Campo Maior
        JLabel maiorLabel = new JLabel("Maior >>>");
        maiorLabel.setBounds(20, 60, 100, 20);
        frame.add(maiorLabel);

        maiorField = new JTextField();
        maiorField.setBounds(140, 60, 100, 20);
        maiorField.setEditable(false);
        frame.add(maiorField);

        // Campo Menor
        JLabel menorLabel = new JLabel("Menor >>>");
        menorLabel.setBounds(20, 90, 100, 20);
        frame.add(menorLabel);

        menorField = new JTextField();
        menorField.setBounds(140, 90, 100, 20);
        menorField.setEditable(false);
        frame.add(menorField);

        // Campo Média
        JLabel mediaLabel = new JLabel("Média >>>");
        mediaLabel.setBounds(20, 120, 100, 20);
        frame.add(mediaLabel);

        mediaField = new JTextField();
        mediaField.setBounds(140, 120, 100, 20);
        mediaField.setEditable(false);
        frame.add(mediaField);

        // Botão Exibir
        exibirButton = new JButton("Exibir");
        exibirButton.setBounds(250, 120, 80, 20);
        exibirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (numeros.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Nenhum número foi inserido.");
                    return;
                }

                int maior = numeros.stream().max(Integer::compare).orElse(0);
                int menor = numeros.stream().min(Integer::compare).orElse(0);
                double media = numeros.stream().mapToInt(Integer::intValue).average().orElse(0.0);

                maiorField.setText(String.valueOf(maior));
                menorField.setText(String.valueOf(menor));
                mediaField.setText(String.format("%.2f", media));
            }
        });
        frame.add(exibirButton);

        // Tornar a janela visível
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new QuartoExercicio();
    }
}
