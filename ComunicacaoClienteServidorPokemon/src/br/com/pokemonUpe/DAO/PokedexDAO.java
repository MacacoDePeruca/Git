package br.com.pokemonUpe.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.pokemonUpe.gameRules.Jogador;
import br.com.pokemonUpe.gameRules.Pokedex;
import br.com.pokemonUpe.gameRules.Pokemon;

public class PokedexDAO {
	
private Connection conexao;
	
public PokedexDAO() throws SQLException{
	this.conexao = CriaConexao.fazerConexao();
}
public void SalvarPokedex(Jogador player, Pokemon poke) throws SQLException{
	String sql = "INSERT INTO pokedex(cod_pokedex, cod_jogador, cod_enciclopedia) VALUES (?,?,?)";
	PreparedStatement pstmt = (PreparedStatement) this.conexao.prepareStatement(sql);
	
	//pstmt.setInt(3, player.getBatalhasVencidas());
	pstmt.setInt(1, player.getIdTreinador());
	pstmt.setString(2, poke.getNome());
	pstmt.execute();
	
	pstmt.close();
}

public void deletarPokedex(Pokedex codPokedex) throws SQLException{
	String sql = "DELETE FROM pokedex WHERE cod_pokedex like ?";
	PreparedStatement pstmt = (PreparedStatement) this.conexao.prepareStatement(sql);
	if(pstmt.execute()== true){
		System.out.println("pokedex deletada com sucesso!");
	}else {
		System.out.println("não foi possivel deletar a pokedex");
	}
	pstmt.close();
}

public List<Pokemon> buscarPokedexPorId(int id) throws SQLException{
	
	List<Pokemon> pokemons = new ArrayList<Pokemon>();
	String sql = "select pokemon.nome_pokemon, armadura, bonus_captura, habilidade, cod_pokemon, nivel, pdf, resistenacia, pontos_de_magia, pontos_de_vida, tipo_pokemon, xp_acumulado from pokemon, jogador where pokemon.jogador_cod_jogador like ? and jogador.cod_jogador like ?";
	
	
	PreparedStatement pstmt = (PreparedStatement) this.conexao.prepareStatement(sql);
	pstmt.setInt(1, id);
	pstmt.setInt(2, id);
	
	ResultSet rs = pstmt.executeQuery();
	
	while(rs.next()){
		Pokemon pk = new Pokemon();
		pk.setArmadura(rs.getInt("armadura"));
		pk.setNome(rs.getString("nome_pokemon"));
		pk.setBonusDecaptura(rs.getInt("bonus_captura"));
		//pk.setEvoluiPara(null);
		pk.setHabilidade(rs.getInt("habilidade"));
		pk.setId(rs.getInt("cod_pokemon"));
		pk.setNivel(rs.getInt("nivel"));
		
		pk.setpoderDeFogo(rs.getInt("pdf"));
		pk.setPontosDeMagia(rs.getInt("pontos_de_magia"));
		pk.setPontosDeVida(rs.getInt("pontos_de_vida"));
		//pk.setResistencia(rs.getInt("resistencia"));
		pk.setTipo(rs.getString("tipo_pokemon"));
		//pk.setVemDe(null);
		pk.setXpAcumulado(rs.getInt("xp_acumulado"));
		
		pokemons.add(pk);
		
	}	
	return pokemons;
}
}
