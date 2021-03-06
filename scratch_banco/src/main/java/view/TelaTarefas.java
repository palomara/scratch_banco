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
import javax.swing.JOptionPane;
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
	
	JLabel lblUsuario = new JLabel ("Usuário:");
	JComboBox selectUsuario = new JComboBox();
	
	JLabel lblTitulo = new JLabel("Título:");
	JTextField txtTitulo = new JTextField();
	
	JLabel lblPrazo = new JLabel("Prazo:");
	JTextField txtPrazo = new JTextField();
	
	JLabel lblDescricao = new JLabel("Descrição:");

	JTextArea txtDescricao = new JTextArea();
	JScrollPane spDescricao = new JScrollPane(txtDescricao);
	

	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnLimpar = new JButton("Limpar");

	public TelaTarefas() {
		
		super("Tarefas");

		  Container paine = this.getContentPane();
		  
		 getContentPane().setBackground(Color.lightGray); 

		  paine.add(selectUsuario);
		  paine.add(lblUsuario);
		  lblUsuario.setBounds(10, 15, 70, 30);
		  selectUsuario.setBounds(90, 15, 120, 25);
		  try {
				 Connection connection = JdbUtil.getConnection();
				 UsuariosJdbcDAO user1 = new UsuariosJdbcDAO(connection);
				 
				 List<Usuarios> user =  user1.dadosUsuarios();
				 for(int i=0; i<user.size(); i++) {
					 selectUsuario.addItem(user.get(i).getidUsuario());					 
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

		  paine.add(btnSalvar);
		  btnSalvar.setBounds(30, 250, 130, 30);
		  btnSalvar.addActionListener(new ActionListener() {
			  
			  @Override
				public void actionPerformed(ActionEvent e) {
					try {
						Tarefas t = new Tarefas();
						t.setTitulo(txtTitulo.getText());
						t.setPrazo(txtPrazo.getText());
						t.setDescricao(txtDescricao.getText());
						t.setIdUsuario(selectUsuario.getSelectedIndex());
						
						
						Connection connection = JdbUtil.getConnection();
						TarefasJdbcDAO tarefasJdbcDao = new TarefasJdbcDAO(connection);

						tarefasJdbcDao.salvar(t);
						JOptionPane.showMessageDialog(new JFrame(), "Tarefa registrada");

					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(new JFrame(), "Tarefa não registrada");
					}

				}
			});
		  
		  paine.add(btnLimpar);
			btnLimpar.setBounds(180, 250, 130, 30);
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
				this.setSize(350, 330);
				this.setDefaultCloseOperation(HIDE_ON_CLOSE);
				this.setLocationRelativeTo(null);
	}

}
