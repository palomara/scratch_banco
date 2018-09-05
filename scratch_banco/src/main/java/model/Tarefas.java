package model;



public class Tarefas {
	private Integer idTarefa;
	private String titulo;
	private String prazo;
	private String descricao;
	private String datainicio;
	private String datatermino;
	
	public Integer getidTarefa() {
		return idTarefa;
	}
	public void setidTarefa(Integer idTarefa) {
		this.idTarefa = idTarefa;
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

@Override

public String toString() {
	return "Tarefas{" + "idTarefa" + idTarefa + ", titulo='" + titulo + '\'' + '}';
}
}
