package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.TarefasJdbcDAO;
import controller.UsuariosJdbcDAO;
import model.Tarefas;
import model.Usuarios;

public class TelaTarefas extends JFrame {
	
	JLabel lblIdTarefa = new JLabel ("ID:");
	JTextField txtID = new JTextField();
	
	JLabel lblTitulo = new JLabel("Título:");
	JTextField txtTitulo = new JTextField();
	
	JLabel lblPrazo = new JLabel("Prazo:");
	JTextField txtPrazo = new JTextField();
	
	JLabel lblDescricao = new JLabel("Descrição:");

	JTextArea txtDescricao = new JTextArea();
	JScrollPane spDescricao = new JScrollPane(txtDescricao);
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnEditar = new JButton ("Editar");
	JButton btnApagar = new JButton ("Apagar");

	public TelaTarefas() {
		
		super("Tarefas");

		  Container paine = this.getContentPane();

		  paine.add(lblTitulo);
		  paine.add(txtTitulo);
		  lblTitulo.setBounds(10, 20, 50, 20);
		  txtTitulo.setBounds(60, 20, 200, 20);

		  paine.add(lblPrazo);
		  paine.add(txtPrazo);
		  lblPrazo.setBounds(10, 50, 95,20);
		  txtPrazo.setBounds(60, 50, 100, 20);

		  paine.add(lblDescricao);
		  paine.add(txtDescricao);
		  lblDescricao.setBounds(10, 80, 70, 20);
		  txtDescricao.setBounds(75, 80, 200, 100);

		 /* paine.add(lblDataInicio);
		  paine.add(txtDataInicio);
		  lblDataInicio.setBounds(10, 190, 95, 20);
		  txtDataInicio.setBounds(80, 190, 100, 20);*/

		  paine.add(btnSalvar);
		  btnSalvar.setBounds(60, 230, 70, 60);
		  btnSalvar.addActionListener(new ActionListener() {
			  
			  @Override
				public void actionPerformed(ActionEvent e) {
					try {
						Tarefas t = new Tarefas();
						t.setTitulo(txtTitulo.getText());
						t.setPrazo(txtPrazo.getText());
						t.setDescricao(txtDescricao.getText());

						Connection connection = JdbUtil.getConnection();
						TarefasJdbcDAO tarefasJdbcDao = new TarefasJdbcDAO(connection);

						tarefasJdbcDao.salvar(t);

					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			});

		  paine.add(btnEditar);
		  btnEditar.setBounds(160, 230, 70, 60);
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
		  
		  paine.add(btnApagar);
		  btnApagar.setBounds(260, 230, 80, 60);
		  btnApagar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tarefas tarefas = new Tarefas();
						tarefas.setTitulo(txtTitulo.getText());
						tarefas.setPrazo(txtPrazo.getText());
						tarefas.setDescricao(txtDescricao.getText());

						Connection connection = JdbUtil.getConnection();
						TarefasJdbcDAO tarefasJdbcDao = new TarefasJdbcDAO(connection);

						tarefasJdbcDao.deletar(tarefas);

					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			});




		  this.setLayout(null);
		  this.setVisible(true);
		  this.setSize(430, 360);
		  this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		  this.setLocationRelativeTo(null);
	}

}
