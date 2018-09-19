package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


import controller.InfluenciasJdbcDAO;
import controller.JdbUtil;
import controller.MetodologiasJdbcDAO;
import controller.UsuariosJdbcDAO;
import model.Influencias;
import model.Metodologias;
import model.Usuarios;

public class TelaInfluencias extends JFrame {

	  JLabel lblHumor = new JLabel("Humor:");
	  
	  JRadioButton rdbFeliz = new JRadioButton("Feliz");
	  JRadioButton rdbTriste = new JRadioButton ("Triste");
	  JRadioButton rdbEmocional = new JRadioButton ("Emocional");
	  JRadioButton rdbEstressado = new JRadioButton ("Estressado (a)");
	  JRadioButton rdbNeutro = new JRadioButton ("Neutro");
	  JRadioButton rdbOutro = new JRadioButton ("Outro");	
	
	  ButtonGroup btngHumor = new ButtonGroup();
	  
	  JLabel lblSaude = new JLabel("Saúde:");
	  
	  JRadioButton rdbDorCabeca = new JRadioButton ("Dor de cabeça");
	  JRadioButton rdbDorCostas = new JRadioButton ("Dor nas costas");
	  JRadioButton rdbCansaco = new JRadioButton ("Cansaço");
	  JRadioButton rdbDoente = new JRadioButton ("Doente");
	  
	  ButtonGroup btngSaude = new ButtonGroup();
	  
	  JLabel lblHorasDormidas = new JLabel("Horas dormidas:");
	  JTextField txtHorasDormidas = new JTextField();
	
	  JLabel lblUsuario = new JLabel("ID Usuário:");
	  JComboBox selectUsuario = new JComboBox();	  
	  
	  JButton btnSalvar = new JButton("Salvar");
	  JButton btnLimpar = new JButton ("Limpar");


	  public TelaInfluencias() {

	  super("Influencias"); 

	  Container paine = this.getContentPane();
	  getContentPane().setBackground(Color.cyan); 
	  
	  
	  paine.add(lblHumor);
	  lblHumor.setBounds(10, 20,60, 20);
	  
	  btngHumor.add(rdbFeliz);
	  btngHumor.add(rdbTriste);
	  btngHumor.add(rdbEmocional);
	  btngHumor.add(rdbEstressado);
	  btngHumor.add(rdbNeutro);
	  btngHumor.add(rdbOutro);
	  
	  paine.add(rdbFeliz);
	  rdbFeliz.setBounds(10, 50, 110, 20);
	  paine.add(rdbTriste);
	  rdbTriste.setBounds(10, 70, 110, 20);
	  paine.add(rdbEmocional);
	  rdbEmocional.setBounds(10, 90, 110, 20);
	  paine.add(rdbEstressado);
	  rdbEstressado.setBounds(10, 110, 110, 20);
	  paine.add(rdbNeutro);
	  rdbNeutro.setBounds(10, 130, 110, 20);
	  paine.add(rdbOutro);
	  rdbOutro.setBounds(10, 150, 110, 20);
	  
	  paine.add(lblSaude);
	  lblSaude.setBounds(160, 20, 60, 20);
	  
	  btngSaude.add(rdbDorCabeca);
	  btngSaude.add(rdbDorCostas);
	  btngSaude.add(rdbCansaco);
	  btngSaude.add(rdbDoente);
	  
	  paine.add(rdbDorCabeca);
	  rdbDorCabeca.setBounds(160, 50, 130, 20);
	  paine.add(rdbDorCostas);
	  rdbDorCostas.setBounds(160, 70, 130, 20);
	  paine.add(rdbCansaco);
	  rdbCansaco.setBounds(160, 90, 130, 20);
	  paine.add(rdbDoente);
	  rdbDoente.setBounds(160, 110, 130, 20);
	  	
	  paine.add(lblHorasDormidas);
	  lblHorasDormidas.setBounds(10, 180, 100, 30);
	  paine.add(txtHorasDormidas);
	  txtHorasDormidas.setBounds(120, 180, 150, 30);
	  
	  paine.add(lblUsuario);
	  lblUsuario.setBounds(10, 220, 100, 30);
	  paine.add(selectUsuario);
	  selectUsuario.setBounds(120, 220, 100, 30);
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
	  

	  paine.add(btnSalvar);
	  btnSalvar.setBounds(35, 270,  130, 30);
	  btnSalvar.addActionListener(new ActionListener() {
		   @Override
		   public void actionPerformed(ActionEvent e) {
			    try {
						Connection connection = JdbUtil.getConnection();
						InfluenciasJdbcDAO influenciasJdbcDao = new InfluenciasJdbcDAO(connection);
						
						Influencias i = new Influencias();
		
						
						try {
							i.setHorasDormidas(txtHorasDormidas.getText());
							i.setIdUsuario(selectUsuario.getSelectedIndex());
							
							if (rdbFeliz.isSelected()) {
								i.setHumor("Feliz");
							} else if (rdbTriste.isSelected()) {
								i.setHumor("Triste");
							}
							
							else if (rdbEmocional.isSelected()) {
								i.setHumor("Emocional");
							}
							
							else if (rdbEstressado.isSelected()) {
								i.setHumor("Estressado");
							}
							
							else if (rdbNeutro.isSelected()) {
								i.setHumor("Triste");
							}
							
							else {
								i.setHumor("Outro");
							}
							
							// JRadioButton -> Saúde
							if (rdbDorCabeca.isSelected()) {
								i.setSaude("Dor de cabeça");
							} else if (rdbDorCostas.isSelected()) {
								i.setSaude("Dor nas costas");
							}
							else if (rdbCansaco.isSelected()) {
								i.setSaude("Cansaço");
							}
							else {
								i.setSaude("Doente");
							}

							influenciasJdbcDao.salvar(i);
							JOptionPane.showMessageDialog(new JFrame(), "Influencias registradas");
						} catch(Exception ex) {
							JOptionPane.showMessageDialog(new JFrame(), "Influencias não registradas");
							ex.printStackTrace();
						}
					
				}
		
				 catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(new JFrame(), "Influencias não registradas");
				}
			}
		});
	  
	  paine.add(btnLimpar);
		btnLimpar.setBounds(180, 270, 130, 30);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtHorasDormidas.setText(null);
				rdbFeliz.setSelected(false);
				rdbTriste.setSelected(false);
				
				
			}
		});

	  this.setLayout(null);
	  this.setSize(350, 360);
	  this.setVisible(true);
	  this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	  this.setLocationRelativeTo(null);
	  
	  }

}
