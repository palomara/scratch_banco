package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TarefaParticipantes;

public class TarefaParticipantesJdbcDAO {

	private Connection conn;
	
	public TarefaParticipantesJdbcDAO (Connection conn) {
		this.conn = conn;
	}
	
	
	public void salvar (TarefaParticipantes c) throws  SQLException {
		String sql = "insert into tarefaParticipantes (idTarefa, idUsuario) values ('"+c.getIdTarefa()+"','"+c.getIdUsuario()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
        prepareStatement.close();
	}
	
	public void alterar (TarefaParticipantes c ) throws SQLException {
		String sql = "update tarefaParticipantes set idTarefa='"+c.getIdTarefa()+",idUsuario='"+c.getIdUsuario()+"' where idTP = "+c.getIdTP()+";";
		System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
            prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		
	}
	
	public void deletar(int idTarefa, int idUsuario) {
		String sql = "delete from tarefaParticipantes where idTarefa = " + idTarefa + " and idUsuario = " + idUsuario;
		System.out.println(sql);
        try {
    		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
    		prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}                		
	}
	
	public int verificarTP(int tarefa, int usuario) throws SQLException {
		String sql = "select * from tarefaParticipantes where idTarefa = " + tarefa + " and idUsuario = " + usuario + ";";
        System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		ResultSet rs = prepareStatement.executeQuery();
		rs.next();
		int resultado = rs.getRow();
		rs.close();
        prepareStatement.close();
		return resultado;
	}
	
	public List<String> listarUsuarios(int idUsuario) {
		String sql = "select p.idUsuario, p.nome, p.email from usuarios as p inner join tarefaPessoas as r on r.idUsuario = p.idUsuario where r.idTarefa = " + idUsuario;
        System.out.println(sql);		
        List<String> Tarefas = new ArrayList<String>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				String email = rs.getString("email");
				Tarefas.add(email);
			}
			rs.close();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Tarefas;
	}
}
