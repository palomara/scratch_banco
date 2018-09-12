package model;

public class TarefaParticipantes {
	private Integer idTP;
	private Integer idUsuario;
	private Integer idTarefa;

	public Integer getIdTP() {
		return idTP;
	}

	public void setIdTP(Integer idTP) {
		this.idTP = idTP;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(Integer idTarefa) {
		this.idTarefa = idTarefa;
	}
	
	@Override 
	
	public String toString() {
		return "TarefaParticipantes{" + "idTP=" + ", idUsuario=" + idUsuario + ", idTarefa='" + idTarefa + '\'' + '}';
	}
}
