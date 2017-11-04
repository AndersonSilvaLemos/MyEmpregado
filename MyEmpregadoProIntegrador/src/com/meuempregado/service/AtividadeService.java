package com.meuempregado.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.meuempregado.dao.AtividadeDao;
import com.meuempregado.model.Atividade;


public class AtividadeService {
	
	private AtividadeDao dao = new AtividadeDao(); 
	public List<Atividade> listAll(){
		
		dao = new AtividadeDao();
		return dao.listarTodos();
	}
	
	public void insertAtividade(Atividade a){
		if(a != null)

			dao.insertAtividade(a);
	}

	public void updateAtividade(Atividade atividade) {
		// TODO Auto-generated method stub
		
		
	}
	
	public Atividade AtividadePorId(Integer id) throws SQLException, ClassNotFoundException, IOException {
		AtividadeDao dao = new AtividadeDao();
		Atividade a = dao.atividadePorId(id);
		return a;
	}

}
