package view;


import java.sql.Connection;

import controller.JdbUtil;
import controller.TarefasJdbcDAO;
import controller.UsuariosJdbcDAO;
import model.Tarefas;
import model.Usuarios;

public class Exec {
	
	public static void main (String [] args) {
		
		Usuarios usuarios = new Usuarios();
		Tarefas tarefas = new Tarefas();
		
		try {
			usuarios.setNome("Jeferson");
			usuarios.setEmail("jeferson@etec.com");
			usuarios.setSexo("Masculino");
			
			
			Connection connection = JdbUtil.getConnection();
			UsuariosJdbcDAO usuariosJdbcDao = new UsuariosJdbcDAO(connection);
			
			usuariosJdbcDao.salvar(usuarios);
			//usuariosJdbcDao.alterar(c);
			//usuariosJdbcDao.deletar(1); 
			//usuariosJdbcDao.listar();
			
			tarefas.setTitulo("Calculadora em JAVA");
			tarefas.setPrazo("2018-08-14");
			tarefas.setDescricao("Calculadora com soma, subtracao, multiplicacao e divisao");
			/*tarefas.setDatainicio("2018-08-10");
			tarefas.setDatatermino("2018-08-13");*/
			
			
			Connection connection2 = JdbUtil.getConnection();
			TarefasJdbcDAO tarefasJdbcDao = new TarefasJdbcDAO(connection2);
			
			tarefasJdbcDao.salvar(tarefas);
			//tarefasJdbcDao.alterar(c);
			//tarefasJdbcDao.deletar(1); 
			//tarefasJdbcDao.listar();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	

	}
}
