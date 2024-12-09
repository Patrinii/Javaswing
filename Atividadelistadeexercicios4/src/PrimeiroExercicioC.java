import javax.swing.*;
import java.awt.*;

public class PrimeiroExercicioC {
    public static void main(String[] args) {
        // Criar a janela principal
        JFrame frame = new JFrame("Teste");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300); // Ajuste do tamanho da janela

        // Definir o layout como GridLayout (3 linhas, 2 colunas) sem espaçamento
        frame.setLayout(new GridLayout(3, 2, 0, 0)); // Sem espaçamento horizontal ou vertical

        // Criar os botões
        JButton button1 = new JButton("Botão 1");
        JButton button2 = new JButton("Botão 2");
        JButton button3 = new JButton("Botão 3");
        JButton button4 = new JButton("Botão 4");
        JButton button5 = new JButton("Botão 5");

        // Adicionar os botões na janela
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(new JLabel("")); // Espaço vazio para preencher a célula restante

        // Tornar a janela visível
        frame.setVisible(true);
    }
}
