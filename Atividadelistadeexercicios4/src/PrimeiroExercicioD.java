import javax.swing.*;
import java.awt.*;

public class PrimeiroExercicioD {
    public static void main(String[] args) {
        // Criar a janela principal
        JFrame frame = new JFrame("Botões na Vertical");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 300); // Tamanho da janela ajustado

        // Criar um painel com FlowLayout para centralizar os botões
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5)); // Menor espaçamento entre os botões

        // Criar os botões
        JButton button1 = new JButton("Botão 1");
        JButton button2 = new JButton("Botão 2");
        JButton button3 = new JButton("Botão 3");
        JButton button4 = new JButton("Botão 4");
        JButton button5 = new JButton("Botão 5");

        // Tornar os botões ainda menores
        button1.setPreferredSize(new Dimension(100, 25));
        button2.setPreferredSize(new Dimension(100, 25));
        button3.setPreferredSize(new Dimension(100, 25));
        button4.setPreferredSize(new Dimension(100, 25));
        button5.setPreferredSize(new Dimension(100, 25));

        // Adicionar os botões ao painel
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);

        // Adicionar o painel ao centro da janela
        frame.add(panel, BorderLayout.CENTER);

        // Centralizar a janela na tela
        frame.setLocationRelativeTo(null); // Isso centraliza a janela na tela

        // Tornar a janela visível
        frame.setVisible(true);
    }
}
