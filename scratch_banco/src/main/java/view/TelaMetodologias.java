package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.MetodologiasJdbcDAO;
import controller.TarefasJdbcDAO;
import controller.UsuariosJdbcDAO;
import model.Metodologias;
import model.Tarefas;
import model.Usuarios;

public class TelaMetodologias extends JFrame {
	
		
		JLabel lblMetodo = new JLabel("Método:");
		JTextField txtMetodo = new JTextField();
		
		JButton btnSalvar = new JButton("Salvar");
		JButton btnEditar = new JButton ("Editar");
		JButton btnApagar = new JButton ("Apagar");
		
	
		public TelaMetodologias() {
			
		super("Metodologia"); 

		 Container paine = this.getContentPane();

		 paine.add(lblMetodo);
		 paine.add(txtMetodo);
		 lblMetodo.setBounds(10, 20,60, 20);
		 txtMetodo.setBounds(70, 20, 120, 25);

		 paine.add(btnSalvar);
		 btnSalvar.setBounds(50, 60, 80, 50);
		 btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Metodologias m = new Metodologias();
						m.setMetodo(txtMetodo.getText());

						Connection connection = JdbUtil.getConnection();
						MetodologiasJdbcDAO metodologiasJdbcDao = new MetodologiasJdbcDAO(connection);
		

						metodologiasJdbcDao.salvar(m);

					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			});
		 
		 paine.add(btnEditar);
		  btnEditar.setBounds(150, 60, 70, 50);
		  btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Metodologias metodologias = new Metodologias();
						metodologias.setMetodo(txtMetodo.getText());

						Connection connection = JdbUtil.getConnection();
						MetodologiasJdbcDAO metodologiasJdbcDao = new MetodologiasJdbcDAO(connection);
		

						metodologiasJdbcDao.alterar(metodologias);

					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			});
		  
		  paine.add(btnApagar);
		  btnApagar.setBounds(230, 60, 80, 50);
		  btnApagar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Metodologias metodologias = new Metodologias();
						metodologias.setMetodo(txtMetodo.getText());

						Connection connection = JdbUtil.getConnection();
						MetodologiasJdbcDAO metodologiasJdbcDao = new MetodologiasJdbcDAO(connection);
		

						metodologiasJdbcDao.deletar(metodologias);

					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			});


		 
		 this.setLayout(null);
		 this.setSize(350, 180);
		 this.setVisible(true);
		 this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		 this.setLocationRelativeTo(null);
		 
		}

}
