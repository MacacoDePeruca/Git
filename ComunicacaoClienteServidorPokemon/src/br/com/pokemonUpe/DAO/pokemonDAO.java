package br.com.pokemonUpe.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.pokemonUpe.gameRules.Jogador;
import br.com.pokemonUpe.gameRules.Pokemon;

import com.mysql.jdbc.PreparedStatement;

public class pokemonDAO {

	private Connection conexao;

	public pokemonDAO() throws SQLException{
		this.conexao = CriaConexao.fazerConexao();
	}
	public void salvarPokemon(Pokemon poke, int codJogador) throws SQLException{
		String slq = "INSERT INTO pokemon(nome_pokemon, tipo_pokemon, habilidade, armadura, resistenacia, pdf, bonus_captura, jogador_cod_jogador, pontos_de_vida, pontos_de_magia, xp_acumulado ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = (PreparedStatement) this.conexao.prepareStatement(slq);
		
		pstmt.setString(1, poke.getNome());
		pstmt.setInt(4, poke.getArmadura());
		pstmt.setInt(7, poke.getBonusDecaptura());
		pstmt.setInt(3, poke.getHabilidade());
		pstmt.setInt(6, poke.getpoderDeFogo());
		pstmt.setInt(10, poke.getPontosDeMagia());
		pstmt.setInt(9, poke.getPontosDeVida());
		pstmt.setInt(5, poke.getResistencia());
		pstmt.setString(11, String.valueOf(poke.getXpAcumulado()));
		pstmt.setString(2, poke.getTipo());
		pstmt.setInt(8, codJogador);
		
		pstmt.execute();
		pstmt.close();
	}
	
	public void deletarPokemon(Pokemon poke) throws SQLException{
		String sql = "DELETE FROM pokemon WHERE cod_pokemon like ?";
		PreparedStatement pstmt = (PreparedStatement) this.conexao.prepareStatement(sql);
		
		if(pstmt.execute()== true){
			System.out.println("pokemon deletado com sucesso!");
		}else {
			System.out.println("não foi possivel deletar o pokemon : "+poke.getNome());
		}
		pstmt.close();
	}
	public Pokemon buscarPokemonPorId(int id) throws SQLException{
		Pokemon poke = new Pokemon();
		//retorna todos os pokemon
		String sql = "select * from pokemon";
		PreparedStatement pstmt = (PreparedStatement) this.conexao.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
		poke.setArmadura(rs.getInt("armadura"));
		poke.setBonusDecaptura(rs.getInt("bonus_de_captura"));
		poke.setHabilidade(rs.getInt("habilidade"));
		poke.setId(rs.getInt("cod_pokemon"));
		poke.setNivel(rs.getInt("nivel"));
		poke.setNome(rs.getString("nome_pokemon"));
		poke.setPoderDeFogo(rs.getInt("poder_de_fogo"));
		poke.setPontosDeMagia(rs.getInt("pontos_de_magia"));
		poke.setPontosDeVida(rs.getInt("pontos_de_vida"));
		poke.setResistencia(rs.getInt("resistenacia"));
		poke.setTipo(rs.getString("tipo_pokemon"));
		//poke.setVemDe();
		poke.setXpAcumulado(rs.getInt("xp_acumulado"));
		}
		
		return poke;
	} 
}
