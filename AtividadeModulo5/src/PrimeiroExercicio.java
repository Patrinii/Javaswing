import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrimeiroExercicio {
    public static void main(String[] args) {
        // Criar a janela principal
        JFrame frame = new JFrame("Modificando a Cor do Painel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200); // Tamanho da janela

        // Criar o painel
        JPanel painel = new JPanel();
        painel.setBackground(Color.YELLOW); // Cor inicial do painel

        // Criar os botões
        JButton botaoAmarelo = new JButton("Amarelo");
        JButton botaoVerde = new JButton("Verde");
        JButton botaoAzul = new JButton("Azul");

        // Adicionar os ouvintes de eventos para os botões
        botaoAmarelo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                painel.setBackground(Color.YELLOW); // Mudar para amarelo
            }
        });

        botaoVerde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                painel.setBackground(Color.GREEN); // Mudar para verde
            }
        });

        botaoAzul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                painel.setBackground(Color.BLUE); // Mudar para azul
            }
        });

        // Criar o painel de botões e adicionar os botões nele
        JPanel painelBotoes = new JPanel();
        painelBotoes.add(botaoAmarelo);
        painelBotoes.add(botaoVerde);
        painelBotoes.add(botaoAzul);

        // Adicionar os dois painéis à janela
        frame.setLayout(new BorderLayout());
        frame.add(painel, BorderLayout.CENTER);
        frame.add(painelBotoes, BorderLayout.SOUTH);

        // Tornar a janela visível
        frame.setVisible(true);
    }
}
