package br.com.pokemonUpe.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.pokemonUpe.comunication.Servidor;

import com.mysql.jdbc.PreparedStatement;

public class ServidorDAO {
private Connection conexao;
	
	public ServidorDAO() throws SQLException{
		this.conexao = CriaConexao.fazerConexao(); 
	}

	public void atualizarServidor(String novoIp ,String nomeDoServidor) throws SQLException{
	String sql = "UPDATE servidores SET ip = ?, qtd_jogadores_on_line = 10, on_line =? where nome_do_servidor like ?";
	PreparedStatement pstmt = (PreparedStatement) this.conexao.prepareStatement(sql);
	
	pstmt.setString(1, novoIp);
	pstmt.setString(3, nomeDoServidor);
	pstmt.setString(2, "sim");
	
	pstmt.executeUpdate();
	pstmt.close();
	
	}
	public Servidor trazerDadosDoServidor(String nomeServidor) throws SQLException{
		Servidor serv = new Servidor();
		String sql = "select * from servidores where nome_do_servidor like ?";
		
		PreparedStatement pstmt = (PreparedStatement) this.conexao.prepareStatement(sql);
		pstmt.setString(1, nomeServidor);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			serv.setIp(rs.getString("ip"));
			serv.setNomeDoServidor(rs.getString("nome_do_servidor"));
			serv.setPorta(rs.getInt("porta"));
			
		}
		
		return serv;
	}
}
