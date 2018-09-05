package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tarefas;



public class TarefasJdbcDAO {

	private Connection conn;
	
	public TarefasJdbcDAO (Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Tarefas t) throws SQLException {
		String sql = "insert into tarefas (titulo, prazo, descricao) values ('"+t.getTitulo()+"','"+t.getPrazo()+"','"+t.getDescricao()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar (Tarefas tarefas) throws SQLException {
		
		String sql = "delete from tarefas where tarefas.idTarefa="+tarefas+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar (Tarefas a) throws SQLException {
		String sql = "update tarefas set nome='"+a.getTitulo()+"',Prazo='"+a.getPrazo()+"',Descricao='"+a.getDescricao()+"';";
		
		System.out.println(sql);
		PreparedStatement prepareStatement;
		
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void selectTarefas (Tarefas idT) throws SQLException {
		String sql = "select * from tarefas'"+idT.getidTarefa()+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement;
		
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Tarefas> listar() {
		String sql = "select * from tarefas";
		System.out.println(sql);
	
	List<Tarefas> tarefas = new ArrayList<Tarefas>();
	try {
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		ResultSet rs = prepareStatement.executeQuery();
		while(rs.next()) {
		//int id = rs.getInt("id");
		String titulo = rs.getString("titulo");
		System.out.println(titulo);
		}
		prepareStatement.close();
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	return tarefas;
	}
}
