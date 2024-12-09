import javax.swing.*;
import java.awt.*;

public class PrimeiroExercicioA {
    public static void main(String[] args) {
        // Criar a janela principal
        JFrame frame = new JFrame("Janela com Quatro Botões");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 100); // Tamanho da janela

        // Definir o layout como FlowLayout para organizar os botões lado a lado
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Alinhamento central, espaçamento de 10px

        // Criar os botões com rótulos simples
        JButton button1 = new JButton("Um");
        JButton button2 = new JButton("Dois");
        JButton button3 = new JButton("Três");
        JButton button4 = new JButton("Quatro");

        // Tornar os botões pequenos
        button1.setPreferredSize(new Dimension(80, 30));  // Largura 80px, Altura 30px
        button2.setPreferredSize(new Dimension(80, 30));
        button3.setPreferredSize(new Dimension(80, 30));
        button4.setPreferredSize(new Dimension(80, 30));

        // Adicionar os botões na janela
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);

        // Tornar a janela visível
        frame.setVisible(true);
    }
}
