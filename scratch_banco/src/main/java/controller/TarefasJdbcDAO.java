package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tarefas;
import model.Usuarios;



public class TarefasJdbcDAO {

	private Connection conn;
	
	public TarefasJdbcDAO (Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Tarefas t) throws SQLException {
		String sql = "insert into tarefas (idUsuario, titulo, prazo, descricao) values ('"+t.getIdUsuario()+"','"+t.getTitulo()+"','"+t.getPrazo()+"','"+t.getDescricao()+"')";
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
		String sql = "update tarefas set titulo='"+a.getTitulo()+"',Prazo='"+a.getPrazo()+"',Descricao='"+a.getDescricao()+"',idTarefa='"+a.getidTarefa()+"';";
		
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
	
	public void select(int id) throws SQLException{
		String sql = "select * from tarefas where idTarefa = "+id;	
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		ps.close();
	}
	

	
	public List<String> listarTarefas() {
		String sql = "select * from tarefas";
		System.out.println(sql);
	
	List<String> tarefas = new ArrayList<String>();
	try {
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		ResultSet rs = prepareStatement.executeQuery();
		while(rs.next()) {
			String idTarefa = rs.getString("idTarefa");
			tarefas.add(idTarefa);
		}
		rs.close();
		prepareStatement.close();
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	return tarefas;
	}
	
	public String[] retornarDados(int idTarefa) throws SQLException {
		String sql = "select * from tarefas where idTarefa = '" + idTarefa + "';";
        System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		ResultSet rs = prepareStatement.executeQuery();
		rs.next();
		String titulo = rs.getString("titulo");
		String prazo = rs.getString("prazo");
		String descricao = rs.getString("descricao");

		rs.close();
		
		String[] dados = {titulo, prazo, descricao};

		prepareStatement.close();
		
		return dados;
	}
	
	public List<Tarefas> dadosTarefas(){
		String sql = "select * from tarefas";
		System.out.println(sql);
		
		List<Tarefas> lista_t = new ArrayList<Tarefas>(); 
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				
				Tarefas tf = new Tarefas();
				
				tf.setidTarefa(rs.getInt("idTarefa"));
				tf.setTitulo(rs.getString("titulo"));
				tf.setPrazo(rs.getString("prazo"));
				tf.setDescricao(rs.getString("descricao"));
				
				lista_t.add(tf);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	return lista_t;
}

}
