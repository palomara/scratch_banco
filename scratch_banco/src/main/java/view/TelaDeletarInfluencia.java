package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.InfluenciasJdbcDAO;
import controller.JdbUtil;
import controller.UsuariosJdbcDAO;
import model.Influencias;

public class TelaDeletarInfluencia extends JFrame {
	
	JLabel lblIDInfluencia = new JLabel("ID Influência:");
	JComboBox selectInfluencia = new JComboBox();
	
	JButton btnApagar = new JButton("Apagar");
	
	TelaDeletarInfluencia() {
		
		super("Apagar");

		Container paine = this.getContentPane();
	
		
		getContentPane().setBackground(Color.cyan); 

		paine.add(lblIDInfluencia);
		paine.add(selectInfluencia);	
		lblIDInfluencia.setBounds(10, 15, 80, 30);
		selectInfluencia.setBounds(90, 15, 180, 30);
		
		
		paine.add(btnApagar);
		  btnApagar.setBounds(80, 60, 120, 30);
		  btnApagar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
					
						int id = Integer.parseInt(selectInfluencia.getSelectedItem().toString());


						Connection connection = JdbUtil.getConnection();
						InfluenciasJdbcDAO influenciasJdbcDao = new InfluenciasJdbcDAO(connection);
						
					

						influenciasJdbcDao.deletar(id);
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
