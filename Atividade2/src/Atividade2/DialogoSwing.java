package Atividade2;
import javax.swing.*;

public class DialogoSwing {
    public static void main(String[] args) {
        // Tela 1: Solicitar o nome do usuário
        String nome = JOptionPane.showInputDialog(null, "Qual é o seu nome?", 
                                                 "Entrada", JOptionPane.QUESTION_MESSAGE);

        // Se o usuário cancelar, o programa pode ser encerrado
        if (nome == null) {
            JOptionPane.showMessageDialog(null, "Operação cancelada. Programa encerrado.", 
                                          "Cancelado", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Tela 2: Mostrar mensagem de boas-vindas com o nome informado
        JOptionPane.showMessageDialog(null, "Olá " + nome + ", seja bem-vindo (a) ao módulo de interfaces gráficas no Java!",
                                      "Mensagem", JOptionPane.INFORMATION_MESSAGE);

        // Tela 3: Perguntar se o usuário gosta de programar
        int respostaProgramar = JOptionPane.showOptionDialog(null, nome + ", você gosta de programar?", 
                                                           "Selecionar uma opção", JOptionPane.DEFAULT_OPTION, 
                                                           JOptionPane.QUESTION_MESSAGE, null, 
                                                           new Object[]{"Sim", "Não", "Cancelar"}, "Cancelar");

        // Se o usuário escolher "Cancelar", o programa será encerrado
        if (respostaProgramar == 2) {
            JOptionPane.showMessageDialog(null, "Operação cancelada. Programa encerrado.", 
                                          "Cancelado", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Resposta para "Não" ou "Sim"
        if (respostaProgramar == 1) {
            JOptionPane.showMessageDialog(null, "Que pena. Mas com as janelas você vai gostar.", 
                                          "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (respostaProgramar == 0) {
            JOptionPane.showMessageDialog(null, "Então estude bem o Java Swing. Ele pode abrir várias portas para você.", 
                                          "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }

        // Tela 4: Perguntar se o usuário gosta de objetos em Java
        Object[] options = {"Sim - Objeto é legal", "Não - Objeto é sofrimento", "Talvez - Quero aprender"};
        int respostaObjeto = JOptionPane.showOptionDialog(null, 
                                                         "Lembrete, aqui no Java Swing tudo é objeto. Você gosta disto?", 
                                                         "Atenção", JOptionPane.DEFAULT_OPTION, 
                                                         JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        // Respostas para a pergunta sobre objetos
        if (respostaObjeto == 0) {
            JOptionPane.showMessageDialog(null, "Ótimo, todos os componentes são objetos.", 
                                          "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (respostaObjeto == 1) {
            JOptionPane.showMessageDialog(null, "Não se preocupe. Agora você irá aprender a importância dos objetos.", 
                                          "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (respostaObjeto == 2) {
            JOptionPane.showMessageDialog(null, "Sim, você aprenderá.", 
                                          "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

