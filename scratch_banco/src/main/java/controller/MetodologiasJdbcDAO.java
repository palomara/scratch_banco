package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Metodologias;


public class MetodologiasJdbcDAO {

	private Connection conn;
	
	public MetodologiasJdbcDAO (Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Metodologias m) throws SQLException {
	String sql = "insert into metodologias (metodo) values ('"+m.getMetodo()+"')";
	System.out.println(sql);
	PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
	prepareStatement.executeUpdate();
	prepareStatement.close();	
	}
	
	public void deletar (Metodologias metodologias) throws SQLException {
		String sql = "delete from metodologias where metodologias.idMetodologia"+metodologias+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar (Metodologias m) throws SQLException {
		String sql = "update metodologias set metodo='"+m.getMetodo()+"'";
		
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
	public List<Metodologias> listar() {
		String sql = "select * from metodologias";
		System.out.println(sql);
	
	List<Metodologias> metodologias = new ArrayList<Metodologias>();
	try {
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		ResultSet rs = prepareStatement.executeQuery();
		while(rs.next()) {
		//int id = rs.getInt("id");
		String metodo = rs.getString("metodo");
		System.out.println(metodo);
		}
		prepareStatement.close();
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	return metodologias;
	}
}

