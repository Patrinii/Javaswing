
	import javax.swing.*;
	import java.awt.*;

	public class PrimeiroExercicioB {
	    public static void main(String[] args) {
	        // Criar a janela principal
	        JFrame frame = new JFrame("Teste");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400, 300); // Definir tamanho da janela

	        // Definir o layout como BorderLayout
	        frame.setLayout(new BorderLayout());

	        // Criar os botões
	        JButton buttonNorth = new JButton("Botão 1"); // Norte
	        JButton buttonSouth = new JButton("Botão 4"); // Sul
	        JButton buttonEast = new JButton("Botão 5");  // Leste
	        JButton buttonWest = new JButton("Botão 3");  // Oeste
	        JButton buttonCenter = new JButton("Botão 2"); // Centro

	        // Adicionar os botões em suas respectivas posições
	        frame.add(buttonNorth, BorderLayout.NORTH); // Topo
	        frame.add(buttonSouth, BorderLayout.SOUTH); // Base
	        frame.add(buttonEast, BorderLayout.EAST);   // Direita
	        frame.add(buttonWest, BorderLayout.WEST);   // Esquerda
	        frame.add(buttonCenter, BorderLayout.CENTER); // Centro

	        // Tornar a janela visível
	        frame.setVisible(true);
	    }
	}
