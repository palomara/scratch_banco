package view;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaConsulta extends JFrame {

	
	JTable tabela = new JTable();
	JScrollPane barraRolagem = new JScrollPane(tabela);
	JPanel painelFundo = new JPanel();
	

	public TelaConsulta () {
		
	
	}
}
