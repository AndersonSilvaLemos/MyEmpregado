package br.edu.facear.meuempregado.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.facear.meuempregado.service.LancamentoService;
import br.edu.facear.meuempregador.model.Lancamento;

public class LancamentoDao extends GenericDao{

	private PreparedStatement ps;
	private String SQL_INSERT = "INSERT INTO tblancamento(documento, data, valor, idTipo, idAtividade) VALUES (?, ?, ?, ?, ?);";
	private String SQL_SELECT = "SELECT * FROM tblancamento";
	private String SQL_SELECT_ID = "SELECT * FROM  tblancamento WHERE ID=?;";
	
	
	
	public void insertLancamento(Lancamento l){
		try {
			// Abrir conexão
			openConnection();
			
			// Preparar o comando SQL a ser enviado ao BD
			ps = connect.prepareStatement(SQL_INSERT);
			ps.setString(1, l.getDocumento());
			ps.setString(2, l.getData());
			ps.setFloat(3, l.getValor());
						
			//ps.setObject(3, c.getCategory().getIdCategory());

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
							rs.getString("data"), rs.getFloat("valor"), null, null);
					
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
}