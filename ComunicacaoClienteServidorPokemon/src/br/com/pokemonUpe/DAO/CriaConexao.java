package br.com.pokemonUpe.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriaConexao {
 public Connection conexao =null;
 
 
 public static Connection fazerConexao() throws SQLException {
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Conectado ao banco");
			return DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			
		}catch(ClassNotFoundException parametro){
			
			throw new SQLException(parametro.getMessage());
			
		}
		
		
		
		
	}
}
