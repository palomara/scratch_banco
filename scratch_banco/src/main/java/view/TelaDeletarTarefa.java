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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.TarefasJdbcDAO;
import model.Tarefas;

public class TelaDeletarTarefa extends JFrame {

	
	JLabel lblID = new JLabel("ID Tarefa: ");
	JComboBox selectTarefa = new JComboBox();
	
	JButton btnApagar = new JButton ("Apagar");

	
	public TelaDeletarTarefa () {
		
		super("Apagar");
		
		Container paine = this.getContentPane();
		
		getContentPane().setBackground(Color.lightGray); 
		
		paine.add(lblID);
		paine.add(selectTarefa);	
		lblID.setBounds(10, 15, 80, 30);
		selectTarefa.setBounds(90, 15, 180, 30);
		try {
			 Connection connection = JdbUtil.getConnection();
			 TarefasJdbcDAO tarefa1 = new TarefasJdbcDAO(connection);
			 
			 List<Tarefas> tf1 =  tarefa1.dadosTarefas();
			 for(int i=0; i< tf1.size(); i++) {
				 selectTarefa.addItem(tf1.get(i).getIdTarefa());					 
			 }	 
		}	catch(Exception e){
			e.printStackTrace();
			}
		
		paine.add(btnApagar);
		btnApagar.setBounds(95, 80, 120, 30);
		btnApagar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						int id = Integer.parseInt(selectTarefa.getSelectedItem().toString());
						
						
						Connection connection = JdbUtil.getConnection();
						TarefasJdbcDAO tarefasJdbcDao = new TarefasJdbcDAO(connection);

						tarefasJdbcDao.deletar(id);
						JOptionPane.showMessageDialog(new JFrame(), "Tarefa apagada");
						
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
		this.setVisible(true);
		this.setSize(300, 130);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
}
