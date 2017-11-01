package br.edu.facear.meuempregado.bean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



import br.edu.facear.meuempregado.service.LancamentoService;
import br.edu.facear.meuempregador.model.Atividade;
import br.edu.facear.meuempregador.model.Lancamento;
import br.edu.facear.meuempregador.model.TipoLancamento;


	@ManagedBean(name = "lancamentoManagedBean")
	@SessionScoped
	public class LancamentoManagedBean implements Serializable{
		private static final long serialVersionUID = -9004785433894347006L;
		
		private Lancamento lancamento;
		private List<Lancamento> listLancamento;
		private LancamentoService service;

		
		public LancamentoManagedBean(){
			service = new LancamentoService();
			lancamento = new Lancamento(0, "", "", 0 , new TipoLancamento(0, ""), new Atividade (0, ""));
			listLancamento = service.listAll();

		}
		
		public void searchByIdAction() throws ClassNotFoundException, SQLException, IOException{
			System.out.println("Searching...");
			this.listLancamento = (List<Lancamento>) service.LancamentoPorId(lancamento.getIdLancamento());
		}
		
		public String insertLancamentoAction(){
			System.out.println("Saving...");
			service.insertLancamento(lancamento);
			
			listLancamento = service.listAll();
		
			return "index";
		}
		/*public String updateLancamentoAction(){
			System.out.println("Updating...");
			service.updateLancamento(lancamento);
			
			return "index";
		}*/
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
		
	

}
