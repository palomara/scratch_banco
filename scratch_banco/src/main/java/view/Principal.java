package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.JdbUtil;
import controller.UsuariosJdbcDAO;
import model.Tarefas;

public class Principal extends JFrame {

	JDesktopPane windowCad = new JDesktopPane();
	
	TitledBorder titleBorderP;
	
	JPanel panel = new JPanel();
	
	JMenuBar barraMenu = new JMenuBar();
	
	JMenu menuUsuarios = new JMenu ("Usuários");
	JMenu menuTarefas = new JMenu ("Tarefas");
	JMenu menuMetodologias = new JMenu ("Metodologias");
	JMenu menuInfluencias = new JMenu ("Influencias");
	JMenu menuConsulta = new JMenu ("Consulta");

	JMenuItem cadUsuario;
	JMenuItem cadTarefa;
	JMenuItem cadMetodologia;
	JMenuItem cadInfluencia;
	JMenuItem editUsuario;
	JMenuItem editTarefa;
	JMenuItem editInfluencia;
	JMenuItem editMetodologia;
	JMenuItem deleteUsuario;
	JMenuItem deleteTarefa;
	JMenuItem deleteMetodologia;
	JMenuItem deleteInfluencia;
	
	
	JLabel lblID = new JLabel ("ID:");
	JLabel lblTitulo = new JLabel ("Tarefa:");
	
	JTextField txbID = new JTextField();
	JTextField txbTitulo = new JTextField();
	
	JLabel lblPesquisa = new JLabel();
	JTextField txtPesquisa = new JTextField();
	
	JButton btnPesquisar = new JButton ("Pesquisar");
	JButton btnSalvar = new JButton ("Salvar");
	

	
	public Principal () {
		
		super ("Scratch out - Gerenciador de tarefas");
		
		 Container paine = this.getContentPane();
		
		windowCad = new JDesktopPane(){

		
		public void paintComponent(Graphics g){
			try {
				super.paintComponents(g);
				Image img = ImageIO.read(new java.net.URL(

						this.getClass().getResource("imagens/kelly.jpg"), "kelly.jpg"));
				
				if (img != null) {

					g.drawImage(img, 0, 0, 600, 396, this);
		
				}
			}
				catch(Exception e){

				e.printStackTrace();
			}
			
		}
	};
	
	windowCad.setBackground(Color.YELLOW);
		
		this.setJMenuBar(barraMenu);
		
		barraMenu.add(menuUsuarios);
		barraMenu.add(menuTarefas);
		barraMenu.add(menuMetodologias);
		barraMenu.add(menuInfluencias);
		barraMenu.add(menuConsulta);
		
		menuUsuarios.setIcon(new ImageIcon(this.getClass().getResource("imagens/plus.png")));
		menuTarefas.setIcon(new ImageIcon(this.getClass().getResource("imagens/notes.png")));
		menuMetodologias.setIcon(new ImageIcon(this.getClass().getResource("imagens/analysis.png")));
		menuInfluencias.setIcon(new ImageIcon(this.getClass().getResource("imagens/smile.png")));
		menuConsulta.setIcon(new ImageIcon(this.getClass().getResource("imagens/search.png")));
		
		menuUsuarios.add(cadUsuario = new JMenuItem ("Cadastrar"));
		cadUsuario.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				TelaUsuarios app = new TelaUsuarios();
			}
		});
		
		menuTarefas.add(cadTarefa = new JMenuItem ("Adicionar"));
		cadTarefa.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				TelaTarefas app = new TelaTarefas();
			}
		});
		
		menuMetodologias.add(cadMetodologia = new JMenuItem ("Adicionar"));
		cadMetodologia.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				TelaMetodologias app = new TelaMetodologias();
			}
		});
		
		menuInfluencias.add(cadInfluencia = new JMenuItem ("Adicionar"));
		cadInfluencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInfluencias app = new TelaInfluencias();
			}
		});
		
		menuUsuarios.add(editUsuario = new JMenuItem ("Editar dados"));
		editUsuario.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				TelaEdicaoUsuario editarUsuario = new TelaEdicaoUsuario();
			}
		});
		
		menuTarefas.add(editTarefa = new JMenuItem ("Editar dados"));
		editTarefa.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				TelaEdicaoTarefa editarTarefa = new TelaEdicaoTarefa();
			}
		});
		
		menuMetodologias.add(editMetodologia = new JMenuItem ("Editar dados"));
		editMetodologia.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
			TelaEdicaoMetodologias editarMetodologia = new TelaEdicaoMetodologias();
			}
		});
		
		menuInfluencias.add(editInfluencia = new JMenuItem ("Editar dados"));
		editInfluencia.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				TelaEditarInfluencia editarInfluencia = new TelaEditarInfluencia();
			}
		});
		
		menuUsuarios.add(deleteUsuario = new JMenuItem ("Deletar"));
		deleteUsuario.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				TelaDeletarUsuario deletarUsuario = new TelaDeletarUsuario();
			}
		});
		
		menuTarefas.add(deleteTarefa = new JMenuItem ("Deletar"));
		deleteTarefa.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				TelaDeletarTarefa deletarTarefa = new TelaDeletarTarefa();

			}
		});
		
		menuMetodologias.add(deleteMetodologia = new JMenuItem ("Deletar"));
		deleteMetodologia.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				TelaDeletarMetodologia deletarMetodologia = new TelaDeletarMetodologia();
			}
		});
		
		menuInfluencias.add(deleteInfluencia = new JMenuItem ("Deletar"));
		deleteInfluencia.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
			TelaDeletarInfluencia deletarInfluencia = new TelaDeletarInfluencia();	
			}
		});
		
		menuConsulta.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				TelaConsulta telaConsulta = new TelaConsulta();
			}
		});
		
		
		
		this.setVisible(true);
		this.setSize(600, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().add(windowCad);
		
	}
}
