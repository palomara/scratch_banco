package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.TarefaParticipantesJdbcDAO;
import controller.TarefasJdbcDAO;
import controller.UsuariosJdbcDAO;
import model.Usuarios;

public class TelaUsuarios extends JFrame {
	
	JLabel lblIdUsuario = new JLabel("ID:");
	JTextField txtIdUsuario = new JTextField();
	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("Nome:");

	JTextField txtEmail = new JTextField();
	JLabel email = new JLabel("E-mail:");

	JLabel sexo = new JLabel("Sexo: ");
	
	JRadioButton rdbFeminino = new JRadioButton("Feminino");
	JRadioButton rdbMasculino = new JRadioButton ("Masculino");
	
	ButtonGroup btngSexo = new ButtonGroup();


	JButton btnSalvar = new JButton("Salvar");
	JButton btnLimpar = new JButton ("Limpar");

	public TelaUsuarios() {

		super("Cadastro");

		Container paine = this.getContentPane();
	
		 getContentPane().setBackground(Color.lightGray);

		paine.add(nome);
		paine.add(txtNome);	
		nome.setBounds(10, 15, 45, 30);
		txtNome.setBounds(90, 15, 225, 30);

		paine.add(email);
		paine.add(txtEmail);
		email.setBounds(10,50,70,30);
		txtEmail.setBounds(90, 50, 225, 30);

		paine.add(sexo);
		sexo.setBounds(10,85,70,30);
		
		btngSexo.add(rdbFeminino);
		btngSexo.add(rdbMasculino);
		
		paine.add(rdbFeminino);
		rdbFeminino.setBounds(90, 90, 100, 20);
		
		paine.add(rdbMasculino);
		rdbMasculino.setBounds(190, 90, 100, 20);

		paine.add(lblIdUsuario);
		paine.add(txtIdUsuario);
		lblIdUsuario.setBounds(10, 120, 70, 30);
		txtIdUsuario.setBounds(90, 120, 80, 30);

		paine.add(btnSalvar);
		btnSalvar.setBounds(35, 180, 130, 30);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuarios usuario = new Usuarios();
					usuario.setNome(txtNome.getText());
					usuario.setEmail(txtEmail.getText());
					usuario.setidUsuario(Integer.parseInt(txtIdUsuario.getText()));
				
					if(!txtNome.getText().isEmpty()&&!txtEmail.getText().isEmpty()&&/*txtIdUsuario.getText().isEmpty()&&*/btngSexo.getSelection() != null) {
						Connection connection = JdbUtil.getConnection();
						UsuariosJdbcDAO usuariosJdbcDao = new UsuariosJdbcDAO(connection);
						TarefaParticipantesJdbcDAO tpJdbcDAO = new TarefaParticipantesJdbcDAO(connection);
						
						try {
							usuario.setNome(txtNome.getText());
							usuario.setEmail(txtEmail.getText());
							usuario.setidUsuario(Integer.parseInt(txtIdUsuario.getText()));
							
							if (rdbFeminino.isSelected()) {
								usuario.setSexo("Feminino");
							} else {
								usuario.setSexo("Masculino");
							}

							usuariosJdbcDao.salvar(usuario);
							JOptionPane.showMessageDialog(new JFrame(), "Cadastro efetuado");
						} catch(Exception ex) {
							JOptionPane.showMessageDialog(new JFrame(), "Cadastro não efetuado");
							ex.printStackTrace();
						}
					}
					else {
						JOptionPane.showMessageDialog(new JFrame(), "Preencha todos os campos");
					}
				}
		
				 catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(new JFrame(), "Cadastro não efetuado");
				}
				 
				 

			}
		});
		
		paine.add(btnLimpar);
		btnLimpar.setBounds(180, 180, 130, 30);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdUsuario.setText(null);
				txtNome.setText(null);
				txtEmail.setText(null);
				rdbFeminino.setSelected(false);
				rdbMasculino.setSelected(false);
				
				
			}
		});

		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(340, 290);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		

	}
}
