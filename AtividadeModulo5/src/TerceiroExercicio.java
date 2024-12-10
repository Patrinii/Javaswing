import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TerceiroExercicio {
    public static void main(String[] args) {
        // Criar a janela principal (JFrame)
        JFrame frame = new JFrame("Exemplo de Enviar Mensagem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150); // Tamanho da janela

        // Criar o painel (JPanel)
        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());

        // Criar a caixa de texto (JTextField)
        JTextField campoTexto = new JTextField(20); // Caixa de texto com 20 colunas

        // Criar o botão "ENVIAR"
        JButton botaoEnviar = new JButton("ENVIAR");

        // Adicionar o ActionListener ao botão
        botaoEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obter o texto digitado no campo de texto
                String mensagem = campoTexto.getText();

                // Exibir a mensagem digitada em uma janela do JOptionPane
                JOptionPane.showMessageDialog(frame, "Mensagem: " + mensagem, "Mensagem Enviada", JOptionPane.INFORMATION_MESSAGE);
                
                // Limpar o campo de texto após o envio
                campoTexto.setText("");
            }
        });

        // Adicionar a caixa de texto e o botão ao painel
        painel.add(campoTexto);
        painel.add(botaoEnviar);

        // Adicionar o painel à janela
        frame.add(painel);

        // Tornar a janela visível
        frame.setVisible(true);
    }
}
