package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.TarefasJdbcDAO;
import controller.UsuariosJdbcDAO;
import model.Tarefas;
import model.Usuarios;

public class TelaEdicaoTarefa extends JFrame {

	JLabel lblTarefa= new JLabel ("Tarefa:");
	JComboBox selecttarefa = new JComboBox();
	
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
		
		  paine.add(selecttarefa);
		  paine.add(lblTarefa);
		  selecttarefa.addItem("");
		  lblTarefa.setBounds(10, 15, 70, 30);
		  selecttarefa.setBounds(90, 15, 120, 25);
		  try {
				 Connection connection = JdbUtil.getConnection();
				 TarefasJdbcDAO tarefa1 = new TarefasJdbcDAO(connection);
				 
				 List<Tarefas> tf1 =  tarefa1.dadosTarefas();
				 for(int i=0; i< tf1.size(); i++) {
					 selecttarefa.addItem(tf1.get(i).getidTarefa());					 
				 }
				 
		}catch(Exception e){
			e.printStackTrace();
		}
		  
		  paine.add(lblTitulo);
		  paine.add(txtTitulo);
		  lblTitulo.setBounds(10, 50, 70, 30);
		  txtTitulo.setBounds(90, 50, 225, 30);

		  paine.add(lblPrazo);
		  paine.add(txtPrazo);
		  lblPrazo.setBounds(10, 85,70,30);
		  txtPrazo.setBounds(90, 90, 225, 30);

		  paine.add(lblDescricao);
		  paine.add(txtDescricao);
		  lblDescricao.setBounds(10,130,70,30);
		  txtDescricao.setBounds(90, 130, 225, 100);
		  
		  paine.add(btnEditar);
		  btnEditar.setBounds(60, 280, 130, 30);
		  btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tarefas a = new Tarefas();
						a.setTitulo(txtTitulo.getText());
						a.setPrazo(txtPrazo.getText());
						a.setDescricao(txtDescricao.getText());
						a.setIdUsuario(selecttarefa.getSelectedIndex());

						Connection connection = JdbUtil.getConnection();
						TarefasJdbcDAO tarefasJdbcDao = new TarefasJdbcDAO(connection);

						tarefasJdbcDao.alterar(a);

					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			});
		  
		  paine.add(btnLimpar);
			btnLimpar.setBounds(200, 280, 130, 30);
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
			this.setSize(500, 380);
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			this.setLocationRelativeTo(null);
		  
		  

	}
	

}
