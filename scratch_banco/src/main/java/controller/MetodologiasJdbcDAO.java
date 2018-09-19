package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Metodologias;
import model.Tarefas;


public class MetodologiasJdbcDAO {

	private Connection conn;
	
	public MetodologiasJdbcDAO (Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Metodologias m) throws SQLException {
	String sql = "insert into metodologias (metodo, idTarefa) values ('"+m.getMetodo()+"','"+m.getIdTarefa()+"')";
	System.out.println(sql);
	PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
	prepareStatement.executeUpdate();
	prepareStatement.close();	
	}
	
	public void deletar (int id) throws SQLException {
		String sql = "delete from metodologias where metodologias.idMetodologia"+id+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar (Metodologias m, int id) throws SQLException {
		String sql = "update tarefas set metodo='"+m.getMetodo()+"'where metodologias.idMetodo='"+id+"';";
		
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
	public List<Metodologias> listarMetodologias() {
		String sql = "select * from metodologias";
		System.out.println(sql);
	
	List<Metodologias> lista_m = new ArrayList<Metodologias>();
	try {
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		ResultSet rs = prepareStatement.executeQuery();
		while(rs.next()) {
			
			Metodologias m = new Metodologias();
			
			m.setIdTarefa(rs.getInt("idMetodologia"));
			m.setIdTarefa(rs.getInt("idTarefa"));
			m.setMetodo(rs.getString("metodo"));

			
			lista_m.add(m);
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return lista_m;
	}
}

