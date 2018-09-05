package model;

public class Usuarios {

	private int idUsuario;
	private String nome;
	private String email;
	private String sexo;
	

	
	
	public Integer getidUsuario() {
		return idUsuario;
	}
	public void setidUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@Override
	public String toString() {
		return "Usuarios {" + "idUsuario=" + idUsuario + ", nome='" + nome + '\'' + '}';
	}
	
	
}
