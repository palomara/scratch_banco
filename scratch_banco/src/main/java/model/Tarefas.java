package model;



public class Tarefas {
	private Integer idTarefa;
	private Integer idUsuario;
	private String titulo;
	private String prazo;
	private String descricao;
	private String datainicio;
	private String datatermino;
	
	public Integer getIdTarefa() {
		return idTarefa;
	}
	
	public void setIdTarefa(Integer idTarefa) {
		this.idTarefa = idTarefa;
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	public String getPrazo() {
		return prazo;
	}
	
	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}
	
	public String getDatainicio() {
		return datainicio;
	}
	
	public void setDatainicio(String datainicio) {
		this.datainicio = datainicio;
	}
	
	public String getDatatermino() {
		return datatermino;
	}
	
	public void setDatatermino(String datatermino) {
		this.datatermino = datatermino;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
