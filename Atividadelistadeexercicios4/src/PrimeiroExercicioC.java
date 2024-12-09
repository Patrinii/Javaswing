import javax.swing.*;
import java.awt.*;

public class PrimeiroExercicioC {
    public static void main(String[] args) {
        // Criar a janela principal
        JFrame frame = new JFrame("Simulando Tabela com Botões");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300); // Aumentar o tamanho da janela para acomodar os botões maiores

        // Definir o layout como GridLayout (3 linhas, 2 colunas)
        frame.setLayout(new GridLayout(3, 2, 10, 10)); // 3 linhas, 2 colunas, espaçamento de 10px

        // Criar os botões
        JButton button1 = new JButton("Botão 1");
        JButton button2 = new JButton("Botão 2");
        JButton button3 = new JButton("Botão 3");
        JButton button4 = new JButton("Botão 4");
        JButton button5 = new JButton("Botão 5");

        // Tornar os botões ainda maiores
        button1.setPreferredSize(new Dimension(150, 60));
        button2.setPreferredSize(new Dimension(150, 60));
        button3.setPreferredSize(new Dimension(150, 60));
        button4.setPreferredSize(new Dimension(150, 60));
        button5.setPreferredSize(new Dimension(150, 60));

        // Adicionar os botões na janela (na ordem desejada)
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5); // O botão 5 ficará na última linha e coluna vazia

        // Tornar a janela visível
        frame.setVisible(true);
    }
}
