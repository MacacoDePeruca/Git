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

	public void atualizarServidor(String novoIp ,String nomeDoServidor, String porta) throws SQLException{
		String sql = "UPDATE servidores SET ip = ?, qtd_jogadores_on_line = 0, on_line = ?, porta = ? where nome_do_servidor like ?";
		PreparedStatement pstmt = (PreparedStatement) this.conexao.prepareStatement(sql);
		
		pstmt.setString(1, novoIp);
		pstmt.setString(2, "sim");
		pstmt.setString(3, porta);
		pstmt.setString(4, nomeDoServidor);
			
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
			serv.setClientesOnline(rs.getInt("qtd_jogadores_on_line"));
			
		}
		
		return serv;
	}
	
	public int addClienteOnLine(String nomeServ) throws SQLException{
		// inclui o cliente na tabela do banco designado
		int onLines =0;
		
		String sql = "update servidores set qtd_jogadores_on_line = qtd_jogadores_on_line + 1 where nome_do_servidor like ?";
		PreparedStatement pstmt = (PreparedStatement) this.conexao.prepareStatement(sql);
		
		pstmt.setString(1, nomeServ);
		
		pstmt.execute();
		pstmt.close();
		
		String consulta = "select qtd_jogadores_on_line from servidores where nome_do_servidor like ?";
		PreparedStatement ps = (PreparedStatement) this.conexao.prepareStatement(consulta);
		ps.setString(1, nomeServ);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			onLines = rs.getInt("qtd_jogadores_on_line");
		}
				
		return onLines;
	}
	public void resetServidor(String nomeServidor) throws SQLException{
		String sql ="update servidores set maximo_de_clientes = 0, porta = 0 , ip ='0.0.0.0', on_line = 'não', qtd_jogadores_on_line = 0 where nome_do_servidor like ?";
		PreparedStatement pstmt = (PreparedStatement) this.conexao.prepareStatement(sql);
		
		pstmt.setString(1, nomeServidor);
		pstmt.execute();
		
		pstmt.close();
		
	}
}
