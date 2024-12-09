package atividade3;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class MainSwing {
    public static void main(String[] args) {
        // Criação da janela principal
        JFrame frame = new JFrame("Interface Gráfica com Java Swing");
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criando o JPanel principal com BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // BoxLayout para organizar os componentes verticalmente

        // a) Imagem com texto: "Interface gráfica com Java Swing"
        JPanel labelPanel = new JPanel();
        labelPanel.add(new JLabel("Interface gráfica com Java Swing"));
        panel.add(labelPanel);

        // b) Nome: (campo de texto)
        JPanel namePanel = new JPanel();
        namePanel.add(new JLabel("Nome: "));
        JTextField nameField = new JTextField(20);
        namePanel.add(nameField);
        panel.add(namePanel);

        // c) Resumo das atividades profissionais
        JPanel activityPanel = new JPanel();
        activityPanel.add(new JLabel("Faça um resumo de suas atividades profissionais:"));
        JTextArea activityTextArea = new JTextArea(5, 20);
        JScrollPane activityScrollPane = new JScrollPane(activityTextArea);
        activityPanel.add(activityScrollPane);
        panel.add(activityPanel);

        // d) Cores preferidas: com caixinhas para marcar
        JPanel colorPanel = new JPanel();
        JCheckBox blueCheckBox = new JCheckBox("Azul");
        JCheckBox blackCheckBox = new JCheckBox("Preto");
        JCheckBox yellowCheckBox = new JCheckBox("Amarelo");
        JCheckBox greenCheckBox = new JCheckBox("Verde");
        colorPanel.add(blueCheckBox);
        colorPanel.add(blackCheckBox);
        colorPanel.add(yellowCheckBox);
        colorPanel.add(greenCheckBox);
        panel.add(colorPanel);

        // e) Sexo: Masculino/Feminino
        JPanel sexPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sexPanel.add(new JLabel("Sexo: "));
        JRadioButton maleButton = new JRadioButton("Masculino");
        JRadioButton femaleButton = new JRadioButton("Feminino");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        sexPanel.add(maleButton);
        sexPanel.add(femaleButton);
        panel.add(sexPanel);
        
     // f) Botões: Cancelar, Salvar, Enviar
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton cancelButton = new JButton("Cancelar");
        JButton saveButton = new JButton("Salvar");
        JButton sendButton = new JButton("Enviar");
        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(sendButton);
        panel.add(buttonPanel);

     // g) Nome e Sexo juntos com botão "Enviar"
        JPanel nameSexPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameSexPanel.add(new JLabel("Nome: "));
        JTextField nameField1 = new JTextField(15);
        nameSexPanel.add(nameField1);
        nameSexPanel.add(new JLabel("Sexo: "));
        JRadioButton maleButton2 = new JRadioButton("Masculino");
        JRadioButton femaleButton2 = new JRadioButton("Feminino");
        ButtonGroup genderGroup2 = new ButtonGroup();
        genderGroup2.add(maleButton2);
        genderGroup2.add(femaleButton2);
        nameSexPanel.add(maleButton2);
        nameSexPanel.add(femaleButton2);
        JButton sendButton2 = new JButton("Enviar");
        nameSexPanel.add(sendButton2);
        panel.add(nameSexPanel);
        
     // Adicionando o painel principal à janela
        frame.add(panel);
        frame.setVisible(true);

        // h) Tabela de produtos
        JPanel tablePanel = new JPanel();
        String[] columnNames = {"Código", "Produto", "Descrição"};
        Object[][] data = {
            {"1123", "Pendrive", "Pendrive 32GB"},
            {"2323", "HD SSD", "256GB"},
            {"3333", "Memória RAM", "16GB"},
            {"2344", "CPU", "i7"}
        };
        JTable productTable = new JTable(data, columnNames);
        JScrollPane tableScrollPane = new JScrollPane(productTable);
        tablePanel.add(tableScrollPane);
        panel.add(tablePanel);

     // i) Caixa com rolagem (JList)
        JPanel listPanel = new JPanel();
        String[] listItems = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"}; // Adicionei mais itens para demonstrar a rolagem
        JList<String> list = new JList<>(listItems);

        // Configurando o número de itens visíveis antes de precisar rolar
        list.setVisibleRowCount(3); // Apenas 3 itens visíveis de cada vez

        // Adicionando a lista a um JScrollPane
        JScrollPane listScrollPane = new JScrollPane(list);
        listScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Sempre mostrar a barra de rolagem vertical

        // Adicionando o JScrollPane ao painel
        listPanel.add(listScrollPane);
        panel.add(listPanel);


        // l) Estrutura de pastas e arquivos (JTree)
        JPanel treePanel = new JPanel();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("The Java Series");
        DefaultMutableTreeNode booksNode1 = new DefaultMutableTreeNode("Books for Java I");
        root.add(booksNode1);
        DefaultMutableTreeNode booksNode2 = new DefaultMutableTreeNode("Books for Java I");
        DefaultMutableTreeNode bookFileNode1 = new DefaultMutableTreeNode("The Java Vlr");
        DefaultMutableTreeNode bookFileNode2 = new DefaultMutableTreeNode("The Java La");
        booksNode2.add(bookFileNode1);
        booksNode2.add(bookFileNode2);
        root.add(booksNode2);
        JTree tree = new JTree(root);
        JScrollPane treeScrollPane = new JScrollPane(tree);
        treePanel.add(treeScrollPane);
        panel.add(treePanel);

        // Criando o JScrollPane para o painel principal
        JScrollPane panelScrollPane = new JScrollPane(panel);
        panelScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panelScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        frame.add(panelScrollPane, BorderLayout.CENTER); // Adiciona o painel com barras de rolagem ao frame
        frame.setVisible(true); // Torna a janela principal visível

        // Criação da janela de progresso
        createProgressWindow();
    }

    // Método para criar a janela separada de progresso
    public static void createProgressWindow() {
        JFrame progressFrame = new JFrame("Progress...");
        progressFrame.setSize(300, 150);
        progressFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel progressPanel = new JPanel();
        progressPanel.setLayout(new BoxLayout(progressPanel, BoxLayout.Y_AXIS));

        JLabel progressLabel = new JLabel("Running, a Long Task");
        progressLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        progressPanel.add(progressLabel);

        JLabel completionLabel = new JLabel("Completed 43%");
        completionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        progressPanel.add(completionLabel);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        progressPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento vertical
        progressPanel.add(cancelButton);

        progressFrame.add(progressPanel);
        progressFrame.setVisible(true);
    }
}
