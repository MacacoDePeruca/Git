package br.com.pokemonUpe.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriaConexao {
 public Connection conexao =null;
 private String url = "jdbc:mysql://localhost//bancoPokemon";
 public CriaConexao() throws SQLException{
	 
	 this.conexao  = DriverManager.getConnection(url, "root", "");
	 if(conexao != null){
		 System.out.println("conexao efetuada com sucesso");	
	 }
	 
 }
}
