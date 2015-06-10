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

public void  salvarCliente(Cliente cliente) throws SQLException{
	String sql = "insert into clientes(idcliente,ip,porta) values (?,?,?)";
	PreparedStatement pstmt = (PreparedStatement) this.conexao.prepareStatement(sql);
	
	pstmt.setInt(1, cliente.getIdCliente());
	pstmt.setString(2, cliente.getIp());
	pstmt.setString(3, cliente.getPorta());
	
	pstmt.execute();
	pstmt.close();
}

}
