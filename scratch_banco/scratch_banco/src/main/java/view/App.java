package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.JdbUtil;
import controller.TarefasJdbcDAO;
import controller.UsuariosJdbcDAO;

import model.Usuarios;

/**
 * Hello world!
 *
 */
public class App {



	public static void main(String[] args) {
		Principal windowCad = new Principal();
	}
}
