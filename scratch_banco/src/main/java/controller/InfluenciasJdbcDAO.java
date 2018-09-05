package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Influencias;

public class InfluenciasJdbcDAO {

	private Connection conn;
	
	public InfluenciasJdbcDAO (Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Influencias i) throws SQLException {
		String sql = "insert into influencias (humor) values ('"+i.getHumor()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar (Influencias influencias) throws SQLException {
		String sql = "delete from influencias where influencias.id="+influencias+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar (Influencias i) throws SQLException {
	String sql = "update influencias set humor='"+i.getHumor()+"';";
	
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
	
	public List<Influencias> listar() {
		String sql = "select * from influencias";
		System.out.println(sql);
		
		List<Influencias> influencias = new ArrayList<Influencias>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
			//int id = rs.getInt("id");
			String humor = rs.getString("humor");
			System.out.println(humor);
			}
			prepareStatement.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return influencias;
	}
	
}
