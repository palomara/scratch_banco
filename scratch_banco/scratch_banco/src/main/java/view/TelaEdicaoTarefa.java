package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.TarefasJdbcDAO;
import model.Tarefas;

public class TelaEdicaoTarefa extends JFrame {
	
	JLabel lblIdTarefa = new JLabel ("ID:");
	JTextField txtID = new JTextField();
	
	JLabel lblTitulo = new JLabel("Título:");
	JTextField txtTitulo = new JTextField();
	
	JLabel lblPrazo = new JLabel("Prazo:");
	JTextField txtPrazo = new JTextField();
	
	JLabel lblDescricao = new JLabel("Descrição:");

	JTextArea txtDescricao = new JTextArea();
	JScrollPane spDescricao = new JScrollPane(txtDescricao);
	
	JButton btnEditar = new JButton("Editar");
	JButton btnLimpar = new JButton("Limpar");

	public TelaEdicaoTarefa() {
		
		super ("Editar");
		
		Container paine = this.getContentPane();
		
		  paine.add(lblTitulo);
		  paine.add(txtTitulo);
		  lblTitulo.setBounds(10, 15, 45, 30);
		  txtTitulo.setBounds(90, 15, 225, 30);

		  paine.add(lblPrazo);
		  paine.add(txtPrazo);
		  lblPrazo.setBounds(10,50,70,30);
		  txtPrazo.setBounds(90, 50, 225, 30);

		  paine.add(lblDescricao);
		  paine.add(txtDescricao);
		  lblDescricao.setBounds(10,85,70,30);
		  txtDescricao.setBounds(90, 90, 225, 100);
		  
		  paine.add(btnEditar);
		  btnEditar.setBounds(60, 210, 130, 30);
		  btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tarefas a = new Tarefas();
						a.setTitulo(txtTitulo.getText());
						a.setPrazo(txtPrazo.getText());
						a.setDescricao(txtDescricao.getText());

						Connection connection = JdbUtil.getConnection();
						TarefasJdbcDAO tarefasJdbcDao = new TarefasJdbcDAO(connection);

						tarefasJdbcDao.alterar(a);

					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			});
		  
		  paine.add(btnLimpar);
			btnLimpar.setBounds(200, 210, 130, 30);
			btnLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtTitulo.setText(null);
					txtPrazo.setText(null);
					txtDescricao.setText(null);
					
					
				}
			});
		  
			this.setLayout(null);
			this.setResizable(false);
			this.setVisible(true);
			this.setSize(400, 280);
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			this.setLocationRelativeTo(null);
		  
		  

	}
	
	
}
