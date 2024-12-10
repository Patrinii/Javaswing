import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SextoExercicio {
    private JFrame frame;
    private JTextField nomeField, enderecoField, cidadeField;
    private JTextArea observacoesArea;
    private JRadioButton masculinoButton, femininoButton;
    private JCheckBox curso1CheckBox, curso2CheckBox, curso3CheckBox;
    private JComboBox<String> estadoComboBox;
    private JList<String> interessesList, selecionadosList;
    private DefaultListModel<String> selecionadosModel;
    private JButton inserirButton, adicionarButton, removerButton;

    public SextoExercicio() {
        // Configuração da Janela
        frame = new JFrame("Componentes de Interface Gráfica");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Campos de texto
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(20, 20, 100, 20);
        frame.add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(100, 20, 250, 20);
        frame.add(nomeField);

        JLabel enderecoLabel = new JLabel("Endereço:");
        enderecoLabel.setBounds(20, 50, 100, 20);
        frame.add(enderecoLabel);

        enderecoField = new JTextField();
        enderecoField.setBounds(100, 50, 250, 20);
        frame.add(enderecoField);

        // Botão Inserir
        inserirButton = new JButton("Inserir");
        inserirButton.setBounds(370, 35, 100, 30);
        frame.add(inserirButton);

        // Cidade e Estado
        JLabel cidadeLabel = new JLabel("Cidade:");
        cidadeLabel.setBounds(20, 90, 100, 20);
        frame.add(cidadeLabel);

        cidadeField = new JTextField();
        cidadeField.setBounds(100, 90, 120, 20);
        frame.add(cidadeField);

        JLabel estadoLabel = new JLabel("Estado:");
        estadoLabel.setBounds(230, 90, 100, 20);
        frame.add(estadoLabel);

        String[] estados = {"PR", "SP", "RJ", "MG", "RS"};
        estadoComboBox = new JComboBox<>(estados);
        estadoComboBox.setBounds(280, 90, 60, 20);
        frame.add(estadoComboBox);

        // Botões de sexo
        JLabel sexoLabel = new JLabel("Sexo:");
        sexoLabel.setBounds(20, 130, 100, 20);
        frame.add(sexoLabel);

        masculinoButton = new JRadioButton("Masculino");
        masculinoButton.setBounds(100, 130, 100, 20);
        frame.add(masculinoButton);

        femininoButton = new JRadioButton("Feminino");
        femininoButton.setBounds(200, 130, 100, 20);
        frame.add(femininoButton);

        ButtonGroup sexoGroup = new ButtonGroup();
        sexoGroup.add(masculinoButton);
        sexoGroup.add(femininoButton);

        // Checkboxes de opções
        JLabel opcoesLabel = new JLabel("Opções:");
        opcoesLabel.setBounds(20, 160, 100, 20);
        frame.add(opcoesLabel);

        curso1CheckBox = new JCheckBox("Curso 1");
        curso1CheckBox.setBounds(100, 160, 80, 20);
        frame.add(curso1CheckBox);

        curso2CheckBox = new JCheckBox("Curso 2");
        curso2CheckBox.setBounds(180, 160, 80, 20);
        frame.add(curso2CheckBox);

        curso3CheckBox = new JCheckBox("Curso 3");
        curso3CheckBox.setBounds(260, 160, 80, 20);
        frame.add(curso3CheckBox);

        // Listas de interesses com barras de rolagem
        JLabel interessesLabel = new JLabel("Interesses:");
        interessesLabel.setBounds(20, 200, 100, 20);
        frame.add(interessesLabel);

        String[] interesses = {"Redes", "Internet", "Compiladores", "Segurança", "BD"};
        interessesList = new JList<>(interesses);
        JScrollPane interessesScroll = new JScrollPane(interessesList);
        interessesScroll.setBounds(100, 200, 100, 80);
        frame.add(interessesScroll);

        adicionarButton = new JButton(">>");
        adicionarButton.setBounds(210, 210, 50, 20);
        frame.add(adicionarButton);

        removerButton = new JButton("<<");
        removerButton.setBounds(210, 240, 50, 20);
        frame.add(removerButton);

        selecionadosModel = new DefaultListModel<>();
        selecionadosList = new JList<>(selecionadosModel);
        JScrollPane selecionadosScroll = new JScrollPane(selecionadosList);
        selecionadosScroll.setBounds(270, 200, 100, 80);
        frame.add(selecionadosScroll);

        // Observações com barra de rolagem (Alterado para rolagem vertical)
        JLabel observacoesLabel = new JLabel("Observações:");
        observacoesLabel.setBounds(20, 300, 100, 20);
        frame.add(observacoesLabel);

        observacoesArea = new JTextArea();
        observacoesArea.setLineWrap(true); // Permite quebra de linha automática
        observacoesArea.setWrapStyleWord(true); // Quebra as linhas nas palavras

        JScrollPane observacoesScroll = new JScrollPane(observacoesArea);
        observacoesScroll.setBounds(20, 330, 450, 100); // Definindo a posição e tamanho
        observacoesScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Forçar rolagem vertical
        observacoesScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Impedir rolagem horizontal
        frame.add(observacoesScroll);

        // Ações dos botões
        adicionarButton.addActionListener(e -> {
            String interesseSelecionado = interessesList.getSelectedValue();
            if (interesseSelecionado != null && !selecionadosModel.contains(interesseSelecionado)) {
                selecionadosModel.addElement(interesseSelecionado);
            }
        });

        removerButton.addActionListener(e -> {
            String interesseSelecionado = selecionadosList.getSelectedValue();
            if (interesseSelecionado != null) {
                selecionadosModel.removeElement(interesseSelecionado);
            }
        });

        inserirButton.addActionListener(e -> {
            // Armazenando os dados
            String nome = nomeField.getText();
            String endereco = enderecoField.getText();
            String cidade = cidadeField.getText();
            String estado = (String) estadoComboBox.getSelectedItem();
            String sexo = masculinoButton.isSelected() ? "Masculino" : femininoButton.isSelected() ? "Feminino" : "Não informado";
            ArrayList<String> cursos = new ArrayList<>();
            if (curso1CheckBox.isSelected()) cursos.add("Curso 1");
            if (curso2CheckBox.isSelected()) cursos.add("Curso 2");
            if (curso3CheckBox.isSelected()) cursos.add("Curso 3");
            ArrayList<String> interessesSelecionados = new ArrayList<>();
            for (int i = 0; i < selecionadosModel.size(); i++) {
                interessesSelecionados.add(selecionadosModel.getElementAt(i));
            }
            String observacoes = observacoesArea.getText();

            // Exibindo os dados no terminal
            System.out.println("Dados Inseridos:");
            System.out.println("Nome: " + nome);
            System.out.println("Endereço: " + endereco);
            System.out.println("Cidade: " + cidade + ", Estado: " + estado);
            System.out.println("Sexo: " + sexo);
            System.out.println("Opções Selecionadas: " + cursos);
            System.out.println("Interesses Selecionados: " + interessesSelecionados);
            System.out.println("Observações: " + observacoes);
        });

        // Tornar a janela visível
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SextoExercicio();
    }
}
