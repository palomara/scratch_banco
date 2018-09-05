package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.UsuariosJdbcDAO;
import model.Usuarios;

public class TelaEdicaoUsuario extends JFrame {
	
	JTextField txtID = new JTextField();
	JLabel lblID = new JLabel("ID: ");
	
	JTextField txtNome = new JTextField();
	JLabel lblNome = new JLabel("Nome: ");
	
	JLabel lblEmail = new JLabel("Email:");
	JTextField txtEmail = new JTextField();
	
	JLabel sexo = new JLabel("Sexo: ");
	
	JRadioButton rdbFeminino = new JRadioButton("Feminino");
	JRadioButton rdbMasculino = new JRadioButton ("Masculino");
	
	ButtonGroup btngSexo = new ButtonGroup();
	
	JButton btnEditar = new JButton ("Editar");
	
	public TelaEdicaoUsuario() {
		
		super("Edição");

		Container paine = this.getContentPane();

		paine.add(lblNome);
		paine.add(txtNome);	
		lblNome.setBounds(10, 15, 45, 30);
		txtNome.setBounds(90, 15, 225, 30);

		paine.add(lblEmail);
		paine.add(txtEmail);
		lblEmail.setBounds(10,50,70,30);
		txtEmail.setBounds(90, 50, 225, 30);
		
		paine.add(sexo);
		sexo.setBounds(10,85,70,30);

		btngSexo.add(rdbFeminino);
		btngSexo.add(rdbMasculino);
		
		paine.add(rdbFeminino);
		rdbFeminino.setBounds(90, 90, 100, 20);
		
		paine.add(rdbMasculino);
		rdbMasculino.setBounds(190, 90, 100, 20);


		
		paine.add(btnEditar);
		btnEditar.setBounds(95, 130, 130, 30);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuarios c = new Usuarios();
					c.setNome(txtNome.getText());
					c.setEmail(txtEmail.getText());


						Connection connection = JdbUtil.getConnection();
						UsuariosJdbcDAO usuariosJdbcDao = new UsuariosJdbcDAO(connection);
						
						try {
							c.setNome(txtNome.getText());
							c.setEmail(txtEmail.getText());
							
							if (rdbFeminino.isSelected()) {
								c.setSexo("Feminino");
							} else {
								c.setSexo("Masculino");
							}

							usuariosJdbcDao.alterar(c);
							JOptionPane.showMessageDialog(new JFrame(), "Edição efetuada");
						} catch(Exception ex) {
							JOptionPane.showMessageDialog(new JFrame(), "Edição não efetuada");
							ex.printStackTrace();
						}
					}
		
				 catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(new JFrame(), "Edição não efetuada");
				}
				 
				 

			}
		});

		
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(340, 220);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	}
}