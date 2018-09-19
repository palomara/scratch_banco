package view;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.UsuariosJdbcDAO;
import model.Usuarios;

public class TelaDeletarUsuario extends JFrame {
	

	JLabel lblID = new JLabel("ID Usuário: ");
	JComboBox selectUsuario = new JComboBox();
	
	JButton btnApagar = new JButton ("Apagar");
	
	public TelaDeletarUsuario () {
		
		super("Apagar");

		Container paine = this.getContentPane();
	
		
		getContentPane().setBackground(Color.lightGray); 

		paine.add(lblID);
		paine.add(selectUsuario);	
		lblID.setBounds(10, 15, 80, 30);
		selectUsuario.setBounds(90, 15, 180, 30);
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
		
		paine.add(btnApagar);
		btnApagar.setBounds(80, 60, 120, 30);
		
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
					int id = Integer.parseInt(selectUsuario.getSelectedItem().toString());


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
		this.setSize(300, 130);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

}
