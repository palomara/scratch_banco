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
		String sql = "insert into influencias (idUsuario, humor, saude, horasDormidas) values ('"+i.getIdUsuario()+"','"+i.getHumor()+"','"+i.getSaude()+"','"+i.getHorasDormidas()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar (int id) throws SQLException {
		String sql = "delete from influencias where influencias.id="+id+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar (Influencias i, int id) throws SQLException {
	String sql = "update influencias set humor='"+i.getHumor()+"',saude='"+i.getSaude()+"',horasDormidas='"+i.getHorasDormidas()+"'where influencias.idInfluencia='"+id+"';";
	
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
	
	public List<Influencias> dadosInfluencias() {
		String sql = "select * from influencias";
		System.out.println(sql);
		
		List<Influencias> lista_i = new ArrayList<Influencias>();
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
			
			Influencias i = new Influencias();
			
			i.setIdInfluencia(rs.getInt("idInfluencia"));
			i.setIdUsuario(rs.getInt("idUsuario"));
			i.setHumor(rs.getString("humor"));
			i.setSaude(rs.getString("saude"));
			i.setHorasDormidas(rs.getString("horasDormidas"));
			
			lista_i.add(i);
				
				
			}
			prepareStatement.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return lista_i;
	}
	
}
