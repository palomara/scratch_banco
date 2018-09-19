package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
	
		JLabel lblTarefa= new JLabel ("Tarefa:");
		JComboBox selectTarefa = new JComboBox();
		
		JLabel lblMetodo = new JLabel("Método:");
		JTextField txtMetodo = new JTextField();
		
		JButton btnSalvar = new JButton("Salvar");
		JButton btnLimpar = new JButton ("Limpar");
		
	
		public TelaMetodologias() {
			
		super("Metodologia"); 

		 Container paine = this.getContentPane();
		 
		 getContentPane().setBackground(Color.YELLOW); 
		 
		 paine.add(selectTarefa);
		 paine.add(lblTarefa);
		 lblTarefa.setBounds(10, 15, 70, 30);
		 selectTarefa.setBounds(90, 15, 120, 25);
		  try {
				 Connection connection = JdbUtil.getConnection();
				 TarefasJdbcDAO tarefa1 = new TarefasJdbcDAO(connection);
				 
				 List<Tarefas> tf1 =  tarefa1.dadosTarefas();
				 for(int i=0; i< tf1.size(); i++) {
					 selectTarefa.addItem(tf1.get(i).getIdTarefa());					 
				 }
				 
		}catch(Exception e){
			e.printStackTrace();
		}
		 
		 
		 paine.add(lblMetodo);
		 paine.add(txtMetodo);
		 lblMetodo.setBounds(10, 50, 70, 30);
		 txtMetodo.setBounds(90, 50, 225, 30);

		 paine.add(btnSalvar);
		 btnSalvar.setBounds(35, 100, 130, 30);
		 btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Metodologias m = new Metodologias();
						m.setMetodo(txtMetodo.getText());
						m.setIdTarefa(selectTarefa.getSelectedIndex());

						Connection connection = JdbUtil.getConnection();
						MetodologiasJdbcDAO metodologiasJdbcDao = new MetodologiasJdbcDAO(connection);
		

						metodologiasJdbcDao.salvar(m);

					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			});
		 
		 paine.add(btnLimpar);
			btnLimpar.setBounds(180, 100, 130, 30);
			btnLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtMetodo.setText(null);
						
					
				}
			});


		 
		 this.setLayout(null);
		 this.setSize(350, 190);
		 this.setVisible(true);
		 this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		 this.setLocationRelativeTo(null);
		 
		}

}
