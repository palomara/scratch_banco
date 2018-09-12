package controller;

import java.sql.Connection;
import java.sql.SQLException;

import model.TarefaParticipantes;

public class TarefaParticipantesJdbcDAO {

	private Connection conn;
	
	public TarefaParticipantesJdbcDAO (Connection conn) {
		this.conn = conn;
	}
	
	
	public void salvar (TarefaParticipantes tp) throws  SQLException {
		
	}
}
