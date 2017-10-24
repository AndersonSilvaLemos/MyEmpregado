package br.edu.facear.meuempregado.teste;

import java.util.List;

import br.edu.facear.meuempregado.service.LancamentoService;
import br.edu.facear.meuempregador.model.Lancamento;

public class TesteLancamento {

	
	//private LancamentoService service;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LancamentoService s = new LancamentoService();
		List<Lancamento> lista = s.listAll();
		
	
		if(lista != null) {
			for(int x=0; x<lista.size(); x++){
				System.out.println(lista);
			}
			
			System.out.println("Tamanho = " + lista.size());
		}
		else
			System.out.println("Vazia");
	}

}
