import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SistemaAluno {

    private JFrame frame;
    private DefaultTableModel tableModel;
    private JTable table;
    private ArrayList<Aluno> alunos;

    public SistemaAluno() {
        alunos = new ArrayList<>();
        criarInterfacePrincipal();
    }

    private void criarInterfacePrincipal() {
        frame = new JFrame("Sistema de Gerenciamento de Alunos");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Botões principais
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(50, 50, 150, 30);
        btnCadastrar.addActionListener(e -> abrirTelaCadastro());
        frame.add(btnCadastrar);

        JButton btnListar = new JButton("Listar");
        btnListar.setBounds(50, 100, 150, 30);
        btnListar.addActionListener(e -> abrirTelaListar());
        frame.add(btnListar);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(50, 150, 150, 30);
        btnAtualizar.addActionListener(e -> abrirTelaAtualizar());
        frame.add(btnAtualizar);

        JButton btnDeletar = new JButton("Deletar");
        btnDeletar.setBounds(50, 200, 150, 30);
        btnDeletar.addActionListener(e -> abrirTelaDeletar());
        frame.add(btnDeletar);

        frame.setVisible(true);
    }

    private void abrirTelaCadastro() {
        JFrame cadastroFrame = new JFrame("Cadastrar Aluno");
        cadastroFrame.setSize(400, 300);
        cadastroFrame.setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 100, 20);
        cadastroFrame.add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(120, 20, 200, 20);
        cadastroFrame.add(txtNome);

        JLabel lblCPF = new JLabel("CPF:");
        lblCPF.setBounds(20, 60, 100, 20);
        cadastroFrame.add(lblCPF);

        JTextField txtCPF = new JTextField();
        txtCPF.setBounds(120, 60, 200, 20);
        cadastroFrame.add(txtCPF);

        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setBounds(20, 100, 100, 20);
        cadastroFrame.add(lblMatricula);

        JTextField txtMatricula = new JTextField();
        txtMatricula.setBounds(120, 100, 200, 20);
        cadastroFrame.add(txtMatricula);

        JLabel lblPolo = new JLabel("Polo:");
        lblPolo.setBounds(20, 140, 100, 20);
        cadastroFrame.add(lblPolo);

        JTextField txtPolo = new JTextField();
        txtPolo.setBounds(120, 140, 200, 20);
        cadastroFrame.add(txtPolo);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(150, 200, 100, 30);
        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText();
            String cpf = txtCPF.getText();
            String matricula = txtMatricula.getText();
            String polo = txtPolo.getText();
            alunos.add(new Aluno(nome, cpf, matricula, polo));
            JOptionPane.showMessageDialog(cadastroFrame, "Aluno cadastrado com sucesso!");
            cadastroFrame.dispose();
        });
        cadastroFrame.add(btnSalvar);

        cadastroFrame.setVisible(true);
    }

    private void abrirTelaListar() {
        JFrame listarFrame = new JFrame("Lista de Alunos");
        listarFrame.setSize(600, 400);

        String[] colunas = {"Nome", "CPF", "Matrícula", "Polo"};
        tableModel = new DefaultTableModel(colunas, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 550, 300);
        listarFrame.add(scrollPane);

        atualizarTabela();

        listarFrame.setLayout(null);
        listarFrame.setVisible(true);
    }

    private void abrirTelaAtualizar() {
        JFrame atualizarFrame = new JFrame("Atualizar Aluno");
        atualizarFrame.setSize(400, 300);
        atualizarFrame.setLayout(null);

        JLabel lblMatriculaBusca = new JLabel("Matrícula:");
        lblMatriculaBusca.setBounds(20, 20, 100, 20);
        atualizarFrame.add(lblMatriculaBusca);

        JTextField txtMatriculaBusca = new JTextField();
        txtMatriculaBusca.setBounds(120, 20, 200, 20);
        atualizarFrame.add(txtMatriculaBusca);

        JLabel lblNovoPolo = new JLabel("Novo Polo:");
        lblNovoPolo.setBounds(20, 60, 100, 20);
        atualizarFrame.add(lblNovoPolo);

        JTextField txtNovoPolo = new JTextField();
        txtNovoPolo.setBounds(120, 60, 200, 20);
        atualizarFrame.add(txtNovoPolo);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(150, 100, 100, 30);
        btnAtualizar.addActionListener(e -> {
            String matricula = txtMatriculaBusca.getText();
            String novoPolo = txtNovoPolo.getText();

            for (Aluno aluno : alunos) {
                if (aluno.getMatricula().equals(matricula)) {
                    aluno.setPolo(novoPolo);
                    JOptionPane.showMessageDialog(atualizarFrame, "Polo atualizado com sucesso!");
                    atualizarFrame.dispose();
                    return;
                }
            }
            JOptionPane.showMessageDialog(atualizarFrame, "Matrícula não encontrada.");
        });
        atualizarFrame.add(btnAtualizar);

        atualizarFrame.setVisible(true);
    }

    private void abrirTelaDeletar() {
        JFrame deletarFrame = new JFrame("Deletar Aluno");
        deletarFrame.setSize(400, 200);
        deletarFrame.setLayout(null);

        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setBounds(20, 20, 100, 20);
        deletarFrame.add(lblMatricula);

        JTextField txtMatricula = new JTextField();
        txtMatricula.setBounds(120, 20, 200, 20);
        deletarFrame.add(txtMatricula);

        JButton btnDeletar = new JButton("Deletar");
        btnDeletar.setBounds(150, 60, 100, 30);
        btnDeletar.addActionListener(e -> {
            String matricula = txtMatricula.getText();
            alunos.removeIf(aluno -> aluno.getMatricula().equals(matricula));
            JOptionPane.showMessageDialog(deletarFrame, "Aluno deletado com sucesso!");
            deletarFrame.dispose();
        });
        deletarFrame.add(btnDeletar);

        deletarFrame.setVisible(true);
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Aluno aluno : alunos) {
            tableModel.addRow(new Object[]{aluno.getNome(), aluno.getCpf(), aluno.getMatricula(), aluno.getPolo()});
        }
    }

    public static void main(String[] args) {
        new SistemaAluno();
    }
}