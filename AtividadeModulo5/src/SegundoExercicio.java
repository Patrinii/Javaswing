import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SegundoExercicio {
    public static void main(String[] args) {
        // Criar a janela principal
        JFrame frame = new JFrame("Modificando o Label");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200); // Tamanho da janela

        // Criar o painel
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());

        // Criar o JLabel inicial
        JLabel label = new JLabel("Texto Inicial", JLabel.CENTER);
        painel.add(label, BorderLayout.CENTER);

        // Criar os botões
        JButton botaoJava = new JButton("Java");
        JButton botaoJavaScript = new JButton("Java Script");
        JButton botaoPython = new JButton("Python");
        JButton botaoCPlusPlus = new JButton("C++");
        JButton botaoCSharp = new JButton("C#");
        JButton botaoC = new JButton("C");

        // Adicionar os ouvintes de eventos para os botões
        botaoJava.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Java"); // Modificar o texto do label para Java
            }
        });

        botaoJavaScript.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Java Script"); // Modificar o texto do label para Java Script
            }
        });

        botaoPython.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Python"); // Modificar o texto do label para Python
            }
        });

        botaoCPlusPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("C++"); // Modificar o texto do label para C++
            }
        });

        botaoCSharp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("C#"); // Modificar o texto do label para C#
            }
        });

        botaoC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("C"); // Modificar o texto do label para C
            }
        });

        // Criar o painel de botões e adicionar os botões nele
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(2, 3)); // Layout para os botões
        painelBotoes.add(botaoJava);
        painelBotoes.add(botaoJavaScript);
        painelBotoes.add(botaoPython);
        painelBotoes.add(botaoCPlusPlus);
        painelBotoes.add(botaoCSharp);
        painelBotoes.add(botaoC);

        // Adicionar os painéis à janela
        frame.setLayout(new BorderLayout());
        frame.add(painel, BorderLayout.CENTER);
        frame.add(painelBotoes, BorderLayout.SOUTH);

        // Tornar a janela visível
        frame.setVisible(true);
    }
}
