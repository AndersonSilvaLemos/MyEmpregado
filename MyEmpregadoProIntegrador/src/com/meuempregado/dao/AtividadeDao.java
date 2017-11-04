package com.meuempregado.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meuempregado.model.Atividade;
import com.meuempregado.service.AtividadeService;

public class AtividadeDao extends GenericDao{
	
	private PreparedStatement ps;
	private String SQL_INSERT = "INSERT INTO tbatividade(descricao) VALUES (?)";
	private String SQL_SELECT = "SELECT * FROM tbatividade";
	private String SQL_SELECT_ID = "SELECT * FROM  tbatividade WHERE ID=?";


	
	public void insertAtividade(Atividade a){
		try {
			// Abrir conexão
			openConnection();
			
			// Preparar o comando SQL a ser enviado ao BD
			ps = connect.prepareStatement(SQL_INSERT);
			ps.setString(1, a.getDescricao());
			 
			
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
	public List<Atividade> listarTodos(){
		List<Atividade> lista = new ArrayList<Atividade>();
		
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
					Atividade a = new Atividade(rs.getInt("idAtividade"), rs.getString("descricao"));
					
					// Adicionar na lista de Clientes
					lista.add(a);
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
	public Atividade atividadePorId(int idAtividade)throws SQLException, ClassNotFoundException, IOException {
		Atividade a = null;
		AtividadeService service = new AtividadeService();
		List<Atividade> listaAtividade = service.listAll();
		
		openConnection();
		
		ps=connect.prepareStatement(SQL_SELECT_ID);
		ps.setInt(1, idAtividade);
		
		for(int i=0; i<listaAtividade.size(); i++) {
			if(idAtividade == listaAtividade.get(i).getIdAtividade()) {
				a = listaAtividade.get(i);
			}
		}
		
		closeConnection();
		
		return a;
	}


}
