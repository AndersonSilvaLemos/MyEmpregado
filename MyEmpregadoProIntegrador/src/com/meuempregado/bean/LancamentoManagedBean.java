package com.meuempregado.bean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.Atividade;
import com.meuempregado.model.Lancamento;
import com.meuempregado.model.TipoLancamento;
import com.meuempregado.service.AtividadeService;
import com.meuempregado.service.LancamentoService;


	@ManagedBean(name = "lancamentoManagedBean")
	@SessionScoped
	public class LancamentoManagedBean implements Serializable{
		private static final long serialVersionUID = -9004785433894347006L;
		
		private Lancamento lancamento;
		private List<Lancamento> listLancamento;
		
		private LancamentoService service;
		private AtividadeService serviceAtividade;
		
		private List<Atividade> listAtividade;
				
		//get set
		public Lancamento getLancamento() {
			return lancamento;
		}
		public void setLancamento(Lancamento lancamento) {
			this.lancamento = lancamento;
		}
		public List<Lancamento> getListLancamento() {
			return listLancamento;
		}
		public void setListLancamento(List<Lancamento> listLancamento) {
			this.listLancamento = listLancamento;
		}
		public LancamentoService getService() {
			return service;
		}
		public void setService(LancamentoService service) {
			this.service = service;
		}
		
		public LancamentoManagedBean(){
			service = new LancamentoService();
			lancamento = new Lancamento(1, 0, "", "", 0 , new TipoLancamento(0, ""), new Atividade (0, ""));
			listLancamento = service.listAll();
			
			serviceAtividade = new AtividadeService();
			listAtividade = serviceAtividade.listAll();

		}
		
		public List<Atividade> getListAtividade() {
			listAtividade = serviceAtividade.listAll();
			return listAtividade;
		}
		public void setListAtividade(List<Atividade> listAtividade) {
			this.listAtividade = listAtividade;
		}
		
		public void searchByIdAction() throws ClassNotFoundException, SQLException, IOException{
			System.out.println("Searching...");
			this.listLancamento = (List<Lancamento>) service.LancamentoPorId(lancamento.getIdLancamento());
		}
		
		public String insertLancamentoAction(){
			System.out.println("Saving...");
			service.insertLancamento(lancamento);
			
			listLancamento = service.listAll();
			limpar();
			
			return "index";
		}
		public String updateLancamentoAction() throws ClassNotFoundException, SQLException, IOException{
			System.out.println("Updating...");
			service.updateLancamento(lancamento);
			
			listLancamento = service.listAll();
			limpar();
			
			return "index";
		}
		public String SearchLancamentoAction() throws ClassNotFoundException, SQLException, IOException{
			System.out.println("Updating...");
			
			
			listLancamento = service.searchLancamento(lancamento.getTipoLancamento().getIdTipo(), lancamento.getAtividade().getIdAtividade());
			limpar();
			
			return "index";
		}
		
		public String deleteLancamentoAction() throws ClassNotFoundException, SQLException, IOException {
			System.out.println("Deleting...");
			service.deleteLancamento(lancamento);
			
			listLancamento = service.listAll();
			limpar();
			
			return "index";
		}
		
		private void limpar() {
			this.lancamento = new Lancamento(1, 0, "", "", 0 , new TipoLancamento(0, ""), new Atividade (0, "")); 
		}

}
