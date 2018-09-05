package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.InfluenciasJdbcDAO;
import controller.JdbUtil;
import controller.MetodologiasJdbcDAO;
import model.Influencias;
import model.Metodologias;

public class TelaInfluencias extends JFrame {
	
	 Influencias i = new Influencias();

	  JLabel lblHumor = new JLabel("Humor:");
	  JTextField txtHumor = new JTextField();
	  
	  JButton btnSalvar = new JButton("Salvar");
	  JButton btnEditar = new JButton ("Editar");
	  JButton btnApagar = new JButton ("Apagar");


	  public TelaInfluencias() {

	  super("Influencias"); 

	  Container paine = this.getContentPane();

	  paine.add(lblHumor);
	  paine.add(txtHumor);
	  lblHumor.setBounds(10, 20,60, 20);
	  txtHumor.setBounds(70, 20, 120, 25);

	  paine.add(btnSalvar);
	  btnSalvar.setBounds(50, 60, 80, 50);
	  btnSalvar.addActionListener(new ActionListener() {
		   @Override
		   public void actionPerformed(ActionEvent e) {
			    try {
			    Connection connection = JdbUtil.getConnection();
			    InfluenciasJdbcDAO influenciasJdbDAO = new InfluenciasJdbcDAO (connection);
		
			    i.setHumor(txtHumor.getText());
	
		    influenciasJdbDAO.salvar(i);
	
		    } catch(Exception v){
		     v.printStackTrace();     
		     }
		   }
	  });
	  
		 paine.add(btnEditar);
		  btnEditar.setBounds(180, 230, 80, 60);
		  btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Influencias influencias = new Influencias();
						influencias.setHumor(txtHumor.getText());

						Connection connection = JdbUtil.getConnection();
						InfluenciasJdbcDAO influenciasJdbcDao = new InfluenciasJdbcDAO(connection);
		

						influenciasJdbcDao.alterar(influencias);

					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			});
		  
		  paine.add(btnApagar);
		  btnApagar.setBounds(280, 230, 80, 60);
		  btnApagar.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
					try {
						Influencias influencias = new Influencias();
						influencias.setHumor(txtHumor.getText());

						Connection connection = JdbUtil.getConnection();
						InfluenciasJdbcDAO influenciasJdbcDao = new InfluenciasJdbcDAO(connection);
		

						influenciasJdbcDao.deletar(influencias);

					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			});
		  



	  this.setLayout(null);
	  this.setSize(280, 200);
	  this.setVisible(true);
	  this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	  this.setLocationRelativeTo(null);
	  
	  }

}
