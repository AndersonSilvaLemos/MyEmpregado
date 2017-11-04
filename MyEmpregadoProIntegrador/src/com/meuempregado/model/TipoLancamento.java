package com.meuempregado.model;

public class TipoLancamento {
	
	private int idTipo;
	private String descricao;
		
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoLancamento() {}
	public TipoLancamento(int idTipo, String descricao) {
		super();
		this.idTipo = idTipo;
		this.descricao = descricao;
	}
	
	
}
