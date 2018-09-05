package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.UsuariosJdbcDAO;
import model.TarefaParticipantes;
import model.Tarefas;

public class Principal extends JFrame {

	JDesktopPane windowCad = new JDesktopPane();
	
	JMenuBar barraMenu = new JMenuBar();
	
	JMenu menuUsuarios = new JMenu ("Usuários");
	JMenu menuTarefas = new JMenu ("Tarefas");
	JMenu menuMetodologias = new JMenu ("Metodologias");
	JMenu menuInfluencias = new JMenu ("Influencias");

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
	
	windowCad.setBackground(Color.WHITE);
		
		this.setJMenuBar(barraMenu);
		
		barraMenu.add(menuUsuarios);
		barraMenu.add(menuTarefas);
		barraMenu.add(menuMetodologias);
		barraMenu.add(menuInfluencias);
		
		
		
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
			
			}
		});
		
		menuInfluencias.add(editInfluencia = new JMenuItem ("Editar dados"));
		editInfluencia.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				
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
				
			}
		});
		
		menuMetodologias.add(deleteMetodologia = new JMenuItem ("Deletar"));
		deleteMetodologia.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				
			}
		});
		
		menuInfluencias.add(deleteInfluencia = new JMenuItem ("Deletar"));
		deleteInfluencia.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				
			}
		});
		
		/*paine.add(lblID);
		paine.add(txbID);
		lblID.setBounds(10, 20, 80, 80);
		txbID.setBounds(70, 50, 85, 20);
		
		paine.add(lblTitulo);
		paine.add(txbTitulo);
		lblTitulo.setBounds(10, 40, 80, 80);
		txbTitulo.setBounds(70, 70, 100, 20);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(30, 110, 120, 40);*/
		
		paine.add(btnPesquisar);
		btnPesquisar.setBounds(30, 110, 120, 40);
		
		btnPesquisar.addActionListener(new ActionListener() {

			@Override
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					TarefaParticipantes TP = new TarefaParticipantes();
					
					
					Connection connection = JdbUtil.getConnection();
					UsuariosJdbcDAO usuariosJdbcDAselectTarefasO = new UsuariosJdbcDAO(connection);
					
					/*if(selectUsuarios()==true && selectTarefas()==true ) {
						String sql = "insert into tarefaparticipantes (idUsuario, idTarefa) values ()";
						System.out.print(sql);
						PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
						prepareStatement.executeUpdate();
						prepareStatement.close();
					}*/
					
					dispose();
				}
				
				catch(Exception v){
				     v.printStackTrace();     
				     }	
			}		
		});
		
		
		this.setVisible(true);
		this.setSize(600, 400);
		this.setLayout(null);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		
	}
}
