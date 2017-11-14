package com.meuempregado.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meuempregado.dao.LancamentoDao;
import com.meuempregado.model.Lancamento;


public class LancamentoService {
	

		private LancamentoDao dao = new LancamentoDao(); 
		
		public List<Lancamento> listAll(){
			
			dao = new LancamentoDao();
			return dao.listarTodos();
		}
		
		public void insertLancamento(Lancamento c){
		
			if(c != null)
				dao.insertLancamento(c);
		}

		public void updateLancamento(Lancamento l) throws ClassNotFoundException, SQLException, IOException {
			// TODO Auto-generated method stub
			dao.updateLancamento(l);
		}
		
		public void deleteLancamento(Lancamento l ) throws ClassNotFoundException, SQLException, IOException {
			dao.deleteLancamento(l);
		}
		
		public Lancamento LancamentoPorId(Integer id) throws SQLException, ClassNotFoundException, IOException {
			LancamentoDao dao = new LancamentoDao();
			Lancamento l = dao.lancamentoPorId(id);
			return l;
		}
		
		public List<Lancamento> searchLancamento(int idTipo, int idAtividade) {
			dao = new LancamentoDao();
			return dao.pesquisar(idTipo, idAtividade);
		}

		/*
		public List<Lancamento> lancamentoPorId(int idLancamento) throws ClassNotFoundException, SQLException, IOException {
			//TO-DO
			List<Lancamento> list = new ArrayList<Lancamento>();
			
			if(idLancamento != 0) {
				list = (List<Lancamento>) dao.lancamentoPorId(idLancamento);
			}
			else {
				list = dao.listarTodos();
			}	
			
			return list;
		}
	*/

}
