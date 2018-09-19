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
		String sql = "insert into usuarios (idUsuario, nome, email, sexo) values ('"+c.getidUsuario()+"','"+c.getNome()+"','"+c.getEmail()+"','"+c.getSexo()+"')";
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
	
	public void alterar (Usuarios c, int id) throws SQLException {
		String sql = "update usuarios set nome='"+c.getNome()+"',Email='"+c.getEmail()+"',Sexo='"+c.getSexo()+"'where usuarios.idUsuario='"+id+"';";
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
	

	public List<Usuarios> dadosUsuarios(){
			String sql = "select * from usuarios";
			System.out.println(sql);
			
			List<Usuarios> lista = new ArrayList<Usuarios>(); 
			
			try {
				PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
				ResultSet rs = prepareStatement.executeQuery();
				while(rs.next()) {
					
					Usuarios usuario = new Usuarios();
					
					usuario.setidUsuario(rs.getInt("idUsuario"));
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					usuario.setSexo(rs.getString("sexo"));
					
					lista.add(usuario);
				}
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		return lista;
	}	
}
