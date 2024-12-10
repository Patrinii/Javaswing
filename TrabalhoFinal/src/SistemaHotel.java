import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SistemaHotel {
    private JFrame frame;
    private DefaultTableModel tableModel;
    private JTable table;
    private ArrayList<Hospede> hospedes;
    private ArrayList<String> quartosOcupados;

    public SistemaHotel() {
        hospedes = new ArrayList<>();
        quartosOcupados = new ArrayList<>();
        criarInterfacePrincipal();
    }

    private void criarInterfacePrincipal() {
        // Criação do JFrame
        frame = new JFrame("Sistema de Gerenciamento de Hóspedes");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel de fundo com imagem
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("background.jpg"); // Substitua pelo caminho da sua imagem
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);
        frame.setContentPane(backgroundPanel);

        // Título estilizado
        JLabel titulo = new JLabel("Hotel Java - Gerenciamento de Hóspedes", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(new Color(70, 130, 180));
        titulo.setBounds(200, 20, 500, 30);
        frame.add(titulo);

        // Botões principais estilizados
        JButton btnCadastrar = criarBotao("Cadastrar Hóspede", 50, 100);
        JButton btnListar = criarBotao("Listar Hóspedes", 50, 160);
        JButton btnAtualizar = criarBotao("Atualizar Hóspede", 50, 220);
        JButton btnDeletar = criarBotao("Deletar Hóspede", 50, 280);
        JButton btnEstatisticas = criarBotao("Estatísticas", 50, 340);
        JButton btnQuartos = criarBotao("Quartos Disponíveis", 50, 400);

        // Adicionando botões ao frame
        frame.add(btnCadastrar);
        frame.add(btnListar);
        frame.add(btnAtualizar);
        frame.add(btnDeletar);
        frame.add(btnEstatisticas);
        frame.add(btnQuartos);

        // Funcionalidades dos botões
        btnCadastrar.addActionListener(e -> abrirTelaCadastro());
        btnListar.addActionListener(e -> abrirTelaListar());
        btnAtualizar.addActionListener(e -> abrirTelaListar());
        btnDeletar.addActionListener(e -> abrirTelaListar());
        btnEstatisticas.addActionListener(e -> mostrarEstatisticas());
        btnQuartos.addActionListener(e -> mostrarQuartosDisponiveis());

        // Exibindo a tela
        frame.setVisible(true);
    }

    // Método para criar botões estilizados
    private JButton criarBotao(String texto, int x, int y) {
        JButton botao = new JButton(texto);
        botao.setBounds(x, y, 200, 40);
        botao.setFont(new Font("Arial", Font.PLAIN, 16));
        botao.setBackground(new Color(70, 130, 180)); // Cor azul claro
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return botao;
    }

    private void abrirTelaCadastro() {
        JFrame cadastroFrame = new JFrame("Cadastro de Hóspede");
        cadastroFrame.setSize(500, 500);
        cadastroFrame.setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 100, 20);
        cadastroFrame.add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(120, 20, 300, 20);
        cadastroFrame.add(txtNome);

        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(20, 60, 100, 20);
        cadastroFrame.add(lblEndereco);

        JTextField txtEndereco = new JTextField();
        txtEndereco.setBounds(120, 60, 300, 20);
        cadastroFrame.add(txtEndereco);

        JLabel lblQuarto = new JLabel("Número do Quarto:");
        lblQuarto.setBounds(20, 100, 150, 20);
        cadastroFrame.add(lblQuarto);

        JTextField txtQuarto = new JTextField();
        txtQuarto.setBounds(120, 100, 100, 20);
        cadastroFrame.add(txtQuarto);

        JLabel lblFoto = new JLabel("Foto:");
        lblFoto.setBounds(20, 140, 150, 20);
        cadastroFrame.add(lblFoto);

        JTextArea areaFoto = new JTextArea("Clique aqui para adicionar a foto...");
        areaFoto.setBounds(120, 140, 300, 100);
        areaFoto.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        cadastroFrame.add(areaFoto);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(180, 300, 100, 30);
        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText();
            String endereco = txtEndereco.getText();
            String quarto = txtQuarto.getText();
            String foto = areaFoto.getText();

            if (!quartosOcupados.contains(quarto)) {
                hospedes.add(new Hospede(nome, endereco, quarto, foto));
                quartosOcupados.add(quarto);
                JOptionPane.showMessageDialog(cadastroFrame, "Hóspede cadastrado com sucesso!");
                cadastroFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(cadastroFrame, "O quarto já está ocupado!");
            }
        });
        cadastroFrame.add(btnSalvar);

        cadastroFrame.setVisible(true);
    }

    private void abrirTelaListar() {
        JFrame listarFrame = new JFrame("Lista de Hóspedes");
        listarFrame.setSize(800, 400);

        String[] colunas = {"Nome", "Endereço", "Quarto", "Foto"};
        tableModel = new DefaultTableModel(colunas, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 750, 300);
        listarFrame.add(scrollPane);

        atualizarTabela();

        listarFrame.setLayout(null);
        listarFrame.setVisible(true);
    }

    private void mostrarEstatisticas() {
        int totalHospedes = hospedes.size();
        int quartosDisponiveis = 100 - quartosOcupados.size();

        JOptionPane.showMessageDialog(frame,
                "Total de Hóspedes: " + totalHospedes + "\n" +
                        "Quartos Disponíveis: " + quartosDisponiveis,
                "Estatísticas",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarQuartosDisponiveis() {
        StringBuilder quartos = new StringBuilder("Quartos Disponíveis:\n");
        for (int i = 1; i <= 100; i++) {
            if (!quartosOcupados.contains(String.valueOf(i))) {
                quartos.append("Quarto ").append(i).append("\n");
            }
        }
        JOptionPane.showMessageDialog(frame, quartos.toString(), "Quartos Disponíveis", JOptionPane.INFORMATION_MESSAGE);
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Hospede hospede : hospedes) {
            tableModel.addRow(new Object[]{hospede.getNome(), hospede.getEndereco(), hospede.getQuarto(), hospede.getFoto()});
        }
    }

    public static void main(String[] args) {
        new SistemaHotel();
    }
}
