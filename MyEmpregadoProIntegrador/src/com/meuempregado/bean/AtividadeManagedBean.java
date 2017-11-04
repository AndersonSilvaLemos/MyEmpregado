package com.meuempregado.bean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.Atividade;
import com.meuempregado.service.AtividadeService;



@ManagedBean(name = "atividadeManagedBean")
@SessionScoped
public class AtividadeManagedBean implements Serializable {
	private static final long serialVersionUID = -9004785433894347006L;
	
	private Atividade atividade;
	private List<Atividade> listAtividade;
	private AtividadeService service;
	
	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public List<Atividade> getListAtividade() {
		return listAtividade;
	}

	public void setListAtividade(List<Atividade> listAtividade) {
		this.listAtividade = listAtividade;
	}

	public AtividadeService getService() {
		return service;
	}

	public void setService(AtividadeService service) {
		this.service = service;
	}
	
	public AtividadeManagedBean(){
		service = new AtividadeService();
		atividade = new Atividade(0, "");
		listAtividade = service.listAll();

	}
	
	public void searchByIdAction() throws ClassNotFoundException, SQLException, IOException{
		System.out.println("Searching...");
		this.listAtividade = (List<Atividade>) service.AtividadePorId(atividade.getIdAtividade());
	}
	
	public String insertAtividadeAction(){
		System.out.println("Saving...");
		service.insertAtividade(atividade);
		
		listAtividade = service.listAll();
		
		return "index";
	}
	public String updateAtividadeAction(){
		System.out.println("Updating...");
		service.updateAtividade(atividade);
		
		return "index";
	}

	
	

}
