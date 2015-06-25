package br.com.pokemonUpe.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import br.com.pokemonUpe.gameRules.Jogador;

public class JogadorDAO {
private Connection conexao;

public JogadorDAO() throws SQLException{
	this.conexao = CriaConexao.fazerConexao();
}

public boolean salvarJogador(Jogador player) throws SQLException{
	String slq = "insert into jogador(nome_jogador,nivel,batalhas,batalhas_vencidas,batalhas_perdidas) values (?,?,?,?,?)";
	PreparedStatement pstmt = (PreparedStatement) this.conexao.prepareStatement(slq);
	
	
	pstmt.setString(1, player.getNomeJogador());
	pstmt.setInt(2, player.getNivel());
	pstmt.setInt(3, player.getBatalhas());
	pstmt.setInt(4, player.getBatalhasVencidas());
	pstmt.setInt(5, player.getBatalhasPerdidas());
			
	boolean flag = pstmt.execute();
			
	pstmt.close();
	
	return flag;
}
public void alterarJogador(Jogador player){
	
}
public void deletarJogador(Jogador player) throws SQLException{
	String sql = "delete from jogador where cod_jogador like ?";
	PreparedStatement pstmt = (PreparedStatement) this.conexao.prepareStatement(sql);
	
	if(pstmt.execute()== true){
		System.out.println("jogador deletado com sucesso!");
	}else {
		System.out.println("não foi possivel deletar o jogador : "+player.getNomeJogador());
	}
	pstmt.close();
}
public Jogador buscarJogadorPorId(int id) throws SQLException{
	Jogador player = new Jogador();
	String sql = "select * from jogador where cod_jogador = ?";
	PreparedStatement pstmt = (PreparedStatement) this.conexao.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	
	while(rs.next()){
		player.setIdTreinador(rs.getInt("cod_jogador"));
		player.setNomeJogador(rs.getString("nome_jogador"));
		player.setBatalhas(rs.getInt("batalhas"));
		player.setBatalhasVencidas(rs.getInt("batalhas_vencidas"));
		player.setBatalhasPerdidas(rs.getInt("batalhas_perdidas"));
		
	}
	
	
	
	return player;
}
public void subirDeNivel(Jogador player) throws SQLException{
	String sql = "update jogador set nivel = ? where cod_jogador like ?";
	PreparedStatement pstmt = (PreparedStatement) this.conexao.prepareStatement(sql);
	int novoNivel = player.getNivel() + 1;
	pstmt.setInt(1, novoNivel);
	pstmt.execute();
	
	pstmt.close();
	
} 




}
