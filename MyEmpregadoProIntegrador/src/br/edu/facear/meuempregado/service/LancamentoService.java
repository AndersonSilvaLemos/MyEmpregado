package br.edu.facear.meuempregado.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.facear.meuempregado.dao.LancamentoDao;
import br.edu.facear.meuempregador.model.Lancamento;


public class LancamentoService {
	

		private LancamentoDao dao = new LancamentoDao(); 
		public List<Lancamento> listAll(){
			dao = new LancamentoDao();
			
			//List<Lancamento> list = new ArrayList<Lancamento>();
			//list.add(new Lancamento(1, "2005", "24/10/2017", 205.0f, null, null));
	
			return dao.listarTodos();
		}
		
		public void insertLancamento(Lancamento c){
			if(c != null)

				dao.insertLancamento(c);
		}

		public void updateLancamento(Lancamento lancamento) {
			// TODO Auto-generated method stub
			
			
		}
		
		public Lancamento LancamentoPorId(Integer id) throws SQLException, ClassNotFoundException, IOException {
			LancamentoDao dao = new LancamentoDao();
			Lancamento l = dao.lancamentoPorId(id);
			return l;
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
