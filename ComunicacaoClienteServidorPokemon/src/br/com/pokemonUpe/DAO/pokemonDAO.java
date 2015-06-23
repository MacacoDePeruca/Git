package br.com.pokemonUpe.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.pokemonUpe.gameRules.Pokemon;

public class pokemonDAO {
	private Connection conexao;
	
	public pokemonDAO() throws SQLException{
		this.conexao= CriaConexao.fazerConexao();
	}
	
	public void salvarPokemon(Pokemon poke){
		String sql = "insert into pokemon ";
	}
}
