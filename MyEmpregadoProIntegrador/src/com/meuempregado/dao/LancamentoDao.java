package com.meuempregado.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meuempregado.model.Atividade;
import com.meuempregado.model.Lancamento;
import com.meuempregado.model.TipoLancamento;
import com.meuempregado.service.LancamentoService;

public class LancamentoDao extends GenericDao{

	private PreparedStatement ps;
	private String SQL_INSERT = "INSERT INTO tblancamento(idTipo, idAtividade, documento, data, valor) VALUES (?, ?, ?, ?, ?)";
	private String SQL_SELECT = "SELECT * FROM tblancamento tl INNER JOIN tbatividade ta ON tl.idAtividade = ta.idAtividade INNER JOIN tbtipolancamento tp ON tl.idTipo = tp.idTipo ;";
	private String SQL_SELECT_ID = "SELECT * FROM  tblancamento WHERE IDLANCAMENTO=?;";
	private String SQL_DELETE = "DELETE FROM  tblancamento WHERE IDLANCAMENTO=?;";
	
	
	public void insertLancamento(Lancamento l){
		try {
			// Abrir conexão
			openConnection();
			
			// Preparar o comando SQL a ser enviado ao BD
			ps = connect.prepareStatement(SQL_INSERT);
			ps.setObject(1, l.getTipoLancamento().getIdTipo());
			ps.setObject(2, l.getAtividade().getIdAtividade());
			ps.setString(3, l.getDocumento());
			ps.setString(4, l.getData());
			ps.setFloat(5, l.getValor());
			
			// Executar o comando de INSERT, logo não se espera retorno
			ps.executeUpdate();
			
			// Fechar conexão
			closeConnection();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found");
		} catch (IOException e) {
			System.out.println("File not Found");
		} catch (SQLException e) {
			System.out.println("Error on Connecting - Salvar");
			
		}
	}
	
	public List<Lancamento> listarTodos(){
		List<Lancamento> lista = new ArrayList<Lancamento>();
		
		try {
			// Abrir conexão
			openConnection();
			
			// Preparar comando de SELECT
			ps = connect.prepareStatement(SQL_SELECT);
			
			// Retorno da consulta com os dados no ResultSet
			ResultSet rs = ps.executeQuery();
			
			// Se houve retorno
			if(rs != null){
				while(rs.next()){
					// Para cada registro do ResultSet, instanciar um objeto Customer
					Lancamento c = new Lancamento(rs.getInt("idLancamento"), rs.getString("documento"),
							rs.getString("data"), rs.getFloat("valor"), new TipoLancamento(rs.getInt("idTipo"), rs.getString("descricao")),
							new Atividade(rs.getInt("idAtividade"), rs.getString("descricao")));
					
					// Adicionar na lista de Clientes
					lista.add(c);
				}
			}
		// Fechar conexão
			closeConnection();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found");
		} catch (IOException e) {
			System.out.println("File not Found");
		} catch (SQLException e) {
			System.out.println("Error on Connecting - listar");
		}
		
		// Se por acado não houve retorno do banco de dados, retorna
		return lista;
	}
	
	public Lancamento lancamentoPorId(int idLancamento) throws SQLException, ClassNotFoundException, IOException {
		Lancamento l = null;
		LancamentoService service = new LancamentoService();
		List<Lancamento> listaLancamento = service.listAll();
		
		openConnection();
		
		ps=connect.prepareStatement(SQL_SELECT_ID);
		ps.setInt(1, idLancamento);
		
		for(int i=0; i<listaLancamento.size(); i++) {
			if(idLancamento == listaLancamento.get(i).getIdLancamento()) {
				l = listaLancamento.get(i);
			}
		}
		
		closeConnection();
		
		return l;
	}
	
	public void deleteLancamento(Lancamento l) throws SQLException, ClassNotFoundException, IOException {
				
		//Abrir conexão
		openConnection();
		
		ps = connect.prepareStatement(SQL_DELETE);
		ps.setInt(1, l.getIdLancamento());
		
		ps.execute();
		
		//Fechar conexão
		closeConnection();
	}
}