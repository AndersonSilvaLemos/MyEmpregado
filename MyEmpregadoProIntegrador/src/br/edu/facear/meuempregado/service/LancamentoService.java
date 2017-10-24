package br.edu.facear.meuempregado.service;

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
		


		public void updateCustomer(Lancamento lancamento) {
			// TODO Auto-generated method stub
			
		}
	
	

}
