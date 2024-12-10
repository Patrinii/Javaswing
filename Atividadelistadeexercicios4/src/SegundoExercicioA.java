import javax.swing.*;
import java.awt.*;

public class SegundoExercicioA {
    public static void main(String[] args) {
        // Criando o frame principal
        JFrame frame = new JFrame("Wireframe Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Configurando o layout principal como BorderLayout
        frame.setLayout(new BorderLayout());

        // Painel esquerdo com campos e botão
        JPanel painelEsquerdo = new JPanel();
        painelEsquerdo.setLayout(new BoxLayout(painelEsquerdo, BoxLayout.Y_AXIS));
        painelEsquerdo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Adicionando os campos
        for (int i = 1; i <= 4; i++) {
            JPanel campoPanel = new JPanel(new BorderLayout());
            campoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            campoPanel.setPreferredSize(new Dimension(200, 30));

            JLabel label = new JLabel("Campo " + i + ":");
            JTextField textField = new JTextField();

            campoPanel.add(label, BorderLayout.WEST);
            campoPanel.add(textField, BorderLayout.CENTER);

            painelEsquerdo.add(campoPanel);
            painelEsquerdo.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço entre os campos
        }

        // Botão "Salvar"
        JButton salvarButton = new JButton("Salvar");
        salvarButton.setPreferredSize(new Dimension(200, 40));
        salvarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelEsquerdo.add(salvarButton);

        frame.add(painelEsquerdo, BorderLayout.WEST);

        // Painel central com título, imagens e texto
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new BorderLayout());
        painelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Título
        JLabel titulo = new JLabel("Título", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        painelCentral.add(titulo, BorderLayout.NORTH);

        // Painel de conteúdo
        JPanel conteudoPanel = new JPanel();
        conteudoPanel.setLayout(new GridLayout(1, 3, 10, 10));
        conteudoPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Painel esquerdo (imagem)
        JPanel imagemEsquerdaPanel = new JPanel();
        imagemEsquerdaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        imagemEsquerdaPanel.add(new JLabel("Colocar uma imagem aqui"));
        conteudoPanel.add(imagemEsquerdaPanel);

        // Painel central (texto)
        JPanel textoPanel = new JPanel(new BorderLayout());
        textoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel texto = new JLabel("<html>Lorem ipsum dolor sit amet, consectetur adipiscing elit.<br>" +
                                   "Etiam eget ligula eu lectus lobortis condimentum.<br>" +
                                   "Aliquam nonummy.</html>", SwingConstants.CENTER);
        textoPanel.add(texto, BorderLayout.CENTER);
        conteudoPanel.add(textoPanel);

        // Painel direito (imagem)
        JPanel imagemDireitaPanel = new JPanel();
        imagemDireitaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        imagemDireitaPanel.add(new JLabel("Colocar uma imagem aqui"));
        conteudoPanel.add(imagemDireitaPanel);

        painelCentral.add(conteudoPanel, BorderLayout.CENTER);

        // Rodapé
        JLabel rodape = new JLabel("Rodapé", SwingConstants.CENTER);
        rodape.setFont(new Font("Arial", Font.BOLD, 16));
        rodape.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        painelCentral.add(rodape, BorderLayout.SOUTH);

        frame.add(painelCentral, BorderLayout.CENTER);

        // Tornando o frame visível
        frame.setVisible(true);
    }
}
