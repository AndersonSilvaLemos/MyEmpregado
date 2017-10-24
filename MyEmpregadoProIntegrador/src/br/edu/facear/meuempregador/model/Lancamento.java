package br.edu.facear.meuempregador.model;

import java.sql.Date;

public class Lancamento {
	
	private int idLancamento;
	private String documento;
	private String data;
	private float valor;
	private TipoLancamento tipo;
	private Atividade atividade;
	
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
	public TipoLancamento getTipo() {
		return tipo;
	}
	public void setTipo(TipoLancamento tipo) {
		this.tipo = tipo;
	}
	public Atividade getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	public Lancamento() {}
	
	public Lancamento(int idLancamento, String documento, String data, float valor, TipoLancamento tipo,
			Atividade atividade) {
		super();
		this.idLancamento = idLancamento;
		this.documento = documento;
		this.data = data;
		this.valor = valor;
		this.tipo = tipo;
		this.atividade = atividade;
	}
	
	@Override
	public String toString() {
		return "Lancamento [idLancamento=" + idLancamento + ", documento=" + documento + ", data=" + data + ", valor="
				+ valor + ", tipo=" + tipo + ", atividade=" + atividade + "]";
	}

	
	

}
