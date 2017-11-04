package com.meuempregado.bean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.TipoLancamento;
import com.meuempregado.service.TipoLancamentoService;

@ManagedBean(name = "tipoLancamentoManagedBean")
@SessionScoped
public class TipoLancamentoManagedBean implements Serializable {
	
	private static final long serialVersionUID = -9004785433894347006L;
	
	private TipoLancamento tipoLancamento;
	private List<TipoLancamento> listTipoLancamento;
	private TipoLancamentoService service;

	
	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}
	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}
	public List<TipoLancamento> getListTipoLancamento() {
		return listTipoLancamento;
	}
	public void setListTipoLancamento(List<TipoLancamento> listTipoLancamento) {
		this.listTipoLancamento = listTipoLancamento;
	}
	public TipoLancamentoService getService() {
		return service;
	}
	public void setService(TipoLancamentoService service) {
		this.service = service;
	}
	
	public TipoLancamentoManagedBean(){
		service = new TipoLancamentoService();
		tipoLancamento = new TipoLancamento(0, "");
		listTipoLancamento = service.listAll();

	}
	
	public void searchByIdAction() throws ClassNotFoundException, SQLException, IOException{
		System.out.println("Searching...");
		this.listTipoLancamento = (List<TipoLancamento>) service.TipoLancamentoPorId(tipoLancamento.getIdTipo());
	}
	
	public String insertTipoLancamentoAction(){
		System.out.println("Saving...");
		service.insertTipoLancamento(tipoLancamento);
		
		listTipoLancamento = service.listAll();
		
		return "index";
	}
	public String updateTipoLancamentoAction(){
		System.out.println("Updating...");
		service.updateTipoLancamento(tipoLancamento);
		
		return "index";
	}

	
}
