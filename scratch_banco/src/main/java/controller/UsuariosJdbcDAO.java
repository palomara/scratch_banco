package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuarios;


public class UsuariosJdbcDAO {

	private Connection conn;
	
	public UsuariosJdbcDAO (Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Usuarios c) throws SQLException {
		String sql = "insert into usuarios (nome, email, sexo) values ('"+c.getNome()+"','"+c.getEmail()+"','"+c.getSexo()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar (int d) throws SQLException {
		String sql = "delete from usuarios where usuarios.idUsuario="+d+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar (Usuarios c) throws SQLException {
		String sql = "update usuarios set nome='"+c.getNome()+"',email='"+c.getEmail()+"',sexo='"+c.getSexo()+"'";
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
	
	public void selectUsuarios (Usuarios idU) throws SQLException {
		String sql = "select * from tarefaparticipantes'"+idU.getidUsuario()+"';";
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
	public List<String> listarUsuarios() {
		String sql = "select * from usuarios";
		System.out.println(sql);
		
		List<String> usuarios = new ArrayList<String>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				String email = rs.getString("email");
				usuarios.add(email);
			}
			rs.close();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public int autenticarEmail(String email) throws SQLException {
		String sql = "select * from usuarios where email = '" + email + "';";
        System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		ResultSet rs = prepareStatement.executeQuery();
		rs.next();
		int resultado = rs.getRow();
		rs.close();
        prepareStatement.close();
		return resultado;
	}
	
	
	public String[] retornarDados(Object object) throws SQLException {
		String sql = "select * from usuarios where email = '" + object + "';";
        System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		ResultSet rs = prepareStatement.executeQuery();
		rs.next();
		String idUsuario = rs.getString("idUsuario");
		String nome = rs.getString("nome");
		String sexo = rs.getString("sexo");
		
		
		String[] dadosUsuario = {nome, (String) object, sexo, idUsuario};
		
		rs.close();
		prepareStatement.close();
		
		return dadosUsuario;
	}
	
	
}
