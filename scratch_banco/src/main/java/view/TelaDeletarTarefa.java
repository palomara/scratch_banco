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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.TarefasJdbcDAO;
import model.Tarefas;

public class TelaDeletarTarefa extends JFrame {

	
	JTextField txtID = new JTextField();
	JLabel lblID = new JLabel("ID Tarefa: ");
	
	JLabel lblTitulo = new JLabel("Título:");
	JTextField txtTitulo = new JTextField();
	
	JLabel lblPrazo = new JLabel("Prazo:");
	JTextField txtPrazo = new JTextField();
	
	JLabel lblDescricao = new JLabel("Descrição:");

	JTextArea txtDescricao = new JTextArea();
	JScrollPane spDescricao = new JScrollPane(txtDescricao);
	
	JButton btnApagar = new JButton ("Apagar");

	
	public TelaDeletarTarefa () {
		
		super("Apagar");
		
		Container paine = this.getContentPane();
		
		paine.add(lblID);
		paine.add(txtID);	
		lblID.setBounds(10, 15, 80, 30);
		txtID.setBounds(90, 15, 180, 30);
		
		paine.add(btnApagar);
		btnApagar.setBounds(95, 80, 120, 30);
		btnApagar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Tarefas a = new Tarefas();
						a.setTitulo(txtTitulo.getText());
						a.setPrazo(txtPrazo.getText());
						a.setDescricao(txtDescricao.getText());
						int id = Integer.parseInt(txtID.getText());
					
						
						Connection connection = JdbUtil.getConnection();
						TarefasJdbcDAO tarefasJdbcDao = new TarefasJdbcDAO(connection);

						tarefasJdbcDao.deletar(a);
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
		this.setSize(300, 170);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
}
