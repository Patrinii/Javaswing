import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroProgramador {
    public static void main(String[] args) {
        // Criando a janela principal
        JFrame janela = new JFrame("Cadastro do Programador");
        janela.setSize(600, 500);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);

        // Criando o painel principal
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(0, 2, 10, 10));

        // Nome
        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();
        painel.add(nomeLabel);
        painel.add(nomeField);

        // CPF
        JLabel cpfLabel = new JLabel("CPF:");
        JTextField cpfField = new JTextField();
        painel.add(cpfLabel);
        painel.add(cpfField);

        // Data de Aniversário
        JLabel dataLabel = new JLabel("Data de Aniversário:");
        JPanel dataPanel = new JPanel(new FlowLayout());
        
        // ComboBox para o dia (1-31)
        Integer[] dias = new Integer[31];
        for (int i = 0; i < 31; i++) {
            dias[i] = i + 1;
        }
        JComboBox<Integer> diaComboBox = new JComboBox<>(dias);
        
        // ComboBox para o mês (1-12)
        Integer[] meses = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        JComboBox<Integer> mesComboBox = new JComboBox<>(meses);
        
        // ComboBox para o ano (1950-2015)
        Integer[] anos = new Integer[66];
        for (int i = 0; i < 66; i++) {
            anos[i] = 1950 + i;
        }
        JComboBox<Integer> anoComboBox = new JComboBox<>(anos);

        dataPanel.add(diaComboBox);
        dataPanel.add(new JLabel("/"));
        dataPanel.add(mesComboBox);
        dataPanel.add(new JLabel("/"));
        dataPanel.add(anoComboBox);
        
        painel.add(dataLabel);
        painel.add(dataPanel);

        // Apresentação pessoal
        JLabel apresentacaoLabel = new JLabel("Apresentação Pessoal:");
        JTextArea apresentacaoArea = new JTextArea(3, 20);
        JScrollPane scrollPane = new JScrollPane(apresentacaoArea);
        painel.add(apresentacaoLabel);
        painel.add(scrollPane);

        // Sexo (Radio Buttons)
        JLabel sexoLabel = new JLabel("Sexo:");
        JRadioButton masculino = new JRadioButton("Masculino");
        JRadioButton feminino = new JRadioButton("Feminino");
        ButtonGroup sexoGroup = new ButtonGroup();
        sexoGroup.add(masculino);
        sexoGroup.add(feminino);
        JPanel sexoPanel = new JPanel(new FlowLayout());
        sexoPanel.add(masculino);
        sexoPanel.add(feminino);
        painel.add(sexoLabel);
        painel.add(sexoPanel);

        // Linguagens (CheckBoxes)
        JLabel linguagensLabel = new JLabel("Linguagens:");
        JCheckBox javaCheck = new JCheckBox("Java");
        JCheckBox pythonCheck = new JCheckBox("Python");
        JCheckBox cplusCheck = new JCheckBox("C++");
        JCheckBox outrasCheck = new JCheckBox("Outras");
        JPanel linguagensPanel = new JPanel(new FlowLayout());
        linguagensPanel.add(javaCheck);
        linguagensPanel.add(pythonCheck);
        linguagensPanel.add(cplusCheck);
        linguagensPanel.add(outrasCheck);
        painel.add(linguagensLabel);
        painel.add(linguagensPanel);

        // Nível de conhecimento (JSlider)
        JLabel nivelLabel = new JLabel("Nível de Conhecimento em Teste de Software:");
        JSlider nivelSlider = new JSlider(0, 3);
        nivelSlider.setPaintTicks(true);
        nivelSlider.setPaintLabels(true);
        nivelSlider.setMinorTickSpacing(1);
        nivelSlider.setMajorTickSpacing(1);
        nivelSlider.setValue(0);
        JPanel nivelPanel = new JPanel(new FlowLayout());
        nivelPanel.add(nivelSlider);
        painel.add(nivelLabel);
        painel.add(nivelPanel);

        // Vagas disponíveis (Tabela)
        JLabel vagasLabel = new JLabel("Vagas Disponíveis:");
        String[] colunas = {"Back-end", "Front-end"};
        String[][] dados = {
                {"Java Spring", "React"},
                {"Python", "Rest API"},
                {"C++", "Vue.js"}
        };
        JTable tabela = new JTable(dados, colunas);
        JScrollPane tabelaScroll = new JScrollPane(tabela);
        painel.add(vagasLabel);
        painel.add(tabelaScroll);

        // Tipo (ComboBox)
        JLabel tipoLabel = new JLabel("Tipo:");
        String[] tipos = {"Back-end", "Front-end"};
        JComboBox<String> tipoComboBox = new JComboBox<>(tipos);
        painel.add(tipoLabel);
        painel.add(tipoComboBox);

        // Botão Enviar
        JButton enviarButton = new JButton("Enviar Formulário");
        painel.add(new JLabel()); // Espaço vazio
        painel.add(enviarButton);

        // Ação do botão "Enviar"
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String cpf = cpfField.getText();
                String data = diaComboBox.getSelectedItem() + "/" + mesComboBox.getSelectedItem() + "/" + anoComboBox.getSelectedItem();
                String apresentacao = apresentacaoArea.getText();
                String sexo = masculino.isSelected() ? "Masculino" : feminino.isSelected() ? "Feminino" : "Não informado";
                StringBuilder linguagens = new StringBuilder();
                if (javaCheck.isSelected()) linguagens.append("Java ");
                if (pythonCheck.isSelected()) linguagens.append("Python ");
                if (cplusCheck.isSelected()) linguagens.append("C++ ");
                if (outrasCheck.isSelected()) linguagens.append("Outras ");
                int nivel = nivelSlider.getValue();
                String tipo = (String) tipoComboBox.getSelectedItem();

                String mensagem = "Nome: " + nome + "\n" +
                                  "CPF: " + cpf + "\n" +
                                  "Data de Aniversário: " + data + "\n" +
                                  "Apresentação: " + apresentacao + "\n" +
                                  "Sexo: " + sexo + "\n" +
                                  "Linguagens: " + linguagens.toString() + "\n" +
                                  "Nível: " + nivel + "\n" +
                                  "Tipo: " + tipo;

                JOptionPane.showMessageDialog(janela, mensagem, "Dados Enviados", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Configuração da janela
        janela.add(painel);
        janela.setVisible(true);
    }
}
