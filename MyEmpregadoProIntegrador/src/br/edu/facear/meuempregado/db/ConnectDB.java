package br.edu.facear.meuempregado.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private Connection con;
	
	private String driver;
	private String url;
	private String username;
	private String password;
	
	/**
	 * Classe de conexão com Banco de Dados
	 * 
	 */
	public ConnectDB(){
		// Melhoria futura: colocar essas informações em arquivo *.properties
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/meuempregado";
		username = "root";
		password = "";
	}
	
	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException{
		Class.forName(driver) ;
		this.con = DriverManager.getConnection(url, username, password);
		
		return this.con;
	}
}

