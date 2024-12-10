
import javax.swing.*;
import java.awt.*;

public class SegundoExercicioB {
    public static void main(String[] args) {
        // Criando o frame principal
        JFrame frame = new JFrame("Wireframe Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Configurando o layout principal como BorderLayout
        frame.setLayout(new BorderLayout());

        // Cabeçalho (Título) com borda
        JPanel painelTitulo = new JPanel(new BorderLayout());
        painelTitulo.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Adicionando borda
        painelTitulo.setBackground(Color.LIGHT_GRAY);

        JLabel titulo = new JLabel("Título", SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBackground(Color.LIGHT_GRAY);

        painelTitulo.add(titulo, BorderLayout.CENTER);
        frame.add(painelTitulo, BorderLayout.NORTH);

        // Menu lateral esquerdo com itens dentro de retângulos
        JPanel menuLateral = new JPanel();
        menuLateral.setLayout(new BoxLayout(menuLateral, BoxLayout.Y_AXIS));
        menuLateral.setBackground(Color.GRAY);
        String[] itensMenu = {"Cliente", "Produto", "Vendas", "Arquivos"};
        for (String item : itensMenu) {
            JPanel itemPanel = new JPanel(new BorderLayout());
            itemPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Adicionando borda ao item
            itemPanel.setBackground(Color.DARK_GRAY);

            JLabel label = new JLabel(item, SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 16));
            label.setForeground(Color.WHITE);
            label.setOpaque(false);

            itemPanel.add(label, BorderLayout.CENTER);
            menuLateral.add(itemPanel);
        }
        frame.add(menuLateral, BorderLayout.WEST);

        // Área de postagens (grid central)
        JPanel areaCentral = new JPanel();
        areaCentral.setLayout(new GridLayout(2, 1, 10, 10)); // 2 linhas (cada linha será um painel com 2 colunas)
        areaCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espaçamento externo

        // Criando cada linha
        for (int linha = 0; linha < 2; linha++) {
            JPanel linhaPanel = new JPanel();
            linhaPanel.setLayout(new GridLayout(1, 2, 10, 0)); // 1 linha, 2 colunas
            linhaPanel.setOpaque(false);

            for (int coluna = 0; coluna < 2; coluna++) {
                JPanel postagem = new JPanel();
                postagem.setLayout(new BorderLayout());
                postagem.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                // "Título" mais estreito
                JLabel tituloPostagem = new JLabel("Título", SwingConstants.CENTER);
                tituloPostagem.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                tituloPostagem.setOpaque(true);
                tituloPostagem.setBackground(Color.WHITE);
                tituloPostagem.setPreferredSize(new Dimension(0, 30)); // Altura fixa

                // "Postagem" maior
                JLabel conteudoPostagem = new JLabel("Postagem", SwingConstants.CENTER);
                conteudoPostagem.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                conteudoPostagem.setOpaque(true);
                conteudoPostagem.setBackground(Color.WHITE);

                // "Autor" mais estreito
                JLabel autorPostagem = new JLabel("Autor", SwingConstants.CENTER);
                autorPostagem.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                autorPostagem.setOpaque(true);
                autorPostagem.setBackground(Color.WHITE);
                autorPostagem.setPreferredSize(new Dimension(0, 30)); // Altura fixa

                // Adicionando ao painel da postagem
                postagem.add(tituloPostagem, BorderLayout.NORTH);
                postagem.add(conteudoPostagem, BorderLayout.CENTER);
                postagem.add(autorPostagem, BorderLayout.SOUTH);

                linhaPanel.add(postagem);
            }

            areaCentral.add(linhaPanel);
        }
        frame.add(areaCentral, BorderLayout.CENTER);

        // Área de propaganda (lateral direita) com borda
        JPanel painelPropaganda = new JPanel(new BorderLayout());
        painelPropaganda.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Adicionando borda
        painelPropaganda.setBackground(Color.LIGHT_GRAY);
        painelPropaganda.setPreferredSize(new Dimension(140, 0)); // Ajustando largura fixa maior

        JLabel propaganda = new JLabel("<html>Área para propagandas</html>", SwingConstants.CENTER);
        propaganda.setOpaque(false);
        propaganda.setFont(new Font("Arial", Font.PLAIN, 14));

        painelPropaganda.add(propaganda, BorderLayout.CENTER);
        frame.add(painelPropaganda, BorderLayout.EAST);

        // Rodapé com borda
        JPanel painelRodape = new JPanel(new BorderLayout());
        painelRodape.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Adicionando borda
        painelRodape.setBackground(Color.LIGHT_GRAY);

        JLabel rodape = new JLabel("Rodapé", SwingConstants.CENTER);
        rodape.setOpaque(true);
        rodape.setFont(new Font("Arial", Font.BOLD, 16));
        rodape.setBackground(Color.LIGHT_GRAY);

        painelRodape.add(rodape, BorderLayout.CENTER);
        frame.add(painelRodape, BorderLayout.SOUTH);

        // Tornando o frame visível
        frame.setVisible(true);
    }
}
