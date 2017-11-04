package com.meuempregado.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.meuempregado.dao.TipoLancamentoDao;
import com.meuempregado.model.TipoLancamento;


public class TipoLancamentoService {
	
	private TipoLancamentoDao dao = new TipoLancamentoDao(); 
	
	public List<TipoLancamento> listAll(){
		
		return dao.listarTodos();
	}
	
	public void insertTipoLancamento(TipoLancamento tl){
		if(tl != null)

			dao.insertTipoLancamento(tl);
	}

	public void updateTipoLancamento(TipoLancamento tipoLancamento) {
		// TODO Auto-generated method stub
		}
	
	public TipoLancamento TipoLancamentoPorId(Integer id) throws SQLException, ClassNotFoundException, IOException {
		TipoLancamentoDao dao = new TipoLancamentoDao();
		TipoLancamento tl = dao.tipoPorId(id);
		return tl;
	}

}
