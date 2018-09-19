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
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.MetodologiasJdbcDAO;
import controller.TarefasJdbcDAO;
import model.Metodologias;
import model.Tarefas;

public class TelaEdicaoMetodologias extends JFrame {

	JLabel lblMetodologia= new JLabel ("ID Metodologia:");
	JComboBox selectMetodologia = new JComboBox();
	
	JLabel lblMetodo = new JLabel("Método:");
	JTextField txtMetodo = new JTextField();
	
	JButton btnEditar= new JButton("Editar");
	JButton btnLimpar = new JButton ("Limpar");
	

	public TelaEdicaoMetodologias() {
		
	super("Editar"); 

	 Container paine = this.getContentPane();
	 
	 getContentPane().setBackground(Color.YELLOW); 
	 
	 paine.add(selectMetodologia);
	 paine.add(lblMetodologia);
	 lblMetodologia.setBounds(10, 15, 70, 30);
	 selectMetodologia.setBounds(90, 15, 120, 25);
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
	 
	 
	 paine.add(lblMetodo);
	 paine.add(txtMetodo);
	 lblMetodo.setBounds(10, 50, 70, 30);
	 txtMetodo.setBounds(90, 50, 225, 30);

	 paine.add(btnEditar);
	  btnEditar.setBounds(35, 100, 130, 30);
	  btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Metodologias m = new Metodologias();
					m.setMetodo(txtMetodo.getText());
					int id = Integer.parseInt(selectMetodologia.getSelectedItem().toString());

					Connection connection = JdbUtil.getConnection();
					MetodologiasJdbcDAO metodologiasJdbcDao = new MetodologiasJdbcDAO(connection);
	

					metodologiasJdbcDao.alterar(m, id);
					JOptionPane.showMessageDialog(new JFrame(), "Edição efetuada");

				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(new JFrame(), "Edição não efetuada");
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
