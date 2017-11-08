package com.meuempregado.model;

import java.sql.Date;

public class Lancamento {
	
	private int idMei;
	
	private int idLancamento;
	private String documento;
	private String data;
	private float valor;
	private TipoLancamento tipoLancamento;
	private Atividade atividade;
	
	
	public int getIdMei() {
		return idMei;
	}

	public void setIdMei(int idMei) {
		this.idMei = idMei;
	}

	public int getIdLancamento() {
		return idLancamento;
	}

	public void setIdLancamento(int idLancamento) {
		this.idLancamento = idLancamento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Lancamento() {}
	
	public Lancamento(int idMei, int idLancamento, String documento, String data, float valor, TipoLancamento tipoLancamento,
			Atividade atividade) {
		super();
		this.idMei = idMei;
		this.idLancamento = idLancamento;
		this.documento = documento;
		this.data = data;
		this.valor = valor;
		this.tipoLancamento = tipoLancamento;
		this.atividade = atividade;
	}
	
	@Override
	public String toString() {
		return "Lancamento [idLancamento=" + idLancamento + ", documento=" + documento + ", data=" + data + ", valor="
				+ valor + ", tipoLancamento =" + tipoLancamento + ", atividade=" + atividade + "]";
	}

	
	

}
