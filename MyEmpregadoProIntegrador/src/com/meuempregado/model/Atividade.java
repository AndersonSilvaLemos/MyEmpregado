package com.meuempregado.model;

public class Atividade {
	private int idAtividade;
	private String descricao;
	
	public int getIdAtividade() {
		return idAtividade;
	}
	
	public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Atividade () {}
	public Atividade(int idAtividade, String descricao) {
		super();
		this.idAtividade = idAtividade;
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return "Atividade[idAtividade =" + idAtividade + ", descricao=" + descricao + "]";
	}
	

}
