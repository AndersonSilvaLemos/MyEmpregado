package com.meuempregado.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meuempregado.model.TipoLancamento;
import com.meuempregado.service.TipoLancamentoService;

public class TipoLancamentoDao extends GenericDao {
	
	private PreparedStatement ps;
	private String SQL_INSERT = "INSERT INTO tbtipolancamento(descricao) VALUES (?)";
	private String SQL_SELECT = "SELECT * FROM tbtipolancamento";
	private String SQL_SELECT_ID = "SELECT * FROM  tbtipolancamento WHERE ID=?";


	
	public void insertTipoLancamento(TipoLancamento tl){
		try {
			// Abrir conexão
			openConnection();
			
			// Preparar o comando SQL a ser enviado ao BD
			ps = connect.prepareStatement(SQL_INSERT);
			ps.setString(1, tl.getDescricao());
			 
			
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
	public List<TipoLancamento> listarTodos(){
		List<TipoLancamento> lista = new ArrayList<TipoLancamento>();
		
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
					TipoLancamento tl = new TipoLancamento(rs.getInt("idTipo"), rs.getString("descricao"));
					
					// Adicionar na lista de Clientes
					lista.add(tl);
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
	public TipoLancamento tipoPorId(int idTipo)throws SQLException, ClassNotFoundException, IOException {
		TipoLancamento tl = null;
		TipoLancamentoService service = new TipoLancamentoService();
		List<TipoLancamento> listaTipo = service.listAll();
		
		openConnection();
		
		ps=connect.prepareStatement(SQL_SELECT_ID);
		ps.setInt(1, idTipo);
		
		for(int i=0; i<listaTipo.size(); i++) {
			if(idTipo == listaTipo.get(i).getIdTipo()) {
				tl = listaTipo.get(i);
			}
		}
		
		closeConnection();
		
		return tl;
	}


}
