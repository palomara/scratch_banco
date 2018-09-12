package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.UsuariosJdbcDAO;
import model.Usuarios;

public class TelaDeletarUsuario extends JFrame {
	
	JTextField txtID = new JTextField();
	JLabel lblID = new JLabel("ID: ");
	
	JTextField txtNome = new JTextField();
	JLabel lblNome = new JLabel("Nome: ");
	
	JLabel lblEmail = new JLabel("Email:");
	JTextField txtEmail = new JTextField();
	
	JTextField txtSexo = new JTextField();
	JLabel sexo = new JLabel("Sexo: ");
	
	JTextField txtIDTarefa = new JTextField ();
	JLabel lblIDTarefa = new JLabel ("ID Tarefa:");
	
	JButton btnApagar = new JButton ("Apagar");
	
	public TelaDeletarUsuario () {
		
		super("Apagar");

		Container paine = this.getContentPane();

		/*paine.add(lblNome);
		paine.add(txtNome);	
		lblNome.setBounds(10, 15, 45, 30);
		txtNome.setBounds(90, 15, 225, 30);

		paine.add(lblEmail);
		paine.add(txtEmail);
		lblEmail.setBounds(10,50,70,30);
		txtEmail.setBounds(90, 50, 225, 30);

		paine.add(sexo);
		paine.add(txtSexo);
		sexo.setBounds(10,85,70,30);
		txtSexo.setBounds(90, 85, 225, 30);*/

		paine.add(lblID);
		paine.add(txtID);	
		lblID.setBounds(10, 15, 45, 30);
		txtID.setBounds(50, 15, 225, 30);
		
		paine.add(btnApagar);
		btnApagar.setBounds(95, 80, 130, 30);
		
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuarios d = new Usuarios();
					d.setNome(txtNome.getText());
					d.setEmail(txtEmail.getText());
					d.setSexo(txtSexo.getText());
					int id = Integer.parseInt(txtID.getText());


					Connection connection = JdbUtil.getConnection();
					UsuariosJdbcDAO usuariosJdbcDao = new UsuariosJdbcDAO(connection);
				

					usuariosJdbcDao.deletar(id);
					JOptionPane.showMessageDialog(new JFrame(), "Deletado");
					
					for (int i=0; i < getContentPane().getComponentCount(); i++) {
						Component gc = getContentPane().getComponent(i);
						
						if(gc instanceof JTextField) {
							JTextField jtfield = (JTextField) gc;
							jtfield.setText("");
						}	
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(new JFrame(), "Não foi possível deletar");
				}

			}
		});
		
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(340, 200);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

}
