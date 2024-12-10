import javax.swing.*;
import java.awt.*;

public class SegundoExercicioC {
    public static void main(String[] args) {
        // Criando o frame principal
        JFrame frame = new JFrame("Wireframe Layout C");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Configurando o layout principal como BorderLayout
        frame.setLayout(new BorderLayout());

        // Painel superior com título
        JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new BorderLayout());
        painelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Título dentro de um retângulo
        JPanel tituloPanel = new JPanel();
        tituloPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        JLabel titulo = new JLabel("Título", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        tituloPanel.add(titulo);
        painelSuperior.add(tituloPanel, BorderLayout.CENTER);

        frame.add(painelSuperior, BorderLayout.NORTH);

        // Painel central com texto e imagem
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new GridLayout(1, 2, 20, 20)); // 1 linha e 2 colunas

        // Coluna esquerda - Texto
        JPanel painelTexto = new JPanel();
        painelTexto.setLayout(new BorderLayout());
        painelTexto.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JTextArea textoArea = new JTextArea("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum. Aliquam nonummy auctor massa. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nulla at risus. Quisque purus magna, auctor et, sagittis ac.", 8, 20);
        textoArea.setLineWrap(true);
        textoArea.setWrapStyleWord(true);
        textoArea.setEditable(false);

        painelTexto.add(new JScrollPane(textoArea), BorderLayout.CENTER);
        painelCentral.add(painelTexto);

        // Colocando os botões "Salvar", "Cancelar", "Voltar" abaixo da primeira caixa
        JPanel botoesTextoPanel = new JPanel();
        botoesTextoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton salvarButton = new JButton("Salvar");
        JButton cancelarButton = new JButton("Cancelar");
        JButton voltarButton = new JButton("Voltar");
        botoesTextoPanel.add(salvarButton);
        botoesTextoPanel.add(cancelarButton);
        botoesTextoPanel.add(voltarButton);
        painelTexto.add(botoesTextoPanel, BorderLayout.SOUTH);

        // Coluna direita - Imagem
        JPanel painelImagem = new JPanel();
        painelImagem.setLayout(new BorderLayout());
        painelImagem.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel imagemLabel = new JLabel("Colocar uma imagem aqui", SwingConstants.CENTER);
        painelImagem.add(imagemLabel, BorderLayout.CENTER);
        painelCentral.add(painelImagem);

        // Botão abaixo da segunda caixa (Carregar Imagem)
        JPanel carregarImagemPanel = new JPanel();
        JButton carregarImagemButton = new JButton("Carregar imagem");
        carregarImagemPanel.add(carregarImagemButton);
        painelImagem.add(carregarImagemPanel, BorderLayout.SOUTH);

        frame.add(painelCentral, BorderLayout.CENTER);

        // Painel inferior com rodapé
        JPanel painelInferior = new JPanel();
        painelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        frame.add(painelInferior, BorderLayout.SOUTH);

        // Tornando o frame visível
        frame.setVisible(true);
    }
}
