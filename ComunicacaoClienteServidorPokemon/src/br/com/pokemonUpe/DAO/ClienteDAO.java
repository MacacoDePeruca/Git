package br.com.pokemonUpe.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import br.com.pokemonUpe.comunication.Cliente;

public class ClienteDAO {
	private Connection conexao;
	
	public ClienteDAO() throws SQLException{
		this.conexao = CriaConexao.fazerConexao();
	}
	
	public boolean  salvarCliente(Cliente cliente) throws SQLException{
		if(cliente != null){
			String sql = "insert into cliente_servidor(ip,porta,nome_cliente) values (?,?,?)";
			PreparedStatement pstmt = (PreparedStatement) this.conexao.prepareStatement(sql);
			
			
			pstmt.setString(1, cliente.getIp());
			pstmt.setInt(2, cliente.getPorta());
			pstmt.setString(3, cliente.getNome());
			
			
			pstmt.execute();
			pstmt.close();
			return true;
		}else{
			return false;
		}
	}
}
