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
import controller.MetodologiasJdbcDAO;
import model.Metodologias;

public class TelaDeletarMetodologia extends JFrame {
	

	JLabel lblMetodologia= new JLabel ("ID Metodologia:");
	JComboBox selectMetodologia = new JComboBox();
	

	
	
	JButton btnApagar = new JButton ("Apagar");
	
	public TelaDeletarMetodologia() {
		
		 super("Deletar"); 
		
		 Container paine = this.getContentPane();
		 
		 getContentPane().setBackground(Color.YELLOW);
		 
		 paine.add(lblMetodologia);
		 paine.add(selectMetodologia);
		 lblMetodologia.setBounds(10, 15, 90, 30);
		 selectMetodologia.setBounds(100, 15, 180, 30);
		  try {
				 Connection connection = JdbUtil.getConnection();
				 MetodologiasJdbcDAO m1 = new MetodologiasJdbcDAO(connection);
				 
				 List<Metodologias> mtd1 =  m1.listarMetodologias();
				 for(int i=0; i< mtd1.size(); i++) {
					 selectMetodologia.addItem(mtd1.get(i).getIdMetodologia());					 
				 }
				 
		}catch(Exception e){
			e.printStackTrace();
		}
		 
		
		
		paine.add(btnApagar);
		  btnApagar.setBounds(80, 60, 120, 30);
		  btnApagar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Metodologias metodologias = new Metodologias();
						

						Connection connection = JdbUtil.getConnection();
						MetodologiasJdbcDAO metodologiasJdbcDao = new MetodologiasJdbcDAO(connection);
						
						int id = Integer.parseInt(selectMetodologia.getSelectedItem().toString());

						metodologiasJdbcDao.deletar(id);
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
			this.setSize(310, 130);
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			this.setLocationRelativeTo(null);
	}
}

